package basic;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WrapperClasses {
    /**
     * 常用基本数据类型及其包装类
     * boolean  Boolean
     * byte     Byte
     * short    Short
     * int      Integer
     * long     Long
     * float    Float
     * double   Double
     * char     Character
     *
     * 其他常用数据类型及其包装类
     * string       StringBuffer、StringBuilder、StringUtils
     * array        Arrays
     * collecttion  Collections
     */

    @Test
    public void arrays() {
        Integer[] arr = {11,22,33,44,55};
        List<Integer> list = Arrays.asList(arr);    //将数组转换成集合,数组必须是引用数据类型
        Arrays.sort(arr);   // 排序
        System.out.println(list);
    }

    @Test
    public void collections() {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        Collections.binarySearch(list, "a");
        Collections.sort(list);
        Collections.max(list);          //根据默认排序结果获取集合中的最大值
        Collections.reverse(list);      //反转集合
        Collections.shuffle(list);      //随机置换,可以用来洗牌

    }
}
