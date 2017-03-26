package chapter1.section4;

/**
 * Created by Ian.Lu on 2017/3/26.
 * Project : Thread
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        int i = 0;
        while (true) {
            System.out.println(i++);
            if (Thread.interrupted()) {
                System.out.println("Thread isInterrupted.");
                return;
            }
            if (isInterrupted()) {
                System.out.println("Thread isInterrupted.");
                return;
            }
        }
    }

}
