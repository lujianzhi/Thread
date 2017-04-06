package chapter2.section6;

/**
 * Created by Ian.Lu on 2017/4/6.
 * Project : Thread
 */
public class ReadPriceRunnable implements Runnable {

    private PriceObj priceObj;

    public ReadPriceRunnable(PriceObj priceObj) {
        this.priceObj = priceObj;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":PriceA : " + priceObj.getPriceA());
            System.out.println(Thread.currentThread().getName() + ":PriceB : " + priceObj.getPriceB());
        }
    }
}
