package autotest.pages.rise;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import autocom.common.CommonPage;

public class ProjectPage extends CommonPage {

	public ProjectPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "title")
	@CacheLookup
	WebElement titleInput;

	@FindBy(id = "deadline")
	@CacheLookup
	WebElement deadlineInput;

	@FindBy(id = "price")
	@CacheLookup
	WebElement priceInput;

	@FindBy(xpath = "//label[text()='Labels']/following-sibling::input")
	@CacheLookup
	WebElement labelInput;

	@FindBy(id = "start_date")
	@CacheLookup
	WebElement startDateInput;

	public void fillProjectForm(Map<String, String> data) {
		titleInput.sendKeys(data.get("title"));
		fillDescription(data.get("description"));
		deadlineInput.sendKeys(data.get("deadline"));
		priceInput.sendKeys(data.get("price"));
		fillStartDate(data.get("start_date"));
		fillMultiDroplist(labelInput, data.get("label"));
		pause(2);
	}

	public void editProject(String newPrice) {
		clickEditBtn();
		priceInput.clear();
		priceInput.sendKeys(newPrice);
		submitForm();
		pause(5);
	}
}
