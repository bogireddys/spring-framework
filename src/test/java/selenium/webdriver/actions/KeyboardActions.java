package selenium.webdriver.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class KeyboardActions {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/keyboard_shortcut.html");
        Thread.sleep(2000);
//        driver.get("https://en.key-test.ru/");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .sendKeys("1")
                .build()
                .perform();
        ((RemoteWebDriver) driver).resetInputState();
        String backgroundColor = driver.findElement(By.xpath("/html/body")).getCssValue("background");
        System.out.println("Background Color after pressing buttons : " + backgroundColor);

        actions.keyDown(Keys.ALT)
                .sendKeys("1")
                .build()
                .perform();
        ((RemoteWebDriver) driver).resetInputState();
        String backgroundColorGreen = driver.findElement(By.xpath("/html/body")).getCssValue("background");
        System.out.println("Background Color after pressing buttons : " + backgroundColorGreen);

        actions.keyDown(Keys.LEFT_CONTROL)
                .keyDown(Keys.ALT)
                .sendKeys("1")
                .build()
                .perform();
        ((RemoteWebDriver) driver).resetInputState();
        String backgroundColorLightGreen = driver.findElement(By.xpath("/html/body")).getCssValue("background");
        System.out.println("Background Color after pressing buttons : " + backgroundColorLightGreen);

        actions.keyDown(Keys.CONTROL)
                .keyDown(Keys.SHIFT)
                .keyDown(Keys.ALT)
                .sendKeys("1")
                .build()
                .perform();
        ((RemoteWebDriver) driver).resetInputState();
        String backgroundColorMagenta = driver.findElement(By.xpath("/html/body")).getCssValue("background");
        System.out.println("Background Color after pressing buttons : " + backgroundColorMagenta);

        driver.navigate().to("https://www.selenium.dev/selenium/web/single_text_input.html");
        WebElement webElement = driver.findElement(By.xpath("//input[@id='textInput']"));
        actions.keyDown(Keys.SHIFT)
                .sendKeys(webElement, "kEYSdOWN")
                .keyUp(Keys.SHIFT)
                .sendKeys("KeysUP")
                .build()
                .perform();
    }
}
