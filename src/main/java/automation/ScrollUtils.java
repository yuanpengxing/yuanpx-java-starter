package automation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("scrollUtils")
public class ScrollUtils {
    @Resource(name = "driverDataSource")
    DriverDataSource driverDataSource;

    @Resource(name = "waitElement")
    WaitElement waitElement;

    public void scrollToSpecifiedElement(String specifiedElementXpath) {
        WebElement element = waitElement.xpath(specifiedElementXpath);
        Point location = element.getLocation();
        String s = "window.scrollBy(" + location.getX() + "," + location.getY() + ")";
        ((JavascriptExecutor) driverDataSource.getDriver()).executeScript(s);
    }

}
