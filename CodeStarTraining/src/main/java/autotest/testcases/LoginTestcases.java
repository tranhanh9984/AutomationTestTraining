//package autotest.testcases;
//
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import autocom.common.CommonPage;
//import autocom.constant.KeywordConstant;
//import autotest.pages.LoginPage;
//
//public class LoginTestcases extends CommonPage{
//
//	public LoginTestcases() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	LoginPage login;
//	
//	
//	public void init() {
//		
//	}
//	
//	@Test
//	public void test() {
//		System.out.println("hello");
//		pause(10);
//	}
//
//	
//	@BeforeTest
//	public void startBrowser() {
//		driver = this.startBrower(KeywordConstant.urlRise, "chrome");		
//		
//	}
//	
//	@AfterTest
//	public void closeBrowser() {
//		this.closeBrowser(driver);
//		login = new LoginPage();
//		init();
//	}
//	
//}
