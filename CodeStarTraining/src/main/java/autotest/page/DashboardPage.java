package autotest.page;

import static autocom.common.Locator.*;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import autocom.common.CommonPage;

public class DashboardPage extends CommonPage {
	
	@FindBy(id="js-clock-in-out") @CacheLookup WebElement clockInOutCard;
	@FindBy(className="note-editable") @CacheLookup WebElement noteBox;
	
	@FindBy(xpath="//span[contains(text(),'My open tasks')]/ancestor::div[2]") @CacheLookup WebElement openTaskBlock;
	@FindBy(xpath="//span[contains(text(),'My open tasks')]/preceding-sibling::h1") @CacheLookup WebElement openTaskCount;
	
	@FindBy(xpath="//div[@id='ajaxModal']") @CacheLookup WebElement modal;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//ul[@class='pagination']//a[text()='3']
	public void handleClickClockIn() {
		clickLinkByTitle("Clock In");
//		pause(2);
		By selector = getLinkByTitle("Clock Out");
		waitForElementVisible(selector);
		verifyTextVisible(clockInOutCard, "Clock started at");
	}

	public void handlePopupClockOut() {
		clickLinkByTitle("Clock Out");
//		pause(2);
		waitForElementPresent(modal);
		noteBox.sendKeys("Clock OUT");
		clickSubmitModal();
//		pause(2);
		By selector = getLinkByTitle("Clock In");
		waitForElementVisible(selector);
		verifyTextVisible(clockInOutCard, "You are currently clocked out");
	}
	
	public void manageClock() {
		By selector = getLinkByTitle("Clock In");
		if(elementIsVisible(selector)) {			
			handleClickClockIn();
//			pause(2);
			handlePopupClockOut();
		} else {
			handlePopupClockOut();
		}
	}
	
	public void checkEventsToday() {
		EventPage eventPage = new EventPage(driver);
		
		WebElement eventsTodayValue = driver.findElement(dashboardColumValue("Events today"));
		WebElement eventsToday = driver.findElement(dashboardColum("Events today"));
		
		int eventCount = Integer.parseInt(eventsTodayValue.getText().trim());
		eventsToday.click();
//		pause(2);
		verifyPageTitle("Event calendar");
		// verify eventCount
		Assert.assertEquals(eventPage.getEventCount(), eventCount, "Don't match events count");
		eventPage.getEventsToday();
	}
	
	public void projectsOverview() {
		checkProjects("Open");
		clickMenuLink("Dashboard");
		pause(2);
		checkProjects("Completed");
		clickMenuLink("Dashboard");
		pause(2);
		checkProjects("Hold");
	}
	
	public void checkProjects(String status) {
		ProjectPage projectPage = new ProjectPage(driver);
		WebElement projectCountValue = driver.findElement(dashboardProjectValue(status));
		WebElement projectBox = driver.findElement(dashboardColum(status));
		
		String projectValue = projectCountValue.getText();
		int projectCount = Integer.parseInt(projectValue);
		
		projectBox.click();
		verifyPageTitle("Projects");
		
		if(projectCount > 0) {			
			handleDropdownPagination("100");
			Assert.assertEquals(projectPage.getProjectCount(), projectCount, "Don't match events count");
			pause(2);
		} else {
			Assert.assertEquals(isTableEmpty("project"), true);
		}
	}
	
	public void addTodo(TodoPage todoPage, HashMap<String, String> todo) {
		todoPage.addTodoDashboard(todo.get("title"));
	}
	
	public void editTodo(TodoPage todoPage, HashMap<String, String> todo) {
		WebElement addedTodoElement = todoPage.getElementByTitle(todo.get("title"));
		if (addedTodoElement != null) {			
			todoPage.clickAction(addedTodoElement);
//			pause(1);
			By locator = By.xpath("//ul[@class='dropdown-menu']");
			waitForElementVisible(locator);
			driver.findElement(btnEdit).click();
			
			todoPage.editTodo(todo);
		}
	}
	
	public void deleteTodo(TodoPage todoPage, HashMap<String, String> todo) {
		WebElement addedTodoElement = todoPage.getElementByTitle(todo.get("title"));
		if (addedTodoElement != null) {			
			todoPage.clickAction(addedTodoElement);
//			pause(1);
			
			By locator = By.xpath("//ul[@class='dropdown-menu']");
			waitForElementVisible(locator);
			
			driver.findElement(btnDelete).click();
		}
	}
	
	public WebElement getInvoiceItem(String value) {
		WebElement invoiceFilter = driver.findElement(dashboardInvoiceFilter(value));
		return invoiceFilter;
	}
	
	public void clickInvoiceItem(WebElement invoiceFilter) {
		invoiceFilter.click();
	}
	
	public int getInvoiceItemCount(WebElement invoiceFilter) {
		String numberText = invoiceFilter.findElement(By.xpath(".//div//div[3][@class='w15p text-center']")).getText();
		
		return Integer.parseInt(numberText);
	}
	
	public double getInvoiceItemTotal(WebElement invoiceFilter) {
		String numberText = invoiceFilter.findElement(By.xpath(".//div//div[4][@class='w25p text-end']")).getText();
		
		return handleAmountFromText(numberText);
	}
	
	public int totalInvoiceRow() {
		//li[contains(@class, 'page-item') and not(contains(@class, 'previous')) and not(contains(@class, 'next'))]
		List<WebElement> pageNumbers = driver.findElements(By.xpath("//li[contains(@class, 'page-item') and not(contains(@class, 'previous')) and not(contains(@class, 'next'))]"));
		
		int numberCount = driver.findElements(tableRows("invoice-list")).size();
		
		if(pageNumbers.size() > 1) {			
			for (int i = 1; i < pageNumbers.size(); i++) {
				WebElement element = pageNumbers.get(i);
				
				element.click();
				waitForElementHasClass(element);
				
				numberCount = numberCount + driver.findElements(tableRows("invoice-list")).size();
			}
		}
		
		return numberCount;
	}
	
	public double getTotalOfColumn(String column) {
		int index = getIndexOfColumn(column);
		String columnText = "";
		if (elementIsVisible(By.xpath("//table//tfoot//tr[@data-section='all_pages']"))) {
			WebElement columnValue = driver.findElement(By.xpath(String.format("//table//tfoot//tr[@data-section='all_pages']//th[%d]", index)));
			columnText = columnValue.getText();
		} else {			
			WebElement columnValue = driver.findElement(By.xpath(String.format("//table//tfoot//th[%d]", index)));
			columnText = columnValue.getText();
		}
		
		return handleAmountFromText(columnText);
	}
	
	public int getIndexOfColumn(String column) {
		List<WebElement> headers = driver.findElements(By.xpath("//table//thead//tr//th"));

		
		int columnIndex = -1;  
		for (int i = 0; i < headers.size(); i++) {
		    String text = headers.get(i).getText().trim();
		    if (text.equals(column)) {
		    	columnIndex = i + 1;
		        break;
		    }
		}
		
		return columnIndex;
	}
}
