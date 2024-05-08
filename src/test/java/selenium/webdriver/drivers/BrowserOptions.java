package selenium.webdriver.drivers;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BrowserOptions {
    public static void main(String[] args) throws MalformedURLException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.setPlatformName(Platform.WIN11.toString());
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setPageLoadTimeout(Duration.of(60, ChronoUnit.SECONDS));
        chromeOptions.setScriptTimeout(Duration.ofMinutes(1));
        chromeOptions.setImplicitWaitTimeout(Duration.ofMinutes(2));
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
        chromeOptions.setStrictFileInteractability(false);
        chromeOptions.setEnableDownloads(true);
//        Proxy proxy = new Proxy();
//        proxy.setProxyType(Proxy.ProxyType.MANUAL);
//        proxy.setHttpProxy("<HOST:PORT>");
//        chromeOptions.setCapability("proxy", proxy);

        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

    }
}
