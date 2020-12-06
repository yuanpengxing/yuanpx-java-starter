package basic;

import org.testng.annotations.Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerMgr {
    @Test
    public void method01() throws InterruptedException {
        Timer t = new Timer();
        //第一个参数,是安排的任务,第二个参数是执行的时间,第三个参数是过多长时间再重复执行
        t.schedule(new MyTimerTask(), new Date(),3000);
    }
}

class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("起床背英语单词");
    }
}
