package book.chapter1.section10;

import java.util.Random;

/**
 * Created by Ian.Lu on 2017/3/27.
 * Project : Thread
 */
public class SafeRunnable implements Runnable {

    private ThreadLocal<Long> time = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start : " + time.get());
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finish : " + time.get());
    }
}
