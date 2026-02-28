package ddtPackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CreatingNewSheet
{
    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream("./src/test/resources/TestingDataFolder/Dummy.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);
            Sheet newBookSheet =  workbook.createSheet("NewBookSheet");

            Row newRow = newBookSheet.createRow(0);
            Cell newCell =newRow.createCell(0);
            newCell.setCellValue("NEwData");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestingDataFolder/Dummy.xlsx");

            workbook.write(fos);

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
