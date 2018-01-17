package skywang.part3.chapter8.item5;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Ian.Lu on 2018/1/17.
 * Project : Thread
 */
public class User {
    private String name;

    private MyCount myCount;

    private ReadWriteLock readWriteLock;

    public User(String name, MyCount myCount) {
        this.name = name;
        this.myCount = myCount;
        readWriteLock = new ReentrantReadWriteLock();
    }

    public void getCash() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                readWriteLock.readLock().lock();
                System.out.println(Thread.currentThread().getName() + " getCash");
                myCount.getCash();
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " getCash");
                readWriteLock.readLock().unlock();
            }
        }.start();
    }

    public void setCash(int cash) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                readWriteLock.writeLock().lock();
                System.out.println(Thread.currentThread().getName() + " setCash(" + cash + ")");
                myCount.setCash(cash);
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " setCash(" + cash + ")");
                readWriteLock.writeLock().unlock();
            }
        }.start();
    }

}
