package skywang.part1.chapter11;

/**
 * Created by Ian.Lu on 2017/12/10.
 * Project : Thread
 */
public class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(int count) {
        new Thread(() -> depot.produce(count), "Producer").start();
    }
}
