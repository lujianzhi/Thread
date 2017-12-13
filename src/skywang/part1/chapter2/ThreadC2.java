package skywang.part1.chapter2;

/**
 * Created by Ian.Lu on 2017/12/6.
 * Project : Thread
 */
public class ThreadC2 extends Thread {

    private int tickets = 10;

    @Override
    public void run() {
        super.run();
        while (tickets > 0)
            System.out.println(tickets--);
    }
}
