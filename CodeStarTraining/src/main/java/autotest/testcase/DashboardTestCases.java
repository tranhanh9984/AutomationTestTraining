package autotest.testcase;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.page.DashboardPage;
import autotest.page.LoginPage;
import autotest.page.TodoPage;

public class DashboardTestCases extends CommonPage {
	LoginPage loginPage;
	DashboardPage dashboardPage;
	HashMap<String, String> todo = new HashMap<>();
	
//	@Test(priority=1)
	public void widgetClockInOut() {
		dashboardPage.manageClock();
	}
//	
//	@Test(priority=2, dependsOnMethods = "widgetClockInOut")
	public void widgetEventsToday() {
		clickMenuLink("Dashboard");
		dashboardPage.checkEventsToday();
	}
//	
////	@Test
//	@Test(priority=3, dependsOnMethods = "widgetEventsToday")
	public void widgetProjects() {
		clickMenuLink("Dashboard");
		dashboardPage.projectsOverview();
	}
//	(priority=4, dependsOnMethods = "widgetProjects")
//	@Test(priority=4, dependsOnMethods = "widgetProjects")
	public void widgetTodos() {
		setTodos();
		clickMenuLink("Dashboard");
		scrollToElement("//table[@id='todo-table']");
		
		pause(2);
		
		TodoPage todoPage = new TodoPage(driver);
		dashboardPage.addTodo(todoPage, todo);
		pause(1);
		verifyMessage("The record has been saved.");
		
		pause(2);
		todoPage.verifyAddedTodo(todo.get("title"));
		
		int index = todoPage.getIndexByTitle(todo.get("title"));
		WebElement row = todoPage.getElementByIndex(index);
		pause(2);
		
		dashboardPage.editTodo(todoPage, todo);
//		todoPage.verifyEditedTodo(index);
		pause(2);
		dashboardPage.deleteTodo(todoPage, todo);
		pause(1);
		verifyMessage("The record has been deleted.");
	}
	
	@Test
	public void widgetInvoiceOverview() {
		Map<String, String> statusToColumn = new HashMap<>();
		statusToColumn.put("overdue", "Due");
		statusToColumn.put("not_paid", "Due");
		statusToColumn.put("partially_paid", "Total invoiced");
		statusToColumn.put("fully_paid", "Total invoiced");
		statusToColumn.put("draft", "");

		for (Map.Entry<String, String> entry : statusToColumn.entrySet()) {
		    
		    WebElement invoiceFilter = dashboardPage.getInvoiceItem(entry.getKey());
		    int number = dashboardPage.getInvoiceItemCount(invoiceFilter);
		    double invoiceTotal = dashboardPage.getInvoiceItemTotal(invoiceFilter);
		    
		    System.out.println(invoiceFilter);
		    dashboardPage.clickInvoiceItem(invoiceFilter);
		    
		    By locator = By.xpath("//ul[@id='invoices-tabs']");
		    waitForElementVisible(locator);
		    
		    if (number != 0) {		    	
		    	int numberExpected = dashboardPage.totalInvoiceRow();
		    	double invoiceTotalExpected = dashboardPage.getTotalOfColumn(entry.getValue());
		    	
		    	verifyNumberEquals(number, numberExpected);
		    	verifyNumberDoubleEquals(invoiceTotal, invoiceTotalExpected);
		    } else {
		    	Assert.assertEquals(isTableEmpty("invoice-list"), true);
		    }
		    
		    clickMenuLink("Dashboard");
		}		
	}
	
	public void setTodos() {
		todo.put("title", "Metting with team members");
		todo.put("description", "Proofread and edit blog posts");
		todo.put("startDate", "26-07-2025");
		todo.put("label", "Bug");
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
