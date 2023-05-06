package autotest;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverInitAndroid {
    public static AndroidDriver init() throws MalformedURLException {
        //启动appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("app", app.getAbsolutePath());    //如果该应用手机已安装不会重新安装和覆盖之前的版本
        //capabilities.setCapability("noReset", true);  //不需要再次安装
        capabilities.setCapability("deviceName","127.0.0.1:21513");
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","7.1");

        //配置测试apk
//        capabilities.setCapability("appPackage", "com.privatemaster.privacy");
//        capabilities.setCapability("appActivity", ".main.MainActivity");
//        capabilities.setCapability("sessionOverride", true);    //每次启动时覆盖session，否则第二次后运行会报错不能新建session
//        capabilities.setCapability("unicodeKeyboard", true);    //设置键盘
//        capabilities.setCapability("resetKeyboard", false);     //设置默认键盘为appium的键盘
//        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);  //错误的
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
