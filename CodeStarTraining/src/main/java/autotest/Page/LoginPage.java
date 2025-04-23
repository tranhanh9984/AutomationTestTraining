package autotest.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage  {
	public LoginPage(){
		
	}
	@FindBy(xpath = "//input[@id = 'email']") @CacheLookup WebElement txtUserName;
	@FindBy(xpath = "//input[@id = 'password']") @CacheLookup WebElement txtPass;
	@FindBy(xpath = "//button[@type = 'submit']") @CacheLookup WebElement btnLogin;
	@FindBy(xpath = "//div[contains(@class, 'p-toast-detail')]") @CacheLookup WebElement msgError;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String UserName, String Password) {
		txtUserName.clear();
		txtUserName.sendKeys(UserName);
		txtPass.clear();
		txtPass.sendKeys(Password);
		btnLogin.click();
//		driver.findElement(By.xpath(txtUserName)).clear();
//		driver.findElement(By.xpath(txtUserName)).sendKeys(UserName);
//		driver.findElement(By.xpath(txtPass)).clear();
//		driver.findElement(By.xpath(txtPass)).sendKeys(Password);
//		driver.findElement(By.xpath(btnLogin)).click();
	}
	public String getErrorMsg() {
		boolean isDisplayed = msgError.isDisplayed();
		if(isDisplayed) {
			return msgError.getText();
		} 
		return "";
	}

}
