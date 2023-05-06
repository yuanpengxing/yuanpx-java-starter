package utils;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class ListUtils {

    // 获取两个集合并集（自动去重）
    public static List<String> getUnion(List<String> list1, List<String> list2) {
        return (List<String>) CollectionUtils.union(list1, list2);
    }

    // 获取两个集合交集
    public static List<String> getIntersection(List<String> list1, List<String> list2) {
        return (List<String>) CollectionUtils.intersection(list1, list2);
    }

    // 获取两个集合交集的补集 即 list1 + list2 - 交集
    public static List<String> getDisjunction(List<String> list1, List<String> list2) {
        return (List<String>) CollectionUtils.disjunction(list1, list2);
    }

    // 获取两个集合的差集 list1 - list2
    public static List<String> getSubtract(List<String> list1, List<String> list2) {
        return (List<String>) CollectionUtils.subtract(list1, list2);
    }


}

