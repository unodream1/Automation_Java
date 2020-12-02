package WebTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GmailLoctor {


    @Test
    public void start() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webD = new ChromeDriver();
        webD.get("https://www.gmail.com");
        webD.manage().window().maximize();
        Thread.sleep(2000);

        WebElement eE = webD.findElement(By.name("identifier"));
        String email= "dummytest993";
        eE.sendKeys(email);
        WebDriverWait wait=new WebDriverWait(webD, 20);
        eE.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]")).click();
        webD.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        WebElement pss = webD.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));
        String password = "itsutra12#";
        pss.sendKeys(password);
        pss.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]")).click();


        String actualUrl="https://accounts.google.com/signin/v2/challenge/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin&cid=1&navigationDirection=forward&TL=AM3QAYbN2JpJM6Kirg4VAb3ER_qDPQYDXVO7E9l1IecXFpWIz6cymu5fHd2J3saH";
        String expectedUrl= webD.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }

}
