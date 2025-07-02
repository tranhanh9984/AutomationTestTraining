package autotest.testcase.rise;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.rise.ClientPage;
import autotest.pages.rise.DashboardPage;
import autotest.pages.rise.DashboardPage.MoneySummary;
import autotest.pages.rise.LoginPage;

public class DashboardTestcases extends CommonPage {

	DashboardPage dashboard;
	LoginPage login;

	@Test(priority = 1)
	public void testMyOpenTasks() {
		dashboard.clickMenu("Dashboard");
		int actual = dashboard.getQuantityOfBigItem("My open tasks");
		dashboard.clickItem("My open tasks");
		int expected = dashboard.countRows("task-table");
		Assert.assertEquals(actual, expected, "Số lượng task không khớp!");
	}

	@Test(priority = 2)
	public void testEventsToday() {
		dashboard.clickMenu("Dashboard");
		int actual = dashboard.getQuantityOfBigItem("Events today");
		dashboard.clickItem("Events today");
		int expected = dashboard.countEventsToday();
		Assert.assertEquals(actual, expected, "Số lượng event không khớp!");
	}

	@Test(priority = 3)
	public void testDue() {
		dashboard.clickMenu("Dashboard");
		float actual = dashboard.getQuantityOfDueItem();

		dashboard.clickMenu("Sales");
		dashboard.clickMiniMenuOfSales("Invoices");
		dashboard.clickShowFilter();
		dashboard.filterInvoiceByStatus("Status");
		pause(2);

		MoneySummary a = dashboard.countQuantityAndSumTotal("Due", "invoice-list-table");
		float totalDue = a.total;
		
		dashboard.filterInvoiceByStatus("Draft");
		pause(5);
		MoneySummary b = dashboard.countQuantityAndSumTotal("Due", "invoice-list-table");
		float draftDue = b.total;

		float expected = totalDue - draftDue;
		Assert.assertEquals(actual, expected, "Tổng tiền due không khớp!");
	}

	@Test(priority = 4)
	public void testProjectsOpen() {
		dashboard.clickMenu("Dashboard");
		int actual = dashboard.getQuantityOfProjectsItem("Open");
		dashboard.clickItem("Open");
		int expected = dashboard.countRows("project-table");
		Assert.assertEquals(actual, expected, "Số lượng projects open không khớp!");
	}

	@Test(priority = 5)
	public void testProjectsCompleted() {
		dashboard.clickMenu("Dashboard");
		int actual = dashboard.getQuantityOfProjectsItem("Completed");
		dashboard.clickItem("Completed");
		int expected = dashboard.countRows("project-table");
		Assert.assertEquals(actual, expected, "Số lượng projects completed không khớp!");
	}

	@Test(priority = 6)
	public void testProjectsHold() {
		dashboard.clickMenu("Dashboard");
		int actual = dashboard.getQuantityOfProjectsItem("Hold");
		dashboard.clickItem("Hold");
		int expected = dashboard.countRows("project-table");
		Assert.assertEquals(actual, expected, "Số lượng projects hold không khớp!");
	}

//	@Test(dependsOnMethods = {"testProjectsOpen", "testProjectsCompleted", "testProjectsHold"})
	@Test(priority = 7)
	public void testProjectProgression() {
		dashboard.clickMenu("Dashboard");
		int open = dashboard.getQuantityOfProjectsItem("Open");
		int completed = dashboard.getQuantityOfProjectsItem("Completed");
		int hold = dashboard.getQuantityOfProjectsItem("Hold");
		int expected = (completed + hold) * 100 / open;
		int actual = dashboard.getValueProgress();
		Assert.assertTrue(Math.abs(actual - expected) <= 2, "Project progress không khớp!");
	}

	@Test(priority = 8)
	public void testInvoiceOverdue() {
		dashboard.clickMenu("Dashboard");
		int actualQuantity = dashboard.getQuantityOfInvoiceItem("Overdue");
		float actualTotalMoney = dashboard.getTotalMoneyOfInvoiceItem("Overdue");
		dashboard.clickMenu("Sales");
		dashboard.clickMiniMenuOfSales("Invoices");
		dashboard.clickShowFilter();
		dashboard.filterInvoiceByStatus("Overdue");
		pause(2);

		MoneySummary a = dashboard.countQuantityAndSumTotal("Due", "invoice-list-table");
		int expectedQuantity = a.rowCount;
		float expectedTotalMoney = a.total;

		Assert.assertEquals(actualQuantity, expectedQuantity, "Số lượng invoices overdue không khớp!");
		Assert.assertEquals(actualTotalMoney, expectedTotalMoney, "Tổng tiền invoices overdue không khớp!");
	}

	@Test(priority = 9)
	public void testInvoiceNotPaid() {
		dashboard.clickMenu("Dashboard");
		int actualQuantity = dashboard.getQuantityOfInvoiceItem("Not paid");
		float actualTotalMoney = dashboard.getTotalMoneyOfInvoiceItem("Not paid");
		dashboard.clickMenu("Sales");
		dashboard.clickMiniMenuOfSales("Invoices");
		dashboard.clickShowFilter();
		dashboard.filterInvoiceByStatus("Not paid");
		pause(2);

		MoneySummary a = dashboard.countQuantityAndSumTotal("Total invoiced", "invoice-list-table");
		int expectedQuantity = a.rowCount;
		float expectedTotalMoney = a.total;

		Assert.assertEquals(actualQuantity, expectedQuantity, "Số lượng invoices not paid không khớp!");
		Assert.assertEquals(actualTotalMoney, expectedTotalMoney, "Tổng tiền invoices not paid không khớp!");
	}

	@Test(priority = 10)
	public void testInvoicePartiallyPaid() {
		dashboard.clickMenu("Dashboard");
		int actualQuantity = dashboard.getQuantityOfInvoiceItem("Partially paid");
		float actualTotalMoney = dashboard.getTotalMoneyOfInvoiceItem("Partially paid");
		dashboard.clickMenu("Sales");
		dashboard.clickMiniMenuOfSales("Invoices");
		dashboard.clickShowFilter();
		dashboard.filterInvoiceByStatus("Partially paid");
		pause(2);

		MoneySummary a = dashboard.countQuantityAndSumTotal("Total invoiced", "invoice-list-table");
		int expectedQuantity = a.rowCount;
		float expectedTotalMoney = a.total;

		Assert.assertEquals(actualQuantity, expectedQuantity, "Số lượng invoices artially paid không khớp!");
		Assert.assertEquals(actualTotalMoney, expectedTotalMoney, "Tổng tiền invoices partially paid không khớp!");
	}

	@Test(priority = 11)
	public void testInvoiceFullyPaid() {
		dashboard.clickMenu("Dashboard");
		int actualQuantity = dashboard.getQuantityOfInvoiceItem("Fully paid");
		float actualTotalMoney = dashboard.getTotalMoneyOfInvoiceItem("Fully paid");
		dashboard.clickMenu("Sales");
		dashboard.clickMiniMenuOfSales("Invoices");
		pause(5);
		dashboard.clickShowFilter();
		dashboard.filterInvoiceByStatus("Fully paid");
		pause(2);

		MoneySummary a = dashboard.countQuantityAndSumTotal("Total invoiced", "invoice-list-table");
		int expectedQuantity = a.rowCount;
		float expectedTotalMoney = a.total;

		Assert.assertEquals(actualQuantity, expectedQuantity, "Số lượng invoices fully paid không khớp!");
		Assert.assertEquals(actualTotalMoney, expectedTotalMoney, "Tổng tiền invoices fully paid không khớp!");
	}

	@Test(priority = 12)
	public void testInvoiceDraft() {
		dashboard.clickMenu("Dashboard");
		int actualQuantity = dashboard.getQuantityOfInvoiceItem("Draft");
		float actualTotalMoney = dashboard.getTotalMoneyOfInvoiceItem("Draft");
		dashboard.clickMenu("Sales");
		dashboard.clickMiniMenuOfSales("Invoices");
		pause(5);
		dashboard.clickShowFilter();
		dashboard.filterInvoiceByStatus("Draft");
		pause(2);

		MoneySummary a = dashboard.countQuantityAndSumTotal("Total invoiced", "invoice-list-table");
		int expectedQuantity = a.rowCount;
		float expectedTotalMoney = a.total;

		Assert.assertEquals(actualQuantity, expectedQuantity, "Số lượng invoices draft không khớp!");
		Assert.assertEquals(actualTotalMoney, expectedTotalMoney, "Tổng tiền invoices draft không khớp!");

	}
	
	@Test(priority = 13)
	public void testTotalInvoiced() {
		dashboard.clickMenu("Dashboard");
		float actual = dashboard.getTotalInvoicedMoney();
		dashboard.clickMenu("Sales");
		dashboard.clickMiniMenuOfSales("Invoices");
		dashboard.clickShowFilter();
		dashboard.filterInvoiceByStatus("Not");
		pause(2);
		float notPaid = dashboard.countQuantityAndSumTotal("Total invoiced", "invoice-list-table").total;
		
		dashboard.filterInvoiceByStatus("Fully");
		pause(2);
		float fullyPaid = dashboard.countQuantityAndSumTotal("Total invoiced", "invoice-list-table").total;
		
		dashboard.filterInvoiceByStatus("partially");
		pause(2);
		float partiallyPaid = dashboard.countQuantityAndSumTotal("Total invoiced", "invoice-list-table").total;
		
		float expected = notPaid + fullyPaid + partiallyPaid;

		Assert.assertEquals(actual, expected, "Tổng total invoiced không khớp!");

	}
	

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		dashboard = new DashboardPage(driver);
		login = new LoginPage(driver);
		login.addCookies();
		login.clearAll();
		login.Login("admin@demo.com", "riseDemo");
	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
	}
}
