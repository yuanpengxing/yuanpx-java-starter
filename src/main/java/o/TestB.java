package o;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestB {
    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        Robot robot = new Robot();

        long t1 = System.currentTimeMillis();

//        for (int i = 0; i < 100; i++) {
//            URL url = new URL("http://www.baidu.com");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.connect();
////            long date1 = connection.getDate();
//            String date = connection.getHeaderField("Date");
////            System.out.println(date1);
//
//        }
        robot.mouseMove(1000,200);
        robot.mousePress(KeyEvent.BUTTON1_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_MASK);


        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }
}
