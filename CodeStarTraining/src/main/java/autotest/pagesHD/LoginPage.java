package autotest.pagesHD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage {

	public LoginPage() {
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath = "//input[@id = 'email']") @CacheLookup WebElement txtUserName;
	@FindBy(id = "password")  @CacheLookup WebElement txtPassword;
	@FindBy(xpath = "//button[@type = 'submit']")  @CacheLookup WebElement btnLogin;
//	String txtPassword = "//input[@id = 'password']";
//	String btnLogin = "//button[@type = 'submit']";		
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	String msgError = "//div[contains(@class, 'p-toast-detail')]";
	
	public void login(String username, String password) {	
		txtUserName.clear();
		txtUserName.sendKeys(username);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		btnLogin.click();
//		driver.findElement(By.xpath(txtUserName)).clear();
//		driver.findElement(By.xpath(txtUserName)).sendKeys(username);
//		driver.findElement(By.xpath(txtPassword)).clear();
//		driver.findElement(By.xpath(txtPassword)).sendKeys(password);
//		driver.findElement(By.xpath(btnLogin)).click();
		
	}
	
	
	//type = 1: pass sai; type = 2: username
	public String getErrorMsg() {
		boolean isDisplayed = driver.findElement(By.xpath(msgError)).isDisplayed();
		if(isDisplayed) {
			return driver.findElement(By.xpath(msgError)).getText();
		} 
		return "";
	}
	
}
