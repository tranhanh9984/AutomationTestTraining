package testcases.page.Rise;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import page.Rise.ClientPage;
import page.Rise.HomePageRise;
import page.Rise.LoginPageRise;
import page.Rise.ProjectPage;

public class Login_TC extends CommonPage{
	LoginPageRise login;
	WebDriver driver;
	HomePageRise homePage;
	ProjectPage projectPage;
	ClientPage clientPage;
	String errorExpected = "This field is required.";
	String alertExpected = "\"Oops, something went wrong!\"";
	String noMatchesExpected = "No matches found";
	
	@Test(priority = 1)
	public void LoginSuccess() {
		login.Login();
		String text = homePage.getUserName();
		Assert.assertEquals(text, "John Doe");
	}
	
//	@Test(priority = 1)
//	public void taoClient() {
//		homePage.clickClient();
//		clientPage.clickTaoClient();
//		clientPage.dienTT();
//		pause(7);
//		clientPage.clickSave();
//	}
	
	
	@Test(priority = 2)
	public void clickproject() {
		homePage.clickProject();
		String text = projectPage.gettxtproject();
		Assert.assertEquals(text, "Projects");
	}
//	@Test(priority = 3)
//	public void nhapTitleInvalid() {
//		projectPage.clickTaoProject();
//		projectPage.dienTitle("");
//		projectPage.clickSave();
//		String Actual = projectPage.getTitleError();
//		Assert.assertEquals(Actual, errorExpected);
//		projectPage.clickOutside(projectPage.txtTile);
//		projectPage.clickClose();
//		pause(5);
//	}
//	@Test(priority = 4)
//	public void nhapTitleSpace() {
//		projectPage.clickTaoProject();
//		projectPage.dienTitle("       ");
//		projectPage.clickSave();
//		String Actual = projectPage.getAlert();
//		Assert.assertEquals(Actual, alertExpected);
//		projectPage.clickClose();
//		pause(2);
//	}
//	@Test(priority = 6)
//	public void nhapPriceText() {
//		projectPage.clickTaoProject();
//		pause(2);
//		projectPage.dienTitle("Test demo");
//		projectPage.price("moot hai ba");
//		projectPage.clickSave();
//		String Actual = projectPage.getAlert();
//		Assert.assertEquals(Actual, alertExpected);
//	}
//	@Test(priority = 5)
//	public void nhapClientInvalid() {
//		projectPage.clickTaoProject();
//		projectPage.client("aa");
//		String Actual = projectPage.getNoMatchFound();
//		Assert.assertEquals(Actual, noMatchesExpected);
//		projectPage.clickOutside(projectPage.txtDemoClient);
//		pause(2);
//		projectPage.clickClose();
//	}
//	@Test(priority = 6)
//	public void nhapProjectInvalid() {
//		projectPage.clickTaoProject();
//		pause(100);
//		projectPage.projectType("aa");
//		String Actual = projectPage.getNoMatchFound();
//		Assert.assertEquals(Actual, noMatchesExpected);
//		projectPage.clickOutside(projectPage.txtProjectType);
//		pause(2);
//		projectPage.clickClose();
//	}
	@Test(priority = 8)
	public void taoProjectValid() {
		projectPage.clickTaoProject();
		projectPage.dienTitle("Test");
		projectPage.projectType("Client Project");
		projectPage.client("Zoila Hauck");
		projectPage.description("Test project");
		projectPage.Date("16-04-2025", "23-04-2025");
		projectPage.price("$5.00");
		projectPage.label();
		projectPage.clickSave();
		pause(1);
		projectPage.sapxepID();
		pause(1);
		String text = projectPage.gettxttile();
		Assert.assertEquals(text, "Test");
		String text1 = projectPage.getClient();
		Assert.assertEquals(text1, "Zoila Hauck");
		String text2 = projectPage.gettxtprice();
		Assert.assertEquals(text2, "$5.00");
		String text3 = projectPage.getStartdate();
		Assert.assertEquals(text3, "16-04-2025");
		String text4 = projectPage.getDealine();
		Assert.assertEquals(text4, "23-04-2025");
	}
	
	@BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.riseUrl, KeywordConstant.BROWSER);
        login = new LoginPageRise(driver);
        homePage = new HomePageRise(driver);
        projectPage = new ProjectPage(driver);
        clientPage = new ClientPage(driver);
    }

    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);

    }

}
