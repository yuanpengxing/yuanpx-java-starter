package pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpClientPoolFactory implements PooledObjectFactory<CloseableHttpClient> {
    @Override
    public PooledObject makeObject() throws Exception {
//        System.out.println("makeObject");
        CloseableHttpClient httpClient = HttpClients.createDefault();
        return new DefaultPooledObject<>(httpClient);
    }

    @Override
    public void destroyObject(PooledObject<CloseableHttpClient> p) throws Exception {
//        System.out.println("destroyObject");
        CloseableHttpClient httpClient = p.getObject();
        httpClient = null;
    }

    @Override
    public boolean validateObject(PooledObject<CloseableHttpClient> p) {
        System.out.println("validateObject");
        return true;
    }

    @Override
    public void activateObject(PooledObject<CloseableHttpClient> p) throws Exception {
//        System.out.println("activateObject");
    }

    @Override
    public void passivateObject(PooledObject<CloseableHttpClient> p) throws Exception {
//        System.out.println("passivateObject");
    }
}
