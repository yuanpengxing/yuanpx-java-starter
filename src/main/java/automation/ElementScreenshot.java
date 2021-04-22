package automation;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

public class ElementScreenshot {
    @Resource(name = "driverDataSource")
    DriverDataSource driverDataSource;

    public void captureElement(WebElement element) throws Exception {
        File screen = ((TakesScreenshot) driverDataSource.getDriver()).getScreenshotAs(OutputType.FILE);
        BufferedImage img = ImageIO.read(screen);
        Dimension size = element.getSize();
        // 创建一个矩形使用上面的高度，和宽度
        Rectangle rect = new Rectangle(size.width, size.height);
        // 得到元素的坐标
        Point p = element.getLocation();
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
        // 存为png格式
        ImageIO.write(dest, "png", new File("testa"));
    }
}
