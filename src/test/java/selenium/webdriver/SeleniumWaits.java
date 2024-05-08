package selenium.webdriver;

import org.hibernate.query.sqm.TemporalUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumWaits {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        //Implicit wait timeouts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Explicit wait timeouts
        driver.findElement(By.xpath("//input[@id='adder']")).click();
        Wait<WebDriver> webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='redbox']")));
        String color = driver.findElement(By.xpath("//div[@class='redbox']")).getCssValue("background-color");
        System.out.println("Box color is : " + color);

        //Fluent wait timeouts
        driver.findElement(By.xpath("//input[@id='reveal']")).click();
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(100))
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .withMessage("Waiting for checkbox to appear");
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='revealed']")));
        driver.findElement(By.xpath("//input[@id='revealed']")).sendKeys("Sample text");

    }
}
