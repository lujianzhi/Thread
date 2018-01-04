package skywang.part2.chapter5;

/**
 * Created by Ian.Lu on 2018/1/4.
 * Project : Thread
 */
public class LongEntity {
    volatile long age;

    private String name;

    public LongEntity(long age, String name) {
        this.age = age;
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LongEntity{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
