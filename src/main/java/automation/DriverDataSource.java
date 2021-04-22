package automation;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component("driverDataSource")
public class DriverDataSource {
    static ThreadLocal<WebDriver> localMap = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        WebDriver driver = localMap.get();
        if (driver == null) {
            localMap.set(InitChrome.getDriver());
        }
        return localMap.get();
    }

    public static void deleteDriver() {
        if (localMap.get() != null) {
            localMap.get().close();
            localMap.remove();
        }
    }

    public static void initNewDriver() {
        DriverDataSource.deleteDriver();
        localMap.set(InitChrome.getDriver());
    }

}
