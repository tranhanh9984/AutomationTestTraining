package autotest.testcases.GiaoVien;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.AdminPage.LoginPageGiaoVien;

public class LoginTestCases extends CommonPage {
	LoginPageGiaoVien login;
	HomePage homepage;
	public LoginTestCases() {
		
	}
	@Test
	public void LoginGiaoVien() {
		login.LoginPage(KeywordConstant.usernameTea, KeywordConstant.passwordTea);
		login.clickLogin();
		homepage.clickMenu();
		pause(10);
	}
	@BeforeTest
	public void StartBrower() {
		driver = this.startBrower(KeywordConstant.urlTea+"login", KeywordConstant.BROWSER);
		login = new LoginPageGiaoVien();
		login.driver = driver;
		homepage = new HomePage();
		homepage.driver = driver;
	}
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
	}

}
