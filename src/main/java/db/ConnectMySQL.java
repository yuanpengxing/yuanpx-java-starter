package db;

import java.sql.*;

public class ConnectMySQL {

    public static void main(String[] args) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db1?serverTimezone=UTC";
        String user = "root";
        String password = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed()){
                System.out.println("数据库连接成功");
            }

            Statement statement = con.createStatement();
            String sql = "select title from table";
            ResultSet rs = statement.executeQuery(sql);

            String title = null;
            while (rs.next()) {
                title = rs.getString("title");
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("获取数据完毕!!!!");
        }
    }

}
