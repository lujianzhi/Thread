package skywang.part1.chapter6;

import skywang.part1.chapter6.item2.ThreadC6Item2;
import skywang.part1.chapter6.item3.ThreadC6Item3;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {

//        item2();
        item3();
    }

    /**
     * yield()是不会释放锁的
     */
    private static void item3() {
        Object obj = new Object();
        ThreadC6Item3 threadC6Item3_1 = new ThreadC6Item3("ThreadC6Item3_1", obj);
        ThreadC6Item3 threadC6Item3_2 = new ThreadC6Item3("ThreadC6Item3_2", obj);
        threadC6Item3_1.start();
        threadC6Item3_2.start();
    }

    /**
     * yield()示例
     */
    private static void item2() {
        ThreadC6Item2 ThreadC6Item2_1 = new ThreadC6Item2("ThreadC6Item2_1");
        ThreadC6Item2 ThreadC6Item2_2 = new ThreadC6Item2("ThreadC6Item2_2");
        ThreadC6Item2_1.start();
        ThreadC6Item2_2.start();
    }
}
