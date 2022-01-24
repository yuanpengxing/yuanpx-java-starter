package o;

import sun.awt.ComponentFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.peer.RobotPeer;
import java.io.File;
import java.io.IOException;

public class TestA {

    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            long t1 = System.currentTimeMillis();


//            //根据指定的区域抓取屏幕的指定区域，1300是长度，800是宽度。
//            BufferedImage bi = robot.createScreenCapture(new Rectangle(10,10,100, 100));
//            //把抓取到的内容写到一个jpg文件中
//            ImageIO.write(bi, "jpg", new File("bootstrap1.jpg"));


            long t2 = System.currentTimeMillis();
            System.out.println(t2 - t1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
