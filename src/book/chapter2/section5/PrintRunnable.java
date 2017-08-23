package book.chapter2.section5;

/**
 * Created by Ian.Lu on 2017/4/6.
 * Project : Thread
 */
public class PrintRunnable implements Runnable {

    private PrintQueue printQueue;

    public PrintRunnable(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "准备打印");
        printQueue.print();
        System.out.println(Thread.currentThread().getName() + "结束打印");
    }
}
