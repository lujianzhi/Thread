package skywang.part3.chapter7;

import skywang.part3.chapter7.item4.ThreadA;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by Ian.Lu on 2018/1/16.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
        item4();
    }

    private static void item4() {
        Thread mainThread = Thread.currentThread();
        ThreadA threadA = new ThreadA("ThreadA", mainThread);
        threadA.start();

        System.out.println("LockSupport.park(mainThread)");
        LockSupport.park(mainThread);
        System.out.println(mainThread.getName() + " : " + mainThread.getState().name());
    }
}
