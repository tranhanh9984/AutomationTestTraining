package autotest.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import autotest.pages.HaDV_LoginPage;
import org.testng.annotations.*;

public class HaDV_LoginTestcase extends HaDV_LoginPage {
	private static final String LOGIN_EMAIL = "0312303803-999";
	private static final String LOGIN_PASSWORD = "0312303803-999";
	private static final String XPATH_EMAIL = "//input[@id='email']";
	private static final String XPATH_PASSWORD = "//input[@id='password']";
	private static final String XPATH_BTN_LOGIN_SUBMIT = "//button[@type='submit']";
	public HaDV_LoginPage loginPage;

	public HaDV_LoginTestcase() {
	}

	public HaDV_LoginTestcase(WebDriver driver) {
		if (this.driver == null) {
			this.driver = driver;
		}
	}

	public void testLoginSuccess() {
		loginPage.loginSuccess();
		checkURLMatched("https://uat-invoice.kaike.vn/dashboard", 10,
				"User should be redirected to the dashboard after successful login.");
	}

	@Test
	public void testLoginFail() {
		loginPage.login("0000-0000", "0000-0000");
		checkURLMatched("https://uat-invoice.kaike.vn/login", 10,
				"User should be redirected to the dashboard after successful login.");
		waitForElementPresent(
				By.xpath("//div[contains(@class,'p-toast-message-error')]//div[text()='Có lỗi xảy ra...']"), 5);
		WebElement errorMessage = driver.findElement(
				By.xpath("//div[contains(@class,'p-toast-message-error')]//div[text()='Có lỗi xảy ra...']"));
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed for invalid username.");
	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
		loginPage = new HaDV_LoginPage(driver);
	}

}
