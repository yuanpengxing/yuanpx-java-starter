package test;

import automation.DriverDataSource;

public class BusinessAnalysisDownload {
    public static void main(String[] args) {
        DriverDataSource.getDriver().get("http://stockpage.10jqka.com.cn/603906/operate/");
    }
}
