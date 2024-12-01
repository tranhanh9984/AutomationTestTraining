package autotest.pages;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.By;

import autocom.common.CommonFuncs;
import autocom.constant.KeywordConstant;

public class HoaDonBanHangPage extends LoginPage {

	String xpathFromDate = "//p-calendar[@id='fromDate']//input";
	String xpathToDate = "//p-calendar[@id='thruDate']//input";
	String xpathDropdownPage = "//app-iam-table/p-table//p-paginator//p-dropdown";
	
	public HoaDonBanHangPage() {
		// TODO Auto-generated constructor stub
	}

	public void gotoHoaDonBanHangPage() {
		this.login(KeywordConstant.USER_NAME, KeywordConstant.PASS_WORD);
		
		MenuBar menuBar = new MenuBar(driver);
		menuBar.getMenuItemByText(KeywordConstant.MENUBAR_INVOICE).click();
		menuBar.getSubMenuItemByText(KeywordConstant.MENUBAR_INVOICE_SUB_HDBH).click();
		
		pause(2);
	}
	
	public void viewAll() {
		driver.findElement(By.xpath(xpathDropdownPage)).click();
		driver.findElement(By.xpath("//app-iam-table/p-table//p-paginator//p-dropdown//ul/p-dropdownitem/li/span[text()=100]")).click();
	}
	
	public void quickSearch() {
//		LocalDateTime currentDateTime = LocalDateTime.now();
//		
//		this.clearText(xpathFromDate);
//		driver.findElement(By.xpath(xpathFromDate)).sendKeys(CommonFuncs.getDateByFormat("dd/mm/yyyy", currentDateTime));
//		this.clearText(xpathToDate);
//		driver.findElement(By.xpath(xpathToDate)).sendKeys(CommonFuncs.getDateByFormat("dd/mm/yyyy", currentDateTime));
	}
	
}
