package autocom.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.pages.LoginPage;

public class LoginTestCase extends CommonPage {

	WebDriver driver;
	String noti = "//div[@role = 'alert']";

	@BeforeTest
	public void startPage() {
		driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");

	}

	 //@AfterTestss
	//public void closePage() throws InterruptedException {
	//this.closeBrowser(driver);
	//}

	@Test
	public void testLoginSuccessful() {

		LoginPage login = new LoginPage(driver);
		login.login("caonv174@gmail.com", "123456", "0312303803-999");

		pause(5000);

		// assertTrue(driver.findElement(By.xpath("//div[@id='company-info']")).isDisplayed());

		String txtWelCome = driver.findElement(By.xpath(noti)).getText();
		Assert.assertTrue(txtWelCome.contains("Nguyễn Văn Cao"));

	}
	
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
