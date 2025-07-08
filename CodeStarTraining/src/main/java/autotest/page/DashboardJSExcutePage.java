package autotest.page;

import static autocom.common.Locator.dashboardColum;
import static autocom.common.Locator.dashboardColumValue;
import static autocom.common.Locator.dashboardProjectValue;
import static autocom.common.Locator.getLinkByTitle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import autocom.common.CommonPage;

public class DashboardJSExcutePage extends CommonPage {

	JavascriptExecutor js;
	
	@FindBy(id="js-clock-in-out") @CacheLookup WebElement clockInOutCard;
	@FindBy(xpath="//a[@title='Clock In']") @CacheLookup WebElement clockInButton;
	@FindBy(xpath="//a[@title='Clock Out']") @CacheLookup WebElement clockOutButton;
	@FindBy(xpath="//div[@class='modal-footer']//button[@type='submit' and normalize-space()='Save']") @CacheLookup WebElement btnSubmitModal;
	
	@FindBy(className="note-editable") @CacheLookup WebElement noteBox;
	
	@FindBy(xpath="//span[contains(text(),'My open tasks')]/ancestor::div[2]") @CacheLookup WebElement openTaskBlock;
	@FindBy(xpath="//span[contains(text(),'My open tasks')]/preceding-sibling::h1") @CacheLookup WebElement openTaskCount;

	
	public DashboardJSExcutePage(WebDriver driver) {
		this.driver = driver;
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	
	//ul[@class='pagination']//a[text()='3']
	public void handleClickClockIn() {
		js.executeScript("arguments[0].click();", clockInButton);
		pause(2);
		verifyTextVisible(clockInOutCard, "Clock started at");
	}

	public void handlePopupClockOut() {
		js.executeScript("arguments[0].click();", clockOutButton);
		pause(2);
		js.executeScript("arguments[0].innerHTML = 'Clock OUT';", noteBox);
		js.executeScript("arguments[0].click()", btnSubmitModal);
		pause(2);
		verifyTextVisible(clockInOutCard, "You are currently clocked out");
	}
	
	public void manageClock() {
		By selector = getLinkByTitle("Clock In");
		System.out.println("selector 1234 " + elementVisible(selector));
		if(elementVisible(selector)) {			
			handleClickClockIn();
			pause(2);
			handlePopupClockOut();
		} else {
			handlePopupClockOut();
		}
	}
	
	public void checkEventsToday() {
		EventPage eventPage = new EventPage(driver);
		
		WebElement eventsTodayValue = driver.findElement(dashboardColumValue("Events today"));
		WebElement eventsToday = driver.findElement(dashboardColum("Events today"));
		
		String eventCountText = (String) js.executeScript("return arguments[0].textContent;", eventsTodayValue);
		
		int eventCount = Integer.parseInt(eventCountText);
		
		js.executeScript("arguments[0].click();", eventsToday);

		pause(2);
		
		// verify eventCount
		Assert.assertEquals(eventPage.getEventCount(), eventCount, "Don't match events count");
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
		
		String projectValue = (String) js.executeScript("return arguments[0].textContent;", projectCountValue);
		int projectCount = Integer.parseInt(projectValue);
		
		js.executeScript("arguments[0].click();", projectBox);
		pause(2);
		
		if(projectCount > 0) {			
			handleDropdownPagination("100");
			Assert.assertEquals(projectPage.getProjectCount(), projectCount, "Don't match events count");
			pause(2);
		} else {
			Assert.assertEquals(isTableEmpty("project"), true);
		}
	}

}
