package chapter2.section4;

/**
 * Created by Ian.Lu on 2017/4/6.
 * Project : Thread
 */
public class Consumer implements Runnable {

    private EventStorage eventStorage;

    public Consumer(EventStorage eventStorage) {
        this.eventStorage = eventStorage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            eventStorage.get();
        }
    }
}
