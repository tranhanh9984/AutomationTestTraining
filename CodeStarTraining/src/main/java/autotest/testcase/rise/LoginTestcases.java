package autotest.testcase.rise;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.rise.LoginPage;

public class LoginTestcases extends CommonPage {

	LoginPage login;

	private HashMap<String, String> inforLogin = new HashMap<>();
	
	public void initDataForTest() {
		inforLogin.put("email", "admin@demo.com");
		inforLogin.put("password", "riseDemo");
	}
	
	@Test
    public void testLogin() {
		login.addCookies();
		login.clearAll();
		login.Login(inforLogin.get("email"), inforLogin.get("password"));	
    }

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		login = new LoginPage(driver);
		initDataForTest();
	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
	}
}
