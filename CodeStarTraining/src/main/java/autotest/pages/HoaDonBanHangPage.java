package autotest.pages;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonFuncs;
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class HoaDonBanHangPage extends CommonPage {
	
	@FindBy(xpath = "//p-calendar[@id='fromDate']//input") public WebElement txtFromDate;
	@FindBy(xpath = "//p-calendar[@id='thruDate']//input") public WebElement txtToDate;
	@FindBy(xpath = "//app-iam-table//table/thead/tr[2]/th[4]//input") WebElement txtKhachHang;
	@FindBy(xpath = "//p-confirmdialog//button[contains(@class,'p-confirm-dialog-accept')]") WebElement btnYesConfirm;
	
	String pCalendar = "//p-calendar[@id='%s']";
	String spMonth = "//p-calendar[@id='%s']//span[contains(@class,'p-datepicker-month')]";
	String spYear = "//p-calendar[@id='%s']//span[contains(@class,'p-datepicker-year')]";
	String btnPreMonth = "//p-calendar[@id='%s']//button[contains(@class,'p-datepicker-prev')]";
	String btnNextMonth = "//p-calendar[@id='%s']//button[contains(@class,'p-datepicker-next')]";
	String spDay = "//p-calendar[@id='%s']//table//td[not(contains(@class,'p-datepicker-other-month'))]/span[text()=%d]";
	
	String btnAction = "//app-iam-table//table/tbody/tr[%d]/td[10]/p-button[@title='%s']";

	public HoaDonBanHangPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LocalDate getSelectedate(WebElement element) {
		return CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, element.getAttribute("value"));
	}
	
	public void clickMonth(LocalDate from, LocalDate to, String idDate, String btnName) {
		int i = 0;
		long monthsBetween = Math.abs(ChronoUnit.MONTHS.between(from, to));
//		if (idDate == "fromDate") {
//			monthsBetween = monthsBetween + 1;
//		}
		while (i < monthsBetween) {
			driver.findElement(By.xpath(String.format(btnName, idDate))).click();
			i ++;
		}
	}
	
	public void setDate(LocalDate date, String idDate, WebElement elementDate) {
		LocalDate currentSelectedDate = this.getSelectedate(elementDate);
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
		this.setDate(fromDate, "fromDate", txtFromDate);
	}
	
	public void setToDate(LocalDate toDate) {
		this.setDate(toDate, "thruDate", txtToDate);
	}
	
	public void filterKhachHang(String value) {
		this.clearTextByWebElement(this.txtKhachHang);
		this.txtKhachHang.sendKeys(value);
		this.txtKhachHang.sendKeys(Keys.ENTER);
	}
	
	public void quickSearch(LocalDate localDate, String tenKhachHang) {
		this.setFromDate(localDate);
		this.setToDate(localDate);
		this.filterKhachHang(tenKhachHang);
	}
	
	public void goToActionHoaDon(int indexRow, String actionName) {
		driver.findElement(By.xpath(String.format(btnAction, indexRow, actionName))).click();
	}
	
	public void clickYesConfirm() {
		this.btnYesConfirm.click();
	}
	
}
