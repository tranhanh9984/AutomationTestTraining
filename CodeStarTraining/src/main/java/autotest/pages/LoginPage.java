package autotest.pages;

import java.lang.annotation.*;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonBase;
import autocom.constant.KeywordConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends CommonBase {
	@Test
	public void tc_01() {
		System.out.println("HaDV_start Browser");
		testWrongUser();
		testWrongPass();
		testLoginSuccess();
		pause(5000);
		clickMenus();
		this.tc_dienThongtin();
	}
	
	
public void clickMenus() {
	driver.findElement(
			By.xpath("//ul[@role=\"menubar\"]//span[contains(@class,\"p-menuitem-text\")][text()=\"Hóa đơn \"]"))
			.click();

	driver.findElement(
			By.xpath("//ul[@role=\"menubar\"]//span[contains(@class,\"p-menuitem-text\")][text()=\"Lập hoá đơn\"]"))
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

	public void inputText(String giatri, String locator) {
		// Now clear the text input field
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(giatri);
		driver.findElement(By.xpath(locator)).getAttribute("value");
		// assert giatri == driver.findElement(By.xpath(locator)).getAttribute("value");
		Assert.assertEquals(giatri, driver.findElement(By.xpath(locator)).getAttribute("value"),
				"input va value khong khop");
	}

	public void tc_dienThongtin() {
		// driver.findElement(By.xpath(""));

		driver.findElement(By.xpath("//p-dropdown[@id='invoiceTemplatePartyId']/div[contains(@class,'p-dropdown')]"))
				.click();
		System.out.println("1");
		driver.findElement(By.xpath("//li[@aria-label=\"1C24TAA\"]")).click();
		System.out.println("2");
		driver.findElement(By.xpath("//p-autocomplete[@id=\"toPartyTaxId\"]//input")).sendKeys("0312303803-999");

		// click vào Lấy Thông Tin btn để pre-filled các thông tin có trong data
		driver.findElement(By.xpath("//span[text()=\"Lấy thông tin\"]")).click();

		// Check các filed xem đã được pre-filled chưa. Nếu trống thì điền thông tin vào
		String filedValue = driver.findElement(By.xpath("//input[@id=\"toName\"]")).getAttribute("value");
		if (filedValue.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"toName\"]")).sendKeys("Do Viet Ha");
		}

		String toIdentification = driver.findElement(By.xpath("//input[@id=\"toIdentification\"]"))
				.getAttribute("value");
		if (toIdentification.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"toIdentification\"]")).sendKeys("001191123456");
		}
		// Check giá trị pre-filled

		String toEmailAddress = driver.findElement(By.xpath("//input[@id=\"toEmailAddress\"]")).getAttribute("value");
		if (toEmailAddress.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"toEmailAddress\"]")).sendKeys("vietha@gmail.com");
		}
		// Check giá trị pre-filled

		String toTelecomNumber = driver.findElement(By.xpath("//input[@id=\"toTelecomNumber\"]")).getAttribute("value");
		if (toTelecomNumber.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"toTelecomNumber\"]")).sendKeys("09777111123");
		}
		// Check giá trị pre-filled

		String accountNumber = driver.findElement(By.xpath("//input[@id=\"accountNumber\"]")).getAttribute("value");
		if (accountNumber.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"accountNumber\"]")).sendKeys("001002003");
		}
		// Check giá trị pre-filled

		String bankName = driver.findElement(By.xpath("//input[@id=\"bankName\"]")).getAttribute("value");
		if (bankName.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"bankName\"]")).sendKeys("Vietcombank");
		}
		
		driver.findElement(By.xpath("//p-dropdown[@id=\"paymentInstrumentEnumId\"]")).click();	
		driver.findElement(By.xpath("//ul[@id='pr_id_14_list']//li[@aria-label='Tiền mặt']")).click();
	

//		driver.findElement(By.xpath("//p-dropdown[@id='currencyUomId']/div[1]")).click();
//		System.out.println("4");

//		driver.findElement(By.xpath("//li[@id=\"p-highlighted-option\" and @aria-label=\"VND\"]")).click();
//		System.out.println("5");

		// Check giá trị pre-filled

		String exchangeRate = driver.findElement(By.xpath("//p-inputnumber[@id=\"exchangeRate\"]//input")).getAttribute("value");
		System.out.println("6");
		if (exchangeRate.isEmpty()) {
			driver.findElement(By.xpath("//p-inputnumber[@id=\\\"exchangeRate\\\"]//input")).sendKeys("20000");
			System.out.println("7");
		}

		driver.findElement(By.xpath("//p-dropdown[@id='paymentInstrumentEnumId']")).click();
		System.out.println("8");
		
		driver.findElement(By.xpath("//ul[@id='pr_id_18_list']//li[@aria-label='Theo từng mặt hàng']")).click();
		System.out.println("9");
		
		driver.findElement(By.xpath("//p-button[@title=\'Thêm\']")).click();
		System.out.println("10");
		// Add hàng vào hóa đơn
		// Kiểm tra nếu checkbox chưa được chọn, thì click để chọn

		String ariaChecked = driver.findElement(By.xpath("//div[@id=\"pr_id_44\"]//tr[3]//div[@role=\"checkbox\"]"))
				.getAttribute("aria-checked");
		if (ariaChecked.equals("false")) {
			// Checkbox chưa được chọn, thực hiện click để chọn
			driver.findElement(By.xpath("//div[@id=\"pr_id_44\"]//tr[3]//div[@role=\"checkbox\"]")).click();
		}

		String ariaChecked2 = driver.findElement(By.xpath("//div[@id=\"pr_id_44\"]//tr[5]//div[@role=\"checkbox\"]"))
				.getAttribute("aria-checked");
		if (ariaChecked2.equals("false")) {
			// Checkbox chưa được chọn, thực hiện click để chọn
			driver.findElement(By.xpath("//div[@id=\"pr_id_44\"]//tr[5]//div[@role=\"checkbox\"]")).click();
		}

		driver.findElement(By.xpath("//p-footer//span[text()=\"Thêm dòng trống\"]")).click();
		driver.findElement(By.xpath("//p-button[@type=\"submit\"]//span[text()=\"Tạo mới\"]")).click();
	}

	public void setText(String content, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(content);
		;
		assert content == this.getAttribute(xpath, "value");
	}

	public void getText(String content, String xpath) {

	}

	public String getAttribute(String xpath, String att) {
		return driver.findElement(By.xpath(xpath)).getAttribute(att);
	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");

	}
//@AfterClass
//	public void close() {
//		this.closeBrowser();
//	}

}