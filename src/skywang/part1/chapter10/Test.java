package skywang.part1.chapter10;

import skywang.part1.chapter10.item3.ThreadC10Item3Daemon;
import skywang.part1.chapter10.item3.ThreadC10Item3Normal;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class Test {
    public static void main(String[] args) {
        item3();
    }

    /**
     * 守护线程的示例
     */
    private static void item3() {
        ThreadC10Item3Normal threadC10Item3Normal = new ThreadC10Item3Normal("ThreadC10Item3Normal");
        ThreadC10Item3Daemon threadC10Item3Daemon = new ThreadC10Item3Daemon("ThreadC10Item3Daemon");
        threadC10Item3Daemon.setDaemon(true);

        threadC10Item3Normal.start();
        threadC10Item3Daemon.start();
    }
}
