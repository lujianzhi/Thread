package skywang.part1.chapter9.item3;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class ThreadC9Item3Blocked extends Thread {

    public ThreadC9Item3Blocked(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        try {
            int i = 0;
            System.out.println(Thread.currentThread().getName() + " 进入while循环前 : isInterrupted : " + isInterrupted());
            while (!isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " sleep之前 : isInterrupted : " + isInterrupted());
                //线程会处于休眠阻塞状态
                sleep(100);
                i++;
                System.out.println(Thread.currentThread().getName() + "的状态 : " + Thread.currentThread().getState().name() + " ; i : " + i);
                System.out.println(Thread.currentThread().getName() + " sleep之后 : isInterrupted : " + isInterrupted());
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "的状态 : " + Thread.currentThread().getState().name() + " ; 抛出InterruptedException异常");
            System.out.println(Thread.currentThread().getName() + " 发生异常 : isInterrupted : " + isInterrupted());
        }
    }
}
