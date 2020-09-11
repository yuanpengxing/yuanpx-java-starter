package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

    public Properties getProperties(String propertiesPath) {
        InputStream in = PropertiesUtils.class.getClassLoader().getResourceAsStream(propertiesPath);
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pro;
    }

}
