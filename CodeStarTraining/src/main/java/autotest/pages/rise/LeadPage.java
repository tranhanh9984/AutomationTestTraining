package autotest.pages.rise;

import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import autocom.common.CommonPage;

public class LeadPage extends CommonPage {

    public LeadPage(WebDriver driver) {
        super(driver); // Gọi constructor cha
    }

    @CacheLookup
    @FindBy(name = "company_name")
    WebElement companyNameInput;

    @CacheLookup
    @FindBy(xpath = "//label[@for='lead_status_id']//following-sibling::div/div")
    WebElement statusDropdown;

    @CacheLookup
    @FindBy(xpath = "//label[@for='lead_source_id']//following-sibling::div/div")
    WebElement sourceDropdown;

    @CacheLookup
    @FindBy(id = "s2id_owner_id")
    WebElement ownerDropdown;

    @FindBy(xpath = "//div[@id='select2-drop']/div/input")
    WebElement dropdownSearch;

    @CacheLookup
    @FindBy(id = "address")
    WebElement addressInput;

    @CacheLookup
    @FindBy(id = "city")
    WebElement cityInput;

    @CacheLookup
    @FindBy(id = "state")
    WebElement stateInput;

    @CacheLookup
    @FindBy(id = "zip")
    WebElement zipInput;

    @CacheLookup
    @FindBy(id = "country")
    WebElement countryInput;

    @CacheLookup
    @FindBy(id = "phone")
    WebElement phoneInput;

    @CacheLookup
    @FindBy(id = "website")
    WebElement websiteInput;

    @CacheLookup
    @FindBy(id = "vat_number")
    WebElement vatNumberInput;

    @CacheLookup
    @FindBy(id = "gst_number")
    WebElement gstNumberInput;

    @CacheLookup
    @FindBy(id = "s2id_currency")
    WebElement currencyDropdown;

    @CacheLookup
    @FindBy(id = "currency_symbol")
    WebElement currencySymbolInput;

    @CacheLookup
    @FindBy(xpath = "//label[text()='Labels']/following-sibling::input")
    WebElement labelInput;

    public void fillClientForm(Map<String, String> data) {
        companyNameInput.sendKeys(data.get("company"));
        fillDroplist(statusDropdown, data.get("status"));
        fillDroplist(ownerDropdown, data.get("owner"));
        fillDroplist(sourceDropdown, data.get("source"));

        addressInput.sendKeys(data.get("address"));
        cityInput.sendKeys(data.get("city"));
        stateInput.sendKeys(data.get("state"));
        zipInput.sendKeys(data.get("zip"));
        countryInput.sendKeys(data.get("country"));
        phoneInput.sendKeys(data.get("phone"));
        websiteInput.sendKeys(data.get("website"));
        vatNumberInput.sendKeys(data.get("vat"));
        gstNumberInput.sendKeys(data.get("gst"));

        fillDroplist(currencyDropdown, data.get("currency"));
        currencySymbolInput.sendKeys(data.get("symbol"));
        fillMultiDroplist(labelInput, data.get("label"));

        shortPause();
    }

    public void editClient(String newAddress) {
        clickEditBtn();
        addressInput.clear();
        addressInput.sendKeys(newAddress);
        submitForm();
    }
}
