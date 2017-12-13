package skywang.part1.chapter4.item2;

/**
 * Created by Ian.Lu on 2017/12/7.
 * Project : Thread
 */
public class ThreadC4Item2Row1 extends Thread {

    public ThreadC4Item2Row1(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    sleep(500);
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
