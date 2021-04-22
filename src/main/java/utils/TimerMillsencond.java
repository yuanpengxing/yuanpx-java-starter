package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimerMillsencond {
    public static void main(String[] args) throws ParseException, InterruptedException {
        specifyTime("2020-12-05 18:20:30");
        System.out.println(new Date().getTime());
    }

    public static void specifyTime(String pattern) throws ParseException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long specifyTimestamp = sdf.parse(pattern).getTime();
        while (true) {
            long currentTimestamp = new Date().getTime();
            if (currentTimestamp < specifyTimestamp) {
                if (currentTimestamp < specifyTimestamp - 1000) {
                    Thread.sleep(1000);
                } else {
                    Thread.sleep(2);
                }
            } else {
                System.out.println("时间到，currentTimestamp: " + currentTimestamp + "，specifyTimestamp: " + specifyTimestamp);
                break;
            }
        }
    }
}
