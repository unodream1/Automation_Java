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

import java.util.*;

public class VerifyMenuBar {
    WebDriver wD;
    //String[] a;

    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        wD =new ChromeDriver();
        wD.get("https://automationpractice.itsutra.com/");
        wD.manage().window().maximize();
        //wD.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Test
    public void readMenu(){

        //False Case
        //List<String> expMenu = new ArrayList<>
          //      (Arrays.asList("Home","Address","Name","Courses","Departments"));

        //True Case
        List<String> expMenu = new ArrayList<>
                (Arrays.asList("Home","About","Students","Courses","Instructors","Departments"));
        List<WebElement> actMenu = wD.findElements(By.xpath("/html/body/div[1]/div/div[2]/ul/li/a"));
        Assert.assertEquals(expMenu.size(), actMenu.size());
        for (WebElement item: actMenu){
            Assert.assertTrue(expMenu.contains((String) item.getText()));
            System.out.println(item.getText());
        }

    }

    @After
    public void exit(){
        wD.quit();
    }
}
