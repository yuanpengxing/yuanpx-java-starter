package automation;

import java.io.IOException;

public class CaptureThread extends Thread {
    String name;

    public CaptureThread(String name) {
        this.name = name;
    }

    public void run() {
        String cmd = "adb exec-out screencap -p > d:/testa/sc" + name + ".png";
        String[] command = {"cmd", "/C", cmd};
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
