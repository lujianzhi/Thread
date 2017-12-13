package skywang.part1.chapter5.item3;

/**
 * Created by Ian.Lu on 2017/12/8.
 * Project : Thread
 */
public class ThreadC5Item3 extends Thread {

    public ThreadC5Item3(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is " + Thread.currentThread().getState().name());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
