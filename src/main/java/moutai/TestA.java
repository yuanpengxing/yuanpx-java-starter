package moutai;

import java.awt.event.InputEvent;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public class TestA {
    public static final String COMMAND_EXIT = "exit\n";
    public static final String COMMAND_LINE_END = "\n";

    public static void main(String[] args) {
        try {


            List<DataOutputStream> osList = new ArrayList<>();

            long l1 = System.currentTimeMillis();
            for (int i = 0; i < 50; i++) {
                Process process = Runtime.getRuntime().exec("adb shell");
                osList.add(new DataOutputStream(process.getOutputStream()));
            }
            long l2 = System.currentTimeMillis();


            for (DataOutputStream os : osList) {
                os.writeBytes("input tap 210 1150");
                os.writeBytes(COMMAND_LINE_END);
                os.writeBytes("input tap 210 1150");
                os.writeBytes(COMMAND_LINE_END);
                os.writeBytes("input tap 210 1150");
                os.writeBytes(COMMAND_LINE_END);
                os.writeBytes("input tap 210 1150");
                os.writeBytes(COMMAND_LINE_END);
                os.flush();
            }
            long l3 = System.currentTimeMillis();

            System.out.println(l2 - l1);
            System.out.println(l3 - l2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
