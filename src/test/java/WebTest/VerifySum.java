package WebTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class VerifySum {
    WebDriver wD;

    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        wD =new ChromeDriver();
        wD.get("https://www.w3schools.com/sql/sql_count_avg_sum.asp");
        wD.manage().window().maximize();
        wD.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    @Test
    public void addPrice(){
        List<WebElement> fullPrice = wD.findElements(By.xpath("//*[@id=\"main\"]/div[6]/table/tbody/tr/td[6]"));
        double total = 0.0;
        for(WebElement price:fullPrice){
            System.out.println(price.getText());
            total = total + Double.parseDouble(price.getText());
        }
        System.out.println("Total Price: " + total);
        double expTotal = 90.35;
        //double expTotal = 38.35; // False verification!
        Assert.assertEquals(expTotal, total, 0.0001);

    }

    @After
    public void exit(){
        wD.quit();
    }

}
