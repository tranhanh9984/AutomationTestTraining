package autotest.page;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static autocom.common.Locator.*;

import autocom.common.CommonPage;

public class TaskPage extends CommonPage {

	public TaskPage(WebDriver driver) {
		this.driver = driver;
	}
	 
	private By taskMenu = By.linkText("Tasks");	
	private By inputTitle = By.id("title");
	private By inputStartDate = By.id("start_date");
	private By inputEndDate = By.id("deadline");
	private By inputRecurring = By.id("recurring");
	
	
	public void clickTasksMenu() {
		driver.findElement(taskMenu).click();
	}
	
	public void searchTask(String title) {		
		search("task", title);
	}
	
	public void verifyMessage(String message) {
		WebElement element = driver.findElement(appAlert);
		Assert.assertTrue(element.isDisplayed(), "Element should be visible on the page");
		Assert.assertTrue(driver.findElement(alertMessage).getText().contentEquals(message),  "Message text does not match");
	}
	
	public void addTask(HashMap<String, String> task) {
		driver.findElement(inputTitle).sendKeys(task.get("title"));
		enterDescription(task.get("description"));
		selectOptionByClick("Related to", task.get("related"));
		
		pause(1);
		selectOptionByClick(task.get("related"), task.get("relatedRender"));
		selectOptionByClick("Collaborators", task.get("collaborators"));
		
		driver.findElement(inputStartDate).sendKeys(task.get("startDate"));
	    driver.findElement(inputEndDate).sendKeys(task.get("endDate"));
	    
	    clickSubmit();
	}
	
	public void editTask(HashMap<String, String> task) {
		 // Click chọn status
		selectOptionByClick("Status", task.get("status"));
		selectOptionByClick("Priority", task.get("priority"));
		selectOptionByClick("Labels", task.get("label"));
		
		driver.findElement(inputRecurring).click();
		clickSubmit();	    
	}
}
