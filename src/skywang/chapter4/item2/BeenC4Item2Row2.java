package skywang.chapter4.item2;

/**
 * Created by Ian.Lu on 2017/12/7.
 * Project : Thread
 */
public class BeenC4Item2Row2 {

    public void printSyn() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + " : printSyn-" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printUnsyn() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " : printUnsyn-" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
