package UtilClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util1 {

	//Explicit waits
	public static WebElement waitTillElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebElement waitTillElementVisible(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static WebElement waitTillElementVisibleLocated(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
	}
	
	public static List<WebElement> waitTillElementVisible1(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	
	public static Object javaScriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("arguments[0].click();", element);
	}
	
	public static Object scroll(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public static Object scrollWithElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static String getScreenshot(WebDriver driver, String testName) throws IOException {
		String path = testName + ".png";
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileHandler.copy(source, dest);
		return path;
	}
}
