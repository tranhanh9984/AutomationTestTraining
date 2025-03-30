package autotest.testcasesHD;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pagesHD.HomePage;
import autotest.pagesHD.LoginPage;

public class LoginTestcases extends CommonPage{

	public LoginTestcases() {
		// TODO Auto-generated constructor stub
	}

	LoginPage loginPage;
	HomePage homePage;
	
	@Test
	public void loginsuccess() {
		loginPage.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
		pause(2);
		String text = homePage.getTitle();
		Assert.assertEquals(text, KeywordConstant.usernameHD);
	}
	
	@Test
	public void loginWrongpass() {
		loginPage.login(KeywordConstant.usernameHD, "123456789");
		pause(2);
		String text = loginPage.getErrorMsg();
		Assert.assertEquals(text, "Password incorrect for username "+KeywordConstant.usernameHD);
	}
	
	@Test
	public void loginWrongUser() {
		loginPage.login(KeywordConstant.usernameHD, "123456789");
		pause(2);
		String text = loginPage.getErrorMsg();
		Assert.assertEquals(text, "Password incorrect for username "+KeywordConstant.usernameHD);
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlHD, KeywordConstant.BROWSER);
		loginPage = new LoginPage();
		loginPage.driver = driver;
		homePage = new HomePage();
		homePage.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}
}
