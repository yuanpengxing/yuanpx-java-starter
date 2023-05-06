package utils;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class MapUtils {
    /**
     * 取Map集合的差集
     */
    public static <S, T> Map<S, T> getDifferenceSetByGuava(Map<S, T> leftMap, Map<S, T> rightMap) {
        if (null != leftMap && null != rightMap) {
            Set<S> leftMapKey = leftMap.keySet();
            Set<S> rightMapKey = rightMap.keySet();
            Set<S> differenceSet = Sets.difference(leftMapKey, rightMapKey);
            Map<S, T> result = Maps.newHashMap();
            for (S key : differenceSet) {
                result.put(key, leftMap.get(key));
            }
            return result;
        } else {
            return null;
        }
    }

    /**
     * 取Map集合的并集
     */
    public static <S, T> Map<S, T> getUnionSetByGuava(Map<S, T> leftMap, Map<S, T> rightMap) {
        if (null != leftMap && null != rightMap) {
            Set<S> leftMapKey = leftMap.keySet();
            Set<S> rightMapKey = rightMap.keySet();
            Set<S> differenceSet = Sets.union(leftMapKey, rightMapKey);
            Map<S, T> result = Maps.newHashMap();
            for (S key : differenceSet) {
                if (leftMap.containsKey(key)) {
                    result.put(key, leftMap.get(key));
                } else {
                    result.put(key, rightMap.get(key));
                }
            }
            return result;
        } else {
            return null;
        }
    }

    /**
     * 取Map集合的交集（String,String）
     */
    public static <S, T> Map<S, T> getIntersectionSetByGuava(Map<S, T> leftMap, Map<S, T> rightMap) {
        if (null != leftMap && null != rightMap) {
            Set<S> leftMapKey = leftMap.keySet();
            Set<S> rightMapKey = rightMap.keySet();
            Set<S> differenceSet = Sets.intersection(leftMapKey, rightMapKey);
            Map<S, T> result = Maps.newHashMap();
            for (S key : differenceSet) {
                result.put(key, leftMap.get(key));
            }
            return result;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "a");
        map1.put("b", "b");
        map1.put("c", "e");

        Map<String, String> map2 = new HashMap<>();
        map2.put("c", "d");
        map2.put("d", "d");
        map2.put("e", "e");


        Map<String, String> diffMap1 = getDifferenceSetByGuava(map1, map2);
        System.out.println("-------------差集结果,入参:A,B  出参:A-B后A中剩余的  -----------");
        diffMap1.forEach((k, v) -> System.out.println(k + ":" + v));

        Map<String, String> diffMap2 = getDifferenceSetByGuava(map2, map1);
        System.out.println("-------------差集结果,入参:B,A  出参:B-A后B中剩余的  -----------");
        diffMap2.forEach((k, v) -> System.out.println(k + ":" + v));

        Map<String, String> unionMap = getUnionSetByGuava(map1, map2);
        System.out.println("-------------并集结果-----------");
        unionMap.forEach((k, v) -> System.out.println(k + ":" + v));

        Map<String, String> intersectionMap = getIntersectionSetByGuava(map2, map1);
        System.out.println("-------------交结果-----------");
        intersectionMap.forEach((k, v) -> System.out.println(k + ":" + v));

    }


}

