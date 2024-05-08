package selenium.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SampleScript {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println("Title of the screen is : " + driver.getTitle());
        WebElement textBox = driver.findElement(By.xpath("//input[@class='form-control' and @id='my-text-id']"));
        textBox.sendKeys("This is the sample text to send in the textbox");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.quit();
    }
}
