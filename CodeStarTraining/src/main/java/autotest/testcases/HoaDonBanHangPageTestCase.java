package autotest.testcases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import autocom.common.CommonFuncs;
import autocom.constant.KeywordConstant;
import autotest.pages.HoaDonBanHangPage;

public class HoaDonBanHangPageTestCase extends HoaDonBanHangPage {

	public HoaDonBanHangPageTestCase() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void init() {
		this.startBrowser(KeywordConstant.LOGIN_URL);
		this.gotoHoaDonBanHangPage();
	}
	
	@AfterClass
	public void close() {
		this.closeBrowser();
	}
	
	//@Test
	public void tc_filterDate() {
		LocalDate fromDate = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, "23/09/2024");
		this.setFromDate(fromDate);
		
		LocalDate toDate = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, "24/01/2025");
		this.setToDate(toDate);
		
		// compare date
		LocalDate fromDateActual = this.getSelectedate("fromDate");
		LocalDate toDateActual = this.getSelectedate("thruDate");
		Assert.assertEquals(fromDateActual.isEqual(fromDate), true);
		Assert.assertEquals(toDateActual.isEqual(toDate), true);
		
		pause(5);
	}
	
	@DataProvider(name = "dataProvider_clickButtonHeader")
	public Object[][] provideData(){
		return new Object[][] {
			{ "Test case 1", "Tạo mới", "", true },
			{ "Test case 2", "Ký hàng loạt", "Ký hoá đơn", false },
			{ "Test case 3", "Download hóa đơn", "Download hóa đơn theo dải", false },
			{ "Test case 4", "Upload excel", "Upload excel hóa đơn", false }
		};
	}
	
	//@Test(dataProvider = "dataProvider_clickButtonHeader")
	public void tc_clickButtonHeader(String testCaseName, String btnName, String headerName, boolean isBtnTaoMoi) {
		System.out.println(testCaseName);
		this.clickButtonHeader(btnName);
		if (isBtnTaoMoi) {
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(currentUrl, KeywordConstant.CREATE_INVOICE_URL);
			this.goToMenu(KeywordConstant.MENUBAR_INVOICE, KeywordConstant.MENUBAR_INVOICE_SUB_HDBH);
		} else {
			Assert.assertEquals(this.isShowDialog(headerName), true);
			this.clickButtonCloseDialog(headerName);
		}
		
		pause(3);
	}
	
	@Test
	public void tc_downloadHoaDon_validate() {
		this.clickButtonHeader("Download hóa đơn");
		
		Assert.assertEquals(this.isShowDialog("Download hóa đơn theo dải"), true);
		this.selectMauHoaDon("6C23NKK");
		
		Assert.assertEquals(this.getDataMauHoaDon(), "6C23NKK");
		
		pause(5);
	}
	
}
