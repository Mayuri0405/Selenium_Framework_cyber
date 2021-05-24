package Seleniumframework;

import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

public class TestListeners extends BaseClasss implements ITestListener {

	public void onTestStart(ITestResult result) {

		System.out.println(
				"This is on test start method from TestListeners class :" + result.getMethod().getMethodName());
		ExtentAutomationReport.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		System.out.println("This is onTestSuccess method from TestListeners class " + result.getStatus());

		Logger.log(LogStatus.PASS, result.getMethod().getMethodName());

	}

	public void onTestFailure(ITestResult result) {

		logger.log(LogStatus.FAIL,
				result.getMethod().getMethodName() + "****Exception is**** : " + result.getThrowable());

		System.out
				.println("This is onTestFailure method from TestListeners class" + result.getMethod().getMethodName());

		ConfigProperties config = new ConfigProperties();

		try {

			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;

			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(file, new File(
					config.getProperty("ScreenShotFilePath") + "/" + result.getMethod().getMethodName() + ".png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

		logger.log(LogStatus.SKIP, result.getMethod().getMethodName());

		System.out.println("This is onTestSkipped method from TestListeners class");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		System.out.println("This is  onTestFailedButWithinSuccessPercentage method");

		logger.log(LogStatus.PASS,
				"This is  onTestFailedButWithinSuccessPercentage method " + result.getMethod().getMethodName());

	}

	public void onStart(ITestContext context) {

		System.out.println("This is onStart method from TestListeners class");

		ExtentAutomationReport.getExtentReport();

	}

	public void onFinish(ITestContext context) {

		System.out.println("This is onFinish method from TestListeners class");

		extentReports.flush();

	}

}
