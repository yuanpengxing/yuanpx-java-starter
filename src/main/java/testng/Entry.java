package testng;

import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Entry {

    public static void main(String[] args) {

    }

    @Test
    public void runClasses(){
        TestNG testNG = new TestNG();
        Class[] classes = {Demo1.class, Demo2.class};
        testNG.setTestClasses(classes);
        testNG.run();
    }

    @Test
    public void runXml() {
        TestNG testNG = new TestNG();
        List<String> suites = new ArrayList<String>();
        suites.add("C:\\Users\\x\\IdeaProjects\\yuanpx-java-starter\\src\\main\\java\\testng\\testng.xml");//此处为xml的绝对路径
        testNG.setTestSuites(suites);
        testNG.run();
    }
}
