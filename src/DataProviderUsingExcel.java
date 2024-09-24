
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;


public class DataProviderUsingExcel {

    static WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.get("https://www.qtpselenium.com/login");
    }

    @Test(dataProvider = "getTestData",dataProviderClass = DataProviderUsingExcel.class)
    public void TestLoginData(String username,String Password) throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='eMailAddress']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='userPassword']")).sendKeys(Password);
        driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div/form/button")).submit();
        Thread.sleep(2000);
    }

    @DataProvider(name="getTestData")
    public Object[][] getTestData() throws IOException {
       File file = new File("C:\\Users\\govin\\OneDrive\\Desktop\\Vrushali Haldankar\\Data\\TestData.xlsx");
       FileInputStream fs = new FileInputStream(file);
       XSSFWorkbook workbook = new XSSFWorkbook(fs);
       XSSFSheet sheet = workbook.getSheet("LoginData");
       int rowCount = sheet.getPhysicalNumberOfRows();
       int colsCount = sheet.getRow(0).getLastCellNum();
       Object[][] LoginData = new Object[rowCount-1][colsCount];
       for(int i=0 ;i <rowCount-1;i++)
       {
           XSSFRow row = sheet.getRow(i+1);
           for(int j=0;j<colsCount;j++)
           {
               XSSFCell cell = row.getCell(j);
               Object cellvalue = getCellType(cell);
               LoginData[i][j]=cellvalue;
               System.out.print("|"+cellvalue);
           }
           System.out.println();
       }
       return LoginData;
    }

    private static Object getCellType(XSSFCell cell) {
        return switch (cell.getCellType()) {
            case NUMERIC -> (cell.getNumericCellValue());
            case BOOLEAN -> (cell.getBooleanCellValue());
            default -> cell.getStringCellValue();
        };
    }


@AfterMethod
    public void tearDown()
    {
        driver.quit();

    }
}
