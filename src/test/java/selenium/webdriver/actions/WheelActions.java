package selenium.webdriver.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.remote.RemoteWebDriver;
import selenium.webdriver.JavaScriptExecutor;

import java.net.MalformedURLException;
import java.net.URL;

public class WheelActions {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://formy-project.herokuapp.com/");
        Actions actions = new Actions(driver);

        WebElement linkElement = driver.findElement(By.xpath("//a[text()='Page Scroll' and @class='btn btn-lg']"));
        actions.moveToElement(linkElement)
                .click()
                .build()
                .perform();
        ((RemoteWebDriver) driver).resetInputState();

        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(linkElement, 0, 0);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 1200)
                .perform();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Bogireddy Gnanendra Reddy");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='date']")).sendKeys("21/05/1996");
        Thread.sleep(2000);

        WebElement footer = driver.findElement(By.xpath("//input[@id='date']"));
        WheelInput.ScrollOrigin scrollOrigin2 = WheelInput.ScrollOrigin.fromElement(footer, 0, 0);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin2, 0, -1000)
                .perform();
    }
}
