package skywang.part1.chapter8;

import skywang.part1.chapter8.item1.ThreadC8Item1Father;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class Test {
    public static void main(String[] args) {

        item1();
    }

    /**
     * join() 的作用：让“主线程”等待“子线程”结束之后才能继续运行。
     */
    private static void item1() {
        ThreadC8Item1Father threadC8Item1Father = new ThreadC8Item1Father("ThreadC8Item1Father");
        threadC8Item1Father.start();
    }
}
