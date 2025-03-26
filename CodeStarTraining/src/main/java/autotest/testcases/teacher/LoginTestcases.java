package autotest.testcases.teacher;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.teacher.LoginPageTeacher;
import autocom.common.CommonPage;

public class LoginTestcases extends CommonPage {

	LoginPageTeacher login;
	public LoginTestcases() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void loginteacher() {
		login.LoginPage(KeywordConstant.usernameTea, KeywordConstant.passwordTea);
		login.clickLogin();
		pause(10);
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlTea, KeywordConstant.BROWSER);
		login = new LoginPageTeacher();
		login.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}
	

}
