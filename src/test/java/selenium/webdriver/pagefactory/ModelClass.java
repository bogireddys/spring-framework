package selenium.webdriver.pagefactory;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

@Data
public class ModelClass {

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(how = How.XPATH, using = "//input[@id='job-title']")
    private WebElement jobTitle;

    @FindBy(how = How.CSS, using = "#select-menu")
    private WebElement experience;


    // FindBys are AND combination for FindBy
    // We can use this when element is having single parent and multiple child elements
    @FindBys({
            @FindBy(xpath = "//input[@aria-label='Radio button']"),
            @FindBy(how = How.XPATH, using = "//input[@id='radio-button-1']")
    })
    private WebElement eduRadioButton;

    // FindAll are OR combination for FindBy
    // We can use this when element is having single parent and multiple child elements
    @FindAll({
            @FindBy(xpath = "//input[@type='checkbox']"),
            @FindBy(how = How.XPATH, using = "//input[@id='checkbox-1']")
    })
    private WebElement sexCheckBox;


    @FindBy(xpath = "//input[@id='datepicker']")
    @CacheLookup
    private WebElement datePicker;

    @FindBy(how = How.XPATH, using = "//a[@class='btn btn-lg btn-primary']")
    @CacheLookup
    private WebElement submitButton;

    // Using FindBy in FindElements context
    @FindBy(how = How.TAG_NAME, using = "a")
    List<WebElement> totalLinks;
}
