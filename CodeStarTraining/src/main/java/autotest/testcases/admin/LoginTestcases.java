package autotest.testcases.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.*;

public class LoginTestcases extends CommonPage {

	LoginPageAdmin login;
	AddSchoolPage addSchool;
	AddPackagePage addPackage;


	public LoginTestcases() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void loginadmin() {
//		step của tesstcase
		login.loginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
		addSchool.clickMenu();
		addSchool.addData(AddSchoolPage.school_name, AddSchoolPage.school_support_email,
				AddSchoolPage.school_support_phone, AddSchoolPage.school_tagline, AddSchoolPage.school_address,
				AddSchoolPage.domain, AddSchoolPage.school_code_prefix, AddSchoolPage.admin_first_name,
				AddSchoolPage.admin_last_name, AddSchoolPage.admin_contact, AddSchoolPage.admin_email);
		addSchool.clickCreat();
		pause(10);
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd + "login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
		addSchool = new AddSchoolPage();
		addSchool.driver = driver;
		

	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);

	}

}