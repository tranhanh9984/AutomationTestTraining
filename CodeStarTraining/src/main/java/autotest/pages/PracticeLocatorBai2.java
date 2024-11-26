package autotest.pages;

import org.openqa.selenium.By;
import org.testng.annotations.*;


import autocom.common.CommonBase;

public class PracticeLocatorBai2 extends CommonBase{

	@BeforeTest
	public void startBrowser() {
		this.startBrowser("https://automationfc.github.io/basic-form/index.html", "chrome");

	}
	
	@Test
	public void checkLocator() {
		driver.findElement(By.id("name")).sendKeys("username");
		driver.findElement(By.id("address")).sendKeys("new york, usa");
		driver.findElement(By.id("email")).sendKeys("test@test.test");
		driver.findElement(By.id("password")).sendKeys("123456");
		
		
		// submit
//		driver.findElement(By.xpath("//button[@value='Submit']")).click();
//		System.out.println("Submit form Successfully");
		
		// reset
		driver.findElement(By.xpath("//button[@value='Reset']")).click();
		System.out.println("Reset form Successfully");
		
		pauseBrowser(10);
		System.out.println("Check Locator Successfully");
		
	}
	
	@AfterTest
	public void tearDown() {
		closeBrowser();
		System.out.println("Browser closed successfully.");
	}

}
