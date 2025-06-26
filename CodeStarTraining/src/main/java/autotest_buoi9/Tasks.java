package autotest_buoi9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.login.LoginPage;

public class Tasks extends CommonPage{
	
	private LoginPage loginPage;
	
	@Test
	public void testAddTask() {
//		loginPage.login("admin@demo.com", "riseDemo");
		clickTasksMenu();
		clickAddTask();
		addTask("Learning Selenium", "Reliable quarterly releases and critical updates, delivered on time for over two decades.", "Client", "Blaze Rohan", "Mark Thomas", "29-06-2025", "29-08-2025");
		pause(2);
		verifyAddedTask("Learning Selenium");
	}
	
	@Test
	public void testEditTask() {
//		loginPage.login("admin@demo.com", "riseDemo");
		clickTasksMenu();
		clickAddTask();
		addTask("Learning Selenium", "Reliable quarterly releases and critical updates, delivered on time for over two decades.", "Client", "Blaze Rohan", "Mark Thomas", "29-06-2025", "29-08-2025");
		pause(2);
		searchTask("Learning Selenium");
		
		clickEditButton("Learning Selenium");
		pause(2);
		editTask("Done", "Major", "Bug");
		pause(2);
//		deleteTask();
	}
	
	@Test
	public void testDeleteTask() {
//		loginPage.login("admin@demo.com", "riseDemo");
		clickTasksMenu();
		clickAddTask();
		addTask("Learning Selenium", "Reliable quarterly releases and critical updates, delivered on time for over two decades.", "Client", "Blaze Rohan", "Mark Thomas", "29-06-2025", "29-08-2025");
		pause(2);
		
		searchTask("Learning Selenium");
		deleteTask();
		
		verifyMessage("The record has been deleted.");
	}
	
//	private void clickSubmit() {
//		driver.findElement(By.cssSelector("button[type='submit']")).click();
//	}
	
	private void clickTasksMenu() {
		driver.findElement(By.linkText("Tasks")).click();
		
	}
	
	private void clickAddTask() {
		driver.findElement(By.xpath("//div[@id='page-content']//a[@title='Add task']")).click();
	}
	
	private void clickEditButton(String name) {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		
		rows.get(0).findElement(By.xpath("./td[2]/a")).click();
		pause(1);
		
		driver.findElement(By.xpath("//div[@class='modal-footer']//a[@title='Edit task']")).click();
	}
	
	private void verifyAddedTask(String title) {
		driver.findElement(By.xpath("//div[@id='task-table_filter']//input")).sendKeys(title);
		driver.findElement(By.xpath("//div[@id='task-table_filter']//input")).sendKeys(Keys.ENTER);
		pause(2);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		Assert.assertTrue(rows.size() > 0, "Không có task nào trong bảng!");
		
		String actualText = rows.get(0).findElement(By.xpath("./td[2]/a")).getText();
		Assert.assertTrue(actualText.contains(title), "Không tìm thấy nội dung mong muốn!");
	}
	
	private void verifyMessage(String message) {
		WebElement element = driver.findElement(By.className("app-alert"));
		Assert.assertTrue(element.isDisplayed(), "Element should be visible on the page");
		Assert.assertTrue(driver.findElement(By.className("app-alert-message")).getText().contentEquals(message),  "Message text does not match");
	}
	
	private void addTask(String title, String description, String related, String relatedRender, String collaborators, String startDate, String endDate) {
		driver.findElement(By.id("title")).sendKeys(title);
		driver.findElement(By.id("description")).click();
		driver.findElement(By.className("note-editable")).sendKeys(description);
		
		driver.findElement(By.xpath("//label[@for='context']//following::div[1]/div")).click();
		driver.findElement(By.xpath(String.format("//ul[@class='select2-results']/li/div[contains(text(),'%s')]", related))).click();
		pause(1);
		System.out.print(String.format("//label[text()='%s']//following-sibling::div[1]/div", related));
		System.out.print(String.format("//div[@class='select2-search']/parent::div[contains(@style,'display: block')]//label[contains(text(),'%s')]//following-sibling::input", related));
		driver.findElement(By.xpath(String.format("//label[text()='%s']//following-sibling::div[1]/div", related))).click();
		pause(1);
		driver.findElement(By.xpath(String.format("//div[@class='select2-search']/parent::div[contains(@style,'display: block')]//label[contains(text(),'%s')]//following-sibling::input", related))).sendKeys(relatedRender);
		driver.findElement(By.xpath(String.format("//div[@class='select2-search']/parent::div[contains(@style,'display: block')]//label[contains(text(),'%s')]//following-sibling::input", related))).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//label[@for='collaborators']//following::div[1]/div")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Collaborators')]//following-sibling::input")).sendKeys(collaborators); //Ram Kumar 
		driver.findElement(By.xpath("//label[contains(text(),'Collaborators')]//following-sibling::input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("start_date")).sendKeys(startDate);
		driver.findElement(By.id("deadline")).sendKeys(endDate);
		
		clickSubmit();
	}
	
	private void editTask(String status, String priority, String label) {
		driver.findElement(By.xpath("//label[@for='status_id']//following::div[1]/div")).click();
		pause(1);
		driver.findElement(By.xpath(String.format("//ul[@class='select2-results']/li/div[contains(text(),'%s')]", status))).click();
		
		driver.findElement(By.xpath("//label[@for='priority_id']//following::div[1]/div")).click();
		pause(1);
		driver.findElement(By.xpath("//div[@class='select2-search']/parent::div[contains(@style,'display: block')]//label[contains(text(),'Priority')]//following::input")).sendKeys(priority);
		driver.findElement(By.xpath("//div[@class='select2-search']/parent::div[contains(@style,'display: block')]//label[contains(text(),'Priority')]//following::input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//label[@for='project_labels']//following::div[1]/div")).click();
		driver.findElement(By.xpath("//ul[@class='select2-choices']//label[contains(text(),'Labels')]//following-sibling::input")).sendKeys(label);
		driver.findElement(By.xpath("//ul[@class='select2-choices']//label[contains(text(),'Labels')]//following-sibling::input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("recurring")).click();
		clickSubmit();
	}
	
	private void searchTask(String name) {
		driver.findElement(By.xpath("//div[@id='task-table_filter']//input")).sendKeys(name);
		driver.findElement(By.xpath("//div[@id='task-table_filter']//input")).sendKeys(Keys.ENTER);
		pause(2);
	}
	
	private void deleteTask() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		
		rows.get(0).findElement(By.cssSelector("[title='Delete task'")).click();
		
		pause(2);
		driver.findElement(By.id("confirmDeleteButton")).click();
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		loginPage = new LoginPage(driver);
		loginPage.login("admin@demo.com", "riseDemo");
		
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
		
	}
}
