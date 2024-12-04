package autotest.testcases;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
	
	@Test
	public void tc1() {
//		LocalDate fromDate = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, "23/09/2024");
//		this.setFromDate(fromDate);
//		
//		LocalDate toDate = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, "24/01/2025");
//		this.setToDate(toDate);
		
		this.quickSearch();
		
		pause(5);
	}

}
