package moutai;

import java.io.IOException;

public class ThreadA extends Thread {
    public void run() {
        try {
            Runtime.getRuntime().exec("adb shell input tap 210 1150");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
