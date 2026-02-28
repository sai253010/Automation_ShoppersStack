package ddtPackage;


import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UpdateExistingCellData
{
    public static void main(String[] args) {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestingDataFolder/Dummy.xlsx");

             Workbook workbook = WorkbookFactory.create(fis);
             Sheet sheet = workbook.getSheet("Books");

             Row row = sheet.getRow(4);
             Cell cell = row.getCell(0);

             cell.setCellValue("Cucumber");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestingDataFolder/Dummy.xlsx");

            workbook.write(fos);

            workbook.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
