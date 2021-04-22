package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadsWrite {
    private static BufferedWriter bw;

    static {
        try {
            bw = new BufferedWriter(new FileWriter("result.txt", true));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(String s) throws IOException {
        synchronized (ThreadsWrite.class) {
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
    }

    public static void close() throws IOException {
        bw.close();
    }
}
