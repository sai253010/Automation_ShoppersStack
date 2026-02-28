package ddtPackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreatingNewRowAndData
{
    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream("./src/test/resources/TestingDataFolder/Dummy.xlsx");
            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("NewBook");

            Row newRow = sheet.createRow(21);

            newRow.createCell(0).setCellValue("Sai25");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestingDataFolder/Dummy.xlsx");

            workbook.write(fos);

            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
