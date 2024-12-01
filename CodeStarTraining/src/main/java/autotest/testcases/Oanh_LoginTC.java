package autotest.testcases;

import org.testng.annotations.*;

import autocom.common.CommonBase;
import autotest.pages.Oanh_B9_LoginPage;

public class Oanh_LoginTC extends CommonBase {

	public Oanh_LoginTC() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void startPage() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
	}
	
	@Test
	public void loginTC() {
		Oanh_B9_LoginPage login = new Oanh_B9_LoginPage(driver);
		login.notFound();
		System.out.println("TC1: Passed");
		login.wrongPw();
		System.out.println("TC2: Passed");
		login.successLogin();
		System.out.println("TC2: Passed");
	}
	
	@AfterClass
	public void closePage() {
		this.closeBrowser();
	}

}
