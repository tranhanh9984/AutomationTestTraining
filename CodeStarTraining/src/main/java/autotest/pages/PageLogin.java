package autotest.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	@Test
	public void loginInvalidAccount() {
		
		
		driver.findElement(By.id("email")).sendKeys("0312303803-999");
		driver.findElement(By.id("password")).sendKeys("0312303803-998");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		pauseBrowser(10);
		System.out.println("Login Unsuccessfully");
		
		
	}
	
	@Test
	public void clickFortgetPassword() {
		driver.findElement(By.xpath("//a[@class='forgot']")).click();
		WebElement forgotPwdPopup = driver.findElement(By.xpath("//span[@id='pr_id_3-label']"));
		if(forgotPwdPopup.isDisplayed()) {
			System.out.println("open Forgot Password popup successfully ");
			System.out.println(forgotPwdPopup.getText());
			
		} else {
			System.out.println("Cannot open Forgot Password popup successfully ");
		}
		
	}
	
	
	@AfterTest
	public void tearDown() {
		closeBrowser();
		System.out.println("Browser closed successfully.");
	}

}
