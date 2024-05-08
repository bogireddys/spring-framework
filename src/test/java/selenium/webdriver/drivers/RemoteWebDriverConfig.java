package selenium.webdriver.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverConfig {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);
        driver.get("https://www.selenium.dev/selenium/web/upload.html");

        // File upload
        File file = new File("src/test/resources/selenium-snapshot.jpg");
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        driver.findElement(By.xpath("//input[@id='upload']")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        String text = driver.findElement(By.xpath("//div[@id='upload_label']")).getText();
        System.out.println("File upload path is : " + text);


    }
}
