

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ExcelReadData {

    public static void main(String[] args) throws IOException {
       File file = new File("C:\\Users\\govin\\OneDrive\\Desktop\\Vrushali Haldankar\\Data\\TestData.xlsx");
       FileInputStream fs = new FileInputStream(file);
       XSSFWorkbook workbook = new XSSFWorkbook(fs);
       XSSFSheet sheet = workbook.getSheet("Data");
       int rowCount =sheet.getPhysicalNumberOfRows();
       for(int i=0;i<rowCount;i++)
       {
           XSSFRow row = sheet.getRow(i);
           int colsCount =row.getPhysicalNumberOfCells();
           for(int j=0;j< colsCount;j++)
           {
               XSSFCell cell = row.getCell(j);
               String cellValue = getCellType(cell);
               System.out.print("|"+cellValue);
           }
           System.out.println();
       }
       workbook.close();
       fs.close();
    }

    private static String getCellType(XSSFCell cell) {
        switch (cell.getCellType())
        {
            case NUMERIC :
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case STRING:
                return String.valueOf(cell.getStringCellValue());
            default:
                return cell.getStringCellValue();
        }
    }
}

