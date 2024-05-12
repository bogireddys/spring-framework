package selenium.webdriver.drivers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicAuthConfig {
    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        Credentials usernameAndPassword = new UsernameAndPassword("admin", "admin");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.setAcceptInsecureCerts(true);

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions, true);
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String securedMessage = driver.findElement(By.xpath("//div[@class='example']/p")).getText();
        System.out.println("Message after entering Basic Auth details : " + securedMessage);

        //CDP Basic Auth Implementation
//        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Predicate<URI> uriPredicate = uri -> uri.toString().contains("herokuapp.com/basic_auth");
        Supplier<Credentials> authentication = UsernameAndPassword.of("admin", "admin");
        ((HasAuthentication) driver).register(uriPredicate, authentication);
        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }
}
