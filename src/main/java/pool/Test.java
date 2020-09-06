package pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.http.impl.client.CloseableHttpClient;

public class Test {

    public static void main(String[] args) throws Exception {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        //最大连接数
        config.setMaxTotal(6);
        //最大空闲数
        config.setMaxIdle(3);
        //最小空闲数
        config.setMinIdle(1);
        //最长等待时间，3秒
        config.setMaxWaitMillis(3000);
        HttpClientPoolFactory factory = new HttpClientPoolFactory();
        GenericObjectPool<CloseableHttpClient> objectPool = new GenericObjectPool<CloseableHttpClient>(factory, config);
        for (int i = 0; i < 30; i++) {
            //获取资源对象
            CloseableHttpClient hc = objectPool.borrowObject();
            //将获取的资源对象，返还给资源池
            objectPool.returnObject(hc);
            //输出资源对象
            System.out.println(hc);
        }
    }
}
