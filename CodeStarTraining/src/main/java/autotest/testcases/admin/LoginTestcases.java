package autotest.testcases.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.LoginPageAdmin;
import autotest.pages.admin.Homepage;

public class LoginTestcases extends CommonPage{

	
	LoginPageAdmin login;
	WebDriver driver; 
    Homepage homepage;
	public LoginTestcases() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void loginadmin() {
		login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
		homepage.clickMenu();
		homepage.click_tao();
		pause(10);
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd+"login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
		homepage = new Homepage();
		homepage.driver = driver;

		
	}
 


}
	 
 
