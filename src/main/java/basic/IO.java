package basic;

import org.testng.annotations.Test;

import java.io.*;

public class IO {
    /**
     * 字节流一次读写一个字节复制音频
     */
    @Test
    public void method01() throws IOException {
        FileInputStream fis = new FileInputStream("src.mp3");
        FileOutputStream fos = new FileOutputStream("des.mp3");
        int b;
        while ((b = fis.read()) != -1) {                                //在不断的读取每一个字节
            fos.write(b);
        }
        fis.close();
        fos.close();
    }

    /**
     * 字节流一次读写定义数组复制
     */
    @Test
    public void method02() throws IOException {
        FileInputStream fis = new FileInputStream("src.mp3");
        FileOutputStream fos = new FileOutputStream("des.mp3");

        byte[] arr = new byte[1024 * 8];
        int len;
        while ((len = fis.read(arr)) != -1) {                //如果忘记加arr,返回的就不是读取的字节个数,而是字节的码表值
            fos.write(arr, 0, len);
        }

        fis.close();
        fos.close();
    }

    /**
     *
     */
    @Test
    public void method03() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src.mp3"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("des.mp3"));

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        bis.close();
        bos.close();
    }

    /**
     * 字节流读取中文的问题，write("".getBytes());
     */
    @Test
    public void method04() throws IOException {
        FileOutputStream fos = new FileOutputStream("zzz.txt");
        fos.write("我读书少,你不要骗我".getBytes());
        fos.close();
    }

    /**
     * 字符流拷贝
     */
    @Test
    public void method05() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("xxx.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("yyy.txt"));

        int c;
        while ((c = br.read()) != -1) {
            bw.write(c);
        }

        br.close();
        bw.close();
    }

    /**
     * BufferedReader.readLine()  BufferedReader.newLine()
     */
    @Test
    public void method06() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("aaa.txt"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();                            //写出回车换行符
        }

        br.close();
        bw.close();
    }

    /**
     * LineNumberReader效率要高些
     */
    @Test
    public void method07() throws IOException {
        LineNumberReader lnr = new LineNumberReader(new FileReader("zzz.txt"));

        String line;
        lnr.setLineNumber(100);
        while ((line = lnr.readLine()) != null) {
            System.out.println(lnr.getLineNumber() + ":" + line);
        }

        lnr.close();
    }

    /**
     * 使用指定的码表读写字符
     */
    @Test
    public void method08() throws IOException {
        BufferedReader br =                                 //更高效的读
                new BufferedReader(new InputStreamReader(new FileInputStream("utf-8.txt"), "utf-8"));
        BufferedWriter bw =                                 //更高效的写
                new BufferedWriter(new OutputStreamWriter(new FileOutputStream("gbk.txt"), "gbk"));

        int c;
        while ((c = br.read()) != -1) {
            bw.write(c);
        }

        br.close();
        bw.close();
    }
}
