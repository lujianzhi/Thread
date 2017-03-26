package chapter1;

import chapter1.section3.MyRunnable;
import chapter1.section4.MyThread;
import chapter1.section5.MyRunnable5;
import chapter1.section6.MyRunnable6;
import chapter1.section7.DoBusinessRunnable;
import chapter1.section7.PrepareRunnable;
import chapter1.section8.CleanDaemonThread;
import chapter1.section8.Time;
import chapter1.section8.TimeRunnable;
import chapter1.section9.ExceptionRunnable;
import chapter1.section9.MyUncaughtExceptionHandler;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ian.Lu on 2017/3/22.
 * Project : Thread
 */
public class Test {

    private static Thread[] threads = new Thread[5];
    private static Thread.State[] states = new Thread.State[5];

    public static void main(String[] args) {

//        test3();

//        test4();

//        test5();

//        test6();

//        test7();

//        test8();

        test9();
    }

    private static void test9() {
        Thread thread = new Thread(new ExceptionRunnable());
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        thread.start();
    }

    private static void test8() {
        Deque<Time> timeList = new ConcurrentLinkedDeque<>();
        Thread thread1 = new Thread(new TimeRunnable(timeList));
        Thread thread2 = new Thread(new TimeRunnable(timeList));
        Thread thread3 = new Thread(new TimeRunnable(timeList));
        Thread daemon = new CleanDaemonThread(timeList);

        thread1.start();
        thread2.start();
        thread3.start();
        daemon.start();
    }

    private static void test7() {
        Thread prepare = new Thread(new PrepareRunnable());
        Thread doBusiness = new Thread(new DoBusinessRunnable());
        prepare.start();
        doBusiness.start();
        try {
            prepare.join();
            doBusiness.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程继续执行任务");
    }

    private static void test6() {
        Thread thread = new Thread(new MyRunnable6());
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("外部中断线程");
        }

        thread.interrupt();
    }

    private static void test5() {
        Thread thread = new Thread(new MyRunnable5());
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    private static void test4() {
        Thread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    private static void test3() {
        for (int i = 0; i < 5; i++) {
            MyRunnable myRunnable = new MyRunnable(i);
            Thread thread = new Thread(myRunnable);
            thread.setName("Thread " + i);
            threads[i] = thread;
            states[i] = thread.getState();
        }

        for (Thread thread : threads) {
            thread.start();
        }

        boolean finish = false;
        while (!finish) {
            for (int i = 0; i < 5; i++) {
                Thread thread = threads[i];
                Thread.State state = states[i];
                if (thread.getState() != state) {
                    System.out.println(thread.getName() + " ; new state : " + thread.getState() + " ; old state : " + state.toString());
                    states[i] = thread.getState();
                }
            }
            finish = true;
            for (int i = 0; i < 5; i++) {
                finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
            }
        }
    }
}
