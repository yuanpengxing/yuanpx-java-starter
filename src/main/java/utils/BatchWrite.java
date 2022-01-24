package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BatchWrite {
    public static void main(String[] args) throws IOException {
        String insertSqlFormat = "INSERT INTO `table1` VALUES ";
        int maxAllowedPacket = 1024 * 2;

        BufferedWriter bw = new BufferedWriter(new FileWriter("testa.txt"));
        StringBuilder batchInsertSql = new StringBuilder(insertSqlFormat);
        int loopStart = 10000;
        int loopEnd = 15000;
        for (int i = loopStart; i <= loopEnd; i++) {
            String sql = "(" + i + ",'column1','datetime',1,'column2'),";
            if (batchInsertSql.toString().getBytes().length + sql.getBytes().length > maxAllowedPacket) {
                bw.write(batchInsertSql.deleteCharAt(batchInsertSql.length() - 1).append(";").toString());
                bw.newLine();
                batchInsertSql = new StringBuilder(insertSqlFormat);
                batchInsertSql.append(sql);
            } else if (i == loopEnd) {
                bw.write(batchInsertSql.deleteCharAt(batchInsertSql.length() - 1).append(";").toString());
                bw.newLine();
            } else {
                batchInsertSql.append(sql);
            }

        }
        bw.close();

    }
}
