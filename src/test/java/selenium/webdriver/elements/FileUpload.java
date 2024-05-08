package selenium.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class FileUpload {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/upload.html");
        File file = new File("src/test/resources/selenium-snapshot.jpg");
        //This code is for file detection with Remote Webdriver execution
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        driver.findElement(By.xpath("//input[@id='upload']")).sendKeys(file.toString());
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("Uploaded path is : " + driver.findElement(By.xpath("//div[@id='upload_label']")).getText());
    }
}
