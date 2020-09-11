package utils;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class ExcelParser {

    //此方法在读取超大型XLSX文件的时候可以有效的防止OOM
    @Test
    public void parser() throws Exception{
        FileInputStream in = new FileInputStream("E:\\20190702.xlsx");
        Workbook wk = StreamingReader.builder()
                .rowCacheSize(100)  //缓存到内存中的行数，默认是10
                .bufferSize(4096)   //读取资源时，缓存到内存的字节大小，默认是1024
                .open(in);  //打开资源，必须，可以是InputStream或者是File，注意：只能打开XLSX格式的文件
        Sheet sheet = wk.getSheetAt(0);
        //遍历所有的行
        for (Row row : sheet) {
            System.out.println("开始遍历第" + row.getRowNum() + "行数据：");
            //遍历所有的列
            for (Cell cell : row) {
                System.out.print(cell.getStringCellValue() + " ");
            }
            System.out.println(" ");
        }
    }

}
