package PomClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClass.Util1;

public class HomePage extends Util1 {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement searchBox;
	
	@FindBy(xpath = "//div[@class='sc-dkPtyc ProductList__GridCol-sc-8lnc8o-0 dqIYJu ilkWHh']")
	private WebElement firstProduct;
	
	@FindBy(xpath = "//h1[@class='ProductListingContent__HeadLine1-e96brm-0 bCPTzp']")
	private WebElement searchHeader;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public void searchProduct() {
		waitTillElementVisible(driver,searchBox);
		searchBox.sendKeys("mens shoes");
		searchBox.sendKeys(Keys.ENTER);
	}
	
	public String getFilterText() {
		waitTillElementVisible(driver,firstProduct);
		return searchHeader.getText();
	}
	
}
