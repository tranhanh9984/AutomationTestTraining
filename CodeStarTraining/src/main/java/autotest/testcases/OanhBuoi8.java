package autotest.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import autocom.common.CommonBase;

public class OanhBuoi8 extends CommonBase {

	public OanhBuoi8() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	public void startPage() {
		this.startBrower("https://selectorshub.com/xpath-practice-page/", "chrome");

	}
	@Test
	public void enterLogin() {
//		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("comrang7@gmaiil.com");
//		driver.findElement(By.id("pass")).sendKeys("12345678");
//		driver.findElement(By.name("company")).sendKeys("Kimei Global");
//		driver.findElement(By.name("mobile number")).sendKeys("0868799867");
//		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
//		pause(5000);
//		//enter name
//		driver.findElement(By.xpath("//label[contains(text(),'Can you enter name')]/*[name()='svg']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='First Enter name']")).sendKeys("oanh");
//		pause(5000);
//		
//		// drop button
//		driver.findElement(By.xpath("//button[text()='Checkout here']")).click();
//		driver.findElement(By.xpath("//a[text()='Join Training']")).click();
//		pause(5000);
		// select button
		driver.findElement(By.id("cars")).click();
		driver.findElement(By.xpath("//option[@value='saab']")).click();
		pause(3000);
		driver.findElement(By.name("the_date")).sendKeys("12/23/2023");
		pause(7000);
		
	}
	@AfterClass
	public void closePage() {
		this.closeBrowser();
	}
	
}
