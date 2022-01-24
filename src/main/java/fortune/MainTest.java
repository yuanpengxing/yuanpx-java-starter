package fortune;

import java.io.*;
import java.util.*;

public class MainTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        String parentDir = "D:\\Fortune\\Data\\五档委托";

        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        String dir = parentDir + "/" + year + "/" + month + "/" + day;
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }

        List<BufferedWriter> list1 = new ArrayList<>();
        List<Timer> list2 = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader("D:\\Fortune\\Data\\FileOfCodes.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(dir + "/" + line + ".txt"));

            Timer timer = new Timer();
            timer.schedule(new CommissionedTask(line, bw), new Date(), 3000);

            list1.add(bw);
            list2.add(timer);
        }

        Thread.sleep(1000 * 60 * 60 * 8);
        for (Timer timer : list2) {
            timer.cancel();
        }
        for (BufferedWriter bw : list1) {
            bw.close();
        }
        br.close();

    }

}
