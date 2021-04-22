package automation;

import java.io.DataOutputStream;
import java.util.List;


public class SimulatorUtils {
    public static final String COMMAND_EXIT = "exit\n";
    public static final String COMMAND_LINE_END = "\n";

    public static void execCommand(List<String> commands, String specifyShell) {
        DataOutputStream os = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(specifyShell);
            os = new DataOutputStream(process.getOutputStream());
            for (String command : commands) {
                if (command == null) {
                    continue;
                }
                os.write(command.getBytes());
                os.writeBytes(COMMAND_LINE_END);
                os.flush();
            }
            os.writeBytes(COMMAND_EXIT);
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
