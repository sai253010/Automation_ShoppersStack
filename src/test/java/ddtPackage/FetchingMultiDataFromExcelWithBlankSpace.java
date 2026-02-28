package ddtPackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class FetchingMultiDataFromExcelWithBlankSpace
{
    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream("./src/test/resources/TestingDataFolder/Dummy.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("New Book");

            int firstRownum = sheet.getFirstRowNum();
            int lastRownum = sheet.getLastRowNum();

            int firstCellnum = sheet.getRow(firstRownum).getFirstCellNum();
            int lastCellnum = sheet.getRow(firstRownum).getLastCellNum();

            for (int r=firstRownum; r<=lastRownum; r++)
            {
                Row newRow = sheet.getRow(r);
                if (newRow == null) continue;

                for (int c=firstCellnum; c<lastCellnum; c++)
                {
                    Cell dataCell = newRow.getCell(c);
                    if (dataCell==null) continue;
                    System.out.print(dataCell.getStringCellValue() + "  ");
                }
                System.out.println();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
