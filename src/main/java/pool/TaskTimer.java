package pool;

import java.util.Date;
import java.util.TimerTask;

public class TaskTimer extends TimerTask {

    @Override
    public void run() {
        System.out.println(PressureUtils.getSecondRequestNum());
        PressureUtils.resetSecondRequestNum();
        PressureUtils.setNow(new Date().getTime());
    }

}
