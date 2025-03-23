package autotest.testcases.teacher;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.teacher.*;

public class LoginTestcases extends CommonPage {

	public LoginTestcases() {
		// TODO Auto-generated constructor stub
	}
	LoginPage login;
	
	@Test
	public void loginadmin() {
		login.LoginPage(KeywordConstant.usernameTea, KeywordConstant.passwordTea);
		login.clickLogin();
		pause(10);
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlTea, KeywordConstant.BROWSER);
		login = new LoginPage();
		login.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}
}
