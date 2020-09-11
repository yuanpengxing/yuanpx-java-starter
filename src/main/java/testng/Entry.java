package testng;

import org.testng.TestNG;
import org.testng.annotations.Test;
import utils.CommonsUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Entry {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestNG testNG = new TestNG();
        List<Class> specifiedClassesUnderClassPath = CommonsUtils.getSpecifiedClassesUnderClassPath("testng");
        Class[] classes = new Class[specifiedClassesUnderClassPath.size()];
        specifiedClassesUnderClassPath.toArray(classes);
        testNG.setTestClasses(classes);
        testNG.setThreadCount(2);
        testNG.run();
    }

    @Test
    public void runClasses() throws IOException, ClassNotFoundException {

    }

//    @Test
//    public void runXml() {
//        TestNG testNG = new TestNG();
//        List<String> suites = new ArrayList<String>();
//        suites.add("C:\\Users\\x\\IdeaProjects\\yuanpx-java-starter\\src\\main\\java\\testng\\testng.xml");//此处为xml的绝对路径
//        testNG.setTestSuites(suites);
//        testNG.run();
//    }
}
