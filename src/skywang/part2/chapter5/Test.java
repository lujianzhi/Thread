package skywang.part2.chapter5;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * Created by Ian.Lu on 2018/1/4.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
        item3();
    }

    /**
     * AtomicLongFieldUpdater可以对指定"类的 'volatile long'类型的成员"进行原子更新。它是基于反射原理实现的。
     */
    private static void item3() {
        // 为对象创建并返回一个具有给定字段的更新器。
        AtomicLongFieldUpdater atomicLongFieldUpdater = AtomicLongFieldUpdater.newUpdater(LongEntity.class, "age");
        LongEntity longEntity = new LongEntity(20, "张三");
        System.out.println(longEntity.toString());

        // 以原子方式将给定值添加到此更新器管理的给定对象的字段的当前值。
        print("addAndGet(longEntity, 100)", atomicLongFieldUpdater.addAndGet(longEntity, 100));
        print("addAndGet(longEntity, 100)后再输出", longEntity);

        // 以原子方式将给定值添加到此更新器管理的给定对象的字段的当前值。
        print("getAndAdd(longEntity, 100)", atomicLongFieldUpdater.getAndAdd(longEntity, 100));
        print("getAndAdd(longEntity, 100)后再输出", longEntity);

        // 以原子方式将此更新器管理的给定对象字段的当前值加 1。
        print("getAndIncrement(longEntity)", atomicLongFieldUpdater.getAndIncrement(longEntity));
        print("getAndIncrement(longEntity)后再输出", longEntity);

        // 以原子方式将此更新器管理的给定对象字段的当前值加 1。
        print("incrementAndGet(longEntity)", atomicLongFieldUpdater.incrementAndGet(longEntity));
        print("incrementAndGet(longEntity)后再输出", longEntity);

        // 如果当前值 == 预期值，则以原子方式将此更新器所管理的给定对象的字段设置为给定的更新值。
        print("compareAndSet(longEntity, 20, 30)", atomicLongFieldUpdater.compareAndSet(longEntity, 20, 30));
        print("compareAndSet(longEntity, 20, 30)后再输出", longEntity);
    }

    private static void print(String name, long value) {
        System.out.println(name + " - age value: " + value);
    }

    private static void print(String name, boolean value) {
        System.out.println(name + " - value: " + value);
    }

    private static void print(String name, LongEntity longEntity) {
        System.out.println(name + " - value: " + longEntity.toString());
    }
}
