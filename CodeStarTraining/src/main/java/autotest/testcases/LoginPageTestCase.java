package autotest.testcases;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.LoginPage;

public class LoginPageTestCase extends CommonPage {
	
	LoginPage loginPage;
	
	public LoginPageTestCase() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void init() {
		this.startBrowser(KeywordConstant.LOGIN_URL);
		loginPage = new LoginPage(driver);
	}
	
	@AfterClass
	public void close() {
		this.closeBrowser();
	}
	
	@Test
	public void tc_1() {
		loginPage.login();
		System.out.print("Test");
	}
	
//	@Test(priority = 1)
//	public void tc1_CompareEnteredValue() {
//		this.enterValue(this.userName, this.password);
//		
//		String username = this.getValue(this.xpathUserName);
//		String password = this.getValue(this.xpathPassword);
//		
//		Assert.assertEquals(username, this.userName);
//		Assert.assertEquals(password, this.password);
//	}
//	
//	@Test(priority = 2)
//	public void tc2_LoginFail_WrongUserName() {
//		this.login("fakeUserName", "fakePassword");
//		boolean isDisplayed = driver.findElement(By.xpath("//div[contains(text(),'No account found for username')]")).isDisplayed();
//		Assert.assertEquals(isDisplayed, true);
//	}
//	
//	@Test(priority = 3)
//	public void tc3_LoginFail_WrongPassword() {
//		this.login(this.userName, "fakePassword");
//		boolean isDisplayed = driver.findElement(By.xpath("//div[contains(text(),'Password incorrect for username')]")).isDisplayed();
//		Assert.assertEquals(isDisplayed, true);
//	}
//
//	@Test(priority = 4)
//	public void tc4_LoginSuccessfull() {
//		this.login(this.userName, this.password);
//		String currentURL = driver.getCurrentUrl();
//		Assert.assertEquals(KeywordConstant.LOGIN_URL != currentURL, true);
//	}
	
}
