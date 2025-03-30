package autotest.testcases.fclass;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.fclass.HomePage;
import autotest.pages.fclass.LoginPage;

public class LoginTestcases extends CommonPage {
	
	LoginPage login;
	WebDriver driver; 
	HomePage homepage;

	@Test
	public void tcs01() {
		// Kiểm tra login
		login.login_enterValue(KeywordConstant.usernameStu, KeywordConstant.passwordStu, KeywordConstant.schoolStu);
		pause(5);

		// Click vào menu "Bài kiểm tra trực tuyến"
//		homepage.clickMenu("Bài kiểm tra trực tuyến");
		homepage.clickMenu("Bài tập");
		pause(10);		
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlStu, KeywordConstant.BROWSER);
		
		login = new LoginPage();
		login.driver = driver;
		
		homepage = new HomePage();  
		homepage.driver = driver;  
	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
	}
}
