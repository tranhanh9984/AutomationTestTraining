package autotest.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import autocom.common.HaDV_CommonBase;
import autotest.pages.HaDV_HoaDonBanHangPage;
import autotest.pages.HaDV_LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class HaDV_HoaDonBanHangTestcase extends HaDV_HoaDonBanHangPage {
	JavascriptExecutor js;
	public HaDV_LoginPage loginPage;

	public HaDV_HoaDonBanHangTestcase() {

	}

	public HaDV_HoaDonBanHangTestcase(WebDriver driver) {
		if (this.driver == null) {
			this.driver = driver;
		}
	}

	@Test
	public void testEditHoaDon() {
		// ngày HĐ = 15/12/2024
		// Tên đơn vị = Khách hàng = Do Viet Ha
		// 1,285,000
		editHoaDon("15/12/2024", "Do Viet Ha", "1,285,000");
	}
	public void testFunction() {
		editHoaDon("11/12/2024", "to chuc a", "935,000");
		pause(500);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("https://uat-invoice.kaike.vn/customer/invoice/hdbh/update"),
				"Test failed: fail go to Edit Hoa Don Ban hang");
	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
		loginPage = new HaDV_LoginPage(driver);
		js = (JavascriptExecutor) driver;
		loginPage.loginSuccess();
		checkNOTMatchedURL("https://uat-invoice.kaike.vn/login", 5, "Test failed: User is still on the login page.");
		goToPage("Hóa đơn/Hóa đơn bán hàng");
		checkURLMatched("https://uat-invoice.kaike.vn/customer/invoice/hdbh", 5,
				"Test failed: fail go to Hoa Don Ban hang");
	}
}
