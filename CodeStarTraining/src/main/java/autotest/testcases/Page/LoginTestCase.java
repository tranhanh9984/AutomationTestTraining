package autotest.testcases.Page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.Page.HomePage;
import autotest.Page.LoginPage;


public class LoginTestCase extends CommonPage {
	LoginPage login;
	WebDriver driver;
	HomePage homePage;
	 String wrongUserName = "aha";
    
	 @Test(priority = 3)
	    public void loginSuccess() {
	    login.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
		String text = homePage.getText();
		Assert.assertEquals(text, KeywordConstant.usernameHD);
	    }
    
    @Test(priority = 1)
	
	public void loginWrongUserName() {
		login.login(wrongUserName, KeywordConstant.passwordHD);
		String text = login.getErrorMsg();
		Assert.assertEquals(text, "No account found for username "+wrongUserName);
		pause(3);
	}
    
    @Test(priority = 2)
    public void loginWrongPassword() {
    	login.login(KeywordConstant.usernameHD, "123");
    	String text = login.getErrorMsg();
    	Assert.assertEquals(text, "Password incorrect for username "+KeywordConstant.usernameHD);
    }
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.hoaDonUrl, KeywordConstant.BROWSER);
		
		login = new LoginPage(driver);
//		login.driver = driver;
		homePage = new HomePage();
		homePage.driver= driver;
		
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}
	

}
