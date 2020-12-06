package basic;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * File更好的封装类参看FileUtils（commons.io）
 */
public class FileMgr {

    /**
     * File类的创建功能
     * public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
     * public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了
     * public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来
     */
    @Test
    public void create() throws IOException {
        File file = new File("");
        file.mkdir();
        file.mkdirs();
        file.createNewFile();
    }

    /**
     * A:判断功能
     *         * public boolean isDirectory():判断是否是目录
     *         * public boolean isFile():判断是否是文件
     *         * public boolean exists():判断是否存在
     *         * public boolean canRead():判断是否可读
     *         * public boolean canWrite():判断是否可写
     *         * public boolean isHidden():判断是否隐藏
     */
    @Test
    public void method01() {
        File file = new File("zzz");
        file.setReadable(false);
        System.out.println(file.canRead());             //windows系统认为所有的文件都是可读的
        file.setWritable(true);
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }

    /**
     * A:获取功能
     *         * public String getAbsolutePath()：获取绝对路径
     *         * public String getPath():获取路径
     *         * public String getName():获取名称
     *         * public long length():获取长度。字节数
     *         * public long lastModified():获取最后一次的修改时间，毫秒值
     *         * public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
     *         * public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
     */
    @Test
    public void method02() {
        File dir = new File("F:/test");
        String[] arr = dir.list();
        File[] files = dir.listFiles();
    }
}
