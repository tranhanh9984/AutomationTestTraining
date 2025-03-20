package autotest.pages.fclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage {
	//textInut - txt, lable: lbl, combobox - cbb, button - btn
	private String txtUserName = "//input[@placeholder = 'Mã số học sinh']";
	private String txtPassword = "//input[@type = 'password']";
	private String schoolCode = "//input[@placeholder = 'Mã trường học']";
 	
 	public String btnLogin = "//button[@type='submit']";
 	
 	
 	
 	
 	public void clearText(String xpath) {
 		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
 		((JavascriptExecutor) driver).executeScript(
 	            "arguments[0].value = '';", driver.findElement(By.xpath(xpath)));
 	}
 	
 	public void login_enterValue(String userName, String password, String school_code) {
 		this.clearText(txtUserName);
 		this.clearText(txtPassword);
 		this.clearText(schoolCode);
 		driver.findElement(By.xpath(txtUserName)).sendKeys(userName);
 		driver.findElement(By.xpath(txtPassword)).sendKeys(password);
 		driver.findElement(By.xpath(schoolCode)).sendKeys(school_code);
 		pause(2000);
 		driver.findElement(By.xpath(btnLogin)).click();
 	}
 	
 	public void login() {
 		driver.findElement(By.xpath(btnLogin)).click();
 	}
	
}
