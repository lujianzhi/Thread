package skywang.part3.chapter2.item3_1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ian.Lu on 2018/1/11.
 * Project : Thread
 */
public class Depot {

    private int count;
    private ReentrantLock reentrantLock;// 独占锁

    public Depot(int count) {
        this.count = count;
        reentrantLock = new ReentrantLock();
    }

    public void consume(int number) {
        //获得锁
//        reentrantLock.lock();
        count -= number;
        System.out.println("消费" + number + "个，总共还有" + count + "个");
        //释放锁
//        reentrantLock.unlock();
    }

    public void produce(int number) {
        //获得锁
//        reentrantLock.lock();
        count += number;
        System.out.println("生产" + number + "个，总共还有" + count + "个");
        //释放锁
//        reentrantLock.unlock();
    }
}
