package db;

import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.util.Date;

public class Testa {
    public static void main(String[] args) throws SQLException {

        String sql = "select * from student where id=10";
        Connection connection = DruidUtil.getConnection();
        System.out.println(new Date().getTime());
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
        }
        System.out.println(new Date().getTime());


//        String sql1 = "insert into `student` (id,name) values (10, 'aaaaaa')";
//        DatabaseUtils.insert(DruidUtil.getConnection(), sql1);

//        String sql2 = "delete from student where name='aaaaaa'";
//        DatabaseUtils.delete(DruidUtil.getConnection(), sql2);
//        DatabaseUtils.rollBack();

//        StringBuilder sb = new StringBuilder();
//        sb.append("INSERT INTO `student` (id,name) VALUES ");
//        for (int i = 1000; i < 2000; i++) {
//            if (i == 1999) {
//                sb.append("(").append(i).append(",'aaaaaa')");
//            } else {
//                sb.append("(").append(i).append(",'aaaaaa'),");
//            }
//        }
//        DatabaseUtils.insert(DruidUtil.getConnection(), sb.toString());
//        DatabaseUtils.rollBack();

    }
}
