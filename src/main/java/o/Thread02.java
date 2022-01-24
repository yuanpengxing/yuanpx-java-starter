package o;

import java.net.HttpURLConnection;
import java.net.URL;

public class Thread02 extends Thread {
    String timeStr;

    public Thread02(String timeStr) {
        this.timeStr = timeStr;
    }

    public void run() {
        HttpURLConnection connection;
        URL url = null;
        for (int i = 0; i < 20000; i++) {
            try {
                url = new URL("http://www.baidu.com");
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                String dd = connection.getHeaderField("Date");
                if (dd.contains(timeStr)) {
                    if (!InvestUtils.getIsTimeOut()) {
                        InvestUtils.setIsTimeOut(true);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
