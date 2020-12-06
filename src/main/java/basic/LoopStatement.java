package basic;

import org.testng.annotations.Test;

public class LoopStatement {

    // 循环结构九九乘法表
    @Test
    public void forLoop() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("hello world!!");
        }
    }

    @Test
    public void whileLoop() {
        int i = 0;
        while (i <= 10) {
            System.out.println("hello world!!");
            i++;
        }
    }

    //控制跳转语句break语句,只能在 switch 和 循环 中
    @Test
    public void breakLoop() {
        for (int x = 1; x <= 10; x++) {
            if (x == 4) {
                break;
            }
            System.out.println("x = " + x);
        }
    }

    //控制跳转语句continue语句,只能在循环中
    @Test
    public void continueLoop() {
        for (int x = 1; x <= 10; x++) {
            if (x == 4) {
                continue;                            //终止本次循环,继续下次循环
            }
            System.out.println("x = " + x);
        }
    }


    /**
     * 控制跳转语句return语句,返回,其实它的作用不是结束循环的，而是结束方法的
     * * return和break以及continue的区别?
     * * return是结束方法
     * * break是跳出循环
     * * continue是终止本次循环继续下次循环
     */
    @Test
    public void returnMethod() {
        for (int i = 1; i <= 10; i++) {
            if (i == 4) {
                //break;                        //停止循环
                return;                        //返回的意思,用来返回方法
            }
            System.out.println("循环结束了");
        }
    }

}
