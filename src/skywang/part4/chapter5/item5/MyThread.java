package skywang.part4.chapter5.item5;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Ian.Lu on 2018/1/19.
 * Project : Thread
 */
public class MyThread extends Thread {

    private Map<Integer, String> map;

    public MyThread(String name, Map<Integer, String> map) {
        super(name);
        this.map = map;
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
            map.put((int) (Math.random() * 10), Thread.currentThread().getName() + "-" + i);
            printAll();
        }
    }

    private void printAll() {
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            System.out.print(key + ":" + map.get(key) + "  ");
        }
        System.out.println("-------------");
    }
}
