package skywang.part2.chapter4;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Ian.Lu on 2018/1/4.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
        item3();
    }

    /**
     * AtomicReference是作用是对"对象"进行原子操作。
     */
    private static void item3() {
        Entity entity1 = new Entity("张三", 20);
        System.out.println("entity1:" + entity1.toString());
        Entity entity2 = new Entity("李四", 30);
        System.out.println("entity2:" + entity2.toString());
        Entity entity3 = new Entity("赵五", 40);
        System.out.println("entity3:" + entity3.toString());
        AtomicReference<Entity> atomicReference = new AtomicReference<>();

        // 设置为给定值。
        atomicReference.set(entity1);
        print("set(entity)", atomicReference);

        // 以原子方式设置为给定值，并返回旧值。
        print("getAndSet(entity2)", atomicReference.getAndSet(entity2));
        print("getAndSet(entity2)后再输出", atomicReference);

        // 如果当前值 == 预期值，则以原子方式将该值设置为给定的更新值。
        print("compareAndSet(entity1, entity2)", atomicReference.compareAndSet(entity2, entity3));
        print("compareAndSet(entity1, entity2)后再输出", atomicReference);
    }

    private static void print(String name, boolean value) {
        System.out.println(name + " - value:" + value);
    }

    private static void print(String name, Entity entity1) {
        System.out.println(name + " - value:" + entity1.toString());
    }

    private static void print(String name, AtomicReference<Entity> atomicReference) {
        System.out.println(name + " - value:" + atomicReference.get().toString());
    }
}
