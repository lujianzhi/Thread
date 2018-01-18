package skywang.part4.chapter3;

import skywang.part4.chapter3.item5.MyThread;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Ian.Lu on 2018/1/18.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
        item5();
    }

    /**
     * CopyOnWriteArraySet是“线程安全”的集合，而HashSet是非线程安全的。
     * <p>
     * 下面是“多个线程同时操作并且遍历集合set”的示例
     * (01) 当set是CopyOnWriteArraySet对象时，程序能正常运行。
     * (02) 当set是HashSet对象时，程序会产生ConcurrentModificationException异常。
     */
    private static void item5() {
        //set是HashSet对象时，程序会出错。
        //Set<String> copyOnWriteArraySet = new HashSet<>();
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        MyThread myThreadA = new MyThread("MTA", copyOnWriteArraySet);
        MyThread myThreadB = new MyThread("MTB", copyOnWriteArraySet);

        // 同时启动两个线程对set进行操作
        myThreadA.start();
        myThreadB.start();
    }
}
