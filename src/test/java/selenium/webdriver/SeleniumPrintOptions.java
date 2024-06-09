package selenium.webdriver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;

public class SeleniumPrintOptions {
    public static void main(String[] args) throws IOException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("headless");
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/printPage.html");

        PrintOptions printOptions = new PrintOptions();

        PrintsPage printer = (PrintsPage) driver;
        Pdf pdf = printer.print(printOptions);
        String content = pdf.getContent();
        File file = new File("src/test/resources/samplepdf.pdf");
        Files.write(file.toPath(), OutputType.BYTES.convertFromBase64Png(content));
    }
}
