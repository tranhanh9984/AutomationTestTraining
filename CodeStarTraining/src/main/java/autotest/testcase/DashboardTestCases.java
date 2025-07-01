package autotest.testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.page.DashboardPage;
import autotest.page.LoginPage;

public class DashboardTestCases extends CommonPage {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	@Test(priority=1)
	public void widgetClockInOut() {
		dashboardPage.manageClock();
	}
//	
//	@Test(priority=2, dependsOnMethods = "widgetClockInOut")
//	public void widgetEventsToday() {
//		clickMenuLink("Dashboard");
//		dashboardPage.checkEventsToday();
//	}
//	
//	@Test(priority=3, dependsOnMethods = "widgetEventsToday")
//	@Test
	public void widgetProjects() {
		clickMenuLink("Dashboard");
		dashboardPage.projectsOverview();
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		loginPage.login("admin@demo.com", "riseDemo");
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
	}
}
