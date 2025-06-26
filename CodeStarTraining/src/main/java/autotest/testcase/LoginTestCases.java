package autotest.testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.login.LoginPage;

public class LoginTestCases extends CommonPage {

	LoginPage loginPage;
	
	@Test
	public void LoginTestCases() {
		loginPage.login("admin@demo.com", "riseDemo");
	}
	
	public void init() {
		
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
	}
	
}
