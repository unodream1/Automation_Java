package testNG.Files;

import org.testng.annotations.Test;

public class testNGWithSettingXml {
    @Test
    public void tOne(){
        System.out.println("Running Normal t-1: ");
    }
    @Test
    public void tTwo(){
        System.out.println("Running Normal t-2: ");
    }
    @Test(groups = {"Regression"})
    public void rOne(){
        System.out.println("Running Normal r-1: ");
    }
    @Test(groups = {"Regression"})
    public void rTwo(){
        System.out.println("Running Normal r-2: ");
    }
    @Test(groups = {"Smoke"})
    public void sOne(){
        System.out.println("Running Normal s-1: ");
    }
    @Test(groups = {"Smoke"})
    public void sTwo(){
        System.out.println("Running Normal s-2: ");
    }
}
