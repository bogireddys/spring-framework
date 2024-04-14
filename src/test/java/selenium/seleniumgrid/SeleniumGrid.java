package selenium.seleniumgrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGrid {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.12:4444"), chromeOptions);
        driver.get("http://www.google.com");
        Thread.sleep(50000);
        driver.quit();
    }
}
