package perf.bottleneck;

import org.apache.commons.cli.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CommonsUtils {

    public static Map<String, String> parserCommandLine(String[] args) throws ParseException {
        Map<String, String> cmdLineParamsMap = new HashMap<>();

        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("d", "jmeterScriptsDir", true, "jmeterScriptsDir");
        options.addOption("j", "jmeterExePath", true, "jmeterExePath");
        options.addOption("n", "maxErrorNum", true, "maxErrorNum");
        options.addOption("c", "countsOfLowerMaxTps", true, "countsOfLowerMaxTps");
        CommandLine commandLine = parser.parse(options, args);

        if (commandLine.hasOption('d')) {
            cmdLineParamsMap.put("jmeterScriptsDir", commandLine.getOptionValue('d'));
        }
        if (commandLine.hasOption('j')) {
            cmdLineParamsMap.put("jmeterExePath", commandLine.getOptionValue('j'));
        }
        if (commandLine.hasOption('n')) {
            cmdLineParamsMap.put("maxErrorNum", commandLine.getOptionValue('n'));
        }
        if (commandLine.hasOption('c')) {
            cmdLineParamsMap.put("countsOfLowerMaxTps", commandLine.getOptionValue('c'));
        }

        return cmdLineParamsMap;
    }

    public static void createTempScript(File oldScriptFile, String newScriptFile, String responseTimeFilePath,
                                        String tpsFilePath, String errorResultsFilePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(oldScriptFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(newScriptFile));
        String line;
        int flag = 0;
        while ((line = br.readLine()) != null) {
            if (flag == 0) {
                if (StringUtils.contains(line, "</TestPlan>")) {
                    bw.write(line);
                    bw.newLine();
                    bw.write("    <hashTree>");
                    bw.newLine();

                    bw.write(ElementConf.getResponseTimesOverTimeGui(responseTimeFilePath));
                    bw.newLine();
                    bw.write(ElementConf.getTransactionsPerSecondGui(tpsFilePath));
                    bw.newLine();
                    bw.write(ElementConf.getErrorResultCollector(errorResultsFilePath));
                    bw.newLine();

                    flag = 1;
                } else {
                    bw.write(line);
                    bw.newLine();
                }
            } else {
                flag = 0;
            }
        }
        br.close();
        bw.close();
    }

    public static void recordScriptStartTime(String jmeterScriptParent, String scriptName) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String currentTime = sdf.format(date);

        BufferedWriter log = new BufferedWriter(new FileWriter(jmeterScriptParent + "/log.txt", true));
        log.newLine();
        log.write(scriptName + " start at " + currentTime);
        log.close();
    }
}
