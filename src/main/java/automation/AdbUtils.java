package automation;

import java.io.DataOutputStream;
import java.io.IOException;

public class AdbUtils {
    public static void processDOSRunCmd(DataOutputStream os, String cmd) {
        try {
            os.writeBytes(cmd);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
