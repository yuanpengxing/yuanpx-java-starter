package ordersequence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

public class MainTest {

    public static void main(String[] args) throws InterruptedException {
        List<Timer> timers = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            Timer timer = new Timer();
            timer.schedule(new ThreadA("SH600000"), new Date(), 1000);
            timers.add(timer);
        }

    }

}
