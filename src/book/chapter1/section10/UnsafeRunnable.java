package book.chapter1.section10;

import java.util.Random;

/**
 * Created by Ian.Lu on 2017/3/27.
 * Project : Thread
 */
public class UnsafeRunnable implements Runnable {

    private long time;

    @Override
    public void run() {
        time = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName() + " start : " + time);
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finish : " + time);
    }
}
