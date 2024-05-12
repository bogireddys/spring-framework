package selenium.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

public class DatePicker {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://formy-project.herokuapp.com/datepicker");
        SimpleDateFormat formDate = new SimpleDateFormat("MM/dd/yyyy");

        String strDate = formDate.format(System.currentTimeMillis());
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys(strDate);
    }
}
