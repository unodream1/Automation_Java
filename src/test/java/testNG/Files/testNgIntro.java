package testNG.Files;

import org.testng.annotations.*;


public class testNgIntro {
    @BeforeTest
    public void beforeTest(){
            System.out.println("Before Test");
        }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test
    public void testOne(){
        System.out.println("Test 1");
    }

    @Test
    public void testTwo(){
        System.out.println("Test 2");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
}

