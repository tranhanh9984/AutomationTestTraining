package autotest.page;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import static autocom.common.Locator.*;
import autocom.common.CommonPage;

public class ClientPage extends CommonPage {

	public ClientPage(WebDriver driver) {
		this.driver = driver;
	}

	// Khai báo biến By private ở đầu class
	private By linkProjectMenu = By.linkText("Clients");
	private By btnAddClient = By.xpath("//a[@title='Add client']");
	private By btnSubmit = By.xpath("//button[@type='submit' and normalize-space()='Save']");
	private By tabClients = By.xpath("//ul[@id='client-tabs']//a[contains(text(), 'Clients')]");

	private By inputSearchClient = By.xpath("//div[@id='client-table_filter']//input");
	private By tableRows = By.xpath("//table[@id='client-table']/tbody/tr");

	private By radioTypePerson = By.xpath("//input[@id='type_person']");
	private By inputCompanyName = By.id("company_name");
	private By ownerDropdown = By.xpath("//div[@class='container-fluid']//label[@for='owner_id']//following::div[1]");
	private By inputOwnerSearch = By.xpath("//div[@class='select2-search']//label[contains(text(),'Owner')]//following::input");

	private By inputAddress = By.id("address");
	private By inputCity = By.id("city");
	private By inputState = By.id("state");
	private By inputZip = By.id("zip");
	private By inputCountry = By.id("country");

	private By clientGroupsDropdown = By.xpath("//label[@for='groups']//following::div[1]/div");
	private By inputClientGroups = By.xpath("//label[@for='groups']//following::div[1]//ul//input");

	private By currencyDropdown = By.xpath("//label[@for='currency']//following::div[1]/div");
	private By inputCurrencySearch = By.xpath("//div[@class='select2-search']//label[contains(text(),'Currency')]//following::input");

	private By checkboxDisableOnlinePayment = By.id("disable_online_payment");

	private By inputCurrencySymbol = By.id("currency_symbol");
	private By labelsDropdown = By.xpath("//label[@for='client_labels']//following::div[1]/div");
	private By inputLabel = By.xpath("//ul[@class='select2-choices']//label[contains(text(),'Labels')]//following::input");

	private By btnEditClient = By.cssSelector("[title='Edit client']");
	private By btnDeleteClient = By.cssSelector("[title='Delete client']");
	private By btnConfirmDelete = By.id("confirmDeleteButton");

	private By alertBox = By.className("app-alert");
	private By alertMessage = By.className("app-alert-message");
	private By firstRowSecondColumnLink = By.xpath("./td[2]/a");
	private By tableEmpty = By.xpath("//td[@class='dataTables_empty' and text()='No record found.']");
	
	// Các method dùng biến By này
	public void clickProjectMenu() {
	    driver.findElement(linkProjectMenu).click();
	}

	public void clickAddClient() {
	    driver.findElement(btnAddClient).click();
	}

	public void clickTabClients() {
	    driver.findElement(tabClients).click();
	}

	public void clickEditButton(String name) {
	    List<WebElement> rows = driver.findElements(tableRows);
	    rows.get(0).findElement(btnEditClient).click();
	}
	
	public void searchClient(String name) {
		driver.findElement(inputSearchClient).clear();
		driver.findElement(inputSearchClient).sendKeys(name);
	    driver.findElement(inputSearchClient).sendKeys(Keys.ENTER);
	    pause(2);
	}

	public void verifyAddedClient(String name) {
		searchClient(name);
	    pause(2);
	    List<WebElement> rows = driver.findElements(tableRows);
	    Assert.assertTrue(rows.size() > 0, "Không có client nào trong bảng!");
	    String actualText = rows.get(0).findElement(firstRowSecondColumnLink).getText();
	    Assert.assertTrue(actualText.contains(name), "Không tìm thấy nội dung mong muốn!");
	}

	public void verifyMessage(String message) {
	    WebElement element = driver.findElement(alertBox);
	    Assert.assertTrue(element.isDisplayed(), "Element should be visible on the page");
	    Assert.assertTrue(driver.findElement(alertMessage).getText().contentEquals(message),  "Message text does not match");
	}

	public void addClients(HashMap<String, String> client) {
	    if ("person".equals(client.get("type"))) {
	        driver.findElement(radioTypePerson).click();
	    }
	    driver.findElement(inputCompanyName).sendKeys(client.get("name"));
	    driver.findElement(ownerDropdown).click();
	    driver.findElement(inputOwnerSearch).sendKeys(client.get("owner"));
	    driver.findElement(inputOwnerSearch).sendKeys(Keys.ENTER);
	    driver.findElement(inputAddress).sendKeys(client.get("address"));
	    driver.findElement(inputCity).sendKeys(client.get("city"));
	    driver.findElement(inputState).sendKeys(client.get("state"));
	    driver.findElement(inputZip).sendKeys(client.get("zip"));
	    driver.findElement(inputCountry).sendKeys(client.get("country"));
	    driver.findElement(clientGroupsDropdown).click();
	    driver.findElement(inputClientGroups).sendKeys(client.get("clientGroups"));
	    driver.findElement(inputClientGroups).sendKeys(Keys.ENTER);
	    driver.findElement(currencyDropdown).click();
	    driver.findElement(inputCurrencySearch).sendKeys(client.get("currency"));
	    driver.findElement(inputCurrencySearch).sendKeys(Keys.ENTER);
	    driver.findElement(checkboxDisableOnlinePayment).click();
	    clickSubmit();
	}

	public void editClients(HashMap<String, String> client) {
	    driver.findElement(inputCurrencySymbol).sendKeys(client.get("currencySymbol"));
	    driver.findElement(labelsDropdown).click();
	    driver.findElement(inputLabel).sendKeys(client.get("label"));
	    driver.findElement(inputLabel).sendKeys(Keys.ENTER);
	    clickSubmit();
	}

	public void deleteClient(String name) {
	    List<WebElement> rows = driver.findElements(tableRows);
	    rows.get(0).findElement(btnDeleteClient).click();
	    pause(2);
	    driver.findElement(btnConfirmDelete).click();
	}
	
	public void deleteAllClient(String name) {
		searchClient(name);
		
	    List<WebElement> rows = driver.findElements(tableRows);
	    if (isTableEmpty()) {
	    	return;
	    }
	    while (rows.size() > 0) {
	        rows.get(0).findElement(btnDeleteClient).click();
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
