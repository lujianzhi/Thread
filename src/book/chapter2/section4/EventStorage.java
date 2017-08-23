package book.chapter2.section4;

import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ian.Lu on 2017/4/5.
 * Project : Thread
 */
public class EventStorage {

    private int maxsize;
    private LinkedList<Date> dateLinkedList;
    private ReentrantLock reentrantLock;
    private Condition full;
    private Condition empty;

    public EventStorage() {
        maxsize = 10;
        dateLinkedList = new LinkedList<>();
        reentrantLock = new ReentrantLock();
        full = reentrantLock.newCondition();
        empty = reentrantLock.newCondition();
    }

    public void set() {
        reentrantLock.lock();
        if (dateLinkedList.size() >= maxsize) {
            try {
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dateLinkedList.add(new Date());
        System.out.println("生产者生产 size : " + dateLinkedList.size());
        empty.signal();
        reentrantLock.unlock();
    }

    public void get() {
        reentrantLock.lock();
        if (dateLinkedList.size() <= 0) {
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dateLinkedList.poll();
        System.out.println("消费者消费 size : " + dateLinkedList.size());
        full.signal();
        reentrantLock.unlock();
    }

//    public synchronized void set() {
//        while (dateLinkedList.size() == maxsize) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        dateLinkedList.add(new Date());
//        System.out.println("生产者生产 size : " + dateLinkedList.size());
//        notify();
//    }
//
//    public synchronized void get() {
//        while (dateLinkedList.size() == 0) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        dateLinkedList.poll();
//        System.out.println("消费者消费 size : " + dateLinkedList.size());
//        notify();
//    }
}
