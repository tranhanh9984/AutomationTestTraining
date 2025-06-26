package autotest.page;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import autocom.common.CommonPage;

public class ProjectPage extends CommonPage {

	public ProjectPage(WebDriver driver) {
		this.driver = driver;
	}

	// ---------- Locators ----------
    private By menuProject = By.linkText("Projects");
    private By btnAddProject = By.cssSelector("[title='Add project']");
    private By inputTitle = By.id("title");
    private By descriptionBox = By.id("description");
    private By descriptionEditor = By.className("note-editable");
    private By inputStartDate = By.id("start_date");
    private By inputDeadline = By.id("deadline");
    private By inputPrice = By.id("price");
    private By inputLabel = By.xpath("//label[text()='Labels']/following::input[1]");
    private By btnSubmit = By.xpath("//button[@type='submit' and normalize-space()='Save']");
    private By tableProject = By.id("project-table");
    private By inputEmail = By.id("email");
    private By inputPassword = By.id("password");
    private By alert = By.className("app-alert");
    private By alertMessage = By.className("app-alert-message");
    private By statusDropdown = By.xpath("//label[text()='Status']/following::div[1]//div[contains(@class, 'select2-container')]");
    private By btnConfirmDelete = By.id("confirmDeleteButton");
    private By btnDelete = By.cssSelector("[title='Delete project']");
    private By inputSearch = By.xpath("//div[@id='project-table_filter']//input");
    private By tableRows = By.xpath("//table[@id='project-table']/tbody/tr");
    private By tableEmpty = By.xpath("//td[@class='dataTables_empty' and text()='No record found.']");
    
    // ---------- Actions ----------
    public void clickProjectMenu() {
        driver.findElement(menuProject).click();
    }

    public void clickAddProject() {
        driver.findElement(btnAddProject).click();
    }

    public void addProject(HashMap<String, String> project) {
    	driver.findElement(inputTitle).sendKeys(project.get("title"));
    	
        driver.findElement(descriptionBox).click();
        driver.findElement(descriptionEditor).sendKeys(project.get("description"));
        driver.findElement(inputStartDate).sendKeys(project.get("startDate"));
        driver.findElement(inputStartDate).sendKeys(Keys.ENTER);
        driver.findElement(inputDeadline).sendKeys(project.get("deadline"));
        driver.findElement(inputDeadline).sendKeys(Keys.ENTER);
        driver.findElement(inputPrice).sendKeys(project.get("price"));
        driver.findElement(inputLabel).sendKeys(project.get("label"));
        driver.findElement(inputLabel).sendKeys(Keys.ENTER);
    }

    public void clickSaveProject() {
        driver.findElement(btnSubmit).click();
    }

    public void verifyCreatedProject(String title) {
    	searchProject(title);
    	
        Assert.assertTrue(driver.findElement(tableProject).getText().contains(title));
    }

    public void clearAll() {
        driver.findElement(inputEmail).clear();
        driver.findElement(inputPassword).clear();
    }
    
    public void searchProject(String title) {
    	driver.findElement(inputSearch).clear();
		driver.findElement(inputSearch).sendKeys(title);
	    driver.findElement(inputSearch).sendKeys(Keys.ENTER);
	    pause(2);
    }

    public void clickEditButton(String title) {
        WebElement titleLink = driver.findElement(By.linkText(title));
        WebElement row = titleLink.findElement(By.xpath("./ancestor::tr"));
        row.findElement(By.cssSelector("[title='Edit project']")).click(); // thiếu dấu ']' trong đoạn gốc bạn đưa
    }

    public void deleteProject(String title) {
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

    public void verifyMessage(String message) {
        Assert.assertTrue(driver.findElement(alert).isDisplayed(), "Element should be visible on the page");
        Assert.assertEquals(driver.findElement(alertMessage).getText(), message, "Message text does not match");
    }

    public void changeStatus(String status) {
        driver.findElement(statusDropdown).click();
        String dynamicStatusXpath = String.format(
            "//ul[contains(@class, 'select2-results')]//div[contains(@class, 'select2-result-label') and text()='%s']",
            status
        );
        driver.findElement(By.xpath(dynamicStatusXpath)).click();
        pause(2);
    }
    
    public void deleteAllProject(String title) {
		searchProject(title);
		
	    List<WebElement> rows = driver.findElements(tableRows);
	    if (isTableEmpty()) {
	    	return;
	    }
	    while (rows.size() > 0) {
	        rows.get(0).findElement(btnDelete).click();
	        pause(2);
	        driver.findElement(btnConfirmDelete).click();
	        pause(2);

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
