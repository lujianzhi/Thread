package skywang.chapter5.item4;

/**
 * Created by Ian.Lu on 2017/12/8.
 * Project : Thread
 */
public class ThreadC5Item4 extends Thread {

    private Object obj;

    public ThreadC5Item4(String name, Object obj) {
        super(name);
        this.obj = obj;
    }

    @Override
    public void run() {
        super.run();
        synchronized (obj) {
            try {
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is " + Thread.currentThread().getState().name() + " ; wait ; time : " + System.currentTimeMillis());

                obj.wait();

                System.out.println(Thread.currentThread().getName() + " is " + Thread.currentThread().getState().name() + " ; notify ;  time : " + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
