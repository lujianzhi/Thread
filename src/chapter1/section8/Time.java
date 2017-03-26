package chapter1.section8;

/**
 * Created by Ian.Lu on 2017/3/26.
 * Project : Thread
 */
public class Time {
    private long lastTime;

    public Time(long lastTime) {
        this.lastTime = lastTime;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }
}
