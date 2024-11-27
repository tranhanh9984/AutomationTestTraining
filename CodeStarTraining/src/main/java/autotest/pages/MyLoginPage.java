package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import autocom.common.CommonBase;

public class MyLoginPage extends  CommonBase{

	public String txtUserName = "//input[@id = 'email']";
	public String txtPassword = "//input[@id = 'password']";
	public String btnLogin = "//button[@class = 'btn btn-login']";
	
	
	
	public MyLoginPage() {
		// TODO Auto-generated constructor stub
	}
	
	public void clearText(String xpath) {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].value = '';", driver.findElement(By.xpath(xpath)));
	}
	
	public void login_enterValue(String userName, String password) {
		this.clearText(txtUserName);
		this.clearText(txtPassword);
		driver.findElement(By.xpath(txtUserName)).sendKeys(userName);
		driver.findElement(By.xpath(txtPassword)).sendKeys(password);
		
	}
	
	public void login() {
		driver.findElement(By.xpath(btnLogin)).click();
	}

}
