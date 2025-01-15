package autotest.testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import autocom.common.HaDV_CommonBase;
import autotest.pages.HaDV_ListingHoaDonPage;
import autotest.pages.HaDV_LoginPage;
import autotest.pages.HaDV_CreateHoaDonPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class HaDV_ListingHoaDonTestcase extends HaDV_ListingHoaDonPage {
	JavascriptExecutor js;
	public HaDV_LoginPage loginPage;
	public HaDV_CreateHoaDonPage CreateHoaDon;

	public HaDV_ListingHoaDonTestcase() {

	}

	public HaDV_ListingHoaDonTestcase(WebDriver driver) {
		if (this.driver == null) {
			this.driver = driver;
		}
	}

	@Test
	public void testEditHoaDonSuccess() {
		// ngày HĐ = 15/12/2024
		// Tên đơn vị = Khách hàng = Do Viet Ha
		// 1,285,000
		chooseHoaDon("15/12/2024", "Do Viet Ha", "1,285,000");
		Assert.assertNotNull(filteredHoaDonResultStatus(), "Hoa Don ton tai nhung khong filter ra ket qua");
		clickEditButtonXpath();
		Assert.assertNotNull(CreateHoaDon.onSuaHoaDonPage(), "click btnEdit khong direct sang edit hoa hon page");
		CreateHoaDon.editHoaDon("15/12/2024", "Do Viet Ha", "1,285,000");
		Assert.assertNotNull(onListingHoaDonPage(), "click btnEdit khong direct sang edit hoa hon page");
		System.out.println("testEditHoaDon old khach hang ::::" + oldKhachHang);
		System.out.println("testEditHoaDon new khach hang ::::" + newKhachHang);
	}

	public void testFunction() {
		editHoaDon("11/12/2024", "to chuc a", "935,000");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("https://uat-invoice.kaike.vn/customer/invoice/hdbh/update"),
				"Test failed: fail go to Edit Hoa Don Ban hang");
	}

	@Test
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
		loginPage = new HaDV_LoginPage(driver);
		CreateHoaDon = new HaDV_CreateHoaDonPage(driver);

		js = (JavascriptExecutor) driver;
		loginPage.loginSuccess();
		checkNOTMatchedURL("https://uat-invoice.kaike.vn/login", 5, "Test failed: User is still on the login page.");
		goToPage("Hóa đơn/Hóa đơn bán hàng");
		checkURLMatched("https://uat-invoice.kaike.vn/customer/invoice/hdbh", 5,
				"Test failed: fail go to Hoa Don Ban hang");
	}
}
