package testNG.Files;

import org.junit.Test;

public class excelReadTest {
    Xls_Reader reader;

    @Test
    public void readDataForFirstName(){
        try{
            reader = new Xls_Reader("testNG/Files/Xls_Reader.java");
        }
        catch(Exception e){
            e.printStackTrace();
        }

        for(int rowNum = 2; rowNum <= reader.getRowCount("Employee"); rowNum++){
            String email = reader.getCellData("Employee","email",rowNum);
            String password = reader.getCellData("Employee","email",rowNum);
            System.out.println("email: " + email + "password: " + password);
        }
    }
}
