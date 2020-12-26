package basic;


import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflect {


    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz1 = Class.forName("basic.Person");
        Class clazz2 = Person.class;

        Person p = new Person();
        Class clazz3 = p.getClass();

        System.out.println(clazz1 == clazz2);    //true
        System.out.println(clazz2 == clazz3);    //true

    }

    // 通过反射获取带参构造方法并使用
    @Test
    public void getConstructor() throws Exception {
        Class clazz = Class.forName("com.heima.bean.Person");
        //Person p = (Person) clazz.newInstance();                通过无餐构造创建对象
        //System.out.println(p);
        Constructor c = clazz.getConstructor(String.class, int.class);    //获取有参构造
        Person p = (Person) c.newInstance("张三", 23);                        //通过有参构造创建对象
        System.out.println(p);

    }

    //通过反射获取成员变量并使用
    @Test
    public void getDeclaredField() throws Exception {
        Class clazz = Class.forName("com.heima.bean.Person");
        Constructor c = clazz.getConstructor(String.class, int.class);    //获取有参构造
        Person p = (Person) c.newInstance("张三", 23);                        //通过有参构造创建对象

        //Field f = clazz.getField("name");                                //获取姓名字段
        //f.set(p, "李四");                                                //修改姓名的值
        Field f = clazz.getDeclaredField("name");                        //暴力反射获取字段
        f.setAccessible(true);                                            //去除私有权限
        f.set(p, "李四");
        System.out.println(p);

    }

    //通过反射获取方法并使用
    @Test
    public void getMethod() throws Exception {
        Class clazz = Class.forName("com.heima.bean.Person");
        Constructor c = clazz.getConstructor(String.class, int.class);    //获取有参构造
        Person p = (Person) c.newInstance("张三", 23);                        //通过有参构造创建对象

        Method m = clazz.getMethod("eat");                                //获取eat方法
        m.invoke(p);

        Method m2 = clazz.getMethod("eat", int.class);                    //获取有参的eat方法
        m2.invoke(p, 10);

    }
}

class Person {
    String name;
    String age;

    public Person() {

    }

    public Person(String name, int age) {

    }

    public void eat() {

    }
}