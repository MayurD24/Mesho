package TestClass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClass.Base1;
import PomClass.HomePage;

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
	}
	
	@AfterMethod
	public void afterTest() {
		
	}
	
	@AfterClass
	public void afterClass() {
		reports.flush();
		Base1.unloadDriver();
	}
}
