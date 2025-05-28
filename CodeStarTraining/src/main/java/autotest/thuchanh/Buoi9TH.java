//package autotest.thuchanh;
//
//import org.openqa.selenium.By;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import autocom.common.CommonPage;
//import autocom.constant.KeywordConstant;
//
//public class Buoi9TH extends CommonPage {
//
//	public Buoi9TH() {
//		// TODO Auto-generated constructor stub
//	}
//
//	
//	String btnCheckOutHere = "//button[@class = 'dropbtn']";
//	
//	
//	@Test
//	public void Test1() {
//		this.scrollToElement(btnCheckOutHere);
//		driver.findElement(By.xpath(btnCheckOutHere)).click();
//		driver.findElement(By.linkText("Join Training")).click();		
//	}
//	
//	
//	@BeforeTest
//	public void startBrowser() {
//		driver = this.startBrower("https://selectorshub.com/xpath-practice-page/", KeywordConstant.BROWSER);
//		
//	}
//	
//	@AfterTest
//	public void closeBrowser() {
//	//	this.closeBrowser(driver);
//		
//	}
//}
