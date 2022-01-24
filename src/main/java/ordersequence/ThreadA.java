package ordersequence;

import apache.HttpsClient;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

public class ThreadA extends TimerTask {
    String code;

    public ThreadA(String code) {
        this.code = code;
    }

    @Override
    public void run() {
        try {
//            String s = HttpsClient.post("http://hq.sinajs.cn/list=" + code.toLowerCase(), "");
//            System.out.println(s);
            System.out.println(new Date().getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
