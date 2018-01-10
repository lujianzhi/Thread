package skywang.part3.chapter2.item3_3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Ian.Lu on 2018/1/11.
 * Project : Thread
 */
public class Depot {
    //总容量
    private int size;
    //库存
    private int left;

    //独占锁
    private ReentrantLock reentrantLock;
    //库存已满的条件
    private Condition fullCondition;
    //库存为空的条件
    private Condition emptyCondition;

    public Depot(int size, int left) {
        this.size = size;
        this.left = left;
        reentrantLock = new ReentrantLock();
        fullCondition = reentrantLock.newCondition();
        emptyCondition = reentrantLock.newCondition();
    }

    public void produce(int count) {
        reentrantLock.lock();
        try {
            while (count > 0) {
                if (left >= size) {
                    fullCondition.await();
                }
                int num = size >= left + count ? count : size - left;
                left += num;
                count -= num;
                System.out.println("生产了:" + num + "个；还剩:" + left + "个");
                emptyCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }

    public void consume(int count) {
        reentrantLock.lock();
        try {
            while (count > 0) {
                if (left <= 0) {
                    emptyCondition.await();
                }
                int num = left > count ? count : count - left;
                left -= num;
                count -= num;
                System.out.println("消费了:" + num + "个；还剩:" + left + "个");
                fullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}
