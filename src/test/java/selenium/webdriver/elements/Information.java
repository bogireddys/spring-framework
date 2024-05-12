package selenium.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Information {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.104.18:4444"), chromeOptions);

        driver.get("https://formy-project.herokuapp.com/enabled");

        boolean selected = driver.findElement(By.xpath("//div[@class='container']/h1")).isDisplayed();
        System.out.println("Element selected or not : " + selected);

        boolean enabled = driver.findElement(By.xpath("//input[@id='disabledInput']")).isEnabled();
        System.out.println("Element enabled or not : " + enabled);

        driver.findElement(By.xpath("//a[@class='nav-link']")).click();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,500)");

        boolean checked = driver.findElement(By.xpath("//input[@id='checkbox-1']")).isSelected();
        System.out.println("Element checked or not : " + checked);

        driver.findElement(By.xpath("//input[@id='checkbox-1']")).click();
        boolean checkedCheckBox = driver.findElement(By.xpath("//input[@id='checkbox-1']")).isSelected();
        System.out.println("Element checked or not : " + checkedCheckBox);

        WebElement webElement = driver.findElement(By.xpath("//label[@for='first-name']"));
        String color = webElement.getCssValue("background-color");
        System.out.println("Background color : " + color);

        String text = webElement.getText();
        System.out.println("Background color : " + text);

        String attribute = webElement.getAttribute("for");
        System.out.println("Background color : " + attribute);


    }
}
