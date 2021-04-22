package timer;

import utils.CommandLineUtils;

import java.util.TimerTask;

public class CommandTask extends TimerTask {
    String command;

    public CommandTask(String command) {
        this.command = command;
    }
    @Override
    public void run() {
        String result = CommandLineUtils.runCmd(command);
        System.out.println(result);
    }
}


