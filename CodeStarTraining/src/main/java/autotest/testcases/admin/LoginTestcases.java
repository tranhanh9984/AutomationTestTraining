package autotest.testcases.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.*;

public class LoginTestcases extends CommonPage{

	
	LoginPageAdmin login;
	public LoginTestcases() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void loginadmin() {
		//step testcases
		login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
		pause(10);
		//verify nó đã login thành công
		
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd+"login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
	//	this.closeBrowser(driver);
		
	}

}
