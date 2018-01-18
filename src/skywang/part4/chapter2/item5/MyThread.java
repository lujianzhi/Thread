package skywang.part4.chapter2.item5;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Ian.Lu on 2018/1/18.
 * Project : Thread
 */
public class MyThread extends Thread {

    private List<String> copyOnWriteArrayList;

    public MyThread(String name, List<String> copyOnWriteArrayList) {
        super(name);
        this.copyOnWriteArrayList = copyOnWriteArrayList;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            copyOnWriteArrayList.add(i, Thread.currentThread().getName() + "-" + i);
            printAll();
        }
    }

    private void printAll() {
        Iterator<String> iterable = copyOnWriteArrayList.iterator();
        while (iterable.hasNext()) {
            System.out.print(iterable.next() + "  ");
        }
        System.out.println();
    }
}
