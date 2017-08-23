package book.chapter1.section6;

/**
 * Created by Ian.Lu on 2017/3/26.
 * Project : Thread
 */
public class MyRunnable6 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getName() + " has interrupted.");
                return;
            }
        }
    }
}
