package autotest.testcases.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.GoiPage;
import autotest.pages.admin.LoginPageAdmin;
import autotest.pages.admin.TruonghocPage;

public class TaomoigoiTestcases extends CommonPage{

	
	LoginPageAdmin login;
	GoiPage goipage;
	public TaomoigoiTestcases() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void loginadmin() {
		login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
		goipage.clickGoi();
		goipage.clicktaomoigoi();
		goipage.dienthongtingoi();
		goipage.clickGui();
		pause(10);
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd+"login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
		goipage = new GoiPage();
		goipage.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}

}
