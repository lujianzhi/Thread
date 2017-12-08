package skywang.chapter4.item3;

/**
 * Created by Ian.Lu on 2017/12/7.
 * Project : Thread
 */
public class BeenC4Item3 {

    public synchronized void synMethod() {
        System.out.println(Thread.currentThread().getName() + " : synMethod - start");
        System.out.println(Thread.currentThread().getName() + " : synMethod - counting");
        int i = 0;
        while (i < 9999999) {
            i++;
        }
        System.out.println(Thread.currentThread().getName() + " : synMethod - stop");
    }

    public synchronized void synBlock() {
        System.out.println(Thread.currentThread().getName() + " : synBlock - start");
        //后来的线程B在这里等，那线程B就不会走到30行了
        synchronized (this) {
            //先到的线程A已经先进去了
            System.out.println(Thread.currentThread().getName() + " : synBlock - counting");
            int i = 0;
            while (i < 9999999) {
                i++;
            }
        }
        System.out.println(Thread.currentThread().getName() + " : synBlock - stop");
    }
}
