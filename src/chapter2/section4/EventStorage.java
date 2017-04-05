package chapter2.section4;

import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Ian.Lu on 2017/4/5.
 * Project : Thread
 */
public class EventStorage {

    private int maxsize;
    private LinkedList<Date> dateLinkedList;

    public EventStorage() {
        maxsize = 10;
        dateLinkedList = new LinkedList<>();
    }

    public synchronized void set() {
        while (dateLinkedList.size() == maxsize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dateLinkedList.add(new Date());
        System.out.println("生产者生产 size : " + dateLinkedList.size());
        notify();
    }

    public synchronized void get() {
        while (dateLinkedList.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        dateLinkedList.poll();
        System.out.println("消费者消费 size : " + dateLinkedList.size());
        notify();
    }
}
