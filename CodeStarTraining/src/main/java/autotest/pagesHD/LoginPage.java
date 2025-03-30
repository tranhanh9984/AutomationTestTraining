package autotest.pagesHD;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage {

	public LoginPage() {
		// TODO Auto-generated constructor stub
	}
	
	String txtUserName = "//input[@id = 'email']";
	String txtPassword = "//input[@id = 'password']";
	String btnLogin = "//button[@type = 'submit']";		
	
	
	String msgError = "//div[contains(@class, 'p-toast-detail')]";
	public void login(String username, String password) {		
		driver.findElement(By.xpath(txtUserName)).sendKeys(username);
		driver.findElement(By.xpath(txtPassword)).sendKeys(password);
		driver.findElement(By.xpath(btnLogin)).click();
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
