package selenium.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class XPathAxes {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);

        driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");

        //XPath using the following
        driver.findElement(By.xpath("//div[@class='form-group w-4/12 smtablet:w-full text-section pr-20 smtablet:pr-0'][2]//following::div[@class='form-group w-4/12 smtablet:w-full']/input")).sendKeys("Relative XPath//following::Relative XPath without //");

        //XPath using the child
        driver.findElement(By.xpath("//form[@id='seleniumform']//child::div[@class='form-group w-4/12 smtablet:w-full text-section pr-20 smtablet:pr-0'][2]/input")).sendKeys("Relative XPath//child::Relative XPath without //");

        //XPath using preceding-sibling
        driver.findElement(By.xpath("//div[@class='form-group w-6/12 smtablet:w-full']//preceding-sibling::div[@class='form-group w-6/12 smtablet:w-full pr-20 smtablet:pr-0']//input[@id='company']")).sendKeys("Relative XPath//preceding-sibling::Relative XPath without //");

        //XPath using the parent
        driver.findElement(By.xpath("//a[starts-with(text(), 'Selenium Testing')]//parent::li//following-sibling::li[1]//a")).click();

        String seleniumGrid = driver.getCurrentUrl();

        System.out.println("LambdaTest Selenium Grid URL : " + seleniumGrid);

        driver.navigate().back();

        //XPath using the following-sibling
        driver.findElement(By.xpath("//a[starts-with(text(), 'Selenium Testing')]//parent::li//following-sibling::li[2]//a")).click();

        //XPath using ancestor, descendant
        driver.findElement(By.xpath("//a[starts-with(text(), 'Mobile App Testing')]//ancestor::div[5]//descendant::li[1]//child::a[@href='https://www.lambdatest.com/automation-cloud']")).click();

        String seleniumAutomationCloud = driver.getCurrentUrl();

        System.out.println("LambdaTest Selenium Grid URL : " + seleniumAutomationCloud);


    }
}
