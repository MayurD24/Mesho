package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import BaseClass.Base1;
import UtilClass.Util1;

public class Listener implements ITestListener {

	WebDriver driver;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		extentTest = Base1.getAlreadyExistingTest();

		extentTest.log(Status.INFO, "Test : Started " + result.getName());
		System.out.println("Test Started " + result.getName());
//		Reporter.log("Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Passed : " + result.getName());
		System.out.println("Test Passed " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		String path = null;
		try {
			path = Util1.getScreenshot(driver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			extentTest.log(Status.FAIL, "Test Failed: " + result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Test Failed " + result.getName());

	}

	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test Skipped: " + result.getName());
		System.out.println("Test Skipped " + result.getName());
	}
}
