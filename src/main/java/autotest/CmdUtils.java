package autotest;

import java.io.IOException;
import java.io.OutputStream;

public class CmdUtils {

    public static OutputStream runCmd(String cmd) {
        OutputStream os = null;
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            os = process.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return os;
    }
}
