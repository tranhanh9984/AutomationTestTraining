package autotest.thuchanh;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class Buoi17_TH extends CommonPage {
	
//	@Test
	public void getWindowHandles() {
		String parentWd = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		driver.switchTo().window(parentWd).getCurrentUrl();
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		driver.switchTo().window(parentWd).getCurrentUrl();
		
		Set<String> windows = driver.getWindowHandles();
		String lastWindow = "";
		for (String window : windows) {
		    lastWindow = window;
		}
		
		driver.switchTo().window(lastWindow).getCurrentUrl();
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("test@gmail.com");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		pause(2);
		
		String title = driver.findElement(By.xpath("//table//h2")).getText();
		String userId = driver.findElement(By.xpath("//td[contains(text(),'User ID')]/following-sibling::td")).getText();
		String password = driver.findElement(By.xpath("//td[contains(text(),'Password')]/following-sibling::td")).getText();
		
		System.out.println(title);
		
		Assert.assertEquals(title, "Access details to demo site.");
//		Assert.assertEquals(userId, "mngr5514");
//		Assert.assertEquals(password, "upavyzY");
		
		driver.switchTo().defaultContent();
		
//		for (String window : windows) {
//		    if (!window.equals(parentWd)) {
//		        driver.switchTo().window(window);
//		        driver.close(); // Đóng những window khác
//		    }
//		}
		
//		driver.switchTo().window(parentWd);
		
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://demo.guru99.com/popup.php", "chrome");
		pause(5);
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
	}
}
