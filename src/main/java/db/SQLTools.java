package db;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.util.JdbcConstants;
import org.apache.commons.lang3.StringUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLTools {
    public static String SQLFormat(String sql) {
        return SQLUtils.format(sql, JdbcConstants.MYSQL);
    }

    public static void main(String[] args) {
        String sql1 = "insert into   tb_emp1 (id,name,age) values (12,'zs',12), (1,'ls',1), (1,'ls',1) ";
        String sql2 = "insert into student (id,name) values (4,'aaaaaa'), (5,'bbbbbb')";
        String sql3 = "delete from tb_emp1 where id=3 and name='lisi'";
        String sql = SQLTools.SQLFormat(sql1);
        System.out.println(sql.replaceAll(StringUtils.LF, " "));
//        System.out.println(SQLTools.getInsertKVList(sql));


    }

    public static String getTableName(String sqlFormat) {
        String tableName = "";
        if (sqlFormat.startsWith("INSERT")) {
            String line1 = sqlFormat.split(StringUtils.LF)[0];
            tableName = line1.split(" ")[2];
        }
        if (sqlFormat.startsWith("UPDATE")) {
            String line1 = sqlFormat.split(StringUtils.LF)[0];
            tableName = line1.split(" ")[1];
        }
        if (sqlFormat.startsWith("DELETE")) {
            String line1 = sqlFormat.split(StringUtils.LF)[0];
            tableName = line1.split(" ")[2];
        }
        return tableName;
    }


    public static List<Map<String, String>> getInsertKVList(String sqlFormat) {
        List<Map<String, String>> insertKVList = new ArrayList<>();
        List<String> insertKeys = new ArrayList<>();

        String[] splits = sqlFormat.split("VALUE");
        Pattern p = Pattern.compile("(?<=\\().*(?=\\))");

        Matcher m1 = p.matcher(splits[0]);
        while (m1.find()) {
            insertKeys.addAll(Arrays.asList(m1.group().split(",")));
        }

        Matcher m2 = p.matcher(splits[1]);
        while (m2.find()) {
            Map<String, String> insertMap = new HashMap<>();
            String[] split = m2.group().split(",");
            for (int i = 0; i < split.length; i++) {
                insertMap.put(insertKeys.get(i), split[i].trim());
            }
            insertKVList.add(insertMap);
        }
        return insertKVList;
    }

    public static Map<String, String> getUpdateKVMap(String sqlFormat) {
        Map<String, String> updateKVMap = new HashMap<>();
        int si = sqlFormat.indexOf("SET") + 4;
        int wi = sqlFormat.indexOf("WHERE");
        String setStr = sqlFormat.substring(si, wi).trim();
        String[] split = setStr.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] s1 = split[i].split("=");
            updateKVMap.put(s1[0], s1[1]);
        }
        return updateKVMap;
    }

    public static Map<String, String> getUpdateWhereKVMap(String sqlFormat) {
        Map<String, String> updateWhereKVMap = new HashMap<>();
        Map<String, String> updateKVMap = SQLTools.getUpdateKVMap(sqlFormat);
        int wi = sqlFormat.indexOf("WHERE");
        String whereStr = sqlFormat.substring(wi + 6);
        String[] split = whereStr.split("and");
        for (String aSplit : split) {
            String[] s1 = aSplit.split("=");
            updateWhereKVMap.put(s1[0], s1[1]);
        }
        for (Map.Entry<String, String> entry : updateWhereKVMap.entrySet()) {
            if (updateKVMap.containsKey(entry.getKey())) {
                return updateKVMap;
            }
        }
        return updateWhereKVMap;
    }

    public static Map<String, String> getDeleteWhereKVMap(String sqlFormat) {
        Map<String, String> deleteWhereKVMap = new HashMap<>();
        int wi = sqlFormat.indexOf("WHERE");
        String whereStr = sqlFormat.substring(wi + 6);
        String[] split = whereStr.split("and");
        for (String aSplit : split) {
            String[] s1 = aSplit.split("=");
            deleteWhereKVMap.put(s1[0], s1[1]);
        }
        return deleteWhereKVMap;
    }

    public static List<String> getColumnList(ResultSet rs) {
        List<String> columnList = new ArrayList<>();
        try {
            ResultSetMetaData md = rs.getMetaData();
            for (int i = 0; i < md.getColumnCount(); i++) {
                columnList.add(md.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnList;
    }
}
