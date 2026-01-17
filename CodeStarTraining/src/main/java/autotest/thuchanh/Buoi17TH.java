//package autotest.thuchanh;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import autocom.common.CommonPage;
//import autocom.constant.KeywordConstant;
//import autotest.pagesHD.HomePage;
//import autotest.pagesHD.LoginPage;
//import org.openqa.selenium.Alert;
//
//public class Buoi17TH extends CommonPage {
//
//	public Buoi17TH() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	@Test
//	public void loginsuccess() {
//		driver.findElement(By.xpath("//input[@name = 'submit']")).click();
//		String alertText = driver.switchTo().alert().getText();
//		System.out.println(alertText);
//		pause(5);
//		driver.switchTo().alert().accept();
//	}
//	
//	
//	@BeforeTest
//	public void startBrowser() {
//		driver = this.startBrower("https://demo.guru99.com/test/delete_customer.php", KeywordConstant.BROWSER);
//	}
//	
//	@AfterTest
//	public void closeBrowser() {
//		this.closeBrowser(driver);
//		
//	}
//
//}
