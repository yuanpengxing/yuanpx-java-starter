package db;

import utils.ListUtils;
import utils.MapUtils;

import java.sql.*;
import java.util.List;
import java.util.Map;


public class Testb {
    public static void main(String[] args) throws SQLException {
        Connection connection = DruidUtil.getConnection();
        assert connection != null;
        Statement stmt = connection.createStatement();

        String table = "ltsz";
        // 判断两张表字段是否一致
        List<String> columnLabels1 = ResultUtils.getColumnList(stmt.executeQuery("SHOW FULL COLUMNS FROM " + table), 1);
        List<String> columnLabels2 = ResultUtils.getColumnList(stmt.executeQuery("SHOW FULL COLUMNS FROM " + table), 1);
        List<String> subtract1 = ListUtils.getSubtract(columnLabels1, columnLabels2);
        List<String> subtract2 = ListUtils.getSubtract(columnLabels2, columnLabels1);

        if (subtract1.size() != 0 && subtract2.size() != 0) {
            System.out.println("两表的字段不相同");
        }


        // 判断给与的字段是否为主键（如果不是主键，但不存在重复也没关系）
        Map<String, Map<String, String>> resultsMap1 = ResultUtils.getResultsMap(stmt.executeQuery("select * from " + table), "date");
        int rows1 = Integer.parseInt(ResultUtils.getRowList(stmt.executeQuery("select count(*) from " + table)).get(0));
        if (resultsMap1.size() < rows1) {
            System.out.println("id不是主键，存在重复");
        }
        Map<String, Map<String, String>> resultsMap2 = ResultUtils.getResultsMap(stmt.executeQuery("select * from " + table), "date");
        int rows2 = Integer.parseInt(ResultUtils.getRowList(stmt.executeQuery("select count(*) from " + table)).get(0));
        if (resultsMap2.size() < rows2) {
            System.out.println("id不是主键，存在重复");
        }


        // 判断两张表数据是否一致
        Map<String, Map<String, String>> inter = MapUtils.getIntersectionSetByGuava(resultsMap1, resultsMap2);
        Map<String, Map<String, String>> diff1 = MapUtils.getDifferenceSetByGuava(resultsMap1, resultsMap2);
        Map<String, Map<String, String>> diff2 = MapUtils.getDifferenceSetByGuava(resultsMap2, resultsMap1);
        if (diff1.size() > 0) {
            System.out.println("resultsMap1 - resultsMap2: ");
            for (Map<String, String> value : diff2.values()) {

            }
        }
        if (diff2.size() > 0) {
            System.out.println("resultsMap2 - resultsMap1: ");
            for (Map<String, String> value : diff2.values()) {

            }
        }
        for (Map.Entry<String, Map<String, String>> entry : inter.entrySet()) {
            Map<String, String> map1 = entry.getValue();
            Map<String, String> map2 = resultsMap2.get(entry.getKey());
            StringBuilder sb = new StringBuilder();
            boolean isTrue = true;
            for (Map.Entry<String, String> entr2 : map1.entrySet()) {
                String k1 = entr2.getKey();
                String v1 = entr2.getValue();
                String v2 = map2.get(k1);
                sb.append(k1).append(": ").append(v1).append(" ").append(v2).append(", ");
                if (!v1.equals(v2)) {
                    isTrue = false;
                }
            }
            if (isTrue) {
                System.out.println("数据相同: " + sb.toString());
            } else {
                System.out.println("数据不同: " + sb.toString());
            }
        }

    }


}