package selenium.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Locators {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);
        driver.get("https://seleniumbase.io/demo_page");

        // xpath using text() method
        String xpathtext = driver.findElement(By.xpath("//button[text()='Click Me (Green)']")).getText();
        System.out.println("Text value retrieved using xpath text() : " + xpathtext);

        // xpath contains text() method
        String xpathtextcontains = driver.findElement(By.xpath("//p[contains(text(), 'This Text is Green')]")).getText();
        System.out.println("Text value retrieved using xpath text() contains method : " + xpathtextcontains);

        //xpath using or//and method
        String xpathusingorand = driver.findElement(By.xpath("//input[@placeholder='Placeholder Text Field' or @id='placeholderText']")).getText();
        System.out.println("Text value retrieved using xpath text() contains method : " + xpathusingorand);

        //xpath using starts-with()
        String xpathusingstartswith = driver.findElement(By.xpath("//label[starts-with(text(), 'Progress')]")).getText();
        System.out.println("Text value retrieved using xpath text() and starts-with()  : " + xpathusingstartswith);

        //xpath using starts-with() and index
        driver.findElement(By.xpath("//input[starts-with(@id,'checkBox')][2]")).click();

        driver.quit();

    }
}
