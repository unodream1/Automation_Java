package WebTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MinMaxVerify {
    WebDriver web;

    @Before
    public void setWeb() {
        WebDriverManager.chromedriver().setup();
        web = new ChromeDriver();
        web.get("https://datatables.net/examples/data_sources/dom");
        web.manage().window().maximize();
    }

    @Test
    public void findColumns() {
        List<Integer> salaryValues = new ArrayList<>();
        List<String> rowTexts = new ArrayList<>();
        while (true){
            String toClick = "//*[@id=\"example_next\"]";
            WebElement nextButton = web.findElement(By.xpath("//*[@id=\"example_next\"]"));
            String status = nextButton.getAttribute("class");
            List<WebElement> salaries = web.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr/td[6]"));
            List<WebElement> fullRow = web.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr"));
            for (WebElement item: fullRow){
                rowTexts.add((String) item.getText());
            }
            for (WebElement salary : salaries) {
                System.out.println(salary.getText());
                String val = (String) salary.getText().replace("$", "").replace(",", "");
                salaryValues.add(Integer.parseInt(val));
            }
            if (status.equals("paginate_button next disabled")){
                break;
            }
            nextButton.click();
        }
        int maxSalary = Collections.max(salaryValues);
        int minSalary = Collections.min(salaryValues);
        for (String element: rowTexts){
            String[] fullTextTokenArray = element.split(" ");
            String salaryStr = fullTextTokenArray[fullTextTokenArray.length -1];
            String salary = salaryStr.replace("$", "").replace(",", "");
            int salaryVal = Integer.parseInt(salary);
            if (salaryVal == maxSalary){
                System.out.println("Maximum Salary: " + maxSalary);
                System.out.println("----------Maximum salary and Information--------------------");
                System.out.println(element);
            }
            if (salaryVal == minSalary){
                System.out.println("Minimum Salary: " + minSalary);
                System.out.println("----------Minimum salary and Information--------------------");
                System.out.println(element);
            }
        }
    }

        @After
        public void exit(){
            web.close();
        }
}


