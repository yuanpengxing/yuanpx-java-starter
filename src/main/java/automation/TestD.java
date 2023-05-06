package automation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestD {
    public static void main(String[] args) {
        WebDriver driver = DriverDataSource.getDriver();
    }

    public static void scrollToSpecifiedElement(WebDriver driver, WebElement element){
        Point location = element.getLocation();
        String s = "window.scrollBy(" + location.getX() + "," + location.getY() + ")";
        ((JavascriptExecutor) driver).executeScript(s);
    }
}
