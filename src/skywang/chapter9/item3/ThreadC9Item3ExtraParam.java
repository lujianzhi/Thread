package skywang.chapter9.item3;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class ThreadC9Item3ExtraParam extends Thread {

    private boolean goOn = true;

    public ThreadC9Item3ExtraParam(String name) {
        super(name);
    }

    public void stopThread() {
        this.goOn = false;
    }

    @Override
    public void run() {
        super.run();
        int i = 0;
        try {
            while (goOn) {
                Thread.sleep(100);
                i++;
                System.out.println(Thread.currentThread().getName() + "的状态 : " + Thread.currentThread().getState().name() + " ; i : " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "的状态 : " + Thread.currentThread().getState().name() + " ; 抛出InterruptedException异常");
        }
    }
}
