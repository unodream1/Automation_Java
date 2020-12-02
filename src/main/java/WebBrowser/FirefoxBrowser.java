package WebBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "Driver Path\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("abcd_password");
        driver.findElement(By.id("loginbutton")).click();
        System.out.println("Login");
        Thread.sleep(6000);
        driver.findElement(By.id("userNavigationLabel")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("Log out")).click();
        System.out.println("Logout successfully");
        Thread.sleep(2000);
        driver.quit();
    }
}
