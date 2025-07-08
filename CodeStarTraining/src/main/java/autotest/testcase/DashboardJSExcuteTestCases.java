package autotest.testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.page.DashboardJSExcutePage;
import autotest.page.LoginPage;

public class DashboardJSExcuteTestCases extends CommonPage {
	LoginPage loginPage;
	DashboardJSExcutePage dashboardPage;
	
	@Test(priority=1)
	public void widgetClockInOut() {
		dashboardPage.manageClock();
	}
	
	@Test(priority=2, dependsOnMethods = "widgetClockInOut")
	public void widgetEventsToday() {
		clickMenuLink("Dashboard");
		dashboardPage.checkEventsToday();
	}
	
//	@Test
	@Test(priority=3, dependsOnMethods = "widgetEventsToday")
	public void widgetProjects() {
		clickMenuLink("Dashboard");
		dashboardPage.projectsOverview();
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardJSExcutePage(driver);
		loginPage.login("admin@demo.com", "riseDemo");
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
	}

}
