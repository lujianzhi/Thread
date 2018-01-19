package skywang.part4.chapter5;

import skywang.part4.chapter5.item5.MyThread;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created by Ian.Lu on 2018/1/19.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
        item5();
    }

    private static void item5() {
        Map<Integer, String> map = new ConcurrentSkipListMap<>();

        MyThread myThreadA = new MyThread("MTA", map);
        MyThread myThreadB = new MyThread("MTB", map);

        myThreadA.start();
        myThreadB.start();
    }
}
