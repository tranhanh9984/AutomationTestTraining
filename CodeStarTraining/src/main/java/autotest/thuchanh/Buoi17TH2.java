package autotest.thuchanh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pagesHD.HomePage;
import autotest.pagesHD.LoginPage;

import java.util.Set;

import org.openqa.selenium.Alert;

public class Buoi17TH2 extends CommonPage {

	public Buoi17TH2() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void alertProcesing() {
		driver.findElement(By.linkText("Alert with OK")).click();
		driver.findElement(By.xpath("//div[@id = 'OKTab']/button")).click();		
		String alertText = driver.switchTo().alert().getText();		
		Assert.assertEquals("I am an alert box!", alertText);
		System.out.println(alertText);
		pause(5);		
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void getWindowHandles() {
		
		String frsWd = driver.getWindowHandle();
		driver.findElement(By.linkText("Click Here")).click();
		driver.switchTo().window(frsWd).getCurrentUrl();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> setA = driver.getWindowHandles();
		String lastWindow = "";
		for(String a : setA) {
			System.out.println(a);
			lastWindow = a;
		}
		
		String url = driver.switchTo().window(lastWindow).getCurrentUrl();
		System.out.println(url);
		url = driver.switchTo().window(frsWd).getCurrentUrl();
		System.out.println(url);
		pause(10);
	}
	
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://demo.guru99.com/popup.php", KeywordConstant.BROWSER);
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}

}
