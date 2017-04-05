package chapter2;

import chapter2.section2.Cinema;
import chapter2.section2.SellARunnable;
import chapter2.section2.SellBRunnable;
import chapter2.section3.WaitRunnable;
import chapter2.section4.Consumer;
import chapter2.section4.EventStorage;
import chapter2.section4.Producer;

/**
 * Created by Ian.Lu on 2017/3/28.
 * Project : Thread
 */
public class Test2 {

    public static void main(String[] args) {
//        test2();

//        test3();

        test4();
    }

    private static void test4() {
        EventStorage eventStorage = new EventStorage();
        Producer producer = new Producer(eventStorage);
        Consumer consumer = new Consumer(eventStorage);

        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();

    }

    private static void test3() {

        WaitRunnable runnable = new WaitRunnable();
        Thread waitThread = new Thread(runnable);

        waitThread.start();
        synchronized (waitThread) {
            System.out.println("等待对象waitThread完成计算。。。");
//            try {
//                waitThread.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("waitThread对象计算的总和是：" + runnable.total);
        }

    }

    private static void test2() {
        Cinema cinema = new Cinema();
        SellARunnable aRunnable = new SellARunnable(cinema);
        SellBRunnable bRunnable = new SellBRunnable(cinema);

        Thread a = new Thread(aRunnable, "A");
        Thread b = new Thread(bRunnable, "B");

        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("A:" + cinema.getTicketForScreenA() + " ; B:" + cinema.getTicketForScreenB());
    }
}
