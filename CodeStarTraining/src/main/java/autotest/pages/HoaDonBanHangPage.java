package autotest.pages;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autocom.common.CommonFuncs;
import autocom.constant.KeywordConstant;

public class HoaDonBanHangPage extends LoginPage {

//	String xpathFromDate = "//p-calendar[@id='fromDate']//input";
//	String xpathToDate = "//p-calendar[@id='thruDate']//input";
//	String xpathDropdownPage = "//app-iam-table/p-table//p-paginator//p-dropdown";

	
	
//	String pcFromDate = "//p-calendar[@id='fromDate']";
//	String pcToDate = "//p-calendar[@id='thruDate']";
//	String dateFrom = "//p-calendar[@id='fromDate']//input";
//	String dateTo = "//p-calendar[@id='thruDate']//input";
	
	String idFromDate = "fromDate";
	String idToDate = "thruDate"; 
	String pCalendar = "//p-calendar[@id='%s']";
	String dateInput = "//p-calendar[@id='%s']//input";
	String spMonth = "//p-calendar[@id='%s']//span[contains(@class,'p-datepicker-month')]";
	String spYear = "//p-calendar[@id='%s']//span[contains(@class,'p-datepicker-year')]";
	String btnPreMonth = "//p-calendar[@id='%s']//button[contains(@class,'p-datepicker-prev')]";
	String btnNextMonth = "//p-calendar[@id='%s']//button[contains(@class,'p-datepicker-next')]";
	String spDay = "//p-calendar[@id='%s']//table//span[text()=%d]";
	
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
//		driver.findElement(By.xpath(xpathDropdownPage)).click();
//		driver.findElement(By.xpath("//app-iam-table/p-table//p-paginator//p-dropdown//ul/p-dropdownitem/li/span[text()=100]")).click();
	}
	
//	public int getCurrentMonth() {
//		String month = driver.findElement(By.xpath(String.format(spMonth, idFromDate))).getAttribute("textContent");
//		return CommonFuncs.convertMonthStringToInt(month);
//	}
//	
//	String btnPreMonth = "//p-calendar//button[contains(@class,'p-datepicker-prev')]";
//	String btnNextMonth = "//p-calendar//button[contains(@class,'p-datepicker-next')]";
//	public void setMonth(int month) {
//		int currentSelectedMonth = CommonFuncs.convertMonthStringToInt(driver.findElement(By.xpath(String.format(spMonth, idFromDate))).getAttribute("textContent"));
//		int diffNumber = currentSelectedMonth - (month + 1);
//		if (diffNumber != 0) {
//			String btnMonth = diffNumber > 0 ? btnPreMonth : btnNextMonth;
//			for(int i = 1; i <= Math.abs(diffNumber); i++) {
//				driver.findElement(By.xpath(btnMonth)).click();
//			}
//		}
//	}
//	
//	public void setFromDate(Date date) {
//		driver.findElement(By.xpath(dateFrom)).click();
//		this.setMonth(date.getMonth());
//	}
	
	public LocalDate getSelectedate(String idDate) {
		String dateString = driver.findElement(By.xpath(String.format(dateInput, idDate))).getAttribute("value");
		LocalDate fromDateConverted = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, dateString);
		return fromDateConverted;
	}
	
	public void clickMonth(LocalDate from, LocalDate to, String idDate, String btnName) {
		int i = 0;
		long monthsBetween = Math.abs(ChronoUnit.MONTHS.between(from, to));
		while (i < monthsBetween) {
			driver.findElement(By.xpath(String.format(btnName, idDate))).click();
			i ++;
		}
	}
	
	public void setDate(LocalDate date, String idDate) {
		LocalDate currentSelectedDate = this.getSelectedate(idDate);
		if (date.isEqual(currentSelectedDate)) return;
		else {
			driver.findElement(By.xpath(String.format(pCalendar, idDate))).click();
			if (date.isBefore(currentSelectedDate)) {
				this.clickMonth(date, currentSelectedDate, idDate, btnPreMonth);
			} else {
				this.clickMonth(currentSelectedDate, date, idDate, btnNextMonth);
			}
			driver.findElement(By.xpath(String.format(spDay, idDate, date.getDayOfMonth()))).click();
		}
	}
	
	public void setFromDate(LocalDate fromDate) {
		this.setDate(fromDate, idFromDate);
	}
	
	public void setToDate(LocalDate toDate) {
		this.setDate(toDate, idToDate);
	}
	
	public void quickSearch() {
		LocalDate currentDate = LocalDate.now();
		this.setDate(currentDate, idFromDate);
		this.setDate(currentDate, idToDate);
	}
	
}
