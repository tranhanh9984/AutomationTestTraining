package autotest.page;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import autocom.common.CommonPage;

public class TaskPage extends CommonPage {

	public TaskPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By btnSubmit = By.xpath("//button[@type='submit' and normalize-space()='Save']");;
	private By taskMenu = By.linkText("Tasks");
	private By btnAddTask = By.xpath("//div[@id='page-content']//a[@title='Add task']");
	private By colTitle = By.xpath("./td[2]/a");
	private By btnEdit = By.xpath("//div[@class='modal-footer']//a[@title='Edit task']");
	private By inputSearch = By.xpath("//div[@id='task-table_filter']//input"); 
	
	private By appAlert = By.className("app-alert");
	private By alertMessage = By.className("app-alert-message");
	
	private By inputTitle = By.id("title");
	private By inputDescription = By.id("description");
	private By noteEdit = By.className("note-editable");	
	private By clickRelate = By.xpath("//label[@for='context']//following::div[1]/div");
	private By clickCollaborators = By.xpath("//label[@for='collaborators']//following::div[1]/div");
	private By inputCollaborators = By.xpath("//label[contains(text(),'Collaborators')]//following-sibling::input");
	private By inputStartDate = By.id("start_date");
	private By inputEndDate = By.id("deadline");
	private By inputStatus = By.xpath("//label[@for='status_id']//following::div[1]/div");
	private By clickPriority = By.xpath("//label[@for='priority_id']//following::div[1]/div");
	private By inputPriority = By.xpath("//div[@class='select2-search']/parent::div[contains(@style,'display: block')]//label[contains(text(),'Priority')]//following::input");
	private By clickLabel = By.xpath("//label[@for='project_labels']//following::div[1]/div");
	private By inputLabel = By.xpath("//ul[@class='select2-choices']//label[contains(text(),'Labels')]//following-sibling::input");
	private By inputRecurring = By.id("recurring");
	private By btnDelete = By.cssSelector("[title='Delete task'");
	private By btnConfirmDelete = By.id("confirmDeleteButton");
    private By tableRows = By.xpath("//table[@id='task-table']/tbody/tr");
    private By tableEmpty = By.xpath("//td[@class='dataTables_empty' and text()='No record found.']");
	
	private By getRelatedRender(String value) {
	    return By.xpath(String.format(
			"//div[@class='select2-search']/parent::div[contains(@style,'display: block')]//label[contains(text(),'%s')]//following-sibling::input", 
			value
	    ));
	}
	
	private By getRelatedRenderValue(String value) {
	    return By.xpath(String.format("//label[text()='%s']//following-sibling::div[1]/div", value));
	}
	
	private By getRelatedValue(String value) {
	    return By.xpath(String.format(
	    	"//ul[@class='select2-results']/li/div[contains(text(),'%s')]", 
	    	value
	    ));
	}
	
	private By getStatusValue(String value) {
	    return By.xpath(String.format(
    		"//ul[@class='select2-results']/li/div[contains(text(),'%s')]", 
    		value
	    ));
	}
	
	public void clickSubmit() {
		driver.findElement(btnSubmit).click();
	}
	
	public void clickTasksMenu() {
		driver.findElement(taskMenu).click();
	}
	
	public void clickAddTask() {
		driver.findElement(btnAddTask).click();
	}
	
	public void clickEditButton(String name) {
		List<WebElement> rows = driver.findElements(tableRows);
		
		rows.get(0).findElement(colTitle).click();
		pause(1);
		
		driver.findElement(btnEdit).click();
	}
	
	public void verifyAddedTask(String title) {
		searchTask(title);
		
		List<WebElement> rows = driver.findElements(tableRows);
		Assert.assertTrue(rows.size() > 0, "Không có task nào trong bảng!");
		
		String actualText = rows.get(0).findElement(colTitle).getText();
		Assert.assertTrue(actualText.contains(title), "Không tìm thấy nội dung mong muốn!");
	}
	
	public void verifyMessage(String message) {
		WebElement element = driver.findElement(appAlert);
		Assert.assertTrue(element.isDisplayed(), "Element should be visible on the page");
		Assert.assertTrue(driver.findElement(alertMessage).getText().contentEquals(message),  "Message text does not match");
	}
	
	public void addTask(HashMap<String, String> task) {
		 driver.findElement(inputTitle).sendKeys(task.get("title"));
	    driver.findElement(inputDescription).click();
	    driver.findElement(noteEdit).sendKeys(task.get("description"));

	    driver.findElement(clickRelate).click();
	    driver.findElement(getRelatedValue(task.get("related"))).click();
	    pause(1);

	    driver.findElement(getRelatedRenderValue(task.get("related"))).click();
	    pause(1);
	    driver.findElement(getRelatedRender(task.get("related"))).sendKeys(task.get("relatedRender"));
	    driver.findElement(getRelatedRender(task.get("related"))).sendKeys(Keys.ENTER);


	    // driver.findElement(clickCollaborators).click();
	    // driver.findElement(inputCollaborators).sendKeys(task.get("collaborators"));
	    // driver.findElement(inputCollaborators).sendKeys(Keys.ENTER);

	    driver.findElement(inputStartDate).sendKeys(task.get("startDate"));
	    driver.findElement(inputEndDate).sendKeys(task.get("endDate"));
		
		clickSubmit();
	}
	
	public void editTask(HashMap<String, String> task) {
		 // Click chọn status
	    driver.findElement(inputStatus).click();
	    pause(1);
	    driver.findElement(getStatusValue(task.get("status"))).click();

	    driver.findElement(clickPriority).click();
	    pause(1);
	    driver.findElement(inputPriority).sendKeys(task.get("priority"));
	    driver.findElement(inputPriority).sendKeys(Keys.ENTER);

	    // Chọn label
	    driver.findElement(clickLabel).click();
	    driver.findElement(inputLabel).sendKeys(task.get("label"));
	    driver.findElement(inputLabel).sendKeys(Keys.ENTER);

	    // Recurring (nếu cần)
	    driver.findElement(inputRecurring).click();

	    clickSubmit();
	}
	
	public void searchTask(String title) {
		WebElement searchInput = driver.findElement(inputSearch);
		searchInput.clear();
		searchInput.sendKeys(title);
		searchInput.sendKeys(Keys.ENTER);
		pause(2);
	}
	
	public void deleteTask(String title) {
		List<WebElement> rows = driver.findElements(tableRows);
		
		 for (WebElement row : rows) {
	        if (row.getText().contains(title)) {
	            row.findElement(btnDelete).click();
	            pause(1);
	            driver.findElement(btnConfirmDelete).click();
	            return;
	        }
	    }
		 
		 System.out.println("No records found with title: " + title);
	}

	public void deleteAllTask(String title) {
		searchTask(title);
		
	    List<WebElement> rows = driver.findElements(tableRows);
	    if (isTableEmpty()) {
	    	return;
	    }
	    while (rows.size() > 0) {
	        rows.get(0).findElement(btnDelete).click();
	        pause(1);
	        driver.findElement(btnConfirmDelete).click();
	        pause(1);

	        if (isTableEmpty()) {
	        	break;
		    }
	        
	        rows = driver.findElements(tableRows);
	    }
	}
	
	public boolean isTableEmpty() {
	    List<WebElement> emptyElements = driver.findElements(tableEmpty);
	    if (!emptyElements.isEmpty()) {
	        System.out.println("No records found");
	        return true; 
	    }
	    return false;
	}
}
