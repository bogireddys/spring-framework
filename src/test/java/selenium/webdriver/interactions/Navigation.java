package selenium.webdriver.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Navigation {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.selenium.dev/selenium/web/index.html");
        driver.findElement(By.xpath("//a[contains(text(), 'blank')]")).click();
        driver.navigate().back();
        System.out.println("URL of the page is : " + driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println("URL of the page is : " + driver.getCurrentUrl());
        driver.navigate().refresh();
    }
}
