package skywang.chapter3;

/**
 * Created by Ian.Lu on 2017/12/6.
 * Project : Thread
 */
public class ThreadC3 extends Thread {

    public ThreadC3(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName() + " is running");
    }
}
