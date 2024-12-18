package autotest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class AnnotationTestCase extends CommonPage {

	public AnnotationTestCase() {
		// TODO Auto-generated constructor stub
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("1. Before class");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("2. Before Suite");
	}
	
	@BeforeGroups("beforeGroup")
	public void beforeGroups() {
		System.out.println("3. Before Groups");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("4. Before Method");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("5. Before Test");
	}
	
	@Test(groups="beforeGroup")
	public void tc_1() {
		System.out.println("6. Test");
		Assert.assertEquals(true, true);
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("11. After Test");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("22. After Method");
	}
	
	@AfterGroups("beforeGroup")
	public void afterGroups() {
		System.out.println("33. After Groups");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("44. After Suite");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("55. After class");
	}
	
}
