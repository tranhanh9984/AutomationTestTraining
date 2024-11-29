package autotest.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonBase;

public class PageInvoice extends CommonBase {

	// get Locator
	String txtEmail = "//input[@id='email']";
	String txtPassword = "//input[@id='password']";
	String btnSubmit = "//button[@type='submit']";
	String txtProfile = "//a[@title='Thông tin cá nhân']";

	String menuHoaDon = "//span[@class='p-menuitem-text ng-star-inserted'and contains(text(),'Hóa đơn')]";
	String menuLapHoaDon = "//span[@class='p-menuitem-text ng-star-inserted'and contains(text(),'Lập hoá đơn')]";
	String txtTitlePage = "//h4[contains(text(),'Lập hoá đơn')]";

	String btnMstNguoiMua = "//button[@class = 'p-element p-ripple p-autocomplete-dropdown ng-tns-c110-12 p-button p-component p-button-icon-only ng-star-inserted']";
	String listMstNguoiMua = "(//div[@class = 'p-grid ng-star-inserted'])[2]";

	String nguoiMuaHang = "//input[@id = 'toName']";
	String CCCD = "//input[@id = 'toIdentification']";
	String txtEmailAdd = "//input[@id = 'toEmailAddress']";
	String txtTelecomNumber = "//input[@id = 'toTelecomNumber']";
	String txtAccountNumber = "//input[@id = 'accountNumber']";
	String txtBankName = "//input[@id = 'bankName']";

	String btnHinhThucTT = "//p-dropdown[@id='paymentInstrumentEnumId']//div[contains(@class, 'p-dropdown-trigger ng-tns-c60')]";
	String listHinhThucTT = "//li[@aria-label='Tiền mặt']";

//
	String btnLoaiTien = "//p-dropdown[@id='currencyUomId']//div[contains(@class, 'p-dropdown-trigger ng-tns-c60')]";
	String listLoaiTien = "//ul//li[@aria-label='VND']";

//
	String txtExchangeRate = "//p-inputnumber[@id='exchangeRate']";

//
	String btnChietKhau = "//p-dropdown[@id='discountTypeEnumId']//div[contains(@class, 'p-dropdown-trigger ng-tns-c60')]";
	String listChietKhau = "//ul//li[@aria-label='Không chiết khấu']";

//
	String btnTinhChat = "//p-dropdown[@class='p-element p-inputwrapper ng-tns-c60-29 p-inputwrapper-filled ng-pristine ng-valid ng-star-inserted ng-touched']//div[contains(@class, 'p-dropdown-trigger ng-tns-c60')]";
	String listTinhChat = "//li[@aria-label='Chiết khấu thương mại']";

//
	String txtTenHangHoa = "//input[@class='ng-tns-c110-33 p-autocomplete-input p-inputtext p-component ng-star-inserted']";
	String txtDonViTinh = "(//td[@class='p-element p-editable-column'])[2]";
	String txtSoLuong = "(//td[@class='p-element p-text-right p-editable-column'])[1]";
	String txtDonGia = "(//td[@class='p-element p-text-right p-editable-column'])[2]";
	String txtThanhTien = "(//td[@class='p-element p-text-right p-editable-column'])[3]";

//
	String btnThue = "//span[@class='p-dropdown-trigger-icon ng-tns-c60-42 pi pi-chevron-down']";
	String listThue = "//li[@aria-label='5%']";

//
	String btnLuuVaKy = "//button/span[text() = 'Lưu và ký']";

	public PageInvoice() {
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void navigateLoginPage() {
		this.startBrowser("https://uat-invoice.kaike.vn/login", "chrome");

	}

	// Verify: Login with Valid Account
	@Test(enabled = true, priority = 1)
	public void loginValidAccount() {

		driver.findElement(By.xpath(txtEmail)).sendKeys("0312303803-999");
		driver.findElement(By.xpath(txtPassword)).sendKeys("0312303803-999");

		// click Submit button
		driver.findElement(By.xpath(btnSubmit)).click();
		pauseBrowser(10);

		// Verify that login is successful
		WebElement menuProfile = driver.findElement(By.xpath(txtProfile));
		if (menuProfile.isDisplayed()) {
			System.out.println("Login Successfully");
		} else {
			System.out.println("Login Unsuccessfully");
		}

	}

	@Test(enabled = false)
	public void navigateInvoicePage() {

		// click on menu "Hóa Đơn"
		driver.findElement(By.xpath(menuHoaDon)).click();

		// click on menu "Lập Hóa Đơn"
		driver.findElement(By.xpath(menuLapHoaDon)).click();

		pauseBrowser(10);
		// verify that page "Lập hoá đơn" is displayed
		WebElement pageLHD = driver.findElement(By.xpath(txtTitlePage));
		if (pageLHD.isDisplayed()) {
			System.out.println("Navigate to page 'Lập Hóa Đơn' successfully");
		} else {
			System.out.println("Navigate to page 'Lập Hóa Đơn' unsuccessfully");
		}
	}

	@Test(enabled = true, priority = 2)
	public void createInvoice() {

		navigateInvoicePage();

		driver.findElement(By.xpath(btnMstNguoiMua)).click();
		driver.findElement(By.xpath(listMstNguoiMua)).click();

		driver.findElement(By.xpath(nguoiMuaHang)).clear();
		driver.findElement(By.xpath(nguoiMuaHang)).sendKeys("Customer A");

		driver.findElement(By.xpath(CCCD)).clear();
		driver.findElement(By.xpath(CCCD)).sendKeys("123456789");

		driver.findElement(By.xpath(txtEmailAdd)).clear();
		driver.findElement(By.xpath(txtEmailAdd)).sendKeys("a@test.test");

		driver.findElement(By.xpath(txtTelecomNumber)).clear();
		driver.findElement(By.xpath(txtTelecomNumber)).sendKeys("0988123897");

		driver.findElement(By.xpath(txtAccountNumber)).clear();
		driver.findElement(By.xpath(txtAccountNumber)).sendKeys("009987878787");

		driver.findElement(By.xpath(txtBankName)).clear();
		driver.findElement(By.xpath(txtBankName)).sendKeys("Vietcombank");

		driver.findElement(By.xpath(btnHinhThucTT)).click();
		driver.findElement(By.xpath(listHinhThucTT)).click();;
		System.out.println("Chọn Hình Thức Thanh Toán: OK");
		
		//JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView();", driver.findElement(By.xpath(btnLoaiTien)));
		
		
		pauseBrowser(3);
		driver.findElement(By.xpath(btnLoaiTien)).click();
		
//		// Tìm tất cả các phần tử <li> trong <p-dropdownitem> có class xác định
//		List<WebElement> liElements = driver.findElements(By.xpath(listLoaiTien));
//
//		// Duyệt qua tất cả các thẻ <li> và in ra nội dung
//		for (WebElement li : liElements) {
//		    System.out.println("Nội dung thẻ <li>: " + li.getText());
//		}
		driver.findElement(By.xpath(listLoaiTien)).click();

//		
		
		System.out.println("Chọn Loại Tiền: OK");
//
		driver.findElement(By.xpath(txtExchangeRate)).sendKeys("3600");

		driver.findElement(By.xpath(btnChietKhau)).click();
		driver.findElement(By.xpath(listChietKhau)).click();
		System.out.println("Chọn Ck: OK");
//
//
//		driver.findElement(By.xpath(btnTinhChat)).click();
//		driver.findElement(By.xpath(listTinhChat)).click();
//
//		driver.findElement(By.xpath(txtTenHangHoa)).sendKeys("Sách");
//		driver.findElement(By.xpath(txtDonViTinh)).sendKeys("Quyển");
//		driver.findElement(By.xpath(txtSoLuong)).sendKeys("5");
//		driver.findElement(By.xpath(txtDonGia)).sendKeys("1600");
//
//		driver.findElement(By.xpath(btnThue)).click();
//		driver.findElement(By.xpath(listThue)).click();
//
//		pauseBrowser(20);
//		driver.findElement(By.xpath(btnLuuVaKy)).click();

		pauseBrowser(10);

	}

	@AfterTest
	public void tearDown() {
		closeBrowser();
		System.out.println("Browser closed successfully.");
	}

}
