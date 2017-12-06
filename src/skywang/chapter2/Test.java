package skywang.chapter2;

/**
 * Created by Ian.Lu on 2017/12/6.
 * Project : Thread
 */
public class Test {
    public static void main(String[] args) {
//        Thread thread1 = new ThreadC2();
//        Thread thread2 = new ThreadC2();
//        Thread thread3 = new ThreadC2();
//        thread1.start();
//        thread2.start();
//        thread3.start();

        Runnable runnable = new RunnableC2();
        Thread thread4 = new Thread(runnable);
        Thread thread5 = new Thread(runnable);
        Thread thread6 = new Thread(runnable);
        thread4.start();
        thread5.start();
        thread6.start();
    }
}
