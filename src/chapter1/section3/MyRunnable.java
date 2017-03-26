package chapter1.section3;

/**
 * Created by Ian.Lu on 2017/3/26.
 * Project : Thread
 */
public class MyRunnable implements Runnable {

    private int count;

    public MyRunnable(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.println(count + " * " + i + " = " + (count * i));
        }
    }
}
