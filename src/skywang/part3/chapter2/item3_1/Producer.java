package skywang.part3.chapter2.item3_1;

/**
 * Created by Ian.Lu on 2018/1/11.
 * Project : Thread
 */
public class Producer {

    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(int number) {
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                depot.produce(number);
            }
        }.start();
    }
}
