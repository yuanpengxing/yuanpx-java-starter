package timertask;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task3 {
    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Hello, stranger");
            }
        };
        // ScheduledExecutorService:是从Java SE5的java.util.concurrent里，
        // 做为并发工具类被引进的，这是最理想的定时任务实现方式。
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        // 10：秒   5：秒
        // 第一次执行的时间为10秒，然后每隔五秒执行一次
        service.scheduleAtFixedRate(runnable, 2, 1, TimeUnit.SECONDS);
        service.shutdown();
        System.out.println(service.isTerminated());
    }
}
