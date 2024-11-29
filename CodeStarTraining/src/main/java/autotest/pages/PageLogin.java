package autotest.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import autocom.common.CommonBase;

public class PageLogin extends CommonBase {

	// get Locator
	String txtEmail = "//input[@id='email']";
	String txtPassword = "//input[@id='password']";
	String btnSubmit = "//button[@type='submit']";
	String linkForgotPassword = "//a[@class='forgot']";
	String txtforgotPwdPopup = "//span[@id='pr_id_3-label']";
	String txtProfile = "//a[@title='Thông tin cá nhân']";
	String warningMsg = "//div[contains(text(), 'Password incorrect for username')]";
	String invalidAccMsg = "//div[contains(text(), 'No account found for username')]";
	String deactivatedAccMsg = "//div[contains(text(), 'Tài khoản của bạn đã bị khóa')]";

	//

	public PageLogin() {
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void startBrowser() {
		this.startBrowser("https://uat-invoice.kaike.vn/login", "chrome");

	}

	// Verify Email Input
	public void verifyEmailInput(String emailField, String expectedEmail) {

		String emailValue = getEmailAttribute(txtEmail, "value");
		System.out.println("Email entered: " + emailValue);
		Assert.assertEquals(emailValue, expectedEmail, "Email entered is incorrect.");
	}

	// Verify Password Input
	public void verifyPasswordInput(String passwordField, String expectedPassword) {

		String pwdValue = getPasswordAttribute(txtPassword, "value");
		System.out.println("Password entered: " + pwdValue);
		Assert.assertEquals(pwdValue, expectedPassword, "Password entered is incorrect.");
	}

	// Verify: Login with Valid Account
	@Test(enabled = false)
	public void loginValidAccount() {

		driver.findElement(By.xpath(txtEmail)).sendKeys("0312303803-999");
		driver.findElement(By.xpath(txtPassword)).sendKeys("0312303803-999");

		// Verify that email/ pwd is input correctly
		pauseBrowser(10);
		verifyEmailInput(txtEmail, "0312303803-999");
		verifyPasswordInput(txtPassword, "0312303803-999");

		// click Submit button
		driver.findElement(By.xpath(btnSubmit)).click();

		// Verify that login is successful
		WebElement menuProfile = driver.findElement(By.xpath(txtProfile));
		if (menuProfile.isDisplayed()) {
			System.out.println("Login Successfully");
		} else {
			System.out.println("Login Unsuccessfully");
		}
		pauseBrowser(10);

	}

	// Verify: Login with Invalid Password
	@Test(enabled = false, invocationCount = 1, priority = 1)
	public void loginInvalidPassword() {

		driver.findElement(By.xpath(txtEmail)).sendKeys("0312303803-999");
		driver.findElement(By.xpath(txtPassword)).sendKeys("0312303803-998");

		// Verify that email/ pwd is input correctly
		pauseBrowser(10);
		verifyEmailInput(txtEmail, "0312303803-999");
		verifyPasswordInput(txtPassword, "0312303803-998");

		driver.findElement(By.xpath(btnSubmit)).click();
		pauseBrowser(10);

		// Verify that warning popup is displayed
		WebElement wrnMessage = driver.findElement(By.xpath(warningMsg));
		String txtWrnMessage = wrnMessage.getText();
		if (wrnMessage.isDisplayed()) {
			System.out.println("Login Unsuccessfully");
			System.out.println(txtWrnMessage);
		}

	}

	// Verify: Login with Invalid Account
	@Test(enabled = false)
	public void loginInvalidAccount() {

		driver.findElement(By.xpath(txtEmail)).sendKeys("0312303803");
		driver.findElement(By.xpath(txtPassword)).sendKeys("0312303803");
		pauseBrowser(10);

		// Verify that email/ pwd is input correctly
		pauseBrowser(10);
		verifyEmailInput(txtEmail, "0312303803");
		verifyPasswordInput(txtPassword, "0312303803");

		driver.findElement(By.xpath(btnSubmit)).click();
		pauseBrowser(10);

		// Verify that warning popup is displayed
		WebElement invalidAccountMsg = driver.findElement(By.xpath(invalidAccMsg));
		String txtInvalidAccountMsg = invalidAccountMsg.getText();
		if (invalidAccountMsg.isDisplayed()) {
			// System.out.println("Login Unsuccessfully");
			System.out.println(txtInvalidAccountMsg);
		}

	}

	// Verify: Account is deactivated
	@Test(enabled = false, priority = 2)
	public void loginDeactivatedAccount() {

		driver.findElement(By.xpath(txtEmail)).sendKeys("0312303803-999");
		driver.findElement(By.xpath(txtPassword)).sendKeys("0312303803-999");

		// Verify that email/ pwd is input correctly
		pauseBrowser(10);
		verifyEmailInput(txtEmail, "0312303803-999");
		verifyPasswordInput(txtPassword, "0312303803-999");

		driver.findElement(By.xpath(btnSubmit)).click();
		pauseBrowser(10);

		// Verify that warning popup is displayed
		WebElement deactivatedAccountMsg = driver.findElement(By.xpath(deactivatedAccMsg));
		String txtDeactivatedAccountMsg = deactivatedAccountMsg.getText();
		if (deactivatedAccountMsg.isDisplayed()) {
			// System.out.println("Login Unsuccessfully");
			System.out.println(txtDeactivatedAccountMsg);
		}

	}

	// Verify: Click on Forgot Password
	@Test(enabled = true)
	public void clickFortgetPassword() {
		driver.findElement(By.xpath(linkForgotPassword)).click();
		pauseBrowser(10);
		WebElement forgotPwdPopup = driver.findElement(By.xpath(txtforgotPwdPopup));
		if (forgotPwdPopup.isDisplayed()) {
			System.out.println("open Forgot Password popup successfully ");
			System.out.println(forgotPwdPopup.getText());

		} else {
			System.out.println("Cannot open Forgot Password popup successfully ");
		}

	}

	@AfterTest
	public void tearDown() {
		closeBrowser();
		System.out.println("Browser closed successfully.");
	}

}
