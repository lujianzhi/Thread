package skywang.chapter7.item3;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class ThreadC7Item3 extends Thread {

    public ThreadC7Item3(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - i : " + i);
            if (i == 3) {
                try {
                    long start = System.currentTimeMillis();
                    Thread.sleep(1000);
                    long duration = System.currentTimeMillis() - start;
                    System.out.println(Thread.currentThread().getName() + " sleep : " + duration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
