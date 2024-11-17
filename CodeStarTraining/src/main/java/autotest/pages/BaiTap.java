package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class BaiTap extends CommonPage {

	String btnSubmit = "//button[@value='Submit']";
	
	//convention
	//text => txtEmail; txtPassword
	//button -> btnSubmit, btn Đangnhap
	//combobox ->cbbAbc
	//label -> lblDesciption
	//select -> sl
	
	////div[contains(@class, 'content block panel') and not(contains(@style, 'none'))]//input[@name = 'company']
	//button[@value = 'Submit']

	public void Testcases1() {
		driver.findElement(By.xpath("//input[@title = 'Email']")).sendKeys("caonv174@gmail.com");
		driver.findElement(By.xpath("//input[@title = 'Password']")).sendKeys("123456789");
		driver.findElement(By.xpath("//div[contains(@class, 'content block panel') and not(contains(@style, 'none'))]//input[@name = 'company']")).sendKeys("0974136888");
		driver.findElement(By.xpath(btnSubmit)).click();
		pause(5000);
	}
	
	
	@Test
	public void pickadate() {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", driver.findElement(By.xpath(btnSubmit)));
		pause(1000);
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].click();", driver.findElement(By.xpath("//input[@type = 'date']")));
//		driver.findElement(By.xpath("//input[@type = 'date']")).sendKeys("123456789");
		pause(5000);
	}
	
	@BeforeTest
	public void startPage() {
		this.startBrower("https://selectorshub.com/xpath-practice-page/", "chrome");
		pause(1000);		
	}
	
	@AfterTest
	public void closePage() {
		this.closeBrowser(driver);
		
	}


}
