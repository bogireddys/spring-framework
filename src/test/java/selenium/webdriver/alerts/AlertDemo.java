package selenium.webdriver.alerts;

import org.openqa.selenium.Alert;
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
import java.util.Set;

public class AlertDemo {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.104.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
        driver.findElement(By.xpath("//a[@id='alert']")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println("Alert text is : " + alert.getText());
        alert.accept();

        driver.findElement(By.xpath("//a[@id='prompt']")).click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("Sending text into alert box");
        alert2.accept();

        driver.findElement(By.xpath("//a[@id='double-prompt']")).click();
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("First alert box");
        alert3.accept();

        Alert alert4 = driver.switchTo().alert();
        alert4.sendKeys("Second alert box");
        alert4.dismiss();

        driver.findElement(By.xpath("//a[@id='slow-alert']")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert slowAlert = driver.switchTo().alert();
        slowAlert.accept();

        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@id='open-window-with-onload-alert']")).click();

        Set<String> stringSet = driver.getWindowHandles();

        for (String windowName : stringSet) {
            driver.switchTo().window(windowName);
            if (!(driver.getWindowHandle().equals(windowName))) {
                break;
            }
        }
        Alert newWindowAlert = driver.switchTo().alert();
        newWindowAlert.dismiss();
    }
}
