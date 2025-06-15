package autotest.pages.rise;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonPage;

public class TaskPage extends CommonPage {

    public TaskPage(WebDriver driver) {
        this.driver = driver;
    }

    By menuText(String text) {
        return By.xpath("//span[@class='menu-text ' and text()='" + text + "']");
    }

    By addTaskLink = By.linkText("Add task");

    By titleInput = By.name("title");
    By descriptionClick = By.id("description");
    By descriptionArea = By.className("note-editable");

    By relatedDropdown = By.xpath("//div[@id='s2id_task-context']");
    By dropdownSearch = By.xpath("//div[@id='select2-drop']/div/input");
    
    By clientDropdown = By.id("s2id_client_id");

    By collaboratorDropdown = By.id("s2id_collaborators");
    By collaboratorInput = By.xpath("//div[@id='s2id_collaborators']/ul/li/input");
    
    By priorityDropdown = By.id("s2id_priority_id");
    
    By labelInput = By.xpath("//label[text()='Labels']/following-sibling::input");

    By startDateInput = By.id("start_date");
    By deadlineInput = By.id("deadline");
    
    By recurringCheckbox =  By.xpath("//input[@type = 'checkbox']");

    By submitBtn = By.xpath("//button[@type='submit']");
    By searchBox = By.xpath("//input[@type='search']");
    By editBtn = By.xpath("//a[@class='edit']");
    By deleteBtn = By.xpath("//a[@class='delete']");
    By confirmDeleteBtn = By.id("confirmDeleteButton");

    By emptyRow = By.xpath("//td[contains(@class, 'dataTables_empty')]");


    public void clickMenu(String menu) {
        driver.findElement(menuText(menu)).click();
    }

    public void clickAddTask() {
        driver.findElement(addTaskLink).click();
    }

    public void fillTaskForm(Map<String, String> data) {
        driver.findElement(titleInput).sendKeys(data.get("title"));
        
        driver.findElement(descriptionClick).click();
        driver.findElement(descriptionArea).sendKeys(data.get("description"));

        driver.findElement(relatedDropdown).click();
        driver.findElement(dropdownSearch).sendKeys(data.get("related"), Keys.ENTER);
        
        pause(5);
        
        driver.findElement(clientDropdown).click();
        driver.findElement(dropdownSearch).sendKeys(data.get("client"), Keys.ENTER);
        
        driver.findElement(collaboratorDropdown).click();
        driver.findElement(collaboratorInput).sendKeys(data.get("collaborator"), Keys.ENTER);

        driver.findElement(priorityDropdown).click();
        driver.findElement(dropdownSearch).sendKeys(data.get("priority"), Keys.ENTER);

        driver.findElement(labelInput).click();
        driver.findElement(labelInput).sendKeys(data.get("label"), Keys.ENTER);

        driver.findElement(startDateInput).sendKeys(data.get("start_date"), Keys.ENTER);
        driver.findElement(deadlineInput).sendKeys(data.get("deadline"), Keys.ENTER);
        
//        driver.findElement(recurringCheckbox).click();


    }

    public void submitForm() {
        driver.findElement(submitBtn).click();
    }

    public void searchTask(String taskName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(taskName, Keys.ENTER);
        pause(3);
    }

    public void editTask(String newDescription) {
        driver.findElement(editBtn).click();
        driver.findElement(descriptionArea).clear();
        driver.findElement(descriptionArea).sendKeys(newDescription);
        submitForm();
        pause(3);
    }

    public void deleteTask() {
        driver.findElement(deleteBtn).click();
        pause(2);
        driver.findElement(confirmDeleteBtn).click();
    }

    public void deleteAllTasksByName(String name) {
        clickMenu("Tasks");
        pause(1);
        searchTask(name);
        pause(2);

        while (true) {
            if (driver.findElements(emptyRow).size() > 0) break;

            deleteTask();
            searchTask(name);
            pause(2);
        }
    }
}
