package autocom.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.pages.HoaDonPage;
import autocom.pages.HomePage;
import autocom.pages.LoginPage;

public class TaoHoaDonTestCase extends CommonPage {
	WebDriver driver;
	HomePage homePage;
	HoaDonPage hoadon;

	@BeforeTest
	public void startPage() {
		driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");

	}

	@Test

	public void testTaoHoaDonandSave() {
		LoginPage login = new LoginPage(driver);
		login.login("caonv174@gmail.com", "123456", "0312303803-999");

		pause(5000);

		HomePage homePage = new HomePage(driver);
		HoaDonPage hoadon = new HoaDonPage(driver);
		homePage.clickMenuHoaDon();
		homePage.clickMenuTaoHoaDon();
		hoadon.fillTaoHoaDonForm("5300680806", "Huong", "0912345678", "huong@brulland.com", "RON 95-V");

		String dshd = hoadon.pageTitleVerify();
		Assert.assertEquals(dshd, "Danh sách hoá đơn");

		// HomePage homePage = new HomePage(driver);
		// HoaDonPage hoadon = new HoaDonPage(driver);

		// homePage.clickMenu("Hóa đơn\Tạo hoá đơn");
		// homePage.clickMenuHoaDon();
		// homePage.clickMenuTaoHoaDon();
		// hoadon.enterMSTKhachHang("5300680806");
		// pause(1000);
		// hoadon.enterCustomerName("Huong");
		// pause(2000);
		// hoadon.enterCustomerPhone("0912345678");
		// hoadon.enterCustomerEmail("huong@brulland.com");
		// hoadon.enterProductCodeService("RON 95-V");
		// hoadon.clickLuuvaKy();

		// String pageTitle = hoadon.pageTitleVerify();
		// Assert.assertEquals(pageTitle, "Danh sách hoá đơn");

	}
}
