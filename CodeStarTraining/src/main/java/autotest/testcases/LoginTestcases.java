package autotest.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autotest.pages.LoginPage1;

public class LoginTestcases extends LoginPage1 {
	String gmail = "caonv174@gmail.com";
	String unregisteredgmail = "khoaminhtran1999@gmail.com";
	String password = "123456";
	String wrongpassword = "abc@123";
	String MST = "0312303803-999";
	String wrongMST = "0312303803-9";
	String text = "Nguyễn Văn Cao";
	String unexistedmessage = "Không tìm thấy tài khoản";
	String wrongpasswordmessage = "Sai mật khẩu";
	String wrongMSTmessage = "Thiếu mã số thuế hoặc mã số thuế không hợp lệ";
	String requiredFieldsMessage = "Bắt buộc";
//	LoginTestcases(WebDriver dr) {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
////	LoginTestcases(WebDriver dr) {
////		super(dr);
////		// TODO Auto-generated constructor stub
////	}
//
//
//	WebDriver driver;
////	public LoginTestcases() {
////		// TODO Auto-generated constructor stub
////	}

	@BeforeTest
	public void StartPage() {
		this.startBrower("https://v2.vietinvoice.vn/auth/dang-nhap", "chrome");
		pause(50);
	}

	//@Test
	public void loginSuccessfully() {
		// Kiem tra login thanh cong
		this.inputAllFields(gmail, password, MST);
		this.clickSubmitButton();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(text(), 'Xin chào, Nguyễn Văn Cao')]")).getText().contains(text));
	}
	
	//@Test
	public void loginWithUnexistedAccount() {
		// Kiem tra login sai email 
		this.inputAllFields(unregisteredgmail, password, MST);
		this.clickSubmitButton();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(text(), '" + unexistedmessage + "')]")).getText().contains(unexistedmessage));
	}
	
	//@Test
	public void loginWithWrongPassword() {
		// Kiem tra login sai password
		this.inputAllFields(gmail, wrongpassword, MST);
		this.clickSubmitButton();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(text(), '" + wrongpasswordmessage + "')]")).getText().contains(wrongpasswordmessage));
	}
	
	//@Test
	public void loginWithWrongMST() {
		// Kiem tra login sai MST
		this.inputAllFields(gmail, password, wrongMST);
		this.clickSubmitButton();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(text(), '" + wrongMSTmessage + "')]")).getText().contains(wrongMSTmessage));
	}
	
	//@Test
	public void leaveAllRequiredFieldsWithBlank() {
		// Kiem tra login khi khong nhap tat ca field bat buoc
		this.leaveAllFieldsWithBlank(gmail);
		this.clickSubmitButton();
		List<WebElement> errmsg = driver.findElements(By.xpath("//*[contains(text(), '" + requiredFieldsMessage + "')]"));
		int count = 0;
        for (WebElement ele: errmsg) {
            count++;
            Assert.assertTrue(ele.isDisplayed());
        }
	}
	
	//@Test
	public void verifyClickOnEyesIcon() {
		// Kiem tra click on Eyes Icon
		this.inputAllFields(gmail, password, MST);
		this.clickEyesIcon();
		Assert.assertEquals(driver.findElement(By.id(txtPassword)).getAttribute("value"), password);
	}

	@AfterTest
	public void ClosePage() {
		this.closeBrowser(driver);
	}

}
