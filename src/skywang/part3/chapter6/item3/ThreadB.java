package skywang.part3.chapter6.item3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ian.Lu on 2018/1/16.
 * Project : Thread
 */
public class ThreadB extends Thread {

    private ReentrantLock reentrantLock;
    private Condition condition;

    public ThreadB(String name, ReentrantLock reentrantLock, Condition condition) {
        super(name);
        this.reentrantLock = reentrantLock;
        this.condition = condition;
    }

    @Override
    public void run() {
        super.run();

        reentrantLock.lock();
        System.out.println(getName() + " : " + getState().name());
        try {
            sleep(1000);
            condition.signal();
            System.out.println(getName() + " : condition-signal : " + getState().name());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }
}
