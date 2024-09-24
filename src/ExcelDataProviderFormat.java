import org.apache.poi.ss.usermodel.DataFormatter;
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

import javax.security.auth.login.LoginContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ExcelDataProviderFormat {

    static WebDriver driver;
    @BeforeMethod
    public void openBrowser() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://www.qtpselenium.com/login");
        Thread.sleep(2000);
    }

    @Test(dataProvider = "LoginData")
    public void TestLoginData(String username,String Password) throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='eMailAddress']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='userPassword']")).sendKeys(Password);
        driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div/form/button")).submit();
        Thread.sleep(2000);
    }

    @DataProvider(name= "LoginData")
    public Object[][] ExcelReadData() throws IOException {

        File file = new File("C://Users//govin//OneDrive//Desktop//Vrushali Haldankar//Data//TestData.xlsx");
        FileInputStream fs = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("LoginData");
        int rowsCount = sheet.getPhysicalNumberOfRows();
        int colsCount = sheet.getRow(0).getLastCellNum();
        Object[][] LoginData =new Object[rowsCount-1][colsCount];

        for (int i = 0; i < rowsCount-1; i++) {
            for (int j = 0; j < colsCount; j++) {
                DataFormatter df = new DataFormatter();
                LoginData[i][j] =df.formatCellValue(sheet.getRow(i+1).getCell(j));
                System.out.print(LoginData[i][j]);
            }
            System.out.println();
        }
        workbook.close();
        fs.close();
        return LoginData;
    }


    @AfterMethod
public void tearDown()
{
    driver.quit();

}

}
