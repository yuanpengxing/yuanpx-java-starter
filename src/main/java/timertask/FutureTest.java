package timertask;

import java.util.concurrent.*;

//等待线程执行完毕，返回执行结果
public class FutureTest {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                //sleep 是为了调试方便
                TimeUnit.SECONDS.sleep(4);
                return 3;
            }
        };
        //创建一个 ThreadPoolExecutor 对象
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> future = executorService.submit(callable);
        try {
            Integer i = future.get();
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
