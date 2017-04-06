package chapter2.section6;

/**
 * Created by Ian.Lu on 2017/4/6.
 * Project : Thread
 */
public class WritePriceRunnable implements Runnable {

    private PriceObj priceObj;

    public WritePriceRunnable(PriceObj priceObj) {
        this.priceObj = priceObj;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + "开始修改价格");
            priceObj.setPrice(Math.random() * 10, Math.random() * 15);
            System.out.println(Thread.currentThread().getName() + "开始修改完毕");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
