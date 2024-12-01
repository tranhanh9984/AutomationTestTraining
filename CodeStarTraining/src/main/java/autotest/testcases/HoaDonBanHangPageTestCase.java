package autotest.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
	
	@Test
	public void tc1() {
		this.viewAll();
		
		pause(5);
	}

}
