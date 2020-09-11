package testng;

import org.testng.annotations.Test;

public class Demo2 {
    @Test(priority = 1)
    public void test() {
        System.out.println("hello demo2");
    }
}
