package skywang.chapter11;

/**
 * Created by Ian.Lu on 2017/12/10.
 * Project : Thread
 */
public class Test {
    public static void main(String[] args) {
        Depot depot = new Depot(100);
        Producer producer = new Producer(depot);
        Customer customer = new Customer(depot);

        producer.produce(60);
        producer.produce(50);
        customer.consume(30);
        customer.consume(90);
    }
}
