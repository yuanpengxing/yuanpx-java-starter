package basic;

import org.testng.annotations.Test;

public class ExceptionMgr {
    // 异常的处理方式
    @Test
    public void exception() throws Exception {
        //方式一：把错误 try catch 起来
        try {
            int x = 10 / 0;
        } catch (ArithmeticException a) {
            System.out.println("出错了,除数为零了");
        } finally {
            System.out.println();
        }

        // 方式二：把错误往上层抛
        throw new Exception("往上层抛");
    }
}
