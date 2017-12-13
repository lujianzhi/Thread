package skywang.part1.chapter4.comment;

/**
 * Created by Ian.Lu on 2017/12/8.
 * Project : Thread
 */
public class TestThread {
    public void method1() {
        System.out.println(Thread.currentThread().getName() + " : method1");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                method2();
            }
        }, "Thread - method1 - t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                method3();
            }
        }, "Thread - method1 - t2");
        t1.start();
        t2.start();
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " : method2");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 5; j++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : method2--" + j);
                }
            }
        }, "Thread - method2").start();
    }

    public synchronized void method3() {
        System.out.println(Thread.currentThread().getName() + " : method3");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 5; j++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : method3--" + j);
                }
            }
        }, "Thread - method3").start();
    }

    public static void main(String[] args) {
        //说不出丶再见   提问：为什么我这样的写法不能顺序执行呢？楼主能指点下吗？
        TestThread test = new TestThread();
        test.method1();
    }
}
