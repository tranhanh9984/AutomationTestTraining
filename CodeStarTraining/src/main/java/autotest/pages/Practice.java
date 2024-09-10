package autotest.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class Practice extends CommonPage {
	String btnSubmit = "//button[contains(text(),'Submit')]";
	String txtEmail = "//input[@placeholder='Enter email']";
	String txtPassword = "//input[@placeholder='Enter Password']";
	String txtCompany = "//div[@class='element-companyId']//input[@placeholder='Enter your company']";
	String txtMobileNumber = "//div[@class='element-companyId']//input[@placeholder='Enter your mobile number']";
	String datePicker = "//input[@type='date']";
	String optCar = "//select[@id='cars']/option[contains(text(),'Audi')]";
	String checkbox = "//table[@id='resultTable']//following::input[@id='ohrmList_chkSelectRecord_25']";
	String btnCheckout = "//button[contains(text(),'Checkout here')]";
	String optJoinTraining = "//a[contains(text(),'Join Training')]";
	
	@BeforeTest
	public void StartPage() {
		this.startBrower("https://selectorshub.com/xpath-practice-page/", "chrome");
		pause(50);
	}
	
	public void TC1() {
		// Input all textboxes
		driver.findElement(By.xpath(txtEmail)).sendKeys("khoaminhtran1999@gmail.com");
		driver.findElement(By.xpath(txtPassword)).sendKeys("abc@123");
		driver.findElement(By.xpath(txtCompany)).sendKeys("Company Name");
		driver.findElement(By.xpath(txtMobileNumber)).sendKeys("0123456789");
		driver.findElement(By.xpath(btnSubmit)).click();
		pause(1000);
	}

	public void TC2() {
		// Chọn Audi trong Choose a car
		driver.findElement(By.id("cars")).click();
		driver.findElement(By.xpath(optCar)).click();
		Assert.assertEquals(driver.findElement(By.xpath(optCar)).getText(), "Audi");
	}

	public void TC3() {
		// Tick vào Checkbox
		new Actions(driver).moveToElement(driver.findElement(By.xpath(checkbox))).perform();
		driver.findElement(By.xpath(checkbox)).click();
	}

	public void TC4() {
		// Chọn Join Training trong Checkout Here button
		driver.findElement(By.xpath(btnCheckout)).click();
		driver.findElement(By.xpath(optJoinTraining)).click();
		pause(1000);
		Object[] windowHandles=driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandles[1]);
		assertEquals("Bootcamp - SelectorsHub",driver.getTitle());
	}
	
	@Test
	public void TC5() {
		//Pick a date
		//JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		//((JavascriptExecutor) driver).executeScript(
	            //"arguments[0].scrollIntoView();", driver.findElement(By.xpath(datePicker)));
		driver.findElement(By.xpath(datePicker)).sendKeys("07");
		driver.findElement(By.xpath(datePicker)).sendKeys("17");
		driver.findElement(By.xpath(datePicker)).sendKeys("1999");
//		driver.findElement(By.xpath(datePicker)).click();
//		driver.findElement(By.xpath(datePicker)).sendKeys(Keys.TAB);
//		driver.findElement(By.xpath(datePicker)).sendKeys(Keys.TAB);
//		driver.findElement(By.xpath(datePicker)).sendKeys(Keys.TAB);
//		driver.findElement(By.xpath(datePicker)).sendKeys(Keys.TAB);
//		driver.findElement(By.xpath(datePicker)).sendKeys(Keys.ENTER);
		pause(1000);
	}
	
	@AfterTest
	public void ClosePage() {
		this.closeBrowser(driver);
	}
}
