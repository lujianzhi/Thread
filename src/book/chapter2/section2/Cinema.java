package book.chapter2.section2;

/**
 * Created by Ian.Lu on 2017/3/28.
 * Project : Thread
 */
public class Cinema {

    private int ticketForScreenA;
    private int ticketForScreenB;

    private final Object screenA;
    private final Object screenB;

    public Cinema() {
        ticketForScreenA = 20;
        ticketForScreenB = 20;

        screenA = new Object();
        screenB = new Object();
    }

    public void sellTicketA(int count) {
        synchronized (screenA) {
            if (ticketForScreenA < count) {
                return;
            }
            ticketForScreenA -= count;
        }
    }

    public void returnTicketA(int count) {
        synchronized (screenA) {
            ticketForScreenA += count;
        }
    }

    public void sellTicketB(int count) {
        synchronized (screenB) {
            if (ticketForScreenB < count) {
                return;
            }
            ticketForScreenB -= count;
        }
    }

    public void returnTicketB(int count) {
        synchronized (screenB) {
            ticketForScreenB += count;
        }
    }

    public int getTicketForScreenA() {
        return ticketForScreenA;
    }

    public void setTicketForScreenA(int ticketForScreenA) {
        this.ticketForScreenA = ticketForScreenA;
    }

    public int getTicketForScreenB() {
        return ticketForScreenB;
    }

    public void setTicketForScreenB(int ticketForScreenB) {
        this.ticketForScreenB = ticketForScreenB;
    }
}
