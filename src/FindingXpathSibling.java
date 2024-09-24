import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


public class FindingXpathSibling {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co  =new ChromeOptions();
        co.setBinary("C:\\Program Files\\chrome-win64\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(co);


        /*
        driver.get("https://classic.crmpro.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("groupautomation");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(5000);
        driver.switchTo().frame("mainpanel");
        driver.findElement(By.xpath("//a[@title='Contacts']")).click();
        Thread.sleep(8000);
        */

/*        System.out.println("XPATH sibling : -------------child------------------");
          String a = driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[2]/td[1]/div[1]/child::a[1]")).getText();
          System.out.println(a);
*/

/*        System.out.println("XPATH sibling : -------------following-sibling and child------------");
       String b = driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[7]/td[1]/following-sibling::td/child::a[1]")).getText();
          System.out.println(b);
*/
/*
        System.out.println("XPATH sibling : -------------preceding-sibling  and child ------------");
        String b = driver.findElement(By.xpath("//*[@id='vContactsForm']/table/tbody/tr[8]/td[3]/preceding-sibling::td/child::a[1]")).getText();
        System.out.println(b);
        Thread.sleep(2000);
        driver.close();
*/
        /*
        System.out.println("XPATH sibling : -------------preceding-sibling |child | following-sibling------------");
        String typeValue=  driver.findElement(By.xpath("//*[@id='extendedSearchLayer']/table/tbody/tr[2]/td[1]/table/tbody/tr[5]/preceding-sibling::tr[1]/child::td/following-sibling::td/child::input[1]")).getAttribute("type");
        System.out.println(typeValue);
        Thread.sleep(2000);
        driver.close();
         */

        System.out.println("XPATH sibling : -------------preceding-sibling |child |");
        driver.get("https://www.w3schools.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        boolean Element = driver.findElement(By.xpath("//*[@id='main']/div[1]/child::div/h3/preceding-sibling::h1")).getText().equals("Learn to Code");
        System.out.println(Element);
        Thread.sleep(2000);
        driver.close();

    }
}
