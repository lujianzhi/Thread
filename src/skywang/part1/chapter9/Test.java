package skywang.part1.chapter9;

import skywang.part1.chapter9.item3.ThreadC9Item3Blocked;
import skywang.part1.chapter9.item3.ThreadC9Item3ExtraParam;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {

        item3_1();
//        item3_2();
    }

    /**
     * 下面是通过“额外添加标记”的方式终止“状态状态”的线程的示例
     */
    private static void item3_2() {

        try {
            ThreadC9Item3ExtraParam threadC9Item3ExtraParam = new ThreadC9Item3ExtraParam("ThreadC9Item3ExtraParam");
            System.out.println(threadC9Item3ExtraParam.getName() + "的状态 : " + threadC9Item3ExtraParam.getState().name());

            threadC9Item3ExtraParam.start();
            System.out.println(threadC9Item3ExtraParam.getName() + "的状态 : " + threadC9Item3ExtraParam.getState().name());

            Thread.sleep(300);
            threadC9Item3ExtraParam.stopThread();
            System.out.println(threadC9Item3ExtraParam.getName() + "stopThread()后的状态 : " + threadC9Item3ExtraParam.getState().name());

            Thread.sleep(300);
            System.out.println(threadC9Item3ExtraParam.getName() + "的状态 : " + threadC9Item3ExtraParam.getState().name());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * interrupt()常常被用来终止“阻塞状态”线程。
     */
    private static void item3_1() {
        try {
            ThreadC9Item3Blocked threadC9Item3Blocked = new ThreadC9Item3Blocked("ThreadC9Item3Blocked");
            System.out.println(threadC9Item3Blocked.getName() + "的状态 : " + threadC9Item3Blocked.getState().name());

            threadC9Item3Blocked.start();
            System.out.println(threadC9Item3Blocked.getName() + "的状态 : " + threadC9Item3Blocked.getState().name());

            Thread.sleep(300);
            System.out.println(threadC9Item3Blocked.getName() + "stopThread()前isInterrupted : " + threadC9Item3Blocked.isInterrupted());
            threadC9Item3Blocked.interrupt();
            System.out.println(threadC9Item3Blocked.getName() + "stopThread()后isInterrupted : " + threadC9Item3Blocked.isInterrupted());
            System.out.println(threadC9Item3Blocked.getName() + "调用了interrupt()后的状态 : " + threadC9Item3Blocked.getState().name());

            Thread.sleep(300);
            System.out.println(threadC9Item3Blocked.getName() + "的状态 : " + threadC9Item3Blocked.getState().name());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
