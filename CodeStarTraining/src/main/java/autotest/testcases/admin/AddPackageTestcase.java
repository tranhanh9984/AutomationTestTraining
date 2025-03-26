package autotest.testcases.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.*;

public class AddPackageTestcase extends CommonPage {

	LoginPageAdmin login;
	AddPackagePage addPackage;




	@Test
	public void loginadmin() {
		login.loginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
		addPackage.clickMenu();
		addPackage.clickButton();
		addPackage.addData(AddPackagePage.name, AddPackagePage.description, AddPackagePage.tagline,AddPackagePage.charges,
			 AddPackagePage.days,
				AddPackagePage.no_of_staffs,AddPackagePage.no_of_students);
		addPackage.clickCreat();
		pause(10);
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd + "login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
		addPackage = new AddPackagePage();
		addPackage.driver = driver;

	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);

	}

}