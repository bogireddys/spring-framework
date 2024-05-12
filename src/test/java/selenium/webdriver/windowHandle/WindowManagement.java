package selenium.webdriver.windowHandle;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WindowManagement {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.setPageLoadTimeout(Duration.ofSeconds(30));
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://the-internet.herokuapp.com");
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        System.out.println("Height of window " + height);
        System.out.println("Width of window " + width);

        Dimension dimension = driver.manage().window().getSize();

        System.out.println("Height of window " + dimension.getHeight());
        System.out.println("Width of window " + dimension.getWidth());

        driver.manage().window().setSize(new Dimension(500, 500));

        Point position = driver.manage().window().getPosition();
        int x1 = position.getX();
        int y1 = position.getY();

        System.out.println("Height of window " + x1);
        System.out.println("Width of window " + y1);

        driver.manage().window().setPosition(new Point(100, 100));

        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();

    }
}
