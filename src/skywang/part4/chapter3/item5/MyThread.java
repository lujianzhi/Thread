package skywang.part4.chapter3.item5;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Ian.Lu on 2018/1/18.
 * Project : Thread
 */
public class MyThread extends Thread {

    private Set<String> copyOnWriteArraySet;

    public MyThread(String name, Set<String> copyOnWriteArraySet) {
        super(name);
        this.copyOnWriteArraySet = copyOnWriteArraySet;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            //重复插入，是为了验证Set是不重复的
            copyOnWriteArraySet.add(Thread.currentThread().getName() + " - " + i);
            copyOnWriteArraySet.add(Thread.currentThread().getName() + " - " + i);
            printAll();
        }
    }

    private void printAll() {
        Iterator<String> iterator = copyOnWriteArraySet.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "   ");
        }
        System.out.println();
    }
}
