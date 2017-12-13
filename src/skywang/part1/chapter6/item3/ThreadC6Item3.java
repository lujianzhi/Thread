package skywang.part1.chapter6.item3;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class ThreadC6Item3 extends Thread {

    private Object obj;

    public ThreadC6Item3(String name, Object obj) {
        super(name);
        this.obj = obj;
    }

    @Override
    public void run() {
        super.run();
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - 优先级:" + Thread.currentThread().getPriority() + " i:" + i);
                //i整除4时，调用yield
                if (i % 4 == 0) {
                    yield();
                }
            }
        }
    }
}
