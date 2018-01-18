package skywang.part4.chapter2;

import skywang.part4.chapter2.item5.MyThread;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Ian.Lu on 2018/1/18.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
        item5();
    }

    /**
     * CopyOnWriteArrayList是“线程安全”的动态数组，而ArrayList是非线程安全的。
     * 01) 当list是CopyOnWriteArrayList对象时，程序能正常运行。
     * 02) 当list是ArrayList对象时，程序会产生ConcurrentModificationException异常。
     */
    private static void item5() {
        //list是ArrayList对象时，程序会出错。
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        MyThread myThreadA = new MyThread("ThreadA", copyOnWriteArrayList);
        MyThread myThreadB = new MyThread("ThreadB", copyOnWriteArrayList);
        // 同时启动两个线程对list进行操作
        myThreadA.start();
        myThreadB.start();
    }
}
