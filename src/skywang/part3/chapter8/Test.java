package skywang.part3.chapter8;

import skywang.part3.chapter8.item5.MyCount;
import skywang.part3.chapter8.item5.User;

/**
 * Created by Ian.Lu on 2018/1/17.
 * Project : Thread
 */
public class Test {

    public static void main(String[] args) {
        item5();
    }

    private static void item5() {
        MyCount myCount = new MyCount("Ian", 100);
        User user = new User("Ian", myCount);
        user.getCash();
        user.setCash(200);
        user.getCash();
        user.setCash(300);
        user.getCash();
        user.setCash(400);
        user.getCash();
        user.setCash(500);
        user.getCash();
    }
}
