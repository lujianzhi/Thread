package skywang.chapter5;

import skywang.chapter5.item2.ThreadC5Item2;
import skywang.chapter5.item3.ThreadC5Item3;
import skywang.chapter5.item4.ThreadC5Item4;

/**
 * Created by Ian.Lu on 2017/12/8.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
//        item2();

        item3();

//        item4();
    }

    /**
     * notifyAll()的用法；
     * 它的作用是唤醒在此对象监视器上等待的所有线程。
     */
    private static void item4() {
        Object obj = new Object();
        ThreadC5Item4 threadC5Item4_1 = new ThreadC5Item4("ThreadC5Item4 - 1", obj);
        ThreadC5Item4 threadC5Item4_2 = new ThreadC5Item4("ThreadC5Item4 - 2", obj);
        ThreadC5Item4 threadC5Item4_3 = new ThreadC5Item4("ThreadC5Item4 - 3", obj);
        threadC5Item4_1.start();
        threadC5Item4_2.start();
        threadC5Item4_3.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " - notifyAll()");

            //直接全部唤醒
            obj.notifyAll();

            //调用几次，就随机唤醒几个
//            obj.notify();
//            obj.notify();
//            obj.notify();
        }
    }

    /**
     * wait(long timeout)会让当前线程处于“等待(阻塞)状态”，
     * “直到其他线程调用此对象的 notify() 方法或 notifyAll() 方法，或者超过指定的时间量”，
     * 当前线程被唤醒(进入“就绪状态”)。
     */
    private static void item3() {
        ThreadC5Item3 threadC5Item3 = new ThreadC5Item3("Thread - C5Item3");
        synchronized (threadC5Item3) {
            try {
                System.out.println(Thread.currentThread().getName() + "处于 " + Thread.currentThread().getState().name() + " 状态");
                threadC5Item3.start();

                System.out.println(Thread.currentThread().getName() + "处于 " + Thread.currentThread().getState().name() + " 状态，threadC5Item3调用wait()");
                threadC5Item3.wait(3000);

                System.out.println(Thread.currentThread().getName() + "处于 " + Thread.currentThread().getState().name() + " 状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * wait()和notify()配合使用的情形
     */
    private static void item2() {
        ThreadC5Item2 threadC5Item2 = new ThreadC5Item2("Thread - C5Item2");
        //使用wait()和notify()必须要有同步块，因为涉及到锁的操作
        synchronized (threadC5Item2) {
            try {
                System.out.println(Thread.currentThread().getName() + "处于 " + Thread.currentThread().getState().name() + " 状态");
                threadC5Item2.start();

                System.out.println(Thread.currentThread().getName() + "处于 " + Thread.currentThread().getState().name() + " 状态，threadC5Item2调用wait()");
                threadC5Item2.wait();

                System.out.println(Thread.currentThread().getName() + "处于 " + Thread.currentThread().getState().name() + " 状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
