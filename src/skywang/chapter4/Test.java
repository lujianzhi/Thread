package skywang.chapter4;

import skywang.chapter4.item2.BeenC4Item2Row2;
import skywang.chapter4.item2.BeenC4Item2Row3;
import skywang.chapter4.item2.ThreadC4Item2Row1;
import skywang.chapter4.item3.BeenC4Item3;
import skywang.chapter4.item4.BeenC4Item4;

/**
 * Created by Ian.Lu on 2017/12/7.
 * Project : Thread
 */
public class Test {
    public static void main(String[] args) {
//        item2();

//        item3();

        item4();
    }

    /**
     * 实例锁 和 全局锁
     */
    private static void item4() {
//        item4row1();
//        item4row2();
//        item4row3();
        item4row4();
    }

    /**
     * synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率。
     */
    private static void item3() {
        BeenC4Item3 beenC4Item3 = new BeenC4Item3();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            beenC4Item3.synBlock();
            long durationTime = System.currentTimeMillis() - startTime;
            System.out.println(Thread.currentThread().getName() + " : synBlock - durationTime : " + durationTime);
        }, "Thread - 1").start();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            beenC4Item3.synBlock();
            long durationTime = System.currentTimeMillis() - startTime;
            System.out.println(Thread.currentThread().getName() + " : synBlock - durationTime : " + durationTime);
        }, "Thread - 2").start();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            beenC4Item3.synBlock();
            long durationTime = System.currentTimeMillis() - startTime;
            System.out.println(Thread.currentThread().getName() + " : synBlock - durationTime : " + durationTime);
        }, "Thread - 3").start();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            beenC4Item3.synBlock();
            long durationTime = System.currentTimeMillis() - startTime;
            System.out.println(Thread.currentThread().getName() + " : synBlock - durationTime : " + durationTime);
        }, "Thread - 4").start();

        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            beenC4Item3.synMethod();
            long durationTime = System.currentTimeMillis() - startTime;
            System.out.println(Thread.currentThread().getName() + " : synMethod - durationTime : " + durationTime);
        }, "Thread - 5").start();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            beenC4Item3.synMethod();
            long durationTime = System.currentTimeMillis() - startTime;
            System.out.println(Thread.currentThread().getName() + " : synMethod - durationTime : " + durationTime);
        }, "Thread - 6").start();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            beenC4Item3.synMethod();
            long durationTime = System.currentTimeMillis() - startTime;
            System.out.println(Thread.currentThread().getName() + " : synMethod - durationTime : " + durationTime);
        }, "Thread - 7").start();
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            beenC4Item3.synMethod();
            long durationTime = System.currentTimeMillis() - startTime;
            System.out.println(Thread.currentThread().getName() + " : synMethod - durationTime : " + durationTime);
        }, "Thread - 8").start();

    }

    /**
     * synchronized的基本规则
     */
    private static void item2() {
//        item2Row1();
//        item2row2();
//        item2row3();
    }

    /**
     * x.isSyncA()与Something.cSyncA()可以被同时访问。
     * 因为isSyncA()是实例方法，x.isSyncA()使用的是对象x的锁；
     * 而cSyncA()是静态方法，Something.cSyncA()可以理解对使用的是“类的锁”。
     * 因此，它们是可以被同时访问的。
     */
    private static void item4row4() {
        BeenC4Item4 beenC4Item4_1 = new BeenC4Item4();
        BeenC4Item4 beenC4Item4_2 = new BeenC4Item4();

        new Thread(beenC4Item4_1::isSyncA, "Thread - 1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                beenC4Item4_2.cSyncB();
            }
        }, "Thread - 2").start();
    }

    /**
     * x.cSyncA()与y.cSyncB()不能被同时访问。
     * 因为cSyncA()和cSyncB()都是static类型，x.cSyncA()相当于Something.isSyncA()，y.cSyncB()相当于Something.isSyncB()，
     * 因此它们共用一个同步锁，不能被同时反问。
     */
    private static void item4row3() {
        BeenC4Item4 beenC4Item4_1 = new BeenC4Item4();
        BeenC4Item4 beenC4Item4_2 = new BeenC4Item4();

        new Thread(new Runnable() {
            @Override
            public void run() {
                beenC4Item4_1.cSyncA();
            }
        }, "Thread - 1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                beenC4Item4_2.cSyncB();
            }
        }, "Thread - 2").start();
    }

    /**
     * x.isSyncA()与y.isSyncA()可以同时被访问。
     * 因为访问的不是同一个对象的同步锁，x.isSyncA()访问的是x的同步锁，而y.isSyncA()访问的是y的同步锁。
     */
    private static void item4row2() {
        BeenC4Item4 beenC4Item4_1 = new BeenC4Item4();
        BeenC4Item4 beenC4Item4_2 = new BeenC4Item4();

        new Thread(beenC4Item4_1::isSyncA, "Thread - 1").start();
        new Thread(beenC4Item4_2::isSyncB, "Thread - 2").start();
    }

    /**
     * x.isSyncA()与x.isSyncB() 不能被同时访问。
     * 因为isSyncA()和isSyncB()都是访问同一个对象(对象x)的同步锁！
     */
    private static void item4row1() {
        BeenC4Item4 beenC4Item4 = new BeenC4Item4();

        new Thread(beenC4Item4::isSyncA, "Thread - 1").start();
        new Thread(beenC4Item4::isSyncB, "Thread - 2").start();
    }

    /**
     * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
     * 其他线程对“该对象”的其他的“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
     */
    private static void item2row3() {
        BeenC4Item2Row3 beenC4RowThree = new BeenC4Item2Row3();
        //Lambda写法，相当于
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                beenC4RowTwo.printSyn();
//            }
//        }, "Thread - 1").start();
        new Thread(beenC4RowThree::printSyn, "Thread - 1").start();
        new Thread(beenC4RowThree::printSynTwo, "Thread - 2").start();
    }

    /**
     * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
     * 其他线程仍然可以访问“该对象”的非同步代码块。
     */
    private static void item2row2() {
        BeenC4Item2Row2 beenC4RowTwo = new BeenC4Item2Row2();
        //Lambda写法，相当于
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                beenC4RowTwo.printSyn();
//            }
//        }, "Thread - 1").start();
        new Thread(beenC4RowTwo::printSyn, "Thread - 1").start();
        new Thread(beenC4RowTwo::printSyn, "Thread - 2").start();
        new Thread(beenC4RowTwo::printUnsyn, "Thread - 3").start();
    }

    /**
     * 当一个线程访问“某对象”的“synchronized方法”或者“synchronized代码块”时，
     * 其他线程对“该对象”的该“synchronized方法”或者“synchronized代码块”的访问将被阻塞。
     */
    private static void item2Row1() {
//        Runnable runnableC4 = new RunnableC4Item2Row1();
//        Thread thread1 = new Thread(runnableC4, "Thread - 1");
//        Thread thread2 = new Thread(runnableC4, "Thread - 2");
//        thread1.start();
//        thread2.start();

        Thread thread3 = new ThreadC4Item2Row1("Thread - 3");
        Thread thread4 = new ThreadC4Item2Row1("Thread - 4");
        thread3.start();
        thread4.start();
    }


}
