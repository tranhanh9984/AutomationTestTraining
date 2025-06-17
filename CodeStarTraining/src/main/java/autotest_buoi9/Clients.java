package autotest_buoi9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.login.LoginPage;

public class Clients extends CommonPage {

	 private LoginPage loginPage;
	 
	@Test
	public void testAddClients() {
//		loginPage.login("admin@demo.com", "riseDemo");
		clickProjectMenu();
		clickAddClient();
		addClients("person", "Bich Lien", "Michael Wood", "Nam Tu Liem", "Ha Noi", "Khong", "10000", "Viet Nam", "Silver", "AMD");
		pause(2);
		clickTabClients();
		verifyAddedClient("Bich Lien");
	}
	
	@Test
	public void testEditClients() {
//		loginPage.login("admin@demo.com", "riseDemo");
		clickProjectMenu();
		clickTabClients();
		
		clickAddClient();
		addClients("person", "Bich Lien", "Michael Wood", "Nam Tu Liem", "Ha Noi", "Khong", "10000", "Viet Nam", "Silver", "AMD");
		pause(5);
		
		clickEditButton("Bich Lien");
		pause(2);
		
		editClients("Đồng", "Potential");
		
		
	}
	
	@Test
	public void testDeleteClients() {
//		loginPage.login("admin@demo.com", "riseDemo");
		clickProjectMenu();
		clickTabClients();
		
		deleteClient("Bich Lien");
		pause(2);
		verifyMessage("The record has been deleted.");
	}
	
	public void clickProjectMenu() {
		driver.findElement(By.linkText("Clients")).click();
		
	}
	
	public void clickAddClient() {
		driver.findElement(By.xpath("//a[@title='Add client']")).click();
	}
	
	public void clickSubmit() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	public void clickTabClients() {
		driver.findElement(By.xpath("//ul[@id='client-tabs']//a[contains(text(), 'Clients')]")).click();
	}
	
	public void clickEditButton(String name) {
		driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(name);
		driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(Keys.ENTER);
		pause(2);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='client-table']/tbody/tr"));
		
		rows.get(0).findElement(By.cssSelector("[title='Edit client'")).click();
	}
	
	public void verifyAddedClient(String name) {
		driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(name);
		driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(Keys.ENTER);
		pause(2);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='client-table']/tbody/tr"));
		Assert.assertTrue(rows.size() > 0, "Không có client nào trong bảng!");
		
		String actualText = rows.get(0).findElement(By.xpath("./td[2]/a")).getText();
		Assert.assertTrue(actualText.contains(name), "Không tìm thấy nội dung mong muốn!");
	}
	
	public void verifyMessage(String message) {
		WebElement element = driver.findElement(By.className("app-alert"));
		Assert.assertTrue(element.isDisplayed(), "Element should be visible on the page");
		Assert.assertTrue(driver.findElement(By.className("app-alert-message")).getText().contentEquals(message),  "Message text does not match");
	}
	
	public void addClients(String type, String name, String owner, String address, String city, String state, String zip, String country, String clientGroups, String currency) {
		if (type.equals("person")) {			
			driver.findElement(By.xpath("//input[@id='type_person']")).click();
		}
		driver.findElement(By.id("company_name")).sendKeys(name);
		driver.findElement(By.xpath("//div[@class='container-fluid']//label[@for='owner_id']//following::div[1]")).click();
		driver.findElement(By.xpath("//div[@class='select2-search']//label[contains(text(),'Owner')]//following::input")).sendKeys(owner);
		driver.findElement(By.xpath("//div[@class='select2-search']//label[contains(text(),'Owner')]//following::input")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.id("city")).sendKeys(city);
		driver.findElement(By.id("state")).sendKeys(state);
		driver.findElement(By.id("zip")).sendKeys(zip);
		driver.findElement(By.id("country")).sendKeys(country);
		
		driver.findElement(By.xpath("//label[@for='groups']//following::div[1]/div")).click();
		driver.findElement(By.xpath("//label[@for='groups']//following::div[1]//ul//input")).sendKeys(clientGroups);
		driver.findElement(By.xpath("//label[@for='groups']//following::div[1]//ul//input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//label[@for='currency']//following::div[1]/div")).click();
		driver.findElement(By.xpath("//div[@class='select2-search']//label[contains(text(),'Currency')]//following::input")).sendKeys(currency);
		driver.findElement(By.xpath("//div[@class='select2-search']//label[contains(text(),'Currency')]//following::input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("disable_online_payment")).click();
		clickSubmit();
	}
	
	public void editClients(String currencySymbol, String label) {
		driver.findElement(By.id("currency_symbol")).sendKeys(currencySymbol);
		driver.findElement(By.xpath("//label[@for='client_labels']//following::div[1]/div")).click();
		driver.findElement(By.xpath("//ul[@class='select2-choices']//label[contains(text(),'Labels')]//following::input")).sendKeys(label);
		driver.findElement(By.xpath("//ul[@class='select2-choices']//label[contains(text(),'Labels')]//following::input")).sendKeys(Keys.ENTER);
		clickSubmit();
	}
	
	public void deleteClient(String name) {
		driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(name);
		driver.findElement(By.xpath("//div[@id='client-table_filter']//input")).sendKeys(Keys.ENTER);
		pause(2);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='client-table']/tbody/tr"));
		
		rows.get(0).findElement(By.cssSelector("[title='Delete client'")).click();
		
		pause(2);
		driver.findElement(By.id("confirmDeleteButton")).click();
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		loginPage = new LoginPage(driver);
		loginPage.login("admin@demo.com", "riseDemo");
		
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}

}
