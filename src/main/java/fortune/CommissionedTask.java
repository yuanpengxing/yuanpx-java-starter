package fortune;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedWriter;
import java.util.TimerTask;

public class CommissionedTask extends TimerTask {
    String code;
    BufferedWriter bw;

    public CommissionedTask(String code, BufferedWriter bw) {
        this.code = code;
        this.bw = bw;
    }

    @Override
    public void run() {
        String url = "http://qt.gtimg.cn/q=" + code.toLowerCase();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpClient.execute(httpget);
            HttpEntity entity = response.getEntity();
            bw.write(EntityUtils.toString(entity));
        } catch (Exception ignored) {
            System.out.println(ignored);
        }

    }
}
