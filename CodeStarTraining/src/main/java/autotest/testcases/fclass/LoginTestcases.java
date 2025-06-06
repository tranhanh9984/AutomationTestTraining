//package autotest.testcases.fclass;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import autocom.common.CommonPage;
//import autocom.constant.KeywordConstant;
//import autotest.pages.fclass.*;
//
//public class LoginTestcases extends CommonPage {
//	
//	WebDriver driver; 
//	LoginPage login;
//	HomePage homepage;
//	
//	@Test
//	public void tcs01() {
//		//kiem tra logiin thanh cong
//		login.login_enterValue(KeywordConstant.usernameStu,KeywordConstant.passwordStu, KeywordConstant.schoolStu);
//	//	homepage.driver = driver;
//		homepage.clickMenu();
//		pause(10);		
//	}
//	
//	
//	@BeforeTest
//	public void startBrowser() {
//		driver = this.startBrower(KeywordConstant.urlStu, KeywordConstant.BROWSER);
//		login = new LoginPage();
//		login.driver = driver;
//		homepage = new HomePage();
//		homepage.driver = driver;
//		
//	}
//	
//	@AfterTest
//	public void closeBrowser() {
//		this.closeBrowser(driver);
//		
//	}
//}
