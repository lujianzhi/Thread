package chapter2.section2;

/**
 * Created by Ian.Lu on 2017/3/28.
 * Project : Thread
 */
public class SellARunnable implements Runnable {

    private Cinema cinema;

    public SellARunnable(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            cinema.sellTicketA(2);
            cinema.sellTicketA(3);
            cinema.sellTicketA(4);
            cinema.sellTicketA(5);
            cinema.returnTicketA(10);

            cinema.sellTicketB(6);
            cinema.sellTicketB(7);
            cinema.sellTicketB(2);
            cinema.returnTicketB(1);
        }

    }
}
