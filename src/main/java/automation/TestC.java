package automation;

import java.io.IOException;

public class TestC {
    public static void main(String[] args) throws IOException, InterruptedException {
        long l1 = System.currentTimeMillis();

        for (int i = 0; i < 1; i++) {
//            String cmd = "adb exec-out screencap -p > d:/testa/sc" + i + ".png";
//            String[] command = {"cmd", "/C", cmd};
//            Runtime.getRuntime().exec(command);


            Thread.sleep(10);
            CaptureThread captureThread = new CaptureThread("" + System.currentTimeMillis());
            captureThread.start();

        }
        long l2 = System.currentTimeMillis();
        System.out.println(l2 - l1);
    }
}
