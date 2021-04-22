package perf.bottleneck;

import utils.CommandLineUtils;

public class JMeterThread extends Thread {
    String cmd;

    public JMeterThread(String cmd){
        this.cmd = cmd;
    }

    public void run() {
        String run = CommandLineUtils.runCmd(cmd);
        System.out.println(run);
    }
}
