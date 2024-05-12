package selenium.webdriver.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class iFrames {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/iframes.html");
        System.out.println("Main heading of the page is : " + driver.findElement(By.xpath("//h1[@id='iframe_page_heading']")).getText());
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='iframe1']"));

        driver.switchTo().frame(frameElement);

        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("john.doe@iemail.com");
        driver.findElement(By.xpath("//input[@type='number']")).sendKeys("0000000000");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.switchTo().defaultContent();

        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top");
        System.out.println("Currently we are in Parent Frame");
        driver.switchTo().frame("frame-left");
        System.out.println("Currently we are in Child Frame");
        // Switches to parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
    }
}
