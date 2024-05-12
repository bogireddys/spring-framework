package selenium.webdriver.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.virtualauthenticator.VirtualAuthenticatorOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumActions {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/clickEventPage.html");
        WebElement webElement = driver.findElement(By.xpath("//div[@id='eventish']"));
        Actions actions = new Actions(driver);
        actions.click(webElement)
                .pause(Duration.ofSeconds(5))
                .build()
                .perform();
        String elementText = driver.findElement(By.xpath("//div[@id='result']/ul/li/span")).getText();
        System.out.println("Element text value : " + elementText);

        //Releasing all actions from last state
        ((RemoteWebDriver)driver).resetInputState();
    }
}
