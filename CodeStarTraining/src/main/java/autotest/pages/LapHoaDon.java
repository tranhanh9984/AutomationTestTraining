package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import autocom.common.CommonBase;

public class LapHoaDon extends CommonBase {

	public LapHoaDon() {

	}

	public LapHoaDon(WebDriver driver) {
		if (this.driver == null) {
			this.driver = driver;
		}
		// PageFactory.initElements(driver, this);
	}

	@Test
	public void testFunction() {
		taoMoiHoaDon_Success();
	}

	public void taoMoiHoaDon_Success() {
		tc_dienThongtin();
		themHangHoaDichVu();
		checkTienTungMatHang();
		checkTongTienHang();
		checkTienThueGTGT();
		checkTongTienThanhToan();

		click("//p-button[@type='submit']//span[text()='Tạo mới']", NO_SCROLL);
		pause(500);
		int successMessage = driver
				.findElements(By.xpath("//div[contains(@class,'p-toast-message-success')]//div[text()='Thành công!']"))
				.size();
		System.out.println("found element ::::" + driver.findElements(
				By.xpath("//div[contains(@class,'p-toast-message-success')]//div[text()='Thành công!']")));
		System.out.println("int successMessage ::::" + successMessage);
		String currentURL = "";
		String expectURL = "https://uat-invoice.kaike.vn/customer/invoice/hdbh";

		Assert.assertTrue(successMessage > 0, "TC Failed: Success Mess hiển thị không đúng expect");
	}

	public void taoMoiHoaDon_Error1() {
		tc_dienThongtin();
		themHangHoaDichVu();
		// Bỏ trống Người mua hàng và Tên Đơn Vị

		setText("//input[@id='toName']", "", true);

		setText("//p-autocomplete[@id='toPartyName']//input", "", true);

		click("//p-button[@type='submit']//span[text()='Tạo mới']", NO_SCROLL);
		int errorMessage = driver.findElements(By.xpath(
				"//div[contains(@class,'p-toast-message-error')]//div[text()='Tên đơn vị hoặc người mua hàng không được bỏ trống']"))
				.size();
		Assert.assertTrue(errorMessage > 0, "TC Failed: Error Mess hiển thị không đúng expect");
	}

	public void taoMoiHoaDon_Error2() {
		// Nhập sai MST và click vào Lấy Thông Tin -> Expected: Hiển thị Error Mess
		// input text MST người mua
		setText("//p-autocomplete[@id='toPartyTaxId']//input", "999", true);

		// click vào Lấy Thông Tin btn để pre-filled các thông tin có trong data
		click("//span[text()='Lấy thông tin']/..", SCROLL);

		String MST = getInputText("//p-autocomplete[@id='toPartyTaxId']//input");

		int errorMessage = driver.findElements(By.xpath(
				"//div[contains(@class,'p-toast-message-error')]//div[text()='Không tìm thấy thông tin doanh nghiệp/cá nhân có mã số thuế: "
						+ MST + ". Hãy xem lại']"))
				.size();
		Assert.assertTrue(errorMessage > 0, "TC Failed: Error Mess hiển thị không đúng expect");
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

	public void checkTienTungMatHang() {
		// Thanh tien = so luong x don gia
		int soLuongMatHang = driver.findElements(By.xpath("//form//p-table//tbody/tr")).size();
		System.out.println("soLuongMatHang ::::" + soLuongMatHang);

		for (int i = 1; i < soLuongMatHang; i++) {
			// form//p-table//tbody/tr[1]//td[5]
			String soLuong = driver.findElement(By.xpath("//form//p-table//tbody/tr[" + i + "]//td[5]")).getText();
			String donGia = driver.findElement(By.xpath("//form//p-table//tbody/tr[" + i + "]//td[6]")).getText();
			String thanhTien = driver.findElement(By.xpath("//form//p-table//tbody/tr[" + i + "]//td[7]")).getText();
			String phanTramThue = driver.findElement(By.xpath("//form//p-table//tbody/tr[" + i + "]//td[8]")).getText();
			String tienThue = driver.findElement(By.xpath("//form//p-table//tbody/tr[" + i + "]//td[9]")).getText();

			double numberSoluong = Double.parseDouble(soLuong.replace(",", ""));
			double numberDonGia = Double.parseDouble(donGia.replace(",", ""));
			double numberThanhTien = Double.parseDouble(thanhTien.replace(",", ""));
			double checkThanhTien = numberSoluong * numberDonGia;

			Assert.assertEquals(checkThanhTien, numberThanhTien, "Failed: Tinh sai Thanh Tien");

			double numberPhanTramThue = Double.parseDouble(phanTramThue.replace("%", ""));
			double numberTienThue = Double.parseDouble(tienThue.replace(",", ""));
			double checkTienThue = (checkThanhTien / 100) * numberPhanTramThue;

			Assert.assertEquals(checkTienThue, numberTienThue, "Failed: Tinh sai Tien Thue");
		}

		String soluong = driver.findElement(By.xpath("//table[@class='p-datatable-table ng-star-inserted']//td[5]"))
				.getText();
		String dongia = driver.findElement(By.xpath("//table[@class='p-datatable-table ng-star-inserted']//td[6]"))
				.getText();
		double soluong2 = Double.parseDouble(soluong.replace(",", ""));
		double dongia2 = Double.parseDouble(dongia.replace(",", ""));
		double thanhtien = soluong2 * dongia2;
		String getthanhtien = driver
				.findElement(By.xpath("//table[@class='p-datatable-table ng-star-inserted']//td[7]")).getText();
		double getthanhtien2 = Double.parseDouble(getthanhtien.replace(",", ""));
		Assert.assertEquals(thanhtien, getthanhtien2, "Failed: Tinh sai Thanh Tien");
	}

	public void checkTongTienHang() {
		// Tổng tiền hàng = Tổng các hàng Thành Tiền
		int soLuongMatHang = driver.findElements(By.xpath("//form//p-table//tbody/tr")).size();
		double tongTienHang = 0;

		for (int i = 1; i < soLuongMatHang; i++) {
			String thanhTien = driver.findElement(By.xpath("//form//p-table//tbody/tr[" + i + "]//td[7]")).getText();
			double numberThanhTien = Double.parseDouble(thanhTien.replace(",", ""));
			tongTienHang = tongTienHang + numberThanhTien;
		}

		String getTongTienHang = driver.findElement(By.xpath("//p-inputnumber[@id='grandTotal']//input"))
				.getAttribute("value");
		double numberTongTienHang = Double.parseDouble(getTongTienHang.replace(",", ""));
		Assert.assertEquals(tongTienHang, numberTongTienHang, "Failed: Tinh sai Tong Tien Hang");

	}

	public void checkTienThueGTGT() {
		// Tổng tiền thuế GTGT = tổng các dòng Tiền thuế
		int soLuongMatHang = driver.findElements(By.xpath("//form//p-table//tbody/tr")).size();
		double tongTienThueGTGT = 0;

		for (int i = 1; i < soLuongMatHang; i++) {
			String tienThue = driver.findElement(By.xpath("//form//p-table//tbody/tr[" + i + "]//td[9]")).getText();
			double numberTienThue = Double.parseDouble(tienThue.replace(",", ""));
			tongTienThueGTGT = tongTienThueGTGT + numberTienThue;
		}
		String getTongTienThueGTGT = driver.findElement(By.xpath("//p-inputnumber[@id='taxAmount']//input"))
				.getAttribute("value");
		double numberTongTienThueGTGT = Double.parseDouble(getTongTienThueGTGT.replace(",", ""));
		Assert.assertEquals(tongTienThueGTGT, numberTongTienThueGTGT, "Failed: Tinh sai Tong Tien Hang");

	}

	public void checkTongTienThanhToan() {
		// Tổng tiền thanh toán= Tổng tiền hàng + Tiền Thuế GTGT
		getAttribute("//p-inputnumber[@id='invoiceTotal']//input", "value");
		String getTongTienHang = getAttribute("//p-inputnumber[@id='grandTotal']//input", "value");
		double numberTongTienHang = Double.parseDouble(getTongTienHang.replace(",", ""));
		String getTongTienThueGTGT = getAttribute("//p-inputnumber[@id='taxAmount']//input", "value");
		double numberTongTienThueGTGT = Double.parseDouble(getTongTienThueGTGT.replace(",", ""));
		double tongTienThanhToan = numberTongTienHang + numberTongTienThueGTGT;
		String getTongTienThanhToan = getAttribute("//p-inputnumber[@id='invoiceTotal']//input", "value");
		int intGetTongTienThanhToan = Integer.parseInt((getTongTienThanhToan).replace(",", ""));
		Assert.assertEquals(tongTienThanhToan, intGetTongTienThanhToan, "Failed: Tinh sai Tong Tien Thanh Toan");
	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
		loginPage = new LoginPage(driver);
		loginPage.testLoginSuccess();
		pause(2000);

		String currentUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(currentUrl, "https://uat-invoice.kaike.vn/login",
				"Test failed: User is still on the login page.");

		goToPage("Hóa đơn/Lập hoá đơn");

		pause(1000);
		currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://uat-invoice.kaike.vn/customer/invoice/hdbh/create",
				"Test failed: fail go to Hoa Don Ban hang");
	}

}
