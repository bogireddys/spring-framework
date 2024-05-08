package selenium.webdriver.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class SelectLists {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/selectPage.html");
        WebElement selectElement = driver.findElement(By.xpath("//select[@id='selectWithoutMultiple']"));
        Select select = new Select(selectElement);
        select.selectByIndex(1);

        WebElement selectElement2 = driver.findElement(By.xpath("//select[@id='selectWithMultipleEqualsMultiple']"));
        Select selectMultiple = new Select(selectElement2);
        System.out.println("Is Multi Select List : " + selectMultiple.isMultiple());
        selectMultiple.selectByVisibleText("Emmental");
        selectMultiple.selectByVisibleText("Parmigiano");
        List<WebElement> selectedOptions = selectMultiple.getAllSelectedOptions();
        for (WebElement element : selectedOptions) {
            System.out.println("Selected options are : " + element.getText());
        }

        WebElement selectElement3 = driver.findElement(By.xpath("//optgroup[@label='Group']/parent::select"));
        Select selectDropdown3 = new Select(selectElement3);
        selectDropdown3.selectByValue("two");

        WebElement selectElement4 = driver.findElement(By.xpath("//select[@id='narrow']"));
        Select selectDropdown4 = new Select(selectElement4);
        List<WebElement> options = selectDropdown4.getOptions();
        for (WebElement element : options) {
            System.out.println("Dropdown element text is : " + element.getText());
        }

        WebElement selectElement5 = driver.findElement(By.xpath("//select[@id='selectWithMultipleLongList']"));
        Select selectDropdown5 = new Select(selectElement5);
        selectDropdown5.selectByIndex(1);
        selectDropdown5.deselectByIndex(1);
    }
}
