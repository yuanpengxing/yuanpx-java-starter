package utils;

import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.InputStream;

public class Base64 {

    public static String getImageStr(String imageFilePath) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imageFilePath);
            data = new byte[in.available()];
            in.read(data);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data).replaceAll("\n|\r", "");
    }
}
