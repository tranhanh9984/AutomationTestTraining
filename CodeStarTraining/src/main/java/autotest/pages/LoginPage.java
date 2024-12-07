package autotest.pages;

import java.lang.annotation.*;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;

import org.openqa.selenium.WebDriver;

import autocom.common.CommonBase;
import autocom.constant.KeywordConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends CommonBase {
	private static final boolean SCROLL = true;
	private static final boolean NO_SCROLL = false;

	@Test
	public void tc_01() {
		System.out.println("HaDV_start Browser");
		testLoginSuccess();
		pause(5000);

		clickMenus(); // tạo hóa đơn
		taoMoiHoaDon_Failed1(); // tạo hóa đơn failed do blank field
		taoMoiHoaDon_Failed2(); // Nhập sai MST và click vào Lấy Thông Tin -> Expected: Hiển thị Error Mess
//		 tc_taoMoiHoaDon();

		// testWrongUser();
		// testWrongPass();

		// testLimitedLoginFail();
	}

	public void clickMenus() {
		driver.findElement(
				By.xpath("//ul[@role='menubar']//span[contains(@class,'p-menuitem-text')][text()='Hóa đơn ']")).click();
		driver.findElement(
				By.xpath("//ul[@role='menubar']//span[contains(@class,'p-menuitem-text')][text()='Lập hoá đơn']"))
				.click();
	}

	public void testLoginSuccess() {
		inputText("0312303803-999", "//input[@id='email']");
		inputText("0312303803-999", "//input[@id='password']");
		driver.findElement(By.xpath("//button")).click();
		pause(1000);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://uat-invoice.kaike.vn/dashboard",
				"User should be redirected to the dashboard after successful login.");
	}

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

	public void tc_dienThongtin() {
		// click Ky hieu
		pause(3000);
		click("//p-dropdown[@id='invoiceTemplatePartyId']/div[contains(@class,'p-dropdown')]", SCROLL);
		System.out.println("1");
		// select Ky hieu
		click("//p-dropdown[@id='invoiceTemplatePartyId']//p-dropdownitem[1]//li", NO_SCROLL);
		System.out.println("2");
		// input text MST người mua
		setText("//p-autocomplete[@id='toPartyTaxId']//input", "0312303803-999", false);
		// click vào Lấy Thông Tin btn để pre-filled các thông tin có trong data
		click("//span[text()='Lấy thông tin']/..", SCROLL);
		// Check các filed xem đã được pre-filled chưa. Nếu trống thì điền thông
		// tin vào
		// Người mua hàng
		setText("//input[@id='toName']", "Do Viet Ha", false);
		// CCCD
		setText("//input[@id='toIdentification']", "001191123456", false);
		// Email
		setText("//input[@id='toEmailAddress']", "vietha@gmail.com", false);
		// Số điện thoại
		setText("//input[@id='toTelecomNumber']", "09777111123", false);
		// Số tài khoản
		setText("//input[@id='accountNumber']", "001002003", false);
		// Ngân hàng
		setText("//input[@id='bankName']", "Vietcombank", false);
		// Click dropdown Hình thức TT
		click("//p-dropdown[@id='paymentInstrumentEnumId']/div[contains(@class,'p-dropdown')]", SCROLL);
		click("//p-dropdown[@id='paymentInstrumentEnumId']//li[@aria-label='Tiền mặt']", NO_SCROLL);
		// Ty gia
		setCommasIntText("//p-inputnumber[@id='exchangeRate']//input", "20000", true);
		// select Chiet khau
		click("//p-dropdown[@id='discountTypeEnumId']/div[contains(@class,'p-dropdown')]", SCROLL);
		click("//ul[@id='pr_id_18_list']//li[@aria-label='Theo từng mặt hàng']", NO_SCROLL);
		System.out.println("9");

	}

	public void themHangHoaDichVu() {
		// ( hàng hóa, dịch vụ ) click Thêm.
		// Add hàng vào hóa đơn.
		// Kiểm tra nếu checkbox chưa được chọn, thì click để chọn.
		driver.findElement(By.xpath("//p-button[@title='Thêm']")).click();
		System.out.println("10");
		String ariaChecked = driver.findElement(By.xpath(
				"//app-dialog-add-product//*[contains(@class,'p-datatable-tbody')]//tr[3]//div[@role='checkbox']"))
				.getAttribute("aria-checked");
		if (ariaChecked.equals("false")) {
			// Checkbox chưa được chọn, thực hiện click để chọn
			driver.findElement(By.xpath(
					"//app-dialog-add-product//*[contains(@class,'p-datatable-tbody')]//tr[3]//div[@role='checkbox']"))
					.click();
		}

		String ariaChecked2 = driver.findElement(By.xpath(
				"//app-dialog-add-product//*[contains(@class,'p-datatable-tbody')]//tr[4]//div[@role='checkbox']"))
				.getAttribute("aria-checked");
		if (ariaChecked2.equals("false")) {
			// Checkbox chưa được chọn, thực hiện click để chọn
			driver.findElement(By.xpath(
					"//app-dialog-add-product//*[contains(@class,'p-datatable-tbody')]//tr[4]//div[@role='checkbox']"))
					.click();
		}

		String ariaChecked3 = driver.findElement(By.xpath(
				"//app-dialog-add-product//*[contains(@class,'p-datatable-tbody')]//tr[2]//div[@role='checkbox']"))
				.getAttribute("aria-checked");
		if (ariaChecked3.equals("false")) {
			// Checkbox chưa được chọn, thực hiện click để chọn
			driver.findElement(By.xpath(
					"//app-dialog-add-product//*[contains(@class,'p-datatable-tbody')]//tr[2]//div[@role='checkbox']"))
					.click();
		}
		driver.findElement(By.xpath("//app-dialog-add-product//span[text()='Thêm']")).click();
	}

	public void tc_taoMoiHoaDon() {
		tc_dienThongtin();
		themHangHoaDichVu();
		driver.findElement(By.xpath("//p-button[@type='submit']//span[text()='Tạo mới']")).click();
	}

	public void taoMoiHoaDon_Failed1() {
		clickMenus();
		tc_dienThongtin();
		themHangHoaDichVu();
		// Bỏ trống Người mua hàng và Tên Đơn Vị
		setText("//input[@id='toName']", "", true);
		setText("//p-autocomplete[@id='toPartyName']//input", "", true);

		click("//p-button[@type='submit']//span[text()='Tạo mới']", NO_SCROLL);
		WebElement errorMessage = driver.findElement(By.xpath(
				"//div[contains(@class,'p-toast-message-error')]//div[text()='Tên đơn vị hoặc người mua hàng không được bỏ trống']"));
		Assert.assertTrue(errorMessage.isDisplayed(), "TC Failed: Error Mess hiển thị không đúng expect");
	}

	public void taoMoiHoaDon_Failed2() {
		// Nhập sai MST và click vào Lấy Thông Tin -> Expected: Hiển thị Error Mess
		clickMenus();

		// input text MST người mua
		setText("//p-autocomplete[@id='toPartyTaxId']//input", "999", true);

		// click vào Lấy Thông Tin btn để pre-filled các thông tin có trong data
		click("//span[text()='Lấy thông tin']/..", SCROLL);

		String MST = getInputText("//p-autocomplete[@id='toPartyTaxId']//input");

		WebElement errorMessage = driver.findElement(By.xpath(
				"//div[contains(@class,'p-toast-message-error')]//div[text()='Không tìm thấy thông tin doanh nghiệp/cá nhân có mã số thuế: " + MST + ". Hãy xem lại']"));
		Assert.assertTrue(errorMessage.isDisplayed(), "TC Failed: Error Mess hiển thị không đúng expect");
	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");

	}
	// @AfterClass
	// public void close() {
	// this.closeBrowser();
	// }

}