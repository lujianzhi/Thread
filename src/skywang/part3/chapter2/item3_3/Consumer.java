package skywang.part3.chapter2.item3_3;

/**
 * Created by Ian.Lu on 2018/1/11.
 * Project : Thread
 */
public class Consumer {

    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void consume(int count) {
        new Thread(() -> {
            try {
                Thread.sleep(100);
                depot.consume(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
