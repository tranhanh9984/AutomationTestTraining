package autotest.testcase.pageHD;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pagesHD.HomePage;
import autotest.pagesHD.LoginPage;

public class LoginTestcase extends CommonPage{

	public LoginTestcase() {
		// TODO Auto-generated constructor stub
	}

	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void loginsuccess() {
		loginPage.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
		pause(1);
		String text = homePage.getTitle();
		Assert.assertEquals(text, KeywordConstant.usernameHD);
		pause(1);

	}
	
	@Test
	public void loginWrongpass() {
		loginPage.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD+"1");
		pause(2);
		String text = loginPage.getErrorMsg();
		pause(1);
		Assert.assertEquals(text, "Password incorrect for username "+KeywordConstant.usernameHD);
	}
	
	@Test
	public void loginWrongUser() {
		loginPage.login(KeywordConstant.usernameHD+"1", KeywordConstant.passwordHD);
		pause(2);	
		String text = loginPage.getErrorMsg();
		pause(1);
		Assert.assertEquals(text, "No account found for username "+KeywordConstant.usernameHD+"1");
	}
	
	@BeforeMethod
	public void startBrowser() {
	    driver = this.startBrower(KeywordConstant.urlHD, KeywordConstant.BROWSER);
	    loginPage = new LoginPage(driver);
 	    homePage = new HomePage();
	    homePage.driver = driver;
	}
	
	@AfterMethod
	public void closeBrowser() {
	    this.closeBrowser(driver);
	}
}
