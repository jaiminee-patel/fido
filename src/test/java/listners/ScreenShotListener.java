package listners;

//import com.ispdatabase.framwork.utils.CaptureType;
//import com.ispdatabase.framwork.utils.Utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.CaptureType;
import utils.Utilities;

public class ScreenShotListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Utilities.captureScreenShot(iTestResult.getName(), CaptureType.PASS);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Utilities.captureScreenShot(iTestResult.getName(), CaptureType.FAIL);

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

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
