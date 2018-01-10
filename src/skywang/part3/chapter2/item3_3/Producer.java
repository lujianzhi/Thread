package skywang.part3.chapter2.item3_3;

/**
 * Created by Ian.Lu on 2018/1/11.
 * Project : Thread
 */
public class Producer {

    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(int count) {
        new Thread(() -> {
            try {
                Thread.sleep(100);
                depot.produce(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
