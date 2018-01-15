package skywang.part3.chapter6.item3;

/**
 * Created by Ian.Lu on 2018/1/16.
 * Project : Thread
 */
public class ThreadA extends Thread {

    public ThreadA(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        synchronized (this) {
            try {
                sleep(1000);
                System.out.println("线程：" + getName() + " ; 状态：" + getState().name());
                System.out.println("notify()");
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
