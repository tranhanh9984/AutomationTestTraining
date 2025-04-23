package autotest.testcases.fclass;
import org.testng.annotations.*;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.fclass.LoginPage;

public class AnnotationTestcases extends CommonPage{

	public AnnotationTestcases() {
		// TODO Auto-generated constructor stub
	}

	
	
//	@BeforeTest
//	public void startBrowser() {
//		driver = this.startBrower(KeywordConstant.urlStu, KeywordConstant.BROWSER);
//	//	login = new LoginPage();
//	//	login.driver = driver;
//	}
//	
//	@AfterTest
//	public void closeBrowser() {
//		this.closeBrowser(driver);
//		
//	}
	
	@BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }
	 @Test(priority = 1)
	    public void test1() {
	        System.out.println("Test 1");
	    }
	 @AfterSuite
	    public void afterSuite() {
	        System.out.println("After Suite");
	    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

   

    @Test(priority = 2)
    public void test2() {
        System.out.println("Test 2");
    }
    @Test(priority = 3)
    public void test3() {
        System.out.println("Test 3");
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

     


}
