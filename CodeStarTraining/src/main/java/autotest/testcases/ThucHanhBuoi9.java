package autotest.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autotest.pages.MyLoginPage;

public class ThucHanhBuoi9 extends MyLoginPage {

	String USERNAME = "0312303803-999";
	String PASSWORD = "0312303803-999";
	
	public ThucHanhBuoi9() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void init() {
		driver = startBrowser("https://uat-invoice.kaike.vn/login");
	}
	
	@AfterClass
	public void close() {
		closeBrowser();
	}
	
	@Test
	public void tc1_CompareValue() {
		this.login_enterValue("0312303803-999", "0312303803-999");
		String username = driver.findElement(By.xpath(txtUserName)).getAttribute("value");
		String password = driver.findElement(By.xpath(txtPassword)).getAttribute("value");
		
		Assert.assertEquals(username, USERNAME);
		Assert.assertEquals(password, PASSWORD);
		
	}
	
	@Test
	public void tc2_LoginThanhCong() {
		String currentTitle = driver.findElement(By.xpath("//title")).getText();
		this.login_enterValue("0312303803-999", "0312303803-999");
		this.login();
		String newTitle = driver.findElement(By.xpath("//title")).getText();
		
		Assert.assertEquals(currentTitle != newTitle, true);
	}
	
	@Test
	public void tc1_LoginFail_WrongUserName() {
		this.login_enterValue("87345928", "436727");
		this.login();
		
		boolean isDisplayed = driver.findElement(By.xpath("//*[contain(text(), 'No account found for username')]")).isDisplayed();
		Assert.assertEquals(isDisplayed, true);
	}
	
	@Test
	public void tc1_LoginFail_WrongPassword() {
		this.login_enterValue("0312303803-999", "436727");
		this.login();
		
		boolean isDisplayed = driver.findElement(By.xpath("//*[contain(text(), 'Password incorrect for username')]")).isDisplayed();
		Assert.assertEquals(isDisplayed, true);
	}

}
