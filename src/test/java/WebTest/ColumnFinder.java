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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColumnFinder {
    WebDriver web;

    @Before
    public void setWeb(){
        WebDriverManager.chromedriver().setup();
        web =new ChromeDriver();
        web.get("https://www.w3schools.com/html/html_tables.asp");
        web.manage().window().maximize();
    }

    @Test
    public void findColumns(){
        WebElement country = web.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td[3]"));
        //System.out.println((country.getText()));

        List<WebElement> columns = web.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/td[3]"));
        for(WebElement column:columns){
            System.out.println(column.getText());
        }
        //for compare with two array list
        List<String> expectedCountries=new ArrayList<>
                (Arrays.asList("Germany","Mexico","Austria","UK","Canada","Italy"));
        List<String> countries = new ArrayList<>();
        for(WebElement column:columns){
            countries.add(column.getText());
        }
        Assert.assertEquals(countries, expectedCountries);
    }

//    @Test  //verification for false case
//    public void readColumns(){
//        String expectedCountry ="USA";
//        byte found =0;
//        List<WebElement> columns = web.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/td[3]"));
//        for(WebElement column:columns) {
//            if (column.getText().equals(expectedCountry)) {
//                found++;
//                break;
//            }
//        }
//        Assert.assertEquals(found,1);
//    }

    @Test  //verification for true case
    public void readTrueColumns(){
        String expectedCountry ="Mexico";
        byte found =0;
        List<WebElement> columns = web.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/td[3]"));
        for(WebElement column:columns) {
            if (column.getText().equals(expectedCountry)) {
                found++;
                break;
            }
        }
        Assert.assertEquals(found,1);
    }

    @After
    public void exit(){
        web.close();
    }
}


