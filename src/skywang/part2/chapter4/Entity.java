package skywang.part2.chapter4;

/**
 * Created by Ian.Lu on 2018/1/4.
 * Project : Thread
 */
public class Entity {

    private String name;

    private int age;

    public Entity(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "hashCode='" + hashCode() + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
