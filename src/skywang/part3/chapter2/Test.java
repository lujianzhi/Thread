package skywang.part3.chapter2;

import skywang.part3.chapter2.item3_1.Consumer;
import skywang.part3.chapter2.item3_1.Depot;
import skywang.part3.chapter2.item3_1.Producer;

/**
 * Created by Ian.Lu on 2018/1/11.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
//        item3_1();
        item3_3();
    }

    private static void item3_3() {
        skywang.part3.chapter2.item3_3.Depot depot = new skywang.part3.chapter2.item3_3.Depot(100, 100);

        skywang.part3.chapter2.item3_3.Consumer consumer = new skywang.part3.chapter2.item3_3.Consumer(depot);
        skywang.part3.chapter2.item3_3.Producer producer = new skywang.part3.chapter2.item3_3.Producer(depot);

        consumer.consume(50);
        consumer.consume(60);
        producer.produce(10);
        producer.produce(40);
    }

    private static void item3_1() {
        Depot depot = new Depot(100);

        Consumer consumer = new Consumer(depot);
        Producer producer = new Producer(depot);

        consumer.consume(50);
        consumer.consume(60);
        producer.produce(10);
        producer.produce(40);
    }
}
