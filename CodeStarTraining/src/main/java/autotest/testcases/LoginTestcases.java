package autotest.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autotest.pages.LoginPage;

public class LoginTestcases extends CommonPage {
	
	LoginPage login;
	WebDriver driver; 
	@Test
	public void tcs01() {
		//kiem tra logiin thanh cong
		login.login_enterValue("20240101", "01082020", "SCH20241");
		pause(1000000);		
	}

	
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://student.f-class.site/auth/login", "chrome");
		login = new LoginPage();
		login.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}
}
