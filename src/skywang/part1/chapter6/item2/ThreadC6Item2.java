package skywang.part1.chapter6.item2;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class ThreadC6Item2 extends Thread {

    public ThreadC6Item2(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - 优先级:" + Thread.currentThread().getPriority() + " i:" + i);
            //i整除4时，调用yield
            if (i % 4 == 0) {
                yield();
            }
        }
    }
}
