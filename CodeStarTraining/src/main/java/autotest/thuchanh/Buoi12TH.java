package autotest.thuchanh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Buoi12TH extends CommonPage {

	public Buoi12TH() {

		
	}

//	@Test
//	public void textCheckbox()
//	{
//		driver.findElement(By.xpath("//button[@class='rct-option rct-option-expand-all']")).click();
//		pause(2);
//		handleCheckbox("//label[@for = 'tree-node-notes']");
//		pause(5);
//		handleCheckbox("//label[@for = 'tree-node-angular']");
//		pause(5);
//		handleCheckbox("//label[@for = 'tree-node-commands']");
//		pause(5);
//		handleCheckbox("//label[@for = 'tree-node-documents']");
//	}

	private void handleRadio() {
		String xpath = "//input[@id = 'yesRadio']";
		boolean isEnabled = driver.findElement(By.xpath(xpath)).isEnabled();
		boolean isSelected = driver.findElement(By.xpath(xpath)).isSelected();
		System.out.println(isSelected);
		if (isEnabled & !isSelected) {
			driver.findElement(By.xpath(xpath + "//following-sibling::label")).click();
		}
		pause(5);
		isSelected = driver.findElement(By.xpath(xpath)).isEnabled();
		System.out.println(isEnabled);

	}

	public void handleCheckbox(String xpath) {
		pause(2);
		boolean isChecked = driver.findElement(By.xpath(xpath + "/input")).isSelected();
		if (!isChecked) {
			driver.findElement(By.xpath(xpath)).click();
		}

		isChecked = driver.findElement(By.xpath(xpath + "/input")).isSelected();

		if (isChecked) {
//			WebElement resultDiv = driver.findElement(By.id("result"));
			List<WebElement> selectedItems = driver.findElements(By.xpath("//div[@id='result']/span"));

			for (WebElement item : selectedItems) {
				System.out.print(item.getText() + " ");
			}
		}
		System.out.println();

	}

	@FindBy(xpath = "//div[@class='main-search-input-item user-chosen-select-container'][.//span[contains(text(),'Select a Country')]]//input")
	@CacheLookup
	WebElement dropdownSearch;

	@FindBy(xpath = "//div[@class='main-search-input-item user-chosen-select-container'][.//span[contains(text(),'Select a Country')]]")
	@CacheLookup
	WebElement country;
	
	@FindBy(xpath = "//div[@class='main-search-input-item user-chosen-select-container']//a[contains(@class,'chosen-single')]/span")
	@CacheLookup
	WebElement selectedValue;

	public void handleDroplistCountry() {
		country.click();
		dropdownSearch.sendKeys("Vietnam", Keys.ENTER);
		pause(5);

		String selectedCountry = selectedValue.getText();

		Assert.assertEquals(selectedCountry, "Vietnam", "Dropdown selection failed.");

		if (selectedCountry.equalsIgnoreCase("Vietnam")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		pause(3);

	}

	public void handleDroplistCategory() {
		pause(5);
		By dropdownSearch = By.xpath(
				"//div[@class='main-search-input-item user-chosen-select-container'][.//span[contains(text(),'Select a Category')]]//input");
		By country = By.xpath(
				"//div[@class='main-search-input-item user-chosen-select-container'][.//span[contains(text(),'Select a Category')]]");
		driver.findElement(country).click();
		driver.findElement(dropdownSearch).sendKeys("Shops", Keys.ENTER);
		pause(5);

		By selectedValue = By.xpath(
				"//div[@class='main-search-input-item user-chosen-select-container']//a[contains(@class,'chosen-single')]/span");
		String selectedCountry = driver.findElement(selectedValue).getText();

		if (selectedCountry.equalsIgnoreCase("Shops")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}

		pause(3);

	}

	@Test
	public void testDroplist() {
		handleDroplistCountry();
		handleDroplistCategory();
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html",
				KeywordConstant.BROWSER);
		PageFactory.initElements(driver, this);

	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);

	}

}
