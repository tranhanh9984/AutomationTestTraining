package autocom.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.pages.LoginPage;

public class LoginTestCase extends CommonPage {

	WebDriver driver;

	@BeforeTest
	public void startPage() {
		driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");

	}

	// @AfterTest
	// public void closePage() throws InterruptedException {
	// this.closeBrowser(driver);
	// }

	@Test
	public void testLoginSuccessful() {

		LoginPage login = new LoginPage(driver);
		login.login("caonv174@gmail.com", "123456", "0312303803-999");

		pause(5000);
		assertTrue(driver.findElement(By.xpath("//div[@id='company-info']")).isDisplayed());

	}
}
