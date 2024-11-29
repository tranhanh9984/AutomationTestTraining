package autotest.pages;


import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage {
	
	public String xpathUserName = "//input[@id='email']";
	public String xpathPassword =  "//input[@id='password']";
	public String xpathSubmit = "//button[@class='btn btn-login']";

	public LoginPage() {
		// TODO Auto-generated constructor stub
	}
	
	public void enterValue(String username, String password) {
		this.setValue(xpathUserName, username);
		this.setValue(xpathPassword, password);
	}
	
	public void login(String username, String password) {
		this.enterValue(username, password);
		driver.findElement(By.xpath(xpathSubmit)).click();
	}
}
