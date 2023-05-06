package autotest;

import java.io.OutputStream;

public class RootShellCmd {
    private static Process process;
    private static OutputStream os;

    public static final void exec(String cmd) {
        try {
            if (process == null) {
                process = Runtime.getRuntime().exec("adb shell");
                os = process.getOutputStream();
            }
            os.write(cmd.getBytes());
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static final void simulateKey(int keyCode) {
        exec(String.format("input keyevent %d &\n", keyCode));
    }

    public static final void simulateClick(int x, int y) {
        exec(String.format("input tap %d %d &\n", x, y));
    }


}
