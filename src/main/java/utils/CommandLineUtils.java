package utils;

import org.apache.commons.cli.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CommandLineUtils {

    public static Map<String, String> parserCommandLine(String[] args) throws ParseException {
        Map<String, String> cmdLineParamsMap = new HashMap<>();

        CommandLineParser parser = new BasicParser();
        Options options = new Options();
        options.addOption("d", "dayOfWeek", true, "which day of week the task begin");
        options.addOption("h", "hour", true, "what hour the task begin");
        options.addOption("m", "min", true, "what min the task begin");
        options.addOption("s", "sec", true, "what sec the task begin");
        options.addOption("p", "period", true, "the period of task, the unit is second");
        options.addOption("c", "cmd", true, "the command of task");
        CommandLine commandLine = parser.parse(options, args);

        if (commandLine.hasOption('d')) {
            cmdLineParamsMap.put("dayOfWeek", commandLine.getOptionValue('d'));
        }
        if (commandLine.hasOption('h')) {
            cmdLineParamsMap.put("hour", commandLine.getOptionValue('h'));
        }
        if (commandLine.hasOption('m')) {
            cmdLineParamsMap.put("min", commandLine.getOptionValue('m'));
        }
        if (commandLine.hasOption('s')) {
            cmdLineParamsMap.put("sec", commandLine.getOptionValue('s'));
        }
        if (commandLine.hasOption('c')) {
            cmdLineParamsMap.put("cmd", commandLine.getOptionValue('c'));
        }
        if (commandLine.hasOption('p')) {
            cmdLineParamsMap.put("period", commandLine.getOptionValue('p'));
        }

        return cmdLineParamsMap;
    }

    public static String runCmd(String cmd) {
        Runtime runtime = Runtime.getRuntime();
        StringBuilder b = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(runtime.exec(cmd).getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                b.append(line).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b.toString();
    }
}
