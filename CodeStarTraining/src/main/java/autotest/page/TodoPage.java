package autotest.page;

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

public class TodoPage extends CommonPage {

	@FindBy(id="todo-title") @CacheLookup WebElement inputTodo;
	@FindBy(xpath="//input[@id='todo-title']/following-sibling::span//button") @CacheLookup WebElement btnSave;
	@FindBy(xpath="//label[contains(text(),'To do')]") @CacheLookup WebElement todoTab;
	@FindBy(xpath="//label[contains(text(),'Done')]") @CacheLookup WebElement doneTab;
//	@FindBy(xpath="//div[@id='todo-table_filter']//input") @CacheLookup WebElement inputSearch;
	@FindBy(xpath="//table[@id='todo-table']//tbody//tr") @CacheLookup List<WebElement> todoRows;
	
	// Popup edit todo
	@FindBy(id="title") @CacheLookup WebElement inputTitle;
	
	By todoStatus = By.xpath("//a[contains(@class,'update-todo-status-checkbox')]//span");
	By todoTitle = By.xpath("//a[@title='To do']");
	By todoEdit = By.xpath("//a[@title='Edit']");
	By todoDelete = By.xpath("//a[@title='Delete']");
	By todoAction = By.xpath("//button[contains(@class,'action-option')]");
	By todoList = By.xpath("//div[@id='todo-list-widget-table']");
	
	public TodoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getTodoRows() {
		return todoRows;
	}
	
	public void addTodoDashboard(String value) {
		inputTodo.sendKeys(value);
		btnSave.click();
	}
	
	public void waitForTodoListDashboard(String value) {
		waitForElementVisible(todoList);
	}
	
	public void editTodo(HashMap<String, String> todo) {
		String newTitle = todo.get("title");
		String currentTitle = inputTitle.getAttribute("value");
		if (!newTitle.equals(currentTitle)) {
		    inputTitle.clear();
		    inputTitle.sendKeys(newTitle);
		}
		
		enterDescription(todo.get("description"));
		
		selectOptionByInputName("labels", todo.get("label"));
		enterStartDate(todo.get("startDate"));
		clickSubmitModal();
	}
	
	
	public String getTextTitle(WebElement element) {
		String title = element.findElement(todoTitle).getText();
		return title;
	}
	
	public WebElement getElementByTitle(String title) {
		for (WebElement row : todoRows) {
	        String currentTitle = row.findElement(todoTitle).getText().trim();
	        if (currentTitle.equalsIgnoreCase(title)) {
	            return row;
	        }
	    }
	    return null;
	}
	
	public int getIndexByTitle(String title) {
	    for (int i = 0; i < todoRows.size(); i++) {
	        String currentTitle = todoRows.get(i).findElement(todoTitle).getText().trim();
	        if (currentTitle.equalsIgnoreCase(title)) {
	            return i;
	        }
	    }
	    return -1;
	}
	
	public WebElement getElementByIndex(int index) {
		if (index >= 0 && index < todoRows.size()) {
	        return todoRows.get(index);
	    }
	    return null; 
	}
	
	public void clickAction(WebElement element) {
		WebElement buttonAction = element.findElement(todoAction);
		buttonAction.click();
	}
	
	public void verifyAddedTodo(String value) {
		WebElement todoNew = todoRows.get(0);
		String title = getTextTitle(todoNew);
		Assert.assertEquals(title, value, "Failed to add todo");
	}
	
//	public void verifyEditedTodo(int index, HashMap<String, String> todo) {
//		if (index < 0 || index >= todoRows.size()) {
//	        throw new IllegalArgumentException("Invalid index: " + index);
//	    }
//		
//		WebElement todoNew = todoRows.get(index).findElement(todoTitle);
//		
//		Assert.assertTrue("Element không chứa text: " + todo.get("title"), (todoNew.getText()).contains(todo.get("title")));
//		Assert.assertTrue("Element không chứa text: " + todo.get("description"), (todoNew.getText()).contains(todo.get("description")));
//	}
	
}
