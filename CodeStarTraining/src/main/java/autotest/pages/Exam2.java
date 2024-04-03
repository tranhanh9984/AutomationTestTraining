package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import autocom.common.CommonPage;

public class Exam2 extends CommonPage {
	
	WebDriver driver;
	
	@BeforeTest
	public void startPage(){
		driver = this.startBrower("https://selectorshub.com/xpath-practice-page/", "chrome");
	}
	
	@AfterTest
	public void closePage() throws InterruptedException{
//		Thread.sleep(2);
		this.closeBrowser(driver);
	}
	
	@Test
	public void testXpath() throws InterruptedException {
//		Thread.sleep(20);
		WebElement txtName = driver.findElement(By.name("email"));
		txtName.click();
		pause(2);
		txtName.sendKeys("Tran Mai Hanh");
		pause(5000);
		String text =  txtName.getAttribute("value");
		Assert.assertEquals("Tran Mai Hanh", text);
//		
//		WebElement txtPass = driver.findElement(By.name("Password"));
//		txtPass.click();
//		txtPass.sendKeys("Password");
//		text =  txtPass.getText();
//		Assert.assertEquals("Password", text);
//		
//		WebElement txtCompany = driver.findElement(By.name("company"));
//		txtCompany.click();
//		txtCompany.sendKeys("Code Star");
//		text =  txtCompany.getText();
//		Assert.assertEquals("Code Star", text);
//
//		driver.findElement(By.id(""));
//		driver.findElement(By.id(""));
//		driver.findElement(By.id(""));
//		driver.findElement(By.id(""));
//		driver.findElement(By.id(""));
//		driver.findElement(By.id(""));
//		driver.findElement(By.id(""));
	}
}
