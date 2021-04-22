package perf.bottleneck;

import org.apache.commons.lang3.StringUtils;
import utils.CommandLineUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TPSTask extends TimerTask {
    File tpsFile;
    String killCmd;
    JMeterThread jMeterThread;
    Timer tpsTimer;
    Timer errorResultTimer;
    int maxThread;
    int count;
    int countsOfLowerMaxTps;

    public TPSTask(File tpsFile, String killCmd, JMeterThread jMeterThread, Timer tpsTimer, int maxThread, int count,
                   Timer errorResultTimer, int countsOfLowerMaxTps) {
        this.tpsFile = tpsFile;
        this.killCmd = killCmd;
        this.jMeterThread = jMeterThread;
        this.tpsTimer = tpsTimer;
        this.errorResultTimer = errorResultTimer;
        this.maxThread = maxThread;
        this.count = count;
        this.countsOfLowerMaxTps = countsOfLowerMaxTps;
    }

    @Override
    public void run() {
        String secNow = Long.toString(new Date().getTime() - 2000).substring(0, 10);
        int cc = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(tpsFile));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("1")) {
                    if (StringUtils.equals(secNow, line.substring(0, 10))) {
                        cc++;
                    }
                }
            }
        } catch (Exception e) {

        }
        if (cc <= maxThread) {
            count++;
            if (count >= countsOfLowerMaxTps) {
                System.out.println("最大tps: " + maxThread);
                MainEntry.isTaskDone = false;
                CommandLineUtils.runCmd(killCmd);
                jMeterThread.stop();
                tpsTimer.cancel();
                errorResultTimer.cancel();
            }
        } else {
            maxThread = cc;
            count = 0;
        }
    }
}
