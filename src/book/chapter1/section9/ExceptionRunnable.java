package book.chapter1.section9;

/**
 * Created by Ian.Lu on 2017/3/27.
 * Project : Thread
 */
public class ExceptionRunnable implements Runnable {
    @Override
    public void run() {
        int a = Integer.parseInt("YYY");
        System.out.println(a);
    }
}
