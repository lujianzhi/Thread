package skywang.part1.chapter3;

/**
 * Created by Ian.Lu on 2017/12/6.
 * Project : Thread
 */
public class Test {
    public static void main(String[] args) {
        ThreadC3 threadC3 = new ThreadC3("Ian");

        System.out.println(Thread.currentThread().getName() + "启动线程");
        threadC3.run();

        System.out.println(Thread.currentThread().getName() + "启动线程");
        threadC3.start();
    }
}
