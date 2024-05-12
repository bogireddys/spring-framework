package selenium.webdriver.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class ModelBox {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://formy-project.herokuapp.com/modal");
        driver.findElement(By.xpath("//button[@id='modal-button']")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@id='exampleModalLabel']")));
        System.out.println("Model Title : " + driver.findElement(By.xpath("//h5[@id='exampleModalLabel']")).getText());
        driver.findElement(By.xpath("//button[@id='close-button']")).click();

    }
}
