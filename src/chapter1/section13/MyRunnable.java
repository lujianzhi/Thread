package chapter1.section13;

/**
 * Created by Ian.Lu on 2017/3/27.
 * Project : Thread
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("水果");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
