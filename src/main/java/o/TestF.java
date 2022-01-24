package o;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestF {
    public static void main(String[] args) throws InterruptedException, ParseException, AWTException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeStr = "10:00:00";
        long time2 = sdf.parse("2021-07-12 " + timeStr).getTime();
        long time1 = new Date().getTime();

        Thread.sleep(time2 - time1 + 8 * 3600 * 1000 - 2000);

        List<Thread02> thread02s = new ArrayList<Thread02>();
        for (int i = 0; i < 12; i++) {
            Thread02 t1 = new Thread02(timeStr);
            t1.start();
            thread02s.add(t1);
        }

        Robot robot = new Robot();
        for (int i = 0; i < 1000000; i++) {
            Thread.sleep(1);
            if (InvestUtils.getIsTimeOut()) {
//                robot.mouseMove(250, 295);
                robot.mousePress(KeyEvent.BUTTON1_MASK);
                robot.mouseRelease(KeyEvent.BUTTON1_MASK);
                robot.mouseMove(185, 375);
                Thread.sleep(30);
                robot.mousePress(KeyEvent.BUTTON1_MASK);
                robot.mouseRelease(KeyEvent.BUTTON1_MASK);
                robot.mousePress(KeyEvent.BUTTON1_MASK);
                robot.mouseRelease(KeyEvent.BUTTON1_MASK);
                for (Thread02 t : thread02s) {
                    t.stop();
                }
                break;
            }
        }
    }
}
