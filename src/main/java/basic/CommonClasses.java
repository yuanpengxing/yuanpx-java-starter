package basic;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonClasses {

    /**
     * Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。
     */
    @Test
    public void math(){
        System.out.println(Math.abs(-10));      //取绝对值
        System.out.println(Math.ceil(12.3));    //向上取整,但是结果是一个double
        System.out.println(Math.floor(12.3));   //向下取整,但是结果是一个double
        System.out.println(Math.max(20, 30));   //获取两个值中的最大值
        System.out.println(Math.pow(2, 3));     //前面的数是底数,后面的数是指数
        System.out.println(Math.random());      //生成0.0到1.0之间的所以小数,包括0.0,不包括1.0
        System.out.println(Math.round(12.3f));  //四舍五入
        System.out.println(Math.sqrt(4));       //开平方
    }

    /**
     * System类的概述和方法使用
     */
    @Test
    public void system() {
        System.out.println(System.currentTimeMillis());     //打印当前时间戳（毫秒级）
        System.exit(1);     //非0状态是异常终止,退出jvm
        System.gc();                //运行垃圾回收器,相当于呼喊保洁阿姨
    }

    @Test
    public void date() {
        Date date = new Date();
        date.getTime();
    }

    @Test
    public void simpleDateFormat() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = sdf.parse("2020-12-06 12:00:00");
        System.out.println(parse);
        System.out.println(sdf.format(new Date()));
    }
}
