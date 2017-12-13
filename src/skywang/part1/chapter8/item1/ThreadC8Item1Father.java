package skywang.part1.chapter8.item1;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class ThreadC8Item1Father extends Thread {

    private ThreadC8Item1Son threadC8Item1Son;

    public ThreadC8Item1Father(String name) {
        super(name);
        threadC8Item1Son = new ThreadC8Item1Son("ThreadC8Item1Son");
    }

    @Override
    public void run() {
        super.run();

        try {
            System.out.println(Thread.currentThread().getName() + "开始执行");

            threadC8Item1Son.start();
            threadC8Item1Son.join();

            System.out.println(Thread.currentThread().getName() + "执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
