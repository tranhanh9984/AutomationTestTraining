package autotest.testcases.fclass;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.fclass.LoginPage;

public class AnnotationTestcases extends CommonPage{

	public AnnotationTestcases() {
		// TODO Auto-generated constructor stub
	}

	
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlStu, KeywordConstant.BROWSER);
	//	login = new LoginPage();
	//	login.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}
}
