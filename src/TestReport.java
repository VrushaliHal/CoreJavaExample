import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestReport implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
         System.out.println("On Test Start ..."+ iTestResult.getName());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On Test Success Event ..."+ iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On Test Failure Event ..."+ iTestResult.getName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On Test Skipped Event..."+ iTestResult.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }
    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
