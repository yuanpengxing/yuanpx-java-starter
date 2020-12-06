package basic;

import org.testng.annotations.Test;

public class SingletonMgr {
    @Test
    public void method01() {
        Singleton s1 = Singleton.s;                //成员变量被私有,不能通过类名.调用
        Singleton s2 = Singleton.s;
        System.out.println(s1 == s2);
    }
}


/**
 *  饿汉式
  */
//class Singleton {
//    //1,私有构造方法,其他类不能访问该构造方法了
//    private Singleton(){}
//    //2,创建本类对象
//    private static Singleton s = new Singleton();
//    //3,对外提供公共的访问方法
//    public static Singleton getInstance() {                //获取实例
//        return s;
//    }
//}


/**
 * 懒汉式
 */
//class Singleton {
//    //1,私有构造方法,其他类不能访问该构造方法了
//    private Singleton(){}
//    //2,声明一个引用
//    private static Singleton s ;
//    public static Singleton getInstance() {                //获取实例
//        if(s == null) {
//            s = new Singleton();
//        }
//        return s;
//    }
//}

/**
 *  饿汉式是空间换时间,懒汉式是时间换空间，一般建议饿汉式。
  */
class Singleton {
    //1,私有构造方法,其他类不能访问该构造方法了
    private Singleton(){}
    //2,声明一个引用
    public static final Singleton s = new Singleton();
}



