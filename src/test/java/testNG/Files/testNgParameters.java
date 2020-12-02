package testNG.Files;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class testNgParameters {
    @Test
    @Parameters({"id","name"})
    public void getId(int id,String name){
        System.out.println("Getting names and values from .xml file: " + id + " " + name);
    }
}


