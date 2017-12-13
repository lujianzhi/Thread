package skywang.part1.chapter7;

import skywang.part1.chapter7.item3.ThreadC7Item3;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class Test {
    public static void main(String[] args) {
        item3();
    }

    private static void item3() {
        ThreadC7Item3 threadC7Item3_1 = new ThreadC7Item3("ThreadC7Item3_1");
        ThreadC7Item3 threadC7Item3_2 = new ThreadC7Item3("ThreadC7Item3_2");
        threadC7Item3_1.start();
        threadC7Item3_2.start();
    }
}
