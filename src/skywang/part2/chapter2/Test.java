package skywang.part2.chapter2;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Ian.Lu on 2018/1/2.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
        item3();
    }

    /**
     * AtomicInteger, AtomicLong和AtomicBoolean这3个基本类型的原子类的原理和用法相似。
     * 本章以AtomicLong对基本类型的原子类进行介绍。
     */
    private static void item3() {
        AtomicLong atomicLong = new AtomicLong();

        atomicLong.set(40);
        // 以原子方式设置当前值为newValue
        print("set", atomicLong.get());

        // 以原子方式将当前值减 1，并返回减1后的值。等价于“--num”
        print("decrementAndGet", atomicLong.decrementAndGet());

        // 以原子方式将当前值减 1，并返回减1前的值。等价于“num--”
        print("getAndDecrement", atomicLong.getAndDecrement());
        print("getAndDecrement后调用get", atomicLong.get());

        // 以原子方式将当前值加 1，并返回加1后的值。等价于“++num”
        print("incrementAndGet", atomicLong.incrementAndGet());

        // 以原子方式将当前值加 1，并返回加1前的值。等价于“num++”
        print("getAndIncrement", atomicLong.getAndIncrement());
        print("getAndIncrement后调用get", atomicLong.get());

        // 以原子方式将delta与当前值相加，并返回相加后的值。
        print("addAndGet", atomicLong.addAndGet(10));

        // 以原子方式将delta添加到当前值，并返回相加前的值。
        print("getAndAdd", atomicLong.getAndAdd(10));
        print("getAndAdd后调用get", atomicLong.get());

        // 如果当前值 == expect，则以原子方式将该值设置为update。成功返回true，否则返回false，并且不修改原值。
        print("compareAndSet:期望值为60,设值为10", atomicLong.compareAndSet(60, 10));
        print("compareAndSet的结果:", atomicLong.get());

        // 以原子方式设置当前值为newValue，并返回旧值
        print("getAndSet(50)", atomicLong.getAndSet(50));
        print("getAndSet(50)后调用get", atomicLong.get());

        print("intValue", atomicLong.intValue());
        print("longValue", atomicLong.longValue());
        print("doubleValue", atomicLong.doubleValue());
        print("floatValue", atomicLong.floatValue());

        // 最后设置为给定值。延时设置变量值，这个等价于set()方法，
        // 但是由于字段是volatile类型的，因此次字段的修改会比普通字段（非volatile字段）有稍微的性能延时（尽管可以忽略），
        // 所以如果不是想立即读取设置的新值，允许在“后台”修改值，那么此方法就很有用。
        // 如果还是难以理解，这里就类似于启动一个后台线程如执行修改新值的任务，原线程就不等待修改结果立即返回（这种解释其实是不正确的，但是可以这么理解）。
        atomicLong.lazySet(10);
        print("lazySet(10)", atomicLong.get());

        // 如果当前值 == 预期值，则以原子方式将该设置为给定的更新值。
        // JSR规范中说：以原子方式读取和有条件地写入变量但不 创建任何 happen-before 排序，
        // 因此不提供与除 weakCompareAndSet 目标外任何变量以前或后续读取或写入操作有关的任何保证。
        // 大意就是说调用weakCompareAndSet时并不能保证不存在happen-before的发生（也就是可能存在指令重排序导致此操作失败）。
        // 但是从Java源码来看，其实此方法并没有实现JSR规范的要求，最后效果和compareAndSet是等效的，都调用了unsafe.compareAndSwapInt()完成操作。
        print("weakCompareAndSet:期望值为60,设值为10", atomicLong.weakCompareAndSet(10, 50));
        print("weakCompareAndSet的结果", atomicLong.get());
    }

    private static void print(String name, long value) {
        System.out.println(name + " - value:" + value);
    }

    private static void print(String name, int value) {
        System.out.println(name + " - value:" + value);
    }

    private static void print(String name, double value) {
        System.out.println(name + " - value:" + value);
    }

    private static void print(String name, float value) {
        System.out.println(name + " - value:" + value);
    }

    private static void print(String name, boolean value) {
        System.out.println(name + " - value:" + value);
    }
}
