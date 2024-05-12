package selenium.webdriver.screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import wiremock.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TakeScreenshot {
    public static void main(String[] args) throws IOException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setPageLoadTimeout(Duration.ofSeconds(30));
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://formy-project.herokuapp.com/fileupload");

        File file = new File("src/test/resources/selenium-screenshot.jpg");
        File savedFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(savedFile, file);

        //This code is for file detection with Remote Webdriver execution
        ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        driver.findElement(By.xpath("//input[@id='file-upload-field']")).sendKeys(file.getPath());
    }
}
