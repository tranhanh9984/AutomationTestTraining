package autotest.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.LoginPage1;

public class LoginTestcases extends CommonPage {
	String txtPassword = "password";
	String unregisteredgmail = "khoaminhtran1999@gmail.com";
	String wrongpassword = "abc@123";
	String wrongMST = "0312303803-9";
	
	KeywordConstant comConstant =  new KeywordConstant();

	@BeforeTest
	public void StartPage() {
		this.startBrower("https://v2.vietinvoice.vn/auth/dang-nhap", "chrome");
		pause(50);
	}

	@Test
	public void loginSuccessfully() {
		LoginPage1 loginPage1 = new LoginPage1(driver);
		// Kiem tra login thanh cong
		loginPage1.inputAllFields(comConstant.EMAIL, comConstant.PASSWORD, comConstant.MST);
		loginPage1.clickSubmitButton();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(text(), 'Xin chào, " + comConstant.HO_TEN +"')]")).getText().contains(comConstant.HO_TEN)); //move to homepage
	}
	
	//@Test
	public void loginWithUnexistedAccount() {
		LoginPage1 loginPage1 = new LoginPage1(driver);
		// Kiem tra login sai email 
		loginPage1.inputAllFields(unregisteredgmail, comConstant.PASSWORD, comConstant.MST);
		loginPage1.clickSubmitButton();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(text(), '" + comConstant.unexistedmessage + "')]")).getText().contains(comConstant.unexistedmessage));
	}
	
	//@Test
	public void loginWithWrongPassword() {
		LoginPage1 loginPage1 = new LoginPage1(driver);
		// Kiem tra login sai password
		loginPage1.inputAllFields(comConstant.EMAIL, wrongpassword, comConstant.MST);
		loginPage1.clickSubmitButton();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(text(), '" + comConstant.wrongpasswordmessage + "')]")).getText().contains(comConstant.wrongpasswordmessage));
	}
	
	//@Test
	public void loginWithWrongMST() {
		LoginPage1 loginPage1 = new LoginPage1(driver);
		// Kiem tra login sai MST
		loginPage1.inputAllFields(comConstant.EMAIL, comConstant.PASSWORD, wrongMST);
		loginPage1.clickSubmitButton();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(text(), '" + comConstant.wrongMSTmessage + "')]")).getText().contains(comConstant.wrongMSTmessage));
	}
	
	//@Test
	public void leaveAllRequiredFieldsWithBlank() {
		LoginPage1 loginPage1 = new LoginPage1(driver);
		// Kiem tra login khi khong nhap tat ca field bat buoc
		loginPage1.leaveAllFieldsWithBlank(comConstant.EMAIL);
		loginPage1.clickSubmitButton();
		List<WebElement> errmsg = driver.findElements(By.xpath("//*[contains(text(), '" + comConstant.requiredFieldsMessage + "')]"));
		int count = 0;
        for (WebElement ele: errmsg) {
            count++;
            Assert.assertTrue(ele.isDisplayed());
        }
	}
	
	//@Test
	public void verifyClickOnEyesIcon() {
		LoginPage1 loginPage1 = new LoginPage1(driver);
		// Kiem tra click on Eyes Icon
		loginPage1.inputAllFields(comConstant.EMAIL, comConstant.PASSWORD, comConstant.MST);
		loginPage1.clickEyesIcon();
		Assert.assertEquals(driver.findElement(By.id(txtPassword)).getAttribute("value"), comConstant.PASSWORD);
	}

	@AfterTest
	public void ClosePage() {
		this.closeBrowser(driver);
	}

}
