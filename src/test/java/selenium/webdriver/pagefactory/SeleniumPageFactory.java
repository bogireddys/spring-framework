package selenium.webdriver.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumPageFactory {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL(" http://10.247.136.204:4444"), chromeOptions);

        driver.get("https://formy-project.herokuapp.com/form");

        ModelClass modelClass = PageFactory.initElements(driver, ModelClass.class);

        modelClass.getFirstName().sendKeys("Gnanendra Reddy");
        modelClass.getLastName().sendKeys("Bogireddy");
        modelClass.getJobTitle().sendKeys("Test Automation Eng Analyst");
        modelClass.getEduRadioButton().click();
        modelClass.getSexCheckBox().click();
        Select select = new Select(modelClass.getExperience());
        select.selectByValue("3");
        modelClass.getDatePicker().sendKeys("21/05/2025");
        modelClass.getSubmitButton().click();

        System.out.println("Current page URL is : " + driver.getCurrentUrl());
        System.out.println("Total links size are : " + modelClass.totalLinks.size());
    }
}
