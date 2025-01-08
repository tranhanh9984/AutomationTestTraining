package autotest.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import autotest.pages.HaDV_LapHoaDonPage;
import autotest.pages.HaDV_LoginPage;

public class HaDV_LapHoaDonTestcase extends HaDV_LapHoaDonPage {

	public HaDV_LapHoaDonTestcase() {
		// TODO Auto-generated constructor stub
	}

	public HaDV_LapHoaDonTestcase(WebDriver driver) {
		if (this.driver == null) {
			this.driver = driver;
		}
	}

	public void testTaoMoiHoaDonSuccess() {
		taoMoiHoaDon_Success();
	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
		loginPage = new HaDV_LoginPage(driver);
		loginPage.loginSuccess();
		pause(2000);
		checkNOTMatchedURL("https://uat-invoice.kaike.vn/login", 5, "Test failed: User is still on the login page.");
		goToPage("Hóa đơn/Lập hoá đơn");
		checkURLMatched("https://uat-invoice.kaike.vn/customer/invoice/hdbh/create", 5,
				"Test failed: fail go to Lap Hoa Don");
	}
}
