package chapter2.section5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ian.Lu on 2017/4/6.
 * Project : Thread
 */
public class PrintQueue {
    private ReentrantLock reentrantLock;

    public PrintQueue() {
        reentrantLock = new ReentrantLock();
    }

    public void print() {
        reentrantLock.lock();
//        if (reentrantLock.tryLock()) {
        try {
            long duration = (long) (Math.random() * 1000);
            System.out.println(Thread.currentThread().getName() + "打印中，耗时" + (float) duration / 1000 + "秒");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放锁");
        }
//        } else {
//            System.out.println("线程:" + Thread.currentThread().getName() + "跳过临界区");
//        }
    }
}
