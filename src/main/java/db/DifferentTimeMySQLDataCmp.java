package db;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DifferentTimeMySQLDataCmp {
    public static void main(String[] args) throws SQLException, IOException, InterruptedException {
        Map<String, Map<String, String>> tablesData1 = new HashMap<>();
        Connection connection = DruidUtil.getConnection();
        Statement statement = connection.createStatement();

        BufferedReader br1 = new BufferedReader(new FileReader("tables.txt"));
        String line1;
        while ((line1 = br1.readLine()) != null) {
            Map<String, String> tableData = DifferentTimeMySQLDataCmp.getTableDataMap(statement, line1);

            ResultSet resultSet2 = statement.executeQuery("select count(*) from " + line1);
            int count = 0;
            while (resultSet2.next()) {
                for (int i = 0; i < resultSet2.getMetaData().getColumnCount(); i++) {
                    count = Integer.parseInt(resultSet2.getString(i + 1));
                }
            }

            if (tableData.size() == count) {
                tablesData1.put(line1, tableData);
            } else {
                System.out.println(line1 + "：id不是主键，存在重复，不唯一");
                System.out.println(line1 + ": tableData数据量" + tableData.size() + ", 实际lines" + count);
            }

        }


        Thread.sleep(100000);

        BufferedReader br = new BufferedReader(new FileReader(""));
        String line;
        while ((line = br.readLine()) != null) {
            Map<String, String> tableData = DifferentTimeMySQLDataCmp.getTableDataMap(statement, line);

            ResultSet resultSet2 = statement.executeQuery("select count(*) from " + line);
            int count = 0;
            while (resultSet2.next()) {
                for (int i = 0; i < resultSet2.getMetaData().getColumnCount(); i++) {
                    count = Integer.parseInt(resultSet2.getString(i + 1));
                }
            }

            if (tableData.size() != count) {
                System.out.println(line1 + ": tableData数据量" + tableData.size() + ", 实际lines" + count);

            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("", true)));
            Map<String, String> tableData1 = tablesData1.get(line);
            if (tableData.size() == tableData1.size()) {
                for (Map.Entry<String, String> entry : tableData.entrySet()) {
                    String key = entry.getKey();
                    if (!entry.getValue().equals(tableData1.get(key))) {
                        bw.write(line + "数据Update ID=" + key + ":" + entry.getValue());
                        bw.newLine();
                    }
                }
            }
            if (tableData.size() > tableData1.size()) {
                for (Map.Entry<String, String> entry : tableData.entrySet()) {
                    String key = entry.getKey();
                    if (!tableData1.containsKey(key)) {
                        bw.write(line + ":数据Insert ID=" + key + ":" + entry.getValue());
                        bw.newLine();
                    } else {
                        if (!entry.getValue().equals(tableData1.get(key))) {
                            bw.write(line + "数据Update ID=" + key + ":" + entry.getValue());
                            bw.newLine();
                        }
                    }
                }
            }

            if (tableData.size() < tableData1.size()) {
                for (Map.Entry<String, String> entry : tableData1.entrySet()) {
                    String key = entry.getKey();
                    if (!tableData.containsKey(key)) {
                        bw.write(line + ":数据Delete ID=" + key + ":" + entry.getValue());
                        bw.newLine();
                    } else {
                        if (!entry.getValue().equals(tableData.get(key))) {
                            bw.write(line + "数据Update ID=" + key + ":" + entry.getValue());
                            bw.newLine();
                        }
                    }
                }
            }
            bw.close();
        }
    }

    public static Map<String, String> getTableDataMap(Statement statement, String tableName) throws SQLException {
        Map<String, String> tableData = new HashMap<>();
        ResultSet resultSet = statement.executeQuery("select * from " + tableName);
        while (resultSet.next()) {
            StringBuilder s = new StringBuilder();
            String id = "";
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                if (i == 0) {
                    id = resultSet.getString(i + 1);
                } else {
                    s.append(resultSet.getString(i + 1)).append(",");
                }
            }
            tableData.put(id, s.toString());
        }
        return tableData;
    }

}
