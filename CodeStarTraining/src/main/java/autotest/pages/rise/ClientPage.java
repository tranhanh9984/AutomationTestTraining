package autotest.pages.rise;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonPage;

public class ClientPage extends CommonPage {

    public ClientPage(WebDriver driver) {
        this.driver = driver;
    }

    By menuText(String text) {
        return By.xpath("//span[@class='menu-text ' and text()='" + text + "']");
    }
    By menuClient = By.xpath("id(\"client-tabs\")/li[2]/a");
    
    By addClientLink = By.linkText("Add client");
    
    By companyNameInput = By.name("company_name");
    
    By ownerDropdown = By.id("s2id_owner_id");
    By dropdownSearch = By.xpath("//div[@id='select2-drop']/div/input");
    
    By addressInput = By.id("address");
    By cityInput = By.id("city");
    By stateInput = By.id("state");
    By zipInput = By.id("zip");
    By countryInput = By.id("country");
    By phoneInput = By.id("phone");
    By websiteInput = By.id("website");
    By vatNumberInput = By.id("vat_number");
    By gstNumberInput = By.id("gst_number");

    By groupDropdown = By.id("s2id_group_ids");
    By groupInput = By.xpath("//div[@id=\"s2id_group_ids\"]/ul/li/input");

    By currencyDropdown = By.id("s2id_currency");
    By currencyInput = By.xpath("//div[@id=\"select2-drop\"]/div/input");

    By currencySymbolInput = By.id("currency_symbol");

    By labelDropdown = By.id("s2id_client_labels");
    By labelInput = By.xpath("//div[@id='s2id_client_labels']/ul/li/input");

    By disableOnlineCheckbox = By.xpath("//input[@type='checkbox']");
//
//    By searchInput = By.xpath("//div[@id=\"client-table_filter\"]/label/input");

    By submitBtn = By.xpath("//button[@type='submit']");
    By searchBox = By.xpath("//input[@type='search']");
    By editBtn = By.xpath("//a[@class='edit']");
    By deleteBtn = By.xpath("//a[@class='delete']");
    By confirmDeleteBtn = By.id("confirmDeleteButton");

    By emptyRow = By.xpath("//td[contains(@class, 'dataTables_empty')]");
    
    public void clickMenu(String menu) {
        driver.findElement(menuText(menu)).click();
        pause(2);
        driver.findElement(menuClient).click();
    }

    public void clickAddClient() {
        driver.findElement(addClientLink).click();
    }

    public void fillClientForm(Map<String, String> data) {
        driver.findElement(companyNameInput).sendKeys(data.get("company"));

        driver.findElement(ownerDropdown).click();
        driver.findElement(dropdownSearch).sendKeys(data.get("owner"), Keys.ENTER);

        driver.findElement(addressInput).sendKeys(data.get("address"));
        driver.findElement(cityInput).sendKeys(data.get("city"));
        driver.findElement(stateInput).sendKeys(data.get("state"));
        driver.findElement(zipInput).sendKeys(data.get("zip"));
        driver.findElement(countryInput).sendKeys(data.get("country"));
        driver.findElement(phoneInput).sendKeys(data.get("phone"));
        driver.findElement(websiteInput).sendKeys(data.get("website"));
        driver.findElement(vatNumberInput).sendKeys(data.get("vat"));
        driver.findElement(gstNumberInput).sendKeys(data.get("gst"));

        driver.findElement(groupDropdown).click();
        driver.findElement(groupInput).sendKeys(data.get("group"), Keys.ENTER);

        driver.findElement(currencyDropdown).click();
        driver.findElement(dropdownSearch).sendKeys(data.get("currency"), Keys.ENTER);

        driver.findElement(currencySymbolInput).sendKeys(data.get("symbol"));

        driver.findElement(labelDropdown).click();
        driver.findElement(labelInput).sendKeys(data.get("label"), Keys.ENTER);

        driver.findElement(disableOnlineCheckbox).click(); // tuỳ chỉnh nếu cần

        pause(1);
    }

    public void submitForm() {
        driver.findElement(submitBtn).click();
    }

    public void searchClient(String clientName) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(clientName, Keys.ENTER);
        pause(3);
    }

    public void editClient(String newAddress) {
        driver.findElement(editBtn).click();
        driver.findElement(addressInput).clear();
        driver.findElement(addressInput).sendKeys(newAddress);
        submitForm();
    }

    public void deleteClient() {
        driver.findElement(deleteBtn).click();
        pause(1);
        driver.findElement(confirmDeleteBtn).click();
        pause(2);
    }
    
    public void deleteAllClientsByName(String name) {
        clickMenu("Clients");
        pause(1);
        searchClient(name);

        while (true) {
            if (driver.findElements(emptyRow).size() > 0) break;
            deleteClient();
            searchClient(name);
            pause(2);
        }
    }

}
