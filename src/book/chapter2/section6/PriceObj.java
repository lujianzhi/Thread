package book.chapter2.section6;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Ian.Lu on 2017/4/6.
 * Project : Thread
 */
public class PriceObj {

    private ReadWriteLock readWriteLock;
    private double priceA;
    private double priceB;

    public PriceObj() {
        readWriteLock = new ReentrantReadWriteLock();
        priceA = 1.0;
        priceB = 2.0;
    }

    public double getPriceA() {
        readWriteLock.readLock().lock();
        double price = priceA;
        readWriteLock.readLock().unlock();
        return price;
    }

    public double getPriceB() {
        readWriteLock.readLock().lock();
        double price = priceB;
        readWriteLock.readLock().unlock();
        return price;
    }

    public void setPrice(double newPriceA, double newPriceB) {
        readWriteLock.writeLock().lock();
        this.priceA = newPriceA;
        this.priceB = newPriceB;
        readWriteLock.writeLock().unlock();
    }
}
