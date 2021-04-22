package automation;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

@Component("switchWindow")
public class SwitchWindow {
    @Resource(name = "driverDataSource")
    DriverDataSource driverDataSource;

    public void toSpecifyWindow(String specifytitlename) {
        WebDriver driver = driverDataSource.getDriver();
        Set<String> handles = driver.getWindowHandles();
        String titlename;
        for (String handle : handles) {
            titlename = driver.switchTo().window(handle).getTitle();
            if (titlename.contains(specifytitlename)) {
                break;
            }
        }
    }

}
