package skywang.part1.chapter4.item2;

/**
 * Created by Ian.Lu on 2017/12/7.
 * Project : Thread
 */
public class BeenC4Item2Row3 {

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

    public void printSynTwo() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(500);
                    System.out.println(Thread.currentThread().getName() + " : printSynTwo-" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
