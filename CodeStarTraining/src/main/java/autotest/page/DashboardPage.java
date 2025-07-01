package autotest.page;

import static autocom.common.Locator.*;

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

	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//ul[@class='pagination']//a[text()='3']
	public void handleClickClockIn() {
		clickLinkByTitle("Clock In");
		pause(2);
		verifyTextVisible(clockInOutCard, "Clock started at");
	}

	public void handlePopupClockOut() {
		clickLinkByTitle("Clock Out");
		pause(2);
		noteBox.sendKeys("Clock OUT");
		clickSubmitModal();
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
		
		int eventCount = Integer.parseInt(eventsTodayValue.getText().trim());
		eventsToday.click();
		pause(2);
		
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
