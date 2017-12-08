package skywang.chapter5.item2;

/**
 * Created by Ian.Lu on 2017/12/8.
 * Project : Thread
 */
public class ThreadC5Item2 extends Thread {

    public ThreadC5Item2(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        //使用wait()和notify()必须要有同步块，因为涉及到锁的操作
        synchronized (this) {
            try {
                sleep(3000);
                System.out.println(Thread.currentThread().getName() + "调用notify,唤醒该对象监视器上的线程");
                System.out.println(Thread.currentThread().getName() + "处于 " + Thread.currentThread().getState().name() + " 状态");
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
