
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConceptDataProvider {
     WebDriver driver;

     @BeforeMethod
     public void Start(){
         driver = new ChromeDriver();
         driver.get("https://www.qtpselenium.com/login");
     }
    @Test(dataProvider = "LoginDataProvider")
    public void TestLoginData(String username,String Password) throws InterruptedException {

        driver.findElement(By.xpath("//*[@id='eMailAddress']")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id='userPassword']")).sendKeys(Password);
        driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[2]/div/form/button")).submit();
        Thread.sleep(2000);
    }

    @DataProvider(name="LoginDataProvider")
    public Object[][] getTestData(){

         Object [][] LoginData = new Object[2][2];
         LoginData[0][0] = "vrushisa36.13@gmail.com";
        LoginData[0][1] = "Vrush123";
        LoginData[1][0] = "vrush.haldankar@gmail.com";
        LoginData[1][1] = "SDet12";
        return LoginData;
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();

    }
}
