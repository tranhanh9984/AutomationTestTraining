package autotest.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autotest.pages.LoginPage;

public class LoginTestcases extends CommonPage{
	//WebDriver dr	;
	LoginTestcases(){
		System.out.print("Tiếp theo");
	}
	LoginPage loginPage;// = new LoginPage(driver);;

	@Test
	public void login1() {
		
		//loginPage.login_at();
	}
	
	
//	@Test
	public void loginFail() {
		//fail email sia
		//loginPage = new LoginPage(driver);
		//gọi ham dang nhap tu class Login Pas
//		??loginPage.login("hanhtm", "1234", "33333");
		//get messasge lỗi
		//assert expected ...
	}
		@Test
	public void loginFail1() {
		//fail email sia
		//gọi ham dang nhap tu class Login Pas
		loginPage = new LoginPage(driver);
		loginPage.login("hanhtm", "1234", "4444");
		assert 1 == 2;
		//get messasge lỗi
		//assert expected ...
	}
	

	@BeforeTest
	public void startPage() {
		driver = this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
		loginPage = new LoginPage(driver);
		System.out.print("Khoi tao");
	}

	@AfterTest
	public void closePage() throws InterruptedException {
//			Thread.sleep(2);
		this.closeBrowser(driver);
	}


}
