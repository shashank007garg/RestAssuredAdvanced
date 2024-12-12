package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class SetUp implements ITestListener {

    public static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context) {

        String fileName = ExtentReportUtil.getReportNameWithTimeStamp();
        String fullReportPath = System.getProperty("user.dir") + "\\reports\\" + fileName;
        extentReports = ExtentReportUtil.createInstance(fullReportPath, "Test API Automation Report", "Execution Report");
    }

    public void onFinish(ITestContext context) {
        if (extentReports != null)
            extentReports.flush();

    }

    public void onTestStart(ITestResult result) {
        ExtentTest test=extentReports.createTest("Test Name "+ " -- " + result.getTestClass().getName()
                + " -- " + result.getMethod().getMethodName());
            extentTest.set(test);
    }

    public void onTestFailure(ITestResult result) {
        ExtentReportUtil.logFailDetails(result.getThrowable().getMessage());
        String stackTrace=Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace=stackTrace.replaceAll(",","<br>");
        String formattedTrace="\n" +
                "<details>\n" +
                "  <summary>Click Here To see More Details</summary>\n" +
                "  "+stackTrace+"\n" +
                "</details>\n";
        ExtentReportUtil.logExceptionDetails( formattedTrace);
    }
}
