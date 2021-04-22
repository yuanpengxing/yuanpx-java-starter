package timer;

import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;
import utils.CommandLineUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Timer;

public class TimerManager {

    public static void main(String[] args) throws ParseException {
        Map<String, String> cmdLineParamsMap = CommandLineUtils.parserCommandLine(args);
        if (!cmdLineParamsMap.containsKey("dayOfWeek") || !cmdLineParamsMap.containsKey("hour") || !cmdLineParamsMap.containsKey("min")
                || !cmdLineParamsMap.containsKey("cmd") || !cmdLineParamsMap.containsKey("period")) {
            String prompt = (StringUtils.LF + StringUtils.LF + "usage example: java -jar timer-cmd.jar -d 4 -h 15 -m 38 -c tasklist -p 5" + StringUtils.LF) +
                    "-d: which day of week the task begin" + StringUtils.LF +
                    "-h: what hour the task begin" + StringUtils.LF +
                    "-m: what min the task begin" + StringUtils.LF +
                    "-s: what sec the task begin" + StringUtils.LF +
                    "-p: the period of task, the unit is second" + StringUtils.LF +
                    "-c: the command of task" + StringUtils.LF;
            throw new RuntimeException(prompt);
        }
        if (!cmdLineParamsMap.containsKey("sec")) {
            cmdLineParamsMap.put("sec", "00");
        }

        new TimerManager(cmdLineParamsMap);
    }

    public TimerManager(Map<String, String> cmdLineParamsMap) {
        Calendar calendar = Calendar.getInstance();

        String dayOfWeek = cmdLineParamsMap.get("dayOfWeek");
        String hour = cmdLineParamsMap.get("hour");
        String min = cmdLineParamsMap.get("min");
        String sec = cmdLineParamsMap.get("sec");
        String cmd = cmdLineParamsMap.get("cmd");
        String period = cmdLineParamsMap.get("period");

        switch (dayOfWeek) {
            case "1":
                calendar.set(Calendar.DAY_OF_WEEK, 2);
                break;
            case "2":
                calendar.set(Calendar.DAY_OF_WEEK, 3);
                break;
            case "3":
                calendar.set(Calendar.DAY_OF_WEEK, 4);
                break;
            case "4":
                calendar.set(Calendar.DAY_OF_WEEK, 5);
                break;
            case "5":
                calendar.set(Calendar.DAY_OF_WEEK, 6);
                break;
            case "6":
                calendar.set(Calendar.DAY_OF_WEEK, 7);
                break;
            case "7":
                calendar.set(Calendar.DAY_OF_WEEK, 1);
                break;
            default:
                throw new RuntimeException("DAY_OF_WEEK MUST 1-7 ");
        }

        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        calendar.set(Calendar.MINUTE, Integer.parseInt(min));
        calendar.set(Calendar.SECOND, Integer.parseInt(sec));
        Date date = calendar.getTime();
        if (date.before(new Date())) {
            date = this.addWeek(date, 1);
        }
        System.out.println("Task begin " + date + ", Task cmd is '" + cmd + "', Task period is " + period + "s");
        CommandTask task = new CommandTask(cmd);
        new Timer().schedule(task, date, Integer.parseInt(period) * 1000);
    }

    public Date addWeek(Date date, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.WEEK_OF_MONTH, num);
        return c.getTime();
    }

}
