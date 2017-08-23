package book.chapter1.section8;

import java.util.Deque;

/**
 * Created by Ian.Lu on 2017/3/26.
 * Project : Thread
 */
public class TimeRunnable implements Runnable {

    private Deque<Time> timeList;

    public TimeRunnable(Deque<Time> timeList) {
        this.timeList = timeList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Time time = new Time(System.currentTimeMillis());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timeList.add(time);
        }

    }
}
