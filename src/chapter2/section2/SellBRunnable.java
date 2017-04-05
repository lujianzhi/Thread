package chapter2.section2;

/**
 * Created by Ian.Lu on 2017/3/28.
 * Project : Thread
 */
public class SellBRunnable implements Runnable {

    private Cinema cinema;

    public SellBRunnable(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            cinema.returnTicketA(9);
            cinema.sellTicketA(1);
            cinema.sellTicketA(3);
            cinema.sellTicketA(7);
            cinema.sellTicketA(5);

            cinema.returnTicketB(10);
            cinema.sellTicketB(4);
            cinema.sellTicketB(3);
            cinema.sellTicketB(1);
        }

    }
}
