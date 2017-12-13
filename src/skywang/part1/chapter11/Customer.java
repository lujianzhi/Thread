package skywang.part1.chapter11;

/**
 * Created by Ian.Lu on 2017/12/10.
 * Project : Thread
 */
public class Customer {
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    public void consume(int count) {
        new Thread(() -> depot.consume(count), "Customer").start();
    }
}
