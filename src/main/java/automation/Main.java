package automation;

import org.apache.commons.cli.ParseException;
import utils.CommandLineUtils;

import java.util.*;

public class Main {
    static int num = 0;

    public static void main(String[] args) throws InterruptedException, ParseException {
        Map<String, String> cmdLineParamsMap = CommandLineUtils.parserCommandLine(args);
        if (!cmdLineParamsMap.containsKey("xLoc")) {
            throw new RuntimeException("xLoc");
        }
        if (!cmdLineParamsMap.containsKey("yLoc")) {
            throw new RuntimeException("yLoc");
        }
        if (!cmdLineParamsMap.containsKey("hour")) {
            throw new RuntimeException("hour");
        }
        if (!cmdLineParamsMap.containsKey("min")) {
            throw new RuntimeException("min");
        }
        if (!cmdLineParamsMap.containsKey("sec")) {
            throw new RuntimeException("sec");
        }
        if (!cmdLineParamsMap.containsKey("simulatorPort")) {
            throw new RuntimeException("simulatorPort");
        }

        String simulatorPort = cmdLineParamsMap.get("simulatorPort");
        String min = cmdLineParamsMap.get("min");
        String sec = cmdLineParamsMap.get("sec");
        String hour = cmdLineParamsMap.get("hour");
        String xLoc = cmdLineParamsMap.get("xLoc");
        String yLoc = cmdLineParamsMap.get("yLoc");

        String specifySimulator = "adb -s 127.0.0.1:" + simulatorPort + " shell";

        final List<String> commnandList = new ArrayList<String>();
        commnandList.add("input tap " + xLoc + " " + yLoc);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        calendar.set(Calendar.MINUTE, Integer.parseInt(min));
        calendar.set(Calendar.SECOND, Integer.parseInt(sec));
        Date date = calendar.getTime();

        new Timer().schedule(new CommandTask(commnandList, specifySimulator), date, 86400);
        System.out.println("任务开始：" + date);


    }
}
