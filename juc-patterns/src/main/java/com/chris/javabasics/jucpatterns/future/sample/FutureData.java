package com.chris.javabasics.jucpatterns.future.sample;

/**
 * 表示RealData的提货单的类
 * 其他线程会创建RealData的实例
 * <p>
 * 假设有一个方法需要花费很长世间才能获取运行结果
 * 那么，与其一直等待结果，不如先拿一张"提货单"
 * 获取提货单并不耗费时间，这里的提货单为Future角色
 * <p>
 * 获取Future角色的线程会在稍后使用Future角色来获取运行结果
 * 如果运行结果已经出来了，那么直接领取即可；如果运行结果还没有出来，那么需要等待结果出来
 * <p>
 * Future角色是购买蛋糕时的提货单、预购单、预约券，是"未来"可以转换为实物的凭证
 * */
public class FutureData implements Data {
    // 用于保存稍后创建完毕的RealData的实例的字段
    private RealData realdata = null;

    // 表示是否已经为realData赋值的字段
    // 如果它为true,表示已经为realData赋值(蛋糕已经制作完成)
    private boolean ready = false;

    public synchronized void setRealData(RealData realdata) {
        // Balking模式
        if (ready)
            return;     // balk

        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    public synchronized String getContent() {
        // Guarded Suspension模式
        // 调用了wait方法而处于等待状态的线程会被从setRealData方法中调用的notifyAll方法唤醒
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }

        return realdata.getContent();
    }
}
