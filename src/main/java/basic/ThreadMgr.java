package basic;

import org.testng.annotations.Test;

public class ThreadMgr {

    /**
     * 多线程程序实现的方式1：继承Thread
     */
    @Test
    public void method01() {
        MyThread mt = new MyThread();        //4,创建Thread类的子类对象
        mt.start();                            //5,开启线程
    }

    /**
     * 多线程程序实现的方式2：实现Runnable
     */
    @Test
    public void method02() {
        MyRunnable mr = new MyRunnable();     //4,创建Runnable的子类对象
        Thread t = new Thread(mr);            //5,将其当作参数传递给Thread的构造函数
        t.start();
    }

    /**
     * 匿名内部类实现线程的两种方式
     */
    @Test
    public void method03() {
        new Thread() {                                        //1,继承Thread类
            public void run() {                                //2,重写run方法
                for(int i = 0; i < 1000; i++) {                //3,将要执行的代码写在run方法中
                    System.out.println("aa");
                }
            }
        }.start();                                            //4,开启线程

        new Thread(new Runnable() {                            //1,将Runnable的子类对象传递给Thread的构造方法
            public void run() {                                //2,重写run方法
                for(int i = 0; i < 1000; i++) {                //3,将要执行的代码写在run方法中
                    System.out.println("bb");
                }
            }
        }).start();
    }

}

class MyThread extends Thread {                //1,继承Thread
    public void run() {                        //2,重写run方法
        for(int i = 0; i < 1000; i++) {        //3,将要执行的代码写在run方法中
            System.out.println("hello world!!");
        }
    }
}

class MyRunnable implements Runnable {        //1,定义一个类实现Runnable
    @Override
    public void run() {                        //2,重写run方法
        for(int i = 0; i < 1000; i++) {        //3,将要执行的代码写在run方法中
            System.out.println("aaaaaaaaaaaa");
        }
    }
}


