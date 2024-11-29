package autotest.pages;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.testng.annotations.*;

import autocom.common.CommonBase;

public class PracticeLocatorDay8 extends CommonBase {

	public PracticeLocatorDay8() {
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void startBrowser() {
		this.startBrowser("https://selectorshub.com/xpath-practice-page/", "chrome");

	}

	@Test
	public void checkLocator() {

		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.test");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("123456");
		driver.findElement(By.xpath("(//input[@name='company'])[1]")).sendKeys("company test");
		driver.findElement(By.xpath("(//input[@name='mobile number'])[1]")).sendKeys("0987654321");

		// Submit btn
		driver.findElement(By.xpath("//button[@value = 'Submit']")).click();

		// First Crush
		driver.findElement(By.xpath("//input[@id = 'inp_val']")).sendKeys("First Crush");

		// Useful Links for learning
		driver.findElement(By.xpath("//button[text()='Checkout here']")).click();
		driver.findElement(By.xpath("//a[text()='SHub Youtube Channel']")).click();
		System.out.println("Select option in drop-down list successfully");

		// pick a date
		driver.findElement(By.xpath("//input[@name='the_date']")).sendKeys("11/26/2024");
		System.out.println("Select date in calendar successfully");

		// Users Table
		driver.findElement(By.xpath("//input[@value = '25']")).click();
		System.out.println("Select checkbox in user table successfully");

		// Click To Open Window Alert
		driver.findElement(By.xpath("//button[@onClick = 'windowAlertFunction()']")).click();
		Alert alert = driver.switchTo().alert();
		// Nhấn nút OK
		alert.accept();
		System.out.println("Click OK in Window Alert Successfully");
		
		/* Nhấn nút Cancel
		 * Alert alert = driver.switchTo().alert();
		 * alert.dismiss();
		 * 
		 */
		
		

		pauseBrowser(10);
		System.out.println("Check Locator Successfully");

	}

	@AfterTest
	public void tearDown() {
		closeBrowser();
		System.out.println("Browser closed successfully.");
	}

}
