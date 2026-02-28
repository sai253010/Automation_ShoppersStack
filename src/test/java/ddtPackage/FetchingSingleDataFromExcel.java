package ddtPackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class FetchingSingleDataFromExcel
{
    public static void main(String[] args) {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestingDataFolder/Dummy.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("Books");

            Row row = sheet.getRow(2);

            Cell cell = row.getCell(1);

            System.out.println(cell.getStringCellValue());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
