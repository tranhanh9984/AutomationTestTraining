package autotest.pages.rise;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class ClientPage extends CommonPage {

	public ClientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "id(\"client-tabs\")/li[2]/a")
	@CacheLookup
	WebElement menuClient;

	@FindBy(name = "company_name")
	@CacheLookup
	WebElement companyNameInput;

	@FindBy(id = "s2id_owner_id")
	@CacheLookup
	WebElement ownerDropdown;

	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
	@CacheLookup
	WebElement dropdownSearch;

	@FindBy(id = "address")
	@CacheLookup
	WebElement addressInput;

	@FindBy(id = "city")
	@CacheLookup
	WebElement cityInput;

	@FindBy(id = "state")
	@CacheLookup
	WebElement stateInput;

	@FindBy(id = "zip")
	@CacheLookup
	WebElement zipInput;

	@FindBy(id = "country")
	@CacheLookup
	WebElement countryInput;

	@FindBy(id = "phone")
	@CacheLookup
	WebElement phoneInput;

	@FindBy(id = "website")
	@CacheLookup
	WebElement websiteInput;

	@FindBy(id = "vat_number")
	@CacheLookup
	WebElement vatNumberInput;

	@FindBy(id = "gst_number")
	@CacheLookup
	WebElement gstNumberInput;

	@FindBy(id = "s2id_group_ids")
	@CacheLookup
	WebElement groupDropdown;

	@FindBy(xpath = "//div[@id='s2id_group_ids']/ul/li/input")
	@CacheLookup
	WebElement groupInput;

	@FindBy(id = "s2id_currency")
	@CacheLookup
	WebElement currencyDropdown;

	@FindBy(xpath = "//div[@id='select2-drop']/div/input")
	@CacheLookup
	WebElement currencyInput;

	@FindBy(id = "currency_symbol")
	@CacheLookup
	WebElement currencySymbolInput;

	@FindBy(id = "s2id_client_labels")
	@CacheLookup
	WebElement labelDropdown;

	@FindBy(xpath = "//div[@id='s2id_client_labels']/ul/li/input")
	@CacheLookup
	WebElement labelInput;

	@FindBy(xpath = "//input[@type='checkbox']")
	@CacheLookup
	WebElement disableOnlineCheckbox;

	public void fillClientForm(Map<String, String> data) {
		companyNameInput.sendKeys(data.get("company"));

		ownerDropdown.click();
		dropdownSearch.sendKeys(data.get("owner"), Keys.ENTER);

		addressInput.sendKeys(data.get("address"));
		cityInput.sendKeys(data.get("city"));
		stateInput.sendKeys(data.get("state"));
		zipInput.sendKeys(data.get("zip"));
		countryInput.sendKeys(data.get("country"));
		phoneInput.sendKeys(data.get("phone"));
		websiteInput.sendKeys(data.get("website"));
		vatNumberInput.sendKeys(data.get("vat"));
		gstNumberInput.sendKeys(data.get("gst"));

		groupDropdown.click();
		groupInput.sendKeys(data.get("group"), Keys.ENTER);

		currencyDropdown.click();
		dropdownSearch.sendKeys(data.get("currency"), Keys.ENTER);

		currencySymbolInput.sendKeys(data.get("symbol"));

		labelDropdown.click();
		labelInput.sendKeys(data.get("label"), Keys.ENTER);

		disableOnlineCheckbox.click();

		shortPause();
	}

	public void editClient(String newAddress) {
		clickEditBtn();
		addressInput.clear();
		addressInput.sendKeys(newAddress);
		submitForm();
	}

	public void clickClient() {
		clickMenu("Clients");
		pause(2);
		menuClient.click();
	}
}
