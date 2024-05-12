package selenium.webdriver.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Set;

public class Cookies {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("browserName", "chrome");
        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.78.18:4444"), chromeOptions);

        driver.get("https://setcookie.net");
        Cookie cookie = new Cookie("Cookie_Name", "Cookie_Value", ".setcookie.net", "Cookie_Path", null, true, true);
//        driver.manage().addCookie(cookie);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(cookie.getName());
        driver.findElement(By.xpath("//input[@name='value']")).sendKeys(cookie.getValue());
        driver.findElement(By.xpath("//input[@name='path']")).sendKeys(cookie.getPath());
        driver.findElement(By.xpath("//input[@value='.setcookie.net']")).click();
        driver.findElement(By.xpath("//input[@value='none'  and @name='ss']")).click();
//        driver.findElement(By.xpath("//input[@type='checkbox' and @name='expires']")).click();
//        driver.findElement(By.xpath("//input[@type='datetime-local']")).sendKeys("21-05-2030 12:00");
        driver.findElement(By.xpath("//input[@type='checkbox' and @name='sec']")).click();
//        driver.findElement(By.xpath("//input[@type='checkbox' and @name='httponly']")).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.navigate().to("https://formy-project.herokuapp.com");
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookies size from the website : " + cookies.size());

        for (Cookie localCookie : cookies) {
            System.out.println("Cookie Name : " + localCookie.getName());
            System.out.println("Cookie Value : " + localCookie.getValue());
            System.out.println("Cookie Path : " + localCookie.getPath());
            System.out.println("Cookie domain : " + localCookie.getDomain());
            System.out.println("Cookie Expiry : " + localCookie.getExpiry());
            System.out.println("Http only : " + localCookie.isHttpOnly());
        }

        driver.manage().deleteAllCookies();
        Set<Cookie> cookieSize = driver.manage().getCookies();
        System.out.println("Cookies size after deleting from the website : " + cookieSize.size());

        driver.get("https://the-internet.herokuapp.com/");
        Set<Cookie> cookiesSize = driver.manage().getCookies();
        System.out.println("Cookies size from the website : " + cookiesSize.size());

        Cookie cookieNamed = driver.manage().getCookieNamed("rack.session");

        System.out.println("Cookie Value : " + cookieNamed.getValue());
        System.out.println("Cookie Domain : " + cookieNamed.getDomain());

        driver.manage().deleteCookieNamed("rack.session");
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println("Cookies size after deleting from the website : " + allCookies.size());
        for (Cookie coo : allCookies) {
            System.out.println("Cookie Names : " + coo.getName());
        }

        Cookie cookieBuilder = new Cookie.Builder("key", "value")
                .isHttpOnly(true)
                .expiresOn(new Date("01/01/2030"))
                .isSecure(true)
                .domain("host")
                .sameSite("Strict").build();
    }
}
