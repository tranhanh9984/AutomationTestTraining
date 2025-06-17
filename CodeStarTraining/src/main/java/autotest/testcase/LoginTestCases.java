package autotest.testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.login.LoginPage;

public class LoginTestCases extends CommonPage {

	LoginPage loginPage;
	public LoginTestCases() {
		// TODO Auto-generated constructor stub
	}
	
	public void init() {
		
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
		
	}
	
}
