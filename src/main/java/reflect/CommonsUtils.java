package reflect;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CommonsUtils {

    public static List<String> getFilesWithSuffixClassUnderClasspath() {
        List<String> classesUnderClasspath = new ArrayList<>();
        File classpath = new File(ReflectionTest.class.getClassLoader().getResource("").getPath());

        String[] filter = {"class"};
        for (File file : FileUtils.listFiles(classpath, filter, true)) {
            String fileName = file.toString();
            String str1 = StringUtils.removeStart(fileName, classpath.toString());
            String str2 = StringUtils.removeStart(str1, "\\");
            String str3 = StringUtils.removeEnd(str2, ".class");
            String str4 = StringUtils.replace(str3, "\\", ".");
            classesUnderClasspath.add(str4);
        }

        return classesUnderClasspath;

    }
}
