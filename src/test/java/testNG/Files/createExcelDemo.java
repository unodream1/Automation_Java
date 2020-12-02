package testNG.Files;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class createExcelDemo {
    public static void main(String[]args){
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sample sheet");

        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("1", new Object[] {"Email", "Password", "salary"});
        data.put("2", new Object[] {"dummytest993@gmail.com", "itsutra12#"});

        Set<String> keys = data.keySet();
        int rownum = 0;
        for (String key : keys) {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
                else if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Double)
                    cell.setCellValue((Double)obj);
            }
        }

        try {

            FileOutputStream out =
                    new FileOutputStream(new File("/Users/sabina/Desktop/User.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return ok("file reading is completed")
    }
}
