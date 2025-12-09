package autotest.testcasesHD;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pagesHD.HomePage;
import autotest.pagesHD.LoginPage;

public class LoginTestcases extends CommonPage{

	
	WebDriver dr;
	LoginPage loginPage;
	HomePage homePage;
	String url = "https://meet.google.com/wvo-wnov-ncn";
	
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
		loginPage.login(KeywordConstant.usernameHD+'1', KeywordConstant.passwordHD);
		pause(2);
		String text = loginPage.getErrorMsg();
		Assert.assertEquals(text, "No account found for username "+KeywordConstant.usernameHD+'1');
	}
	
	@BeforeTest
	@Parameters("browser")
	public void startBrowser(@Optional("chrome")String browser) {
		driver = this.startBrower(KeywordConstant.urlHD, browser);
		loginPage = new LoginPage(driver);
		//loginPage.driver = driver;
		homePage = new HomePage();
		homePage.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}
}
