package test;

import java.awt.*;
import java.awt.event.InputEvent;

public class TestB {

    public static void main(String[] args) throws AWTException, InterruptedException {

        Robot robot = new Robot();
//        180 - 600
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(677);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
