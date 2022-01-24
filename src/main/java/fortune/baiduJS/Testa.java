package fortune.baiduJS;

import automation.AdbUtils;
import utils.CommandLineUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

public class Testa {
    public static void main(String[] args) throws IOException, InterruptedException {
//        Process process = Runtime.getRuntime().exec("adb -s QXXGL21106000011 shell");
//        DataOutputStream os = new DataOutputStream(process.getOutputStream());
//        AdbUtils.processDOSRunCmd(os, "input tap 350 600");
//        AdbUtils.processDOSRunCmd(os, "adb -s QXXGL21106000011 shell input swipe 350 900 350 300 500");


//        for (int i = 0; i < 5; i++) {
//            CommandLineUtils.runCmd("adb -s QXXGL21106000011 shell input swipe 350 900 350 300 500");
//            Thread.sleep(5000);
//        }

        while (true) {
            CommandLineUtils.runCmd("adb -s QXXGL21106000011 shell input swipe 350 900 350 300 500");
            int nextInt = new Random().nextInt(5);
            System.out.println(nextInt);
            Thread.sleep(nextInt * 1000 * 10*3);
        }
    }
}
