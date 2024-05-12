package selenium.webdriver.screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import wiremock.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ElementScreenshot {
    public static void main(String[] args) throws IOException, InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setPageLoadTimeout(Duration.ofSeconds(30));
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement element = driver.findElement(By.xpath("//div[@id='drag-drop-upload']"));
        File file = new File("src/test/resources/selenium-element-screenshot.jpg");
        File elementScreenshot = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(elementScreenshot, file);

        //This code is for file detection with Remote Webdriver execution
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys(file.getPath());
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();

        Thread.sleep(10);
        String text = driver.findElement(By.xpath("//div[@class='large-12 columns' and @id='content']/div/h3")).getText();
        System.out.println("Uploaded file : " + text);
    }
}
