package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class EfficientReadLargeFile {
    // 高效读取大型文件
    @Test
    public void testReadLargeFile(File file){
        File f = new File("C:\\Users\\Think\\Desktop\\YUAN\\cbs_kglb_zongzh_20270801.txt");
        try {
            LineIterator it = FileUtils.lineIterator(f);
            while (it.hasNext()){
                String line = it.nextLine();
                System.out.println(line);
            }
            it.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
