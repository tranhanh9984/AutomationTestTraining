//package autotest.testcases;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import autocom.common.CommonPage;
//import autotest.pages.DanhSachHoaDon;
//import autotest.pages.LoginPage;
//import autotest.pages.TaoHoaDon;
//
//public class TaoHoaDonTestcases extends CommonPage {
//
//	@Test
//	public void taoHoaDonThanhCong() {
//		// login thành công vào trang
//		LoginPage login = new LoginPage(driver);
//		login.login();
//		// input thông tin hoa đơn
//		this.clickMenu("Hóa đơn/Tạo hoá đơn");
//		
//		TaoHoaDon taoHD = new TaoHoaDon(driver);
//		taoHD.createNew();
//		
//		// kiểm tra hóa đơn được store trên màn danh sách
//		DanhSachHoaDon dshd = new DanhSachHoaDon(driver);
//		dshd.getDSHoaDon();
//	}
//
//	@BeforeClass
//	public void startPage() {
//		driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");
//
//	}
//
//	@AfterClass
//	public void closePage() throws InterruptedException {
////			Thread.sleep(2);
//		this.closeBrowser(driver);
//	}
//
//}
