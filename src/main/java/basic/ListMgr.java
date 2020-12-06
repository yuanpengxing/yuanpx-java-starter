package basic;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListMgr {

    /**
     * 集合迭代的方式
     */
    @Test
    public void iterator() {
        List<String> list = new ArrayList<String>();
        list.add("hello world!!");

        //快捷键itar
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //快捷键iter
        for (String s : list) {
            System.out.println(s);
        }

        //增强for循环
        for (String s : list) {
            System.out.println(s);
        }

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }

        ListIterator lit = list.listIterator();
        while(lit.hasNext()) {
            String s = (String) lit.next();
            System.out.println(s);
        }
    }

    /**
     * 求2个集合并集，非并集、合集
     */
    @Test
    public void collectionsOperater() {
        List<String> c1 = new ArrayList<>();
        c1.add("a");
        c1.add("d");

        List<String> c2 = new ArrayList<>();
        c2.add("a");
        c2.add("d");
        c2.add("e");

        //取交集,如果调用的集合改变就返回true,如果调用的集合不变就返回false
        boolean b = c1.retainAll(c2);                    //取交集
        System.out.println(b);
        System.out.println(c1);

        boolean c = c2.removeAll(c1);                    //删除的是交集
        System.out.println(c);
        System.out.println(c2);

        c1.addAll(c2);      //将c2中的每一个元素添加到c1中
        System.out.println(c1);
    }
}
