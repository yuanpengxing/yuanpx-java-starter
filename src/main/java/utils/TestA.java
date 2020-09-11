package utils;

import java.util.List;

public class TestA {

    public static void main(String[] args) {
        String line = "C:\\Users\\x\\IdeaProjects\\yuanpx-java-starter\\target\\classes\\timertask\\Task3.class";
        System.out.println(line);
        if (line.contains("\\")){
            System.out.println(line.replaceAll("\\\\", ""));

        }

    }
}
