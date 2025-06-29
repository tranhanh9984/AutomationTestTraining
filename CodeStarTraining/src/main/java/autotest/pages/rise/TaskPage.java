package autotest.pages.rise;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import autocom.common.CommonPage;

public class TaskPage extends CommonPage {

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "title")
    @CacheLookup
    WebElement titleInput;

    @FindBy(id = "description")
    @CacheLookup
    WebElement descriptionClick;

    @FindBy(className = "note-editable")
    @CacheLookup
    WebElement descriptionArea;

    @FindBy(xpath = "//div[@id='s2id_task-context']")
    @CacheLookup
    WebElement relatedDropdown;

    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    @CacheLookup
    WebElement dropdownSearch;

    @FindBy(id = "s2id_client_id")
    @CacheLookup
    WebElement clientDropdown;

    @FindBy(id = "s2id_collaborators")
    @CacheLookup
    WebElement collaboratorDropdown;

    @FindBy(xpath = "//div[@id='s2id_collaborators']/ul/li/input")
    @CacheLookup
    WebElement collaboratorInput;

    @FindBy(id = "s2id_priority_id")
    @CacheLookup
    WebElement priorityDropdown;

    @FindBy(xpath = "//label[text()='Labels']/following-sibling::input")
    @CacheLookup
    WebElement labelInput;

    @FindBy(id = "start_date")
    @CacheLookup
    WebElement startDateInput;

    @FindBy(id = "deadline")
    @CacheLookup
    WebElement deadlineInput;

    @FindBy(xpath = "//input[@type='checkbox']")
    @CacheLookup
    WebElement recurringCheckbox;

    public void fillTaskForm(Map<String, String> data) {
        titleInput.sendKeys(data.get("title"));

        descriptionClick.click();
        descriptionArea.sendKeys(data.get("description"));

        relatedDropdown.click();
        dropdownSearch.sendKeys(data.get("related"), Keys.ENTER);
        pause(5);

        clientDropdown.click();
        dropdownSearch.sendKeys(data.get("client"), Keys.ENTER);

        collaboratorDropdown.click();
        collaboratorInput.sendKeys(data.get("collaborator"), Keys.ENTER);

        priorityDropdown.click();
        dropdownSearch.sendKeys(data.get("priority"), Keys.ENTER);

        labelInput.click();
        labelInput.sendKeys(data.get("label"), Keys.ENTER);

        startDateInput.sendKeys(data.get("start_date"), Keys.ENTER);
        deadlineInput.sendKeys(data.get("deadline"), Keys.ENTER);

    }

    public void editTask(String newDescription) {
        clickEditBtn();
        descriptionArea.clear();
        descriptionArea.sendKeys(newDescription);
        submitForm();
        pause(3);
    }
}
