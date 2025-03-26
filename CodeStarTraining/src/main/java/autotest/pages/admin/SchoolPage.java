package autotest.pages.admin;

import autocom.common.CommonPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SchoolPage extends CommonPage {

	public SchoolPage() {
		super();
	}
	public void clickMenu() {
		driver.findElement(By.partialLinkText("Trường học")).click();	
	}
	public void creat_School(String name, String email, String phone, String tagline, String address, String code) {
		driver.findElement(By.id("school_name")).sendKeys(name);
			WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
			uploadElement.sendKeys("C:\\Users\\Admin\\123.png"); 

			
		
		driver.findElement(By.id("school_support_email")).sendKeys(email);
		driver.findElement(By.id("school_support_phone")).sendKeys(phone);
		driver.findElement(By.id("school_tagline")).sendKeys(tagline);
		driver.findElement(By.id("school_address")).sendKeys(address);
		driver.findElement(By.id("school_code_prefix")).sendKeys(code);		
		
	}
	public void create_Admin(String firstName, String lastName, String contact, String email) {
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1000);");

	    driver.findElement(By.id("admin_first_name")).sendKeys(firstName);
	    driver.findElement(By.id("admin_last_name")).sendKeys(lastName);
	    driver.findElement(By.id("admin_contact")).sendKeys(contact);
	    driver.findElement(By.id("admin_email")).sendKeys(email);

	   
		WebElement adminImageUpload = driver.findElement(By.name("admin_image"));
	    adminImageUpload.sendKeys("C:\\Users\\Admin\\123.png");
	    	
	}
	public void submit() {
		driver.findElement(By.id("create-btn")).click();
		
	}
	public void edit(String email) {
 	    WebElement row = driver.findElement(By.xpath("//td//small[normalize-space(text())='" + email + "']/ancestor::tr"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(row.findElement(By.xpath(".//button[contains(@id, 'dropdownMenuButton')]"))));
		menuButton.click();

		WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(row.findElement(By.xpath(".//a[contains(text(),'Chỉnh sửa')]"))));
		editButton.click();

	}
	public void update(String tag) {
	    WebDriverWait waitt = new WebDriverWait(driver, 10);

 	    WebElement taglineInput = waitt.until(ExpectedConditions.visibilityOfElementLocated(By.id("edit_school_tagline")));
	    taglineInput.clear();
	    taglineInput.sendKeys(tag);
//	    WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Gửi']"));
//
//	    submitButton.click();

		 
 	}

	
}
