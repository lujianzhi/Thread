package book.chapter1.section5;

/**
 * Created by Ian.Lu on 2017/3/26.
 * Project : Thread
 */
public class MyRunnable5 implements Runnable {
    @Override
    public void run() {
        try {
            interruptException();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + " ; isInterrupted : " + Thread.currentThread().isInterrupted()
                    + " ; interrupted : " + Thread.interrupted());
        }
    }

    private void interruptException() throws InterruptedException {
        int i = 0;
        while (true) {
            i++;
            System.out.println(i);
            if (Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() + " ; isInterrupted : " + Thread.currentThread().isInterrupted()
                        + " ; interrupted : " + Thread.interrupted());
                throw new InterruptedException();
            }
        }
    }

}
