package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommonsUtils {

    /**
     * @param packageName example: "cn.yuanpx.testcase", default is whole classes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Class> getSpecifiedClassesUnderClassPath(String packageName) throws IOException, ClassNotFoundException {
        String classesParent = Objects.requireNonNull(CommonsUtils.class.getClassLoader().getResource("")).getPath();
        List<Class> specifiedClassesListUnderClassPath = new ArrayList<>();
        String newClassesParent = classesParent.substring(1).replaceAll("/", ".");
        String[] filter = {"class"};
        for (File file : FileUtils.listFiles(new File(classesParent), filter, true)) {
            String absolutePath = file.getAbsolutePath();
            if (absolutePath.contains("\\")) {
                absolutePath = absolutePath.replaceAll("\\\\", ".");
            } else {
                absolutePath = absolutePath.replaceAll("/", ".");
            }
            String classPathRemain = absolutePath.replaceAll(newClassesParent, "");
            if (classPathRemain.contains(packageName)) {
                classPathRemain = classPathRemain.substring(0, (classPathRemain.length() - 6));
                specifiedClassesListUnderClassPath.add(Class.forName(classPathRemain));
            }
        }
        return specifiedClassesListUnderClassPath;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String p = Objects.requireNonNull(CommonsUtils.class.getClassLoader().getResource("")).getPath();

        Class<?> aClass = Class.forName("testng.Demo1");
        Method test = aClass.getMethod("test");
        Object o = aClass.newInstance();
        test.invoke(o);
    }


}
