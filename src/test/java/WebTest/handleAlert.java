package WebTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class handleAlert {
    WebDriver web;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        web = new ChromeDriver();
        web.get("http://demo.guru99.com/test/delete_customer.php");
        web.manage().window().maximize();
    }


    @Test
    public void testWebAlert() throws InterruptedException {
        web.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"))
                .sendKeys("100");
        web.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
        web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        Alert alert = web.switchTo().alert();
        String alertMessage = web.switchTo().alert().getText();
        System.out.println(alertMessage);
        Thread.sleep(5000);
        alert.dismiss();

    }

    @Test
    public void testTrueWebAlert() throws InterruptedException {
        web.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"))
                .sendKeys("200");
        web.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
        web.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        Alert alert = web.switchTo().alert();
        String alertMessage = web.switchTo().alert().getText();
        System.out.println(alertMessage);
        Thread.sleep(3000);
        alert.accept();

    }
    @After
    public void tearDown() {
        web.quit();

    }
}
