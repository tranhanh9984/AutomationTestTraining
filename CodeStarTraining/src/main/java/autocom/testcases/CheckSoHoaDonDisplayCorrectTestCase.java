package autocom.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.pages.DanhSachHoaDon;
import autocom.pages.HoaDonPage;
import autocom.pages.HomePage;
import autocom.pages.LoginPage;

public class CheckSoHoaDonDisplayCorrectTestCase extends CommonPage {
	
	WebDriver driver;
	HomePage homePage;
	HoaDonPage hoadon;
	CommonPage commonPage;

	@BeforeTest
	public void startPage() {
		driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");

	}

	@Test

	public void testTaoHoaDonandSave() {
		LoginPage login = new LoginPage(driver);
		login.login("caonv174@gmail.com", "123456", "0312303803-999");

		pause(5000);

		HoaDonPage hoadon = new HoaDonPage(driver);
	
		//hoadon.fillTaoHoaDonForm("44444","Huong","RON 95-V");
		
		
		//String dshd = hoadon.pageTitleVerify();
		//Assert.assertEquals(dshd, "Danh sách hoá đơn");
		
		// kiểm tra hóa đơn được store trên màn danh sách
		//DanhSachHoaDon dshd = new DanhSachHoaDon(driver);
		//dshd.getDSHoaDon();
		//HomePage homePage = new HomePage(driver);
		DanhSachHoaDon dshd = new DanhSachHoaDon(driver);
		hoadon.clickMenu("Hóa đơn/Danh sách hoá đơn");
		dshd.openFilterDataHoaDon();
		dshd.selectStartDate("04/20/2024");
		dshd.selectEndDate("04/20/2024");
		
		String lblSoHoaDon = driver.findElement(By.xpath("//div[@data-column-id= 'no']")).getText();
		Assert.assertTrue(lblSoHoaDon.contains("00018773"));
		
	}
}
