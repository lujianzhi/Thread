package chapter1.section8;

import java.util.Deque;
import java.util.Iterator;

/**
 * Created by Ian.Lu on 2017/3/26.
 * Project : Thread
 */
public class CleanDaemonThread extends Thread {

    private Deque<Time> timeList;

    public CleanDaemonThread(Deque<Time> timeList) {
        this.timeList = timeList;
        setDaemon(true);
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            Iterator<Time> iterator = timeList.iterator();
            while (iterator.hasNext()) {
                Time time = iterator.next();
                if(time != null){
                    long last = System.currentTimeMillis() - time.getLastTime();
                    if (last > 5000) {
                        iterator.remove();
                    }
                }
            }
            System.out.println("长度:" + timeList.size());
        }

    }
}
