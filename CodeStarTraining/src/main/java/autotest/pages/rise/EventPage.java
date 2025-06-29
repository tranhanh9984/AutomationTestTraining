package autotest.pages.rise;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class EventPage extends CommonPage {

    public EventPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "title")
    @CacheLookup
    WebElement titleInput;

    @FindBy(id = "start_date")
    @CacheLookup
    WebElement startDateInput;

    @FindBy(id = "start_time")
    @CacheLookup
    WebElement startTimeInput;

    @FindBy(id = "end_date")
    @CacheLookup
    WebElement endDateInput;

    @FindBy(id = "end_time")
    @CacheLookup
    WebElement endTimeInput;

    @FindBy(id = "location")
    @CacheLookup
    WebElement locationInput;

    @FindBy(xpath = "//label[text()='Labels']/following-sibling::input")
    @CacheLookup
    WebElement labelInput;

    @FindBy(id = "s2id_clients_dropdown")
    @CacheLookup
    WebElement clientInput;

    @FindBy(xpath = "//input[@type='checkbox' and @id='only_me']")
    @CacheLookup
    WebElement shareWith;

    @FindBy(xpath = "//a[contains(., 'Ha Anh')]")
    @CacheLookup
    WebElement event;

    @FindBy(xpath = "//a[contains(., 'Edit')]")
    @CacheLookup
    WebElement editEventBtn;

    @FindBy(xpath = "//a[contains(., 'Delete')]")
    @CacheLookup
    WebElement deleteEventBtn;

    @FindBy(xpath = "//button[contains(., 'Yes')]")
    @CacheLookup
    WebElement deleteConfirmBtn;

    public void fillEventForm(Map<String, String> data) {
        titleInput.sendKeys(data.get("title"));
        fillDescription(data.get("description"));

        fillStartDate(data.get("start_date"));
        startTimeInput.sendKeys(data.get("start_time"));
        fillEndDate(data.get("end_date"));
        endTimeInput.sendKeys(data.get("end_time"));

        locationInput.sendKeys(data.get("location"));

        fillMultiDroplist(labelInput, data.get("label"));
        fillDroplist(clientInput, data.get("client"));

        shareWith.click();

        pause(2);
    }

    public void clickEvent() {
        event.click();
    }

    public void editEvent(String newLocation) {
        clickEvent();
        shortPause();
        editEventBtn.click();
        shortPause();
        locationInput.sendKeys(newLocation);
        submitForm();
        pause(5);
    }

    public void deleteEvent() {
        clickEvent();
        shortPause();
        deleteEventBtn.click();
        shortPause();
        deleteConfirmBtn.click();
    }
}
