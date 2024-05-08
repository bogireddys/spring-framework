package selenium.seleniumgrid;

import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class BasicAuth {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        ClientConfig clientConfig = ClientConfig.defaultConfig()
                .baseUrl(new URL("http://localhost:4444"))
                .authenticateAs(new UsernameAndPassword("admin", "password"));
        HttpCommandExecutor executor = new HttpCommandExecutor(clientConfig);

        RemoteWebDriver driver = new RemoteWebDriver(executor, new ChromeOptions());
        driver.get("https://www.selenium.dev/");
        Thread.sleep(5000);
        driver.quit();
    }
}
