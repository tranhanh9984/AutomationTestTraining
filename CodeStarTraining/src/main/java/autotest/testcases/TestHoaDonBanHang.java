package autotest.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import autocom.common.CommonBase;
import autotest.pages.HoaDonBanHang;
import autotest.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestHoaDonBanHang extends HoaDonBanHang {
	JavascriptExecutor js;
	public LoginPage loginPage;

	public TestHoaDonBanHang() {

	}

	public TestHoaDonBanHang(WebDriver driver) {
		if (this.driver == null) {
			this.driver = driver;
		}
	}
	@Test
	public void testFunction() {
		editHoaDon("11/12/2024","to chuc a","935,000");
		pause(500);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("https://uat-invoice.kaike.vn/customer/invoice/hdbh/update"),
				"Test failed: fail go to Edit Hoa Don Ban hang");
	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
		loginPage = new LoginPage(driver);
		js = (JavascriptExecutor) driver;
		loginPage.testLoginSuccess();
		pause(2000);

		String currentUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(currentUrl, "https://uat-invoice.kaike.vn/login",
				"Test failed: User is still on the login page.");

		goToPage("Hóa đơn/Hóa đơn bán hàng");
		pause(1000);
		currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://uat-invoice.kaike.vn/customer/invoice/hdbh",
				"Test failed: fail go to Hoa Don Ban hang");
	}
}
