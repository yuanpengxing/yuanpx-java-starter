package automation;

import java.io.IOException;
import java.io.OutputStream;

public class CmdUtils {
    public static void processRun(OutputStream os, String cmd) {
        try {
            synchronized (CmdUtils.class) {
                os.write((cmd + " &\n").getBytes());
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static OutputStream getProcessOS(String cmd) {
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
