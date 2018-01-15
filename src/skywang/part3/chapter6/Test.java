package skywang.part3.chapter6;

import skywang.part3.chapter6.item3.ThreadA;
import skywang.part3.chapter6.item3.ThreadB;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ian.Lu on 2018/1/15.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
//        item3_1();
        item3_2();
    }

    private static void item3_2() {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        ThreadB threadB = new ThreadB("ThreadB", reentrantLock, condition);
        threadB.start();

        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " : condition.await() : " + Thread.currentThread().getState().name());
            Thread.sleep(1000);
            condition.await();
            System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getState().name());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

    private static void item3_1() {
        ThreadA threadA = new ThreadA("ThreadA");
        System.out.println("开启线程start：" + threadA.getName() + " ; 状态：" + threadA.getState().name());
        threadA.start();
        System.out.println("线程：" + threadA.getName() + " ; 状态：" + threadA.getState().name());

        synchronized (threadA) {
            try {
                threadA.wait();
                System.out.println("休眠线程wait：" + threadA.getName() + " ; 状态：" + threadA.getState().name());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("线程" + threadA.getName() + " ; 状态：" + threadA.getState().name());

    }
}
