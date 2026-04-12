package autotest.buoi8;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Samples extends CommonPage {

	public Samples() {
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	
	@Test (priority = 2)
	public void test1() {
		pause(10);
		System.out.println("Toi dang chay thu nghiem voi testn1g");
		Assert.assertEquals("1", "1");
	}
	
	@Test (priority = 1)
	public void test2() {
		pause(10);
		System.out.println("Toi dang chay thu nghiem voi testng2");
		Assert.assertEquals("1", "1");
	
	}
	
	@Test (priority = 3)
	public void test3() {
		pause(10);
		System.out.println("Toi dang chay thu nghiem voi testng3");
		Assert.assertEquals("1", "1");
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://uat-auction-partner.tamvietgroup.vn/taisankhac/product", "chrome");		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("Da chay xong, toi se closed broser web");
		this.closeBrowser(driver);		
	}

}
