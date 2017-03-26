package chapter1.section9;

/**
 * Created by Ian.Lu on 2017/3/27.
 * Project : Thread
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName() + "异常 : " + e.getMessage());
//        e.printStackTrace();
    }
}
