package skywang.part1.chapter8.item1;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class ThreadC8Item1Son extends Thread {

    public ThreadC8Item1Son(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        try {
            System.out.println(Thread.currentThread().getName() + "开始执行");
            sleep(2000);
            System.out.println(Thread.currentThread().getName() + "执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
