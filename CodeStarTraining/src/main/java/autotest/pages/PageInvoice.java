package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

	String btnLoaiTien = "//p-dropdown[@id='currencyUomId']//div[contains(@class, 'p-dropdown-trigger ng-tns-c60')]";
	String listLoaiTien = "//ul//li[@aria-label='VND']";

	String txtExchangeRate = "//p-inputnumber[@id='exchangeRate']";

	String btnChietKhau = "//p-dropdown[contains(@id, 'discountTypeEnumId')]//div[contains(@class, 'p-dropdown-trigger ng-tns')]";
	String listChietKhau = "//ul//li[@aria-label='Không chiết khấu']";

	String layoutTinhChat = "(//td[@class = 'p-element p-editable-column'])[1]";
	String btnTinhChat = "(//p-dropdown[contains(@class, 'p-element p-inputwrapper ng-tns-c60')]//div[contains(@class, 'p-dropdown-trigger ng-tns-c60')])[6]";
	String listTinhChat = "//ul//li[@aria-label='Chiết khấu thương mại']";

	String txtTenHangHoa = "//p-autocomplete[@field = 'productName']//input[contains(@class, 'ng-tns-c110')]";

	String layoutDonViTinh = "//tr//td[@class = 'p-element p-editable-column p-cell-editing']";
	String txtDonViTinh = "//input[@class='p-inputtext p-component p-element ng-pristine ng-valid ng-star-inserted ng-touched']";

	String layoutSoLuong = "//td[contains(@class, 'p-element p-text-right p-editable-column')]";
	String txtSoLuong = "//td[contains(@class, 'p-element p-text-right p-editable-column')]//p-inputnumber//input[@inputmode = 'decimal']";

	String layoutDonGia = "//td[@class = 'p-element p-text-right p-editable-column']";
	String txtDonGia = "//input[@class='p-inputtext p-component p-element p-inputnumber-input']";

	String layoutThue = "(//td[contains(@class , 'p-element p-text-right p-editable-column ng-star-inserted')])[1]";
	String btnThue = "(//td[contains(@class , 'p-element p-text-right p-editable-column ng-star-inserted')])[1]";
	String selectedThue = "//li[@aria-label='10%']";

	String btnThemSP = "//button[@class='p-ripple p-element p-button-rounded p-button-info p-button-outlined p-button-sm p-button p-component p-button-icon-only']";
	String listCheckbox = "//div[@class = 'p-checkbox p-component']";
	String checkboxSP01 = "(//div[@class = 'p-checkbox p-component'])[4]";
	String checkboxSP02 = "(//div[@class = 'p-checkbox p-component'])[5]";
	String checkboxSP03 = "(//div[@class = 'p-checkbox p-component'])[6]";

	String btnThem = "//button//span[text() = 'Thêm']";

	String btnTaoMoi= "//button/span[text() = 'Tạo mới']";
	String popupXacNhan = "//div[text() = 'Thành công!']";

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

	// Verify: create Invoice successfully
	@Test(enabled = true, priority = 2)
	public void createInvoice() {

		navigateInvoicePage();

		driver.findElement(By.xpath(btnMstNguoiMua)).click();
		driver.findElement(By.xpath(listMstNguoiMua)).click();

		driver.findElement(By.xpath(nguoiMuaHang)).clear();
		driver.findElement(By.xpath(nguoiMuaHang)).sendKeys("Customer C");

		driver.findElement(By.xpath(CCCD)).clear();
		driver.findElement(By.xpath(CCCD)).sendKeys("123456789");

		driver.findElement(By.xpath(txtEmailAdd)).clear();
		driver.findElement(By.xpath(txtEmailAdd)).sendKeys("atest@mailinator.com");

		driver.findElement(By.xpath(txtTelecomNumber)).clear();
		driver.findElement(By.xpath(txtTelecomNumber)).sendKeys("0988123897");

		driver.findElement(By.xpath(txtAccountNumber)).clear();
		driver.findElement(By.xpath(txtAccountNumber)).sendKeys("009987878787");

		driver.findElement(By.xpath(txtBankName)).clear();
		driver.findElement(By.xpath(txtBankName)).sendKeys("Vietcombank");

		driver.findElement(By.xpath(btnHinhThucTT)).click();
		driver.findElement(By.xpath(listHinhThucTT)).click();
		;

		// JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath(btnLoaiTien)));

		pauseBrowser(3);
		driver.findElement(By.xpath(btnLoaiTien)).click();

		driver.findElement(By.xpath(listLoaiTien)).click();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath(btnChietKhau)));

		driver.findElement(By.xpath(btnChietKhau)).click();
		driver.findElement(By.xpath(listChietKhau)).click();

		/*
		 * driver.findElement(By.xpath(layoutTinhChat)).click();
		 * driver.findElement(By.xpath(btnTinhChat)).click();
		 * driver.findElement(By.xpath(listTinhChat)).click();
		 * //System.out.println("TC: OK");
		 * 
		 * driver.findElement(By.xpath(txtTenHangHoa)).sendKeys("Sách");
		 * 
		 * driver.findElement(By.xpath(layoutDonViTinh)).click();
		 * System.out.println("OK");
		 * 
		 * //driver.findElement(By.xpath(txtDonViTinh)).sendKeys("Quyển");
		 * 
		 * 
		 * driver.findElement(By.xpath(layoutSoLuong)).click();
		 * driver.findElement(By.xpath(txtSoLuong)).sendKeys("5");
		 * 
		 * driver.findElement(By.xpath(layoutDonGia)).click();
		 * driver.findElement(By.xpath(txtDonGia)).sendKeys("1600");
		 * 
		 * driver.findElement(By.xpath(layoutThue)).click();
		 * driver.findElement(By.xpath(btnThue)).click();
		 * driver.findElement(By.xpath(selectedThue)).click();
		 */

		// thêm 3 sản phẩm
		driver.findElement(By.xpath(btnThemSP)).click();

		Boolean isSelectedSP1 = driver.findElement(By.xpath(checkboxSP01)).isSelected();
		if (isSelectedSP1 == false) {
			driver.findElement(By.xpath(checkboxSP01)).click();
		}

		Boolean isSelectedSP2 = driver.findElement(By.xpath(checkboxSP02)).isSelected();
		if (isSelectedSP2 == false) {
			driver.findElement(By.xpath(checkboxSP02)).click();
		}

		Boolean isSelectedSP3 = driver.findElement(By.xpath(checkboxSP03)).isSelected();
		if (isSelectedSP3 == false) {
			driver.findElement(By.xpath(checkboxSP03)).click();
		}

		driver.findElement(By.xpath(btnThem)).click();
		
		//

		driver.findElement(By.xpath(btnTaoMoi)).click();
		WebElement popupXacNhanElement = driver.findElement(By.xpath(popupXacNhan));
		if (popupXacNhanElement.isDisplayed()) {
			System.out.println("Thành Công");
		} else {
			System.out.println("Có Lỗi");
		}

		pauseBrowser(10);

	}

	@AfterTest
	public void tearDown() {
		closeBrowser();
		System.out.println("Browser closed successfully.");
	}

}
