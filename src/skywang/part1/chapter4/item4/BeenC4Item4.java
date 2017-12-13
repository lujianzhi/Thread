package skywang.part1.chapter4.item4;

/**
 * Created by Ian.Lu on 2017/12/7.
 * Project : Thread
 */
public class BeenC4Item4 {

    public synchronized void isSyncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " : isSyncA()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void isSyncB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " : isSyncB()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void cSyncA() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " : cSyncA()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void cSyncB() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " : cSyncB()");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
