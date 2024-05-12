package selenium.webdriver;

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
import java.util.Base64;

public class SeleniumPrintOptions {
    public static void main(String[] args) throws IOException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("headless");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://www.selenium.dev/selenium/web/printPage.html");

        PrintOptions printOptions = new PrintOptions();
        printOptions.setPageRanges("1-4");
        printOptions.setOrientation(PrintOptions.Orientation.PORTRAIT);

        PrintsPage printer = (PrintsPage) driver;
        Pdf pdf = printer.print(printOptions);
        String content = pdf.getContent();
        byte[] base64String = Base64.getMimeDecoder().decode(content);
        File file = new File("src/test/resources/samplepdf.pdf");
        FileWriter myWriter = new FileWriter(file);
        myWriter.write(new String(base64String));
        myWriter.close();
        System.out.println("Page Content is : " + new String(base64String));

    }
}
