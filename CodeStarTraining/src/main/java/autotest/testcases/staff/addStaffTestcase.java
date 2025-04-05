package autotest.testcases.staff;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.LoginPageAdmin;
import autotest.pages.staff.addStaffPage;

public class addStaffTestcase extends CommonPage {

	LoginPageAdmin login;
	addStaffPage addstaff;

	public addStaffTestcase() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void loginadmin() {
		login.loginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
		addstaff.clickMenu();
		pause(1);
//		addstaff.addData(addStaffPage.schoolSelectValues);
		addstaff.addData(addStaffPage.first_name, addStaffPage.last_name, addStaffPage.mobile, addStaffPage.email,
				addStaffPage.dob, addStaffPage.schoolSelectValues);
		addstaff.clickCreat();
		pause(1);
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd + "login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
		addstaff = new addStaffPage();
		addstaff.driver = driver;

	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);

	}

}
