package selenium.webdriver.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class PageInfo {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/index.html");
        System.out.println("URL of the page is : " + driver.getCurrentUrl());
        System.out.println("Title of the page is : " + driver.getTitle());
        System.out.println("Page source is : " + driver.getPageSource());

    }
}
