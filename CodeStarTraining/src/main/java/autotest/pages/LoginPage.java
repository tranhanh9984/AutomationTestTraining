package autotest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class LoginPage extends CommonPage {
	
	@FindBy(xpath = "//input[@id='email']") WebElement txtUserName;
	@FindBy(xpath = "//input[@id='password']") WebElement txtPassword;
	@FindBy(xpath = "//button[@class='btn btn-login']") WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login() {
		txtUserName.sendKeys(KeywordConstant.USER_NAME);
		txtPassword.sendKeys(KeywordConstant.PASS_WORD);
		btnLogin.click();
	}
}
