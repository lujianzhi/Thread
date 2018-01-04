package skywang.part2.chapter3;

import java.util.concurrent.atomic.AtomicLongArray;

/**
 * Created by Ian.Lu on 2018/1/4.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
        item3();
    }

    /**
     * AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray这3个数组类型的原子类的原理和用法相似。
     * 本章以AtomicLongArray对数组类型的原子类进行介绍。
     */
    private static void item3() {
        long[] array = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        AtomicLongArray atomicLongArray = new AtomicLongArray(array);
        print("构造函数", atomicLongArray);

        // 将位置 i 的元素设置为给定值。
        atomicLongArray.set(2, 0);
        print("set(2,0)后再输出", atomicLongArray);

        // 以原子方式将给定值添加到索引 i 的元素。++i
        print("addAndGet(1, 10)", atomicLongArray.addAndGet(1, 10));
        print("addAndGet(1,10)后再输出", atomicLongArray);

        // 以原子方式将给定值与索引 i 的元素相加。i++
        print("getAndAdd(1, 10)", atomicLongArray.getAndAdd(1, 10));
        print("getAndAdd(1,10)后再输出", atomicLongArray);

        // 以原子方式将索引 i 的元素减1，并返回i位置的元素值 --array[i]
        print("decrementAndGet(0)", atomicLongArray.decrementAndGet(0));
        print("decrementAndGet(0)后再输出", atomicLongArray);

        // 以原子方式将索引 i 的元素减 1，并返回i位置的元素值 array[i]--
        print("getAndDecrement(0)", atomicLongArray.getAndDecrement(0));
        print("getAndDecrement(0)后再输出", atomicLongArray);

        // 以原子方式将索引 i 的元素加1，并返回i位置的元素值 ++array[i]
        print("incrementAndGet(0)", atomicLongArray.incrementAndGet(0));
        print("incrementAndGet(0)后再输出", atomicLongArray);

        // 以原子方式将索引 i 的元素加 1，并返回i位置的元素值 array[i]++
        print("getAndIncrement(0)", atomicLongArray.getAndIncrement(0));
        print("getAndIncrement(0)后再输出", atomicLongArray);

        // 如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。
        print("compareAndSet(3,4,40)", atomicLongArray.compareAndSet(3, 4, 40));
        print("compareAndSet(3,4,40)后再输出", atomicLongArray);
    }

    private static void print(String name, boolean value) {
        System.out.println(name + " - value:" + value);
    }

    private static void print(String name, long number) {
        System.out.println(name + " - value:" + number);
    }

    private static void print(String name, AtomicLongArray atomicLongArray) {
        System.out.println(name + " - value:" + atomicLongArray.toString());
    }
}
