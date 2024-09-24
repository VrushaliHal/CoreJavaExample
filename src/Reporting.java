import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestReport.class})
public class Reporting {


    @Test(priority = 1)
    public void TestPass()
    {
        System.out.println("On Test Passed 1..");
    }
    @Test(priority = 2)
    public void TestPassed()
    {
        System.out.println("On Test Passed 2..");
    }
    @Test(priority = 3)
    public void TestFailure()
    {
        System.out.println("On Test Failed..");
        Assert.assertTrue(false);
    }
    @Test(dependsOnMethods = "TestFailure")
    public void TestSkipped()
    {
        System.out.println("On Test Skipped...");
      //  throw new RuntimeException();
    }
}
