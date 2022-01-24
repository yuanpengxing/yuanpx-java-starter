package fortune.baiduJS;

import utils.CommandLineUtils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Testb {
    public static void main(String[] args) throws InterruptedException, IOException {
        String cmd = "adb exec-out screencap -p > d:\\testa.png";
        String[] command = {"cmd", "/C", cmd};
        long l1 = System.currentTimeMillis();
        Process process = Runtime.getRuntime().exec(command);
        long l2 = System.currentTimeMillis();
        System.out.println(l2-l1);
    }
}
