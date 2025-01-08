package autotest.pages;

import java.lang.annotation.*;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;

import org.openqa.selenium.WebDriver;

import autocom.common.HaDV_CommonBase;
import autocom.constant.KeywordConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class HaDV_LoginPage extends HaDV_CommonBase {
	public String LOGIN_EMAIL = "0312303803-999";
	public String LOGIN_PASSWORD = "0312303803-999";
	private static final String XPATH_EMAIL = "//input[@id='email']";
	private static final String XPATH_PASSWORD = "//input[@id='password']";
	private static final String XPATH_BTN_LOGIN_SUBMIT = "//button[@type='submit']";

	public HaDV_LoginPage() {
	}

	public HaDV_LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void tc_01() {
//		testLoginSuccess();
//		pause(2000);

		// clickMenus(); // tạo hóa đơn
		// taoMoiHoaDon_Error1(); // tạo hóa đơn failed do blank field
		// taoMoiHoaDon_Error2(); // Nhập sai MST và click vào Lấy Thông Tin ->
		// Expected: Hiển thị Error Mess

		// testWrongUser();
		// testWrongPass();
		// testLimitedLoginFail();
	}

	public void loginSuccess() {
		inputText(LOGIN_EMAIL, XPATH_EMAIL);
		inputText(LOGIN_PASSWORD, XPATH_PASSWORD);
		driver.findElement(By.xpath(XPATH_BTN_LOGIN_SUBMIT)).click();
	}

	public void login(String email, String password) {
		inputText(email, XPATH_EMAIL);
		inputText(password, XPATH_PASSWORD);
		driver.findElement(By.xpath(XPATH_BTN_LOGIN_SUBMIT)).click();
	}

//	public void testLoginSuccess() {
//		inputText(LOGIN_EMAIL, XPATH_EMAIL);
//		inputText(LOGIN_PASSWORD, XPATH_PASSWORD);
//		driver.findElement(By.xpath(XPATH_BTN_LOGIN_SUBMIT)).click();
//		pause(1000);
//		String currentUrl = driver.getCurrentUrl();
//		Assert.assertEquals(currentUrl, "https://uat-invoice.kaike.vn/dashboard",
//				"User should be redirected to the dashboard after successful login.");
//	}

	public void testWrongUser() {
		inputText("1", "//input[@id='email']");
		inputText("0312303803-999", "//input[@id='password']");
		driver.findElement(By.xpath("//button")).click();
		WebElement errorMessage = driver.findElement(
				By.xpath("//div[contains(@class,'p-toast-message-error')]//div[text()='Có lỗi xảy ra...']"));
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed for invalid username.");
	}

	public void testWrongPass() {
		inputText("0312303803-999", "//input[@id='email']");
		inputText("1", "//input[@id='password']");
		driver.findElement(By.xpath("//button")).click();
		WebElement errorMessage = driver.findElement(
				By.xpath("//div[contains(@class,'p-toast-message-error')]//div[text()='Có lỗi xảy ra...']"));
		Assert.assertTrue(errorMessage.isDisplayed(), "Error message should be displayed for invalid password.");
	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
	}

}