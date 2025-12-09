package autotest.thuchanh;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class BTVNbuoi8 extends CommonPage {

	
	@Test
	public void loginsuccess() {
		
		System.out.println("Truoc khi clear");
		
        driver.findElement(By.id("name")).sendKeys("test@example.com");
		driver.findElement(By.id("address")).sendKeys("Admin123");
		driver.findElement(By.name("email")).sendKeys("dinhlan@gmail.com");
		driver.findElement(By.name("password")).sendKeys("039029302");

		
//		driver.findElement(By.xpath("//button[@value = 'Submit']")).click();

		driver.findElement(By.cssSelector("#login-form > button:nth-child(15)")).click();

		
//		driver.findElement(By.linkText("Sign up")).click();
//	driver.findElement(By.partialLinkText("Sign up")).click();
//		driver.findElement(By.cssSelector("#email")).clear();
//		driver.findElement(By.xpath("//input[@id='email']")).clear();
//		driver.findElement(By.tagName("button")).clear();


		
		System.out.println("Sau khi clear text");
		
		pause(15);		
	}
	
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://automationfc.github.io/basic-form/index.html", KeywordConstant.BROWSER);
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}
	
}

