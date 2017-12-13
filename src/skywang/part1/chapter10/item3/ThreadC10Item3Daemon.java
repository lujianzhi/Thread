package skywang.part1.chapter10.item3;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class ThreadC10Item3Daemon extends Thread {

    public ThreadC10Item3Daemon(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 10000; i++) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " 是否为守护线程 : " + Thread.currentThread().isDaemon() + " ; i : " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
