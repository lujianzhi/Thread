package chapter1.section7;

/**
 * Created by Ian.Lu on 2017/3/26.
 * Project : Thread
 */
public class DoBusinessRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("开始执行任务");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务执行结束");
    }
}
