package test;

import java.util.Calendar;

public class TestA {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
    }
}
