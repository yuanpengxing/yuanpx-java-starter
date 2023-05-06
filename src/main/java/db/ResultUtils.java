package db;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultUtils {

    // 将查询结果resultset转换为Map<String, Map<String, String>>
    public static Map<String, Map<String, String>> getResultsMap(ResultSet rs, String primaryKey) throws SQLException {
        Map<String, Map<String, String>> map = new HashMap<>();
        ResultSetMetaData md = rs.getMetaData();
        int columnCount = md.getColumnCount();
        while (rs.next()) {
            Map<String, String> rowData = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i).toUpperCase(), rs.getString(i));
            }
            map.put(rs.getString(primaryKey), rowData);
        }
        return map;
    }

    public static List<String> getRowList(ResultSet rs) throws SQLException {
        List<String> list = new ArrayList<>();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();
        if (rs.next()) {
            for (int i = 1; i <= count; i++) {
                list.add(rs.getString(i));
            }
        }
        return list;
    }

    public static List<String> getColumnList(ResultSet rs, int column) throws SQLException {
        List<String> list = new ArrayList<>();
        while (rs.next()) {
            list.add(rs.getString(column).toUpperCase());
        }
        return list;
    }


}
