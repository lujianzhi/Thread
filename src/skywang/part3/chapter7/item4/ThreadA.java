package skywang.part3.chapter7.item4;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by Ian.Lu on 2018/1/16.
 * Project : Thread
 */
public class ThreadA extends Thread {

    private Thread thread;

    public ThreadA(String name, Thread thread) {
        super(name);
        this.thread = thread;
    }

    @Override
    public void run() {
        super.run();
        System.out.println(getName() + " isRunning");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("LockSupport.unpark(" + thread.getName() + ")");
        LockSupport.unpark(thread);
    }
}
