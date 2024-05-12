package selenium.webdriver.windowHandle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class WindowHandles {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setPageLoadTimeout(Duration.ofSeconds(30));
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
        String parentWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[@id='a-link-that-opens-a-new-window']")).click();
        Set<String> setOfWindows = driver.getWindowHandles();

        for (String windowHandle : setOfWindows) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("Simple Page")) {
                break;
            }
        }

        String text = driver.findElement(By.xpath("/html/body/div")).getText();
        System.out.println("Text from another Window is : " + text);
        driver.close();

        driver.switchTo().window(parentWindow);
        driver.switchTo().frame("myframe");
        driver.switchTo().defaultContent();

        String originalWindow = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> setOfNewWindows = driver.getWindowHandles();
        System.out.println("Size is : " + setOfNewWindows.size());
        for (String string : setOfNewWindows) {
            driver.switchTo().window(string);
            System.out.println("URL is : " + driver.getCurrentUrl());
            if (!(string.equals(originalWindow))) {
                break;
            }
        }
        driver.navigate().to("https://formy-project.herokuapp.com/");

    }
}
