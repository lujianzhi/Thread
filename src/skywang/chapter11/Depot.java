package skywang.chapter11;

/**
 * Created by Ian.Lu on 2017/12/9.
 * Project : Thread
 */
public class Depot {
    //仓库总容量
    private int totalSize;
    //仓库现有产品数量
    private int currentNumber;

    public Depot(int totalSize) {
        this.totalSize = totalSize;
        this.currentNumber = 0;
    }

    public synchronized void produce(int count) {
        try {
            //剩余还有多少要生产
            int left = count;
            while (left > 0) {
                //当仓库现有产品数量大于等于仓库总容量时，不能生产了
                if (currentNumber >= totalSize) {
                    System.out.println("produce wait");
                    wait();
                }
                //如果仓库剩余容量大于要生产数量，那么需要生产数量就是left，否则就是仓库剩余容量
                int needProduct = totalSize - currentNumber > left ? left : totalSize - currentNumber;
                currentNumber += needProduct;
                left -= needProduct;

                System.out.println("生产了:" + needProduct + "个产品;仓库情况:" + toString());
                //唤醒线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void consume(int count) {
        try {
            //剩余还有多少需要消费
            int left = count;
            while (left > 0) {
                //如果仓库现有产品数量没有了，不能消费了
                if (currentNumber <= 0) {
                    System.out.println("consume wait");
                    wait();
                }
                //如果仓库现有产品数量大于需要剩余消费数量，那么需要消费数量就是剩余消费数量，否则是两者两者之差
                int needConsume = currentNumber - left > 0 ? left : currentNumber;
                currentNumber -= needConsume;
                left -= needConsume;

                System.out.println("消费了:" + needConsume + "个产品;仓库情况:" + toString());
                //唤醒线程
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Depot{" +
                "totalSize=" + totalSize +
                ", currentNumber=" + currentNumber +
                '}';
    }
}
