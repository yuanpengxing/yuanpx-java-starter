package basic;

import java.util.Calendar;

public class CalendarMgr {

    public void calendar() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
        c.add(Calendar.MONTH, -1);      //对指定的字段进行向前减或向后加
        c.set(Calendar.HOUR_OF_DAY, 12);         //修改指定字段
    }
}
