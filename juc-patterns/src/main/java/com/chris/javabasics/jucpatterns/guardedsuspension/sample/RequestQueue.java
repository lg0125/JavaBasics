package com.chris.javabasics.jucpatterns.guardedsuspension.sample;

import com.chris.javabasics.jucpatterns.guardedsuspension.sample.Request;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 依次存放请求的类
 * Passive Object
 * <p>
 * 只用于表示ClientThread传递给ServerThread的实例
 * */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    /*
    * synchronized关键字在保护什么
    *       queue字段
    * Single Threaded Execution模式
    * 必须确保同时"只能由一个线程执行"
    * */

    /**
     * 取出最先存放在RequestQueue中的一个请求，作为其返回值
     * 如果一个请求的没有，那就一直等待，直到其他某个线程执行putRequest
     * <p>
     * synchronized方法
     * <p>
     * 目标处理——从queue中取出一个Request实例
     * 必须满足的条件(守护条件) queue.peek() != null，即存在想要取出的元素
     * while语句的条件表达式是守护条件的逻辑非运算
     * while语句保证在remove方法被调用时，守护条件是一定成立的
     * 即守护条件不成立时，不会继续执行while语句之后的语句(调用remove方法)
     * <p>
     * 当守护条件成立时，线程不会进入while语句内，
     *      而是立即执行while语句的下一条语句，调用remove方法
     *      这时，不会执行到wait方法，所以线程也就不会等待
     * 当守护条件不成立时，线程会进入while语句内，执行wait方法，开始等待
     * <p>
     * 当守护条件不成立时，线程会进入while语句内，执行wait方法，开始等待
     * 等待notify/notifyAll => 等待实例状态发生变化，守护条件成立的时刻
     * 只有知道线程在等待什么，才能明白应该何时执行notify/notifyAll
     * <p>
     * 在执行目标处理之前，守护条件一定是成立的
     * 将执行某个处理之前必须满足的条件成为前置条件
     * 守护条件就是目标处理的前置条件
     * <p>
     * while(守护条件的逻辑非) {
     *     使用wait方法进行等待
     * }
     * 执行目标处理
     * <p>
     * 线程要执行某个实例的wait方法。这时，线程必须获取该实例的锁。
     *      在getRequest方法(synchronized方法)中，wait方法被调用时，获取的就是this锁
     *      线程执行this的wait方法后，进入this的等待队列，并释放持有的this锁
     * */
    public synchronized Request getRequest() {
        // while语句用于检查条件是否成立
        while (queue.peek() == null) {
            try {
                // while语句执行wait方法
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        // 执行玩while语句后，程序才会执行实际相应的处理
        return queue.remove();
    }

    /**
     * 用于添加一个请求
     * 当线程想要向RequestQueue添加Request实例时，可以调用该方法
     * <p>
     * synchronized方法
     * */
    public synchronized void putRequest(Request request) {
        queue.offer(request);
        // 在putRequest中执行notify
        notifyAll();
    }
}
