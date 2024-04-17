package autocom.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class TC0_Exam2 extends CommonPage{
WebDriver driver;
	
	@BeforeTest
	public void startPage(){
		driver = this.startBrower("https://selectorshub.com/xpath-practice-page/", "chrome");
	}
	
	@AfterTest
	public void closePage() throws InterruptedException{
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
	}

}
