package selenium.webdriver.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class MouseActions {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        Actions actions = new Actions(driver);

        WebElement clickElement = driver.findElement(By.xpath("//a[@id='click']"));
        actions.click(clickElement)
                .perform();
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://www.selenium.dev/selenium/web/resultPage.html")) {
            System.out.println("URL matched ");
        }

        ((RemoteWebDriver) driver).resetInputState();
        driver.navigate().back();
        actions.click(driver.findElement(By.xpath("//input[@id='clickable']")))
                .build().perform();
        ;
        ((RemoteWebDriver) driver).resetInputState();

        String focusText = driver.findElement(By.xpath("//strong[@id='click-status']")).getText();
        if (focusText.equals("focused")) {
            System.out.println("Text matched");
        }

        driver.navigate().refresh();
        WebElement draggableElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppableElement = driver.findElement(By.xpath("//div[@id='droppable']"));

        actions.dragAndDrop(draggableElement, droppableElement);
        ((RemoteWebDriver) driver).resetInputState();

        actions.clickAndHold(draggableElement)
                .moveToElement(droppableElement)
                .release()
                .perform();
        ((RemoteWebDriver) driver).resetInputState();

        driver.get("https://www.selenium.dev/selenium/web/mouseOver.html");
        WebElement redElement = driver.findElement(By.xpath("//div[@id='redbox']"));
        actions.moveToElement(redElement)
                .perform();
        System.out.println("Backgroud Color : " + driver.findElement(By.xpath("//div[@id='redbox']")).getCssValue("background-color"));
        ((RemoteWebDriver) driver).resetInputState();
    }
}
