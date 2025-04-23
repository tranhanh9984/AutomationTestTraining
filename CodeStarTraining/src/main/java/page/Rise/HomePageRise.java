package page.Rise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class HomePageRise extends CommonPage {
	
	public HomePageRise(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//span[@class = 'user-name ml10']") @CacheLookup WebElement txtGetUserName;
	public String getUserName() {
		return txtGetUserName.getText();
	}
	
	@FindBy (xpath = "//span[text() = 'Projects']//parent::a") @CacheLookup WebElement txtClickProject;
	public void clickProject() {
		txtClickProject.click();
	}
	
	@FindBy (xpath = "//span[text() = 'Clients']//parent::a") @CacheLookup WebElement txtClickClient;
	public void clickClient() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", txtClickClient);
	}

}
