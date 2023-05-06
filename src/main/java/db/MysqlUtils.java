package db;

import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MysqlUtils {
    static Map<Connection, List<String>> sqlMap = new HashMap<>();

    public static void insert(Connection conn, String sqlInsert) {
        if (!sqlMap.containsKey(conn)) {
            List<String> sqlList = new ArrayList<>();
            sqlMap.put(conn, sqlList);
        }
        List<String> deleteList = sqlMap.get(conn);
        Statement statement = null;
        try {
            String sqlFormat = SQLTools.SQLFormat(sqlInsert);
            statement = conn.createStatement();
            statement.executeUpdate(sqlFormat, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            String tableName = SQLTools.getTableName(sqlFormat);
            if (generatedKeys.next()) {
                deleteList.add(SQLTools.SQLFormat("delete from " + tableName + " where id=" + Integer.toString(generatedKeys.getInt(1))));
            } else {
                List<Map<String, String>> insertKVList = SQLTools.getInsertKVList(sqlFormat);
                for (Map<String, String> insertKVMap : insertKVList) {
                    StringBuilder s = new StringBuilder();
                    for (Map.Entry<String, String> entry : insertKVMap.entrySet()) {
                        s.append(entry.getKey()).append("=").append(entry.getValue()).append(" and ");
                    }
                    String w = s.substring(0, s.length() - 5);
                    String sqlDelete = "delete from " + tableName + " where " + w;
                    deleteList.add(SQLTools.SQLFormat(sqlDelete));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(Connection conn, String sqlUpdate) {
        if (!sqlMap.containsKey(conn)) {
            List<String> sqlList = new ArrayList<>();
            sqlMap.put(conn, sqlList);
        }
        List<String> updateList = sqlMap.get(conn);
        Statement statement = null;
        try {
            String sqlFormat = SQLTools.SQLFormat(sqlUpdate);
            // 先根据update语句查询该条记录详细信息，然后拼接恢复的sql
            String tableName = SQLTools.getTableName(sqlFormat);
            Map<String, String> updateWhereKVMap = SQLTools.getUpdateWhereKVMap(sqlFormat);
            Map<String, String> updateKVMap = SQLTools.getUpdateKVMap(sqlFormat);
            String sqlSelect = SQLTools.SQLFormat("SELECT * FROM " + tableName + " WHERE " + sqlFormat.split("WHERE")[1]);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            Map<String, String> prevMap = new HashMap<>();
            while (rs.next()) {
                for (Map.Entry<String, String> entry : updateKVMap.entrySet()) {
                    prevMap.put(entry.getKey().trim(), rs.getString(entry.getKey().trim()));
                }
            }
            StringBuilder s1 = new StringBuilder();
            for (Map.Entry<String, String> entry : prevMap.entrySet()) {
                if (!entry.getValue().matches("[0-9]+")) {
                    s1.append(entry.getKey()).append("='").append(entry.getValue()).append("',");
                } else {
                    s1.append(entry.getKey()).append("=").append(entry.getValue()).append(",");
                }
            }
            StringBuilder s2 = new StringBuilder();
            for (Map.Entry<String, String> entry : updateWhereKVMap.entrySet()) {
                s2.append(entry.getKey()).append("=").append(entry.getValue()).append(" and ");
            }
            String s = s1.substring(0, s1.length() - 1);
            String w = s2.substring(0, s2.length() - 5);
            String sql = "UPDATE " + tableName + " SET " + s + " WHERE " + w;

            // 执行更新语句
            statement.executeUpdate(sqlFormat);
            // 执行成功后再添加到updateList
            updateList.add(SQLTools.SQLFormat(sql));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Connection conn, String sqlDelete) {
        if (!sqlMap.containsKey(conn)) {
            List<String> sqlList = new ArrayList<>();
            sqlMap.put(conn, sqlList);
        }
        List<String> insertList = sqlMap.get(conn);
        Statement statement = null;
        try {
            String sqlFormat = SQLTools.SQLFormat(sqlDelete);
            // 先根据delete语句查询该条记录详细信息，然后拼接恢复的sql
            String tableName = SQLTools.getTableName(sqlFormat);
            String sqlSelect = SQLTools.SQLFormat("SELECT * FROM " + tableName + " WHERE " + sqlFormat.split("WHERE")[1]);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sqlSelect);
            List<String> columnList = SQLTools.getColumnList(rs);

            // 还原SQL拼接
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ");
            sb.append(tableName);
            sb.append(" (");
            for (int i = 0; i < columnList.size(); i++) {
                if (i == columnList.size() - 1) {
                    sb.append(columnList.get(i));
                } else {
                    sb.append(columnList.get(i)).append(",");
                }
            }
            sb.append(") VALUES ");
            while (rs.next()) {
                sb.append("(");
                for (int i = 1; i < columnList.size() + 1; i++) {
                    if (i == columnList.size()) {
                        if (rs.getString(i).matches("[0-9]+")) {
                            sb.append(rs.getString(i));
                        } else {
                            sb.append("'").append(rs.getString(i)).append("'");
                        }
                    } else {
                        if (rs.getString(i).matches("[0-9]+")) {
                            sb.append(rs.getString(i)).append(",");
                        } else {
                            sb.append("'").append(rs.getString(i)).append("',");
                        }
                    }
                }
                sb.append("),");
            }
            String sql = sb.toString().substring(0, sb.toString().length() - 1);

            // 执行更新语句
            statement.executeUpdate(sqlFormat);
            // 执行成功后再添加到deleteList
            insertList.add(SQLTools.SQLFormat(sql));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollBack() {
        for (Map.Entry<Connection, List<String>> connectionListEntry : sqlMap.entrySet()) {
            try {
                Statement stat = connectionListEntry.getKey().createStatement();
                List<String> updateList = new ArrayList<>();
                List<String> insertList = new ArrayList<>();
                List<String> deleteList = new ArrayList<>();
                List<String> sqlList = connectionListEntry.getValue();
                for (String sql : sqlList) {
                    if (sql.startsWith("UPDATE")) {
                        updateList.add(sql);
                    } else if (sql.startsWith("INSERT")) {
                        insertList.add(sql);
                    } else if (sql.startsWith("DELETE")) {
                        deleteList.add(sql);
                    }
                }
                for (String sql : updateList) {
                    System.out.println("执行回滚: " + sql.replaceAll(StringUtils.LF, " "));
                    stat.executeUpdate(sql);
                }
                for (String sql : deleteList) {
                    System.out.println("执行回滚: " + sql.replaceAll(StringUtils.LF, " "));
                    stat.executeUpdate(sql);
                }
                for (String sql : insertList) {
                    System.out.println("执行回滚: " + sql.replaceAll(StringUtils.LF, " "));
                    stat.executeUpdate(sql);
                }

                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        sqlMap = new HashMap<>();
    }

}
