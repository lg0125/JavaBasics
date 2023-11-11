package com.chris.javabasics.jucpatterns.producerconsumer.sample;

/**
 * 有3位糕点师制作蛋糕并将其放在桌子上，然后有3位客人来吃这些蛋糕
 *      糕点师(MakerThread)制作蛋糕(String)，并将其放置到桌子(Table)
 *      桌子上最多可放置3个蛋糕
 *      如果桌子上已经放满3个蛋糕时糕点师还要再放置蛋糕，必须等到桌子上空出位置
 *      客人(EaterThread)取出桌子上的蛋糕吃
 *      客人按蛋糕被放置到桌子上的顺序来取蛋糕
 *      当桌子上1个蛋糕都没有时，客人若要取蛋糕，必须等到桌子上新放置了蛋糕
 * */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);     // 创建一个能放置3个蛋糕的桌子

        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 92653).start();
        new MakerThread("MakerThread-3", table, 58979).start();

        new EaterThread("EaterThread-1", table, 32384).start();
        new EaterThread("EaterThread-2", table, 62643).start();
        new EaterThread("EaterThread-3", table, 38327).start();
    }
}
