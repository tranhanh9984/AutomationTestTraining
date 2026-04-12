package autotest.buoi8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class Practice1 extends CommonPage {

	WebDriver dr;
	
	@Test
	public void practiceWithByE() {
		dr.findElement(By.id("email")).clear();
		dr.findElement(By.id("email")).sendKeys("admin@demo.com");
		
		dr.findElement(By.id("password")).clear();
		dr.findElement(By.id("password")).sendKeys("riseDemo");
		
	//	dr.findElement(By.linkText("Forgot password?")).click();
		dr.findElement(By.partialLinkText("Forgot")).click();
		
		
		dr.findElement(By.xpath("//button[text() = 'Sign in']")).click();
		
		pause(20);
	}
	
	@BeforeTest
	public void startBrowser() {
		dr = this.startBrower("https://rise.fairsketch.com/index.php/signin?redirect=https://rise.fairsketch.com/index.php/clients", "chrome");
	}
	
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(dr);
	}
	
}
