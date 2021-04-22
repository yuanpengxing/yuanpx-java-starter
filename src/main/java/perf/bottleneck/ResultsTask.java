package perf.bottleneck;

import utils.CommandLineUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Timer;
import java.util.TimerTask;

public class ResultsTask extends TimerTask {
    File errorResultsFile;
    String killCmd;
    Thread jMeterThread;
    Timer errorResultTimer;
    Timer tpsTimer;
    int maxErrorNum;

    public ResultsTask(File errorResultsFile, String killCmd, Thread jMeterThread, Timer errorResultTimer,
                       Timer tpsTimer, int maxErrorNum) {
        this.errorResultsFile = errorResultsFile;
        this.killCmd = killCmd;
        this.jMeterThread = jMeterThread;
        this.errorResultTimer = errorResultTimer;
        this.tpsTimer = tpsTimer;
        this.maxErrorNum = maxErrorNum;
    }
    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(errorResultsFile));
            int errorNum = 0;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("<httpSample")) {
                    errorNum++;
                }
                if (line.startsWith("</testResults>")) {
                    MainEntry.isTaskDone = false;
                    errorResultTimer.cancel();
                    tpsTimer.cancel();
                }
            }
            br.close();
            if (errorNum > maxErrorNum) {
                System.out.println("报错日志参看log.txt");
                MainEntry.isTaskDone = false;
                CommandLineUtils.runCmd(killCmd);
                jMeterThread.stop();
                errorResultTimer.cancel();
                tpsTimer.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
