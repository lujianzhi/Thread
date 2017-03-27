package chapter1.section13;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Ian.Lu on 2017/3/27.
 * Project : Thread
 */
public class MyThreadFactory implements ThreadFactory {

    private int count;
    private List<String> status;

    public MyThreadFactory() {
        this.count = 0;
        this.status = new ArrayList<>();
    }

    @Override
    public Thread newThread(Runnable r) {
        count++;
        Thread thread = new Thread(r, "工厂创建" + count);
        status.add("线程:" + thread.getName() + "; state:" + thread.getState().toString());
        return thread;
    }

    public void printStatus() {
        System.out.println(status.toString());
    }
}
