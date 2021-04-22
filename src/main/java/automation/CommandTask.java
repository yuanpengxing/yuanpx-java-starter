package automation;

import java.util.List;
import java.util.TimerTask;

public class CommandTask extends TimerTask {
    List<String> commnandList;
    String specifyShell;

    public CommandTask(List<String> commnandList,String specifyShell) {
        this.commnandList = commnandList;
        this.specifyShell = specifyShell;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Thread(new Runnable() {
                public void run() {
                    SimulatorUtils.execCommand(commnandList, specifyShell);
                }
            }).start();
        }
    }
}
