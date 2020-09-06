package pool;

import java.io.IOException;
import java.util.*;

public class PressureUtils {
    private static int totalRequestsNum = 0;
    private static int secondRequestNum = 0;
    private static long now;

    public static void main(String[] args) throws InterruptedException, IOException {
        String url = "http://www.baidu.com";
        List<Timer> timerList = new ArrayList<>();

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.MILLISECOND, 2000);
        Date time = c.getTime();
        PressureUtils.setNow(time.getTime());
        for (int i = 0; i < 300; i++) {
            Timer timer = new Timer();
            timer.schedule(new TaskGet(url), time, 1000);
            timerList.add(timer);
        }

        Thread.sleep(1000 * 60);
        for (Timer timer : timerList) {
            timer.cancel();
        }
    }

    public static void setTotalRequestsNum(int num) {
        synchronized (PressureUtils.class) {
            totalRequestsNum += num;
        }
    }

    public static int getTotalRequestsNum() {
        synchronized (PressureUtils.class) {
            return totalRequestsNum;
        }
    }

    public static void setSecondRequestNum(int num) {
        synchronized (PressureUtils.class) {
            secondRequestNum += num;
        }
    }

    public static void resetSecondRequestNum() {
        synchronized (PressureUtils.class) {
            secondRequestNum = 0;
        }
    }

    public static int getSecondRequestNum() {
        synchronized (PressureUtils.class) {
            return secondRequestNum;
        }
    }

    public static void setNow(long l) {
        synchronized (PressureUtils.class) {
            now = l;
        }
    }

    public static long getNow() {
        synchronized (PressureUtils.class) {
            return now;
        }
    }

}
