package perf.bottleneck;

import org.apache.commons.cli.ParseException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import utils.CommandLineUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainEntry {
    static boolean isTaskDone = true;

    public static void main(String[] args) throws ParseException, IOException, InterruptedException {

        Map<String, String> cmdLineParamsMap = CommonsUtils.parserCommandLine(args);
        if (!cmdLineParamsMap.containsKey("jmeterScriptsDir") || !cmdLineParamsMap.containsKey("jmeterExePath")) {
            StringBuilder sb = new StringBuilder();
            sb.append(StringUtils.LF).append(StringUtils.LF);
            sb.append("usage example: java -jar D:\\soft\\perfauto.jar -j D:\\soft\\apache-jmeter-5.1.1\\bin\\jmeter.bat -d C:\\Users\\x\\Desktop\\test\\NewScripts -n 100").append(StringUtils.LF).append(StringUtils.LF);
            sb.append("-j: path of jmeter executor").append(StringUtils.LF);
            sb.append("-d: directory of jmeter scripts").append(StringUtils.LF);
            sb.append("-n: max num of errors accepted").append(StringUtils.LF);
            throw new RuntimeException(sb.toString());
        }
        if (!cmdLineParamsMap.containsKey("maxErrorNum")) {
            cmdLineParamsMap.put("maxErrorNum", "50");
        }
        if (!cmdLineParamsMap.containsKey("countsOfLowerMaxTps")) {
            cmdLineParamsMap.put("countsOfLowerMaxTps", "30");
        }
        System.out.println("CountsOfLowerMaxTps: " + cmdLineParamsMap.get("countsOfLowerMaxTps"));
        System.out.println("MaxErrorNum: " + cmdLineParamsMap.get("maxErrorNum"));

        // 跑整个文件夹
        String[] strArray = {"jmx"};
        Collection<File> files = FileUtils.listFiles(new File(cmdLineParamsMap.get("jmeterScriptsDir")), strArray, false);
        for (File oldScriptFile : files) {
            String jmeterScriptParent = oldScriptFile.getParent();
            String scriptName = oldScriptFile.getName().substring(0, oldScriptFile.getName().length() - 4);
            String newScriptFile = jmeterScriptParent + "/" + scriptName + "_B.jmx";

            String erResultFilePath = jmeterScriptParent + "/" + scriptName + "_ErrorResults.jtl";
            String respTimeFilePath = jmeterScriptParent + "/" + scriptName + "_ResponseTime.jtl";
            String tpsFilePath = jmeterScriptParent + "/" + scriptName + "_TPS.jtl";

            CommonsUtils.createTempScript(oldScriptFile, newScriptFile, respTimeFilePath, tpsFilePath, erResultFilePath);
            CommonsUtils.recordScriptStartTime(jmeterScriptParent, scriptName);

            List<String> oldProcessList = new ArrayList<>();
            String jMeterPID = "";
            String[] oldProcessArray = CommandLineUtils.runCmd("tasklist").split(StringUtils.LF);
            for (int i = 0; i < oldProcessArray.length; i++) {
                String processLine = oldProcessArray[i];
                Pattern p = Pattern.compile("[0-9]");
                Matcher m = p.matcher(processLine);
                if (m.find()) {
                    oldProcessList.add(processLine.substring(0, 34));
                }
            }

            String cmd = cmdLineParamsMap.get("jmeterExePath") + " -n -t " + newScriptFile
                    + " -j " + jmeterScriptParent + "/jmeter.log"
                    + " -l " + jmeterScriptParent + "/" + scriptName + "_Aggregate.jtl"
                    + " -e -o " + jmeterScriptParent + "/Report_" + scriptName;
            System.out.println(cmd);
            JMeterThread jMeterThread = new JMeterThread(cmd);
            jMeterThread.start();

            Thread.sleep(10000);

            String[] newProcessArray = CommandLineUtils.runCmd("tasklist").split(StringUtils.LF);
            for (String s : newProcessArray) {
                if (Pattern.compile("[0-9]").matcher(s).find()) {
                    String process = s.substring(0, 34);
                    if (!oldProcessList.contains(process)) {
                        if (process.startsWith("java.exe")) {
                            jMeterPID = Pattern.compile("[^0-9]").matcher(process).replaceAll("").trim();
                        }
                    }
                }
            }
            String killCmd = "taskkill /pid " + jMeterPID + " -f";

            File tpsFile = new File(tpsFilePath);
            Timer tpsTimer = new Timer();
            File errorResultsFile = new File(erResultFilePath);
            Timer errorResultTimer = new Timer();

            int maxThread = 0;
            int count = 0;
            TPSTask tpsTask = new TPSTask(tpsFile, killCmd, jMeterThread, tpsTimer, maxThread, count, errorResultTimer,
                    Integer.parseInt(cmdLineParamsMap.get("countsOfLowerMaxTps")));
            tpsTimer.schedule(tpsTask, new Date(), 1000);

            ResultsTask errorResultsTask = new ResultsTask(errorResultsFile, killCmd, jMeterThread,
                    errorResultTimer, tpsTimer, Integer.parseInt(cmdLineParamsMap.get("maxErrorNum")));
            errorResultTimer.schedule(errorResultsTask, new Date(), 1000);

            File file = new File(newScriptFile);
            FileUtils.forceDelete(file);
            while (true) {
                if (MainEntry.isTaskDone) {
                    Thread.sleep(1000);
                } else {
                    break;
                }
            }
            MainEntry.isTaskDone = true;
            Thread.sleep(60000);
        }

    }
}
