package autotest.testcases.fclass;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.fclass.LoginPage;

public class AnnotationTestcases extends CommonPage{

	public AnnotationTestcases() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void Test() {
		System.out.println("@Test");
	}
	@BeforeMethod
	public void BeforeMethod() {
		System.out.println("@BeforeMethod");
	}
	@AfterMethod
	public void AfterMethod() {
		System.out.println("@AfterMethod");
	}
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("@BeforeSuite");
	}
	@AfterSuite
	public void AfterSuite() {
		System.out.println("@AfterSuite");
	}
	@BeforeClass
	public void BeforeClass() {
		System.out.println("@BeforeClass");
	}
	@AfterClass
	public void AfterClass() {
		System.out.println("@AfterClass");
	}
	@BeforeGroups
	public void BeforeGroups() {
		System.out.println("@BeforeGroups");
	}
	@AfterGroups
	public void AfterGroups() {
		System.out.println("@AfterGroups");
	}
	@BeforeTest
	public void startBrowser() {
		System.out.println("@BeforeTest");
//		driver = this.startBrower(KeywordConstant.urlStu, KeywordConstant.BROWSER);
	//	login = new LoginPage();
	//	login.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("@AfterTest");
		
	}
}
