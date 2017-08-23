package book.chapter1.section11;

import java.util.Random;

/**
 * Created by Ian.Lu on 2017/3/27.
 * Project : Thread
 */
public class TaskRunnable implements Runnable {

    @Override
    public void run() {
        Random random = new Random();
        System.out.println(Thread.currentThread().getName() + " : tag=" + random.nextInt(10));

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
