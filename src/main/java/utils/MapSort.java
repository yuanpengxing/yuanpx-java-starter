package utils;

import java.util.*;

public class MapSort {
    public static void main(String[] args) {
        Map<String, Integer> maps = new HashMap<>();
        maps.put("zhangsan", 22);
        maps.put("lisi", 24);
        maps.put("wangwu", 18);
        maps.put("zhaoli", 22);

        Comparator<Map.Entry<String, Integer>> valueCmp = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        List<Map.Entry<String, Integer>> list = new ArrayList<>(maps.entrySet());
        Collections.sort(list, valueCmp);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + " : " + list.get(i).getValue());
        }


    }
}
