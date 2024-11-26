package autotest.pages;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import autocom.common.CommonBase;

public class PageLogin extends CommonBase {
	
	

	public PageLogin() {
		// TODO Auto-generated constructor stub
	}
	

	
	@BeforeTest
	public void startBrowser() {
		this.startBrowser("https://uat-invoice.kaike.vn/login","chrome");
		
	}
	
	@Test
	public void loginValidAccount() {
		
		
		driver.findElement(By.id("email")).sendKeys("0312303803-999");
		driver.findElement(By.id("password")).sendKeys("0312303803-999");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		pauseBrowser(10);
		System.out.println("Login Successfully");
		
		
	}
	
	
	
	@AfterTest
	public void tearDown() {
		closeBrowser();
		System.out.println("Browser closed successfully.");
	}

}
