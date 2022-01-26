package automation;

import org.apache.poi.ss.formula.functions.T;
import utils.CommandLineUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestB {
    public static void main(String[] args) throws InterruptedException {

//        List<OutputStream> oss = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            oss.add(CmdUtils.getProcessOS("adb shell"));
//        }
//        for (OutputStream os : oss) {
//            CmdUtils.processRun(os, "input tap 360 1370");
//            Thread.sleep(5);
//        }

        OutputStream os = CmdUtils.getProcessOS("adb shell");
        CmdUtils.processRun(os, "input tap 360 870");
        Thread.sleep(1000);

        CmdUtils.processRun(os, "input tap 360 1370");
//        Thread.sleep(100);
        CmdUtils.processRun(os, "input tap 360 1370");

    }
}
