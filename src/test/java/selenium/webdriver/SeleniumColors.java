package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.Color;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumColors {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/colorPage.html");
        String rgbColor = driver.findElement(By.xpath("//div[@id='rgb']")).getCssValue("background-color");
        System.out.println("RGB Color : " + Color.fromString(rgbColor));
        String rgbaColor = driver.findElement(By.xpath("//div[@id='rgba']")).getCssValue("background-color");
        System.out.println("RGBA Color : " + Color.fromString(rgbaColor));
        String hexColor = driver.findElement(By.xpath("//div[@id='hex']")).getCssValue("background-color");
        System.out.println("HEX Color : " + Color.fromString(hexColor));
    }
}
