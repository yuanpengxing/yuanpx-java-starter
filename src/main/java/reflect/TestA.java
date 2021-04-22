package reflect;

import org.testng.annotations.Test;

public class TestA {
    @InitData
    @Test
    public void testC() {
        System.out.println("testC");
    }

    @InitData(dependMethod = "cn.yuanpx.TestA.testC()")
    @Test
    public void testc() {
        System.out.println("testc");
    }

    @InitData(dependMethod = "cn.yuanpx.TestA.testc()")
    @Test
    public void testd() {
        System.out.println("testd");
    }

    @InitData(dependMethod = "cn.yuanpx.TestA.testd()")
    @Test
    public void teste() {
        System.out.println("teste");
    }
}
