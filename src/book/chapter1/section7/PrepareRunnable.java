package book.chapter1.section7;

/**
 * Created by Ian.Lu on 2017/3/26.
 * Project : Thread
 */
public class PrepareRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("准备工作开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("准备工作结束");
    }
}
