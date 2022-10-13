package TestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.Base1;
import PomClass.HomePage;
import UtilClass.Util1;

public class verifyUserCanSearchProduct {

	WebDriver driver;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports reports;
	ExtentTest extentTest;
	
	HomePage hp;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser){
		htmlReporter = Base1.getExtentHtmlReporter();
		reports = Base1.getReports();
		extentTest = Base1.getExtentTest("verifyUserCanSearchProduct");
		
		driver = Base1.getDriver(browser);
	}
	
	@BeforeMethod
	public void beforeTest() {
		hp = new HomePage(driver);
	}
	
	@Test
	public void verifyUserCanSearchProducts() {
		hp.searchProduct();
		hp = new HomePage(driver);
		String ActualText = hp.getFilterText();
		Assert.assertEquals(ActualText, "Category");
	}
	
	@AfterMethod
	public void afterTest(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE) {
			String path = Util1.getScreenshot(driver, result.getName());
			extentTest.log(Status.FAIL, result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
	}
	
	@AfterClass
	public void afterClass() {
		reports.flush();
		Base1.unloadDriver();
	}
}
