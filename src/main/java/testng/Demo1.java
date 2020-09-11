package testng;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo1 {

    @BeforeMethod
    public void testa() {
        System.out.println("Demo1 BeforeMethod");
    }
    @Test
    public void test() {
        System.out.println("hello demo1");
    }
}
