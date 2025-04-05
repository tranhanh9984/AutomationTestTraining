package autotest.pages.invoice;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class loginPage extends CommonPage{

	String txtUserName = "//input[@id = 'email']";
 	String txtPassword = "//input[@id = 'password']";
 	String btnLogin = "//button[@type = 'submit']";	
			

 	String msgError = "//div[contains(@class, 'p-toast-detail')]";
 	public void login(String username, String password) {	
 		driver.findElement(By.xpath(txtUserName)).clear();
 		driver.findElement(By.xpath(txtUserName)).sendKeys(username);
 		driver.findElement(By.xpath(txtPassword)).clear();
 		driver.findElement(By.xpath(txtPassword)).sendKeys(password);
 		driver.findElement(By.xpath(btnLogin)).click();
 	}
 	

 	public String getErrorMsg() {
 		boolean isDisplayed = driver.findElement(By.xpath(msgError)).isDisplayed();
 		if(isDisplayed) {
 			return driver.findElement(By.xpath(msgError)).getText();
 		} 
 		return "";
 	}
 	
 
 }