package skywang.part3.chapter8.item5;

/**
 * Created by Ian.Lu on 2018/1/17.
 * Project : Thread
 */
public class MyCount {
    private String id;         //账号
    private int cash;       //账户余额

    public MyCount(String id, int cash) {
        this.id = id;
        this.cash = cash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCash() {
        System.out.println(Thread.currentThread().getName() + " getCash cash=" + cash);
        return cash;
    }

    public void setCash(int cash) {
        System.out.println(Thread.currentThread().getName() + " setCash cash=" + cash);
        this.cash = cash;
    }
}
