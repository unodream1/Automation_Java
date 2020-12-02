package Test;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testing.Assert;

public class GmailLoctor {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver webD = new ChromeDriver();
        webD.get("https://www.gmail.com");
        webD.manage().window().maximize();

        WebElement eE = webD.findElement(By.name("identifier"));
        String email= "dummytest993";
        eE.sendKeys(email);
        WebDriverWait wait=new WebDriverWait(webD, 20);
        eE.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
        webD.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

       /* WebElement pss = webD.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        String password = "itsutra12#";
        pss.sendKeys(password);
        pss.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();*/

        //Assert.assertEquals(String actual, String expected);
        String actualUrl="https://accounts.google.com/signin/v2/challenge/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward&TL=AM3QAYbN2JpJM6Kirg4VAb3ER_qDPQYDXVO7E9l1IecXFpWIz6cymu5fHd2J3saH";
        String expectedUrl= webD.getCurrentUrl();

        if(actualUrl.equalsIgnoreCase(expectedUrl))
        {
            System.out.println("Test passed");
        }
        else
        {
            System.out.println("Test failed");
        }



    }
}
