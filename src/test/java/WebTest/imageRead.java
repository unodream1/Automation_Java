package WebTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//public class imageRead {
//    WebDriver web;
//
//    @Before
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        web = new ChromeDriver();
//        web.get("http://automationpractice.com/index.php");
//        web.manage().window().maximize();
//    }
//    @Test
//    public void imageList() throws InterruptedException{
//        web.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
//        web.findElement(By.className("icon-th-large")).click();
//        Thread.sleep(5000);
//
//        web.findElement(By.cssSelector(".replace-2x.img-responsive")).get(4).click();
//        Thread.sleep(5000);
//
//        web.switchTo().frame(0);
//        int noIcons = web.findElement(By.cssSelector("#thumbs_list_frame>li")).size();
//        List<WebElement> webElements = web.findElements(By.cssSelector("#thumbs_list_frame>li"));
//        Thread.sleep(5000);
//        web.findElement(By.xpath("//*[@id=\"bigpic\"]")).click();
//        web.findElement(By.xpath("//*[@id=\"bigpic\"]")).click();
//        Thread.sleep(5000);
//
//        for (int i=1; i<noIcons; i++){
//            WebElement nextArrow = web.findElement(By.xpath(".fancybox-nav.fancybox-next"));
//            nextArrow.click();
//            Thread.sleep(5000);
//        }
//        web.switchTo().defaultContent();
//        Thread.sleep(3000);
//
//    }
//
//    @After
//    public void exit(){
//        web.close();
//    }
//}
