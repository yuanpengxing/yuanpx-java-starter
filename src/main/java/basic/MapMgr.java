package basic;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapMgr {
    @Test
    public void iterator() {
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 23);
        map.put("李四", 24);

        // 方式一：
        Iterator<String> it = map.keySet().iterator();    //获取迭代器
        while (it.hasNext()) {                        //判断集合中是否有元素
            String key = it.next();                    //获取每一个键
            Integer value = map.get(key);            //根据键获取值
            System.out.println(key + "=" + value);
        }

        // 方式二：使用增强for循环遍历
        for(String key : map.keySet()) {            //map.keySet()是所有键的集合
            System.out.println(key + "=" + map.get(key));
        }

        // 方式三：
        for(Map.Entry<String, Integer> en : map.entrySet()) {
            System.out.println(en.getKey() + "=" + en.getValue());
        }

    }
}
