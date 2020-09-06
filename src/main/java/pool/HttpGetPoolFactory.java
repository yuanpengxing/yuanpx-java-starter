package pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.http.client.methods.HttpGet;

public class HttpGetPoolFactory implements PooledObjectFactory<HttpGet> {
    @Override
    public PooledObject makeObject() throws Exception {
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        return new DefaultPooledObject<>(httpGet);
    }

    @Override
    public void destroyObject(PooledObject<HttpGet> p) throws Exception {
        HttpGet object = p.getObject();
        object = null;
    }

    @Override
    public boolean validateObject(PooledObject pooledObject) {
        return true;
    }

    @Override
    public void activateObject(PooledObject pooledObject) throws Exception {

    }

    @Override
    public void passivateObject(PooledObject pooledObject) throws Exception {

    }
}
