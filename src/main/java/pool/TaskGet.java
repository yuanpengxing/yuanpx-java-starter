package pool;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.TimerTask;

public class TaskGet extends TimerTask {
    String url;

    public TaskGet(String url) {
        this.url = url;
    }

    @Override
    public void run() {
//        synchronized (TaskGet.class) {
//            long now1 = PressureUtils.getNow();
//            long now2 = new Date().getTime();
//            if (now2 - now1 > 1000) {
//                try {
//                    ThreadsWrite.write(String.valueOf(PressureUtils.getSecondRequestNum()));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                PressureUtils.resetSecondRequestNum();
//                PressureUtils.setNow(now1 + 1000);
//            } else {
//                PressureUtils.setSecondRequestNum(1);
//            }
//        }

        try {
            URL url = new URL("https://www.baidu.com/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //连接
            connection.connect();
            //得到响应码
            int responseCode = connection.getResponseCode();
            assert responseCode == 200;
            PressureUtils.setTotalRequestsNum(1);
            System.out.println(PressureUtils.getTotalRequestsNum());

//            if(responseCode == HttpURLConnection.HTTP_OK){
//                //得到响应流
//                InputStream is = connection.getInputStream();
//                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//                // 存放数据
//                StringBuilder sbf = new StringBuilder();
//                String temp = null;
//                while ((temp = br.readLine()) != null) {
//                    sbf.append(temp).append(StringUtils.LF);
//                }
//                String result = sbf.toString();
////                System.out.println(result);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
