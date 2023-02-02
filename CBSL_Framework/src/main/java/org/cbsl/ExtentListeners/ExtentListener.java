package org.cbsl.ExtentListeners;

import java.util.Arrays;

import org.cbsl.utility.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ExtentListener implements ITestListener {

	public void onTestStart(ITestResult result) {

		// ExtentTest test=
		// BaseClass.extent.createTest(result.getTestClass().getName()+" @TestCase :
		// "+result.getMethod().getMethodName());
		BaseClass.extentTest.set(BaseClass.test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		BaseClass.extentTest.get().pass(m);

	}

	public void onTestFailure(ITestResult result) {

		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		BaseClass.extentTest.get()
		.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" + excepionMessage.replaceAll(",", "<br>") + "</details>"
				+ " \n");

		try {

			// ExtentManager.captureScreenshot();
			// BaseClass.extentTest.get().fail("<b>" + "<font color=" + "red>" + "Screenshot
			// of failure" + "</font>" +
			// "</b>",MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
			// .build());
			BaseClass.extentTest.get().log(Status.FAIL, "Fail");
		} catch (Exception e) {

		}

		String failureLogg = "TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		BaseClass.extentTest.get().log(Status.FAIL, m);

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		BaseClass.extentTest.get().skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		if (BaseClass.extent != null) {

			BaseClass.extent.flush();
		}

	}

}
