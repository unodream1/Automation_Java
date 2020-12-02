package WebTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebBrowserTest {
    @Test
    public void ChromeBrowser() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver web = new ChromeDriver();

        web.get("http://www.gmail.com");
        web.manage().window().maximize();
        Thread.sleep(3000);
        web.close();
    }

    @Test
    public void firefoxBrowser() throws InterruptedException{
        System.setProperty("webdriver.firefox.bin","/Users/sabina/Desktop/Firefox.app/Contents/MacOS/firefox");
        WebDriverManager.firefoxdriver().setup();
        WebDriver wb = new FirefoxDriver();

        wb.get("http://www.facebook.com");
        wb.manage().window().maximize();
        Thread.sleep(3000);
        wb.close();


    }
}
