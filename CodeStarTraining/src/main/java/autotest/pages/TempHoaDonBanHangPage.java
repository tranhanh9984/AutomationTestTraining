package autotest.pages;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import autocom.common.CommonFuncs;
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class TempHoaDonBanHangPage extends CommonPage {

	String idFromDate = "fromDate";
	String idToDate = "thruDate"; 
	String pCalendar = "//p-calendar[@id='%s']";
	String dateInput = "//p-calendar[@id='%s']//input";
	String spMonth = "//p-calendar[@id='%s']//span[contains(@class,'p-datepicker-month')]";
	String spYear = "//p-calendar[@id='%s']//span[contains(@class,'p-datepicker-year')]";
	String btnPreMonth = "//p-calendar[@id='%s']//button[contains(@class,'p-datepicker-prev')]";
	String btnNextMonth = "//p-calendar[@id='%s']//button[contains(@class,'p-datepicker-next')]";
	String spDay = "//p-calendar[@id='%s']//table//td[not(contains(@class,'p-datepicker-other-month'))]/span[text()=%d]";
	
	String btnHeaderCommon = "//span[text()='%s']/parent::button";
	String dialogCommon = "//p-dialog[@header='%s']//div[@role='dialog']";
	String btnCloseDialog = "//p-dialog[@header='%s']//div[@role='dialog']//div[contains(@class,'p-dialog-header-icons')]/button";
	
	String txtFilter = "//app-iam-table//table/thead/tr[%d]/th[%d]//input";
	String btnAction = "//app-iam-table//table/tbody/tr[%d]/td[10]/p-button[@title='%s']";
	String btnYesConfirm = "//p-confirmdialog//button[contains(@class,'p-confirm-dialog-accept')]";
	
	// dialog download hoa don
	String cbbMauHoaDon = "//p-dropdown[@id='invoiceTemplatePartyId']";
	String dropdownItem = "//p-dropdown[@id='invoiceTemplatePartyId']//p-dropdownitem";
	String btnDongY = "//p-dialog[@header='Download hóa đơn theo dải']//p-footer//button[@type='submit']";
	
//	LoginPage loginPage;
	
	public TempHoaDonBanHangPage() {
		// TODO Auto-generated constructor stub
	}
	
	public TempHoaDonBanHangPage(WebDriver wd) {
		// TODO Auto-generated constructor stub
		this.driver = wd;
	}

	public void gotoHoaDonBanHangPage() {
		//this.login(KeywordConstant.USER_NAME, KeywordConstant.PASS_WORD);
		//this.login();
		this.goToMenu(KeywordConstant.MENUBAR_INVOICE, KeywordConstant.MENUBAR_INVOICE_SUB_HDBH);
		
		pause(2);
	}
	
	public LocalDate getSelectedate(String idDate) {
		String dateString = driver.findElement(By.xpath(String.format(dateInput, idDate))).getAttribute("value");
		LocalDate fromDateConverted = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, dateString);
		return fromDateConverted;
	}
	
	public void clickMonth(LocalDate from, LocalDate to, String idDate, String btnName) {
		int i = 0;
		long monthsBetween = Math.abs(ChronoUnit.MONTHS.between(from, to));
		if (idDate == idFromDate) {
			monthsBetween = monthsBetween + 1;
		}
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
	
	public void filterText(String value, int rowIndex, int columnIndex) {
		WebElement weKhachHang = driver.findElement(By.xpath(String.format(txtFilter, rowIndex, columnIndex)));
		this.clearText(String.format(txtFilter, 2, 4));
		weKhachHang.sendKeys(value);
		weKhachHang.sendKeys(Keys.ENTER);
	}
	
	public void quickSearch(LocalDate localDate, String tenKhachHang) {
//		this.setDate(localDate, idFromDate);
//		this.setDate(localDate, idToDate);
		this.filterText(tenKhachHang, 2, 4); // filter ten khach hang
	}
	
	public void goToActionHoaDon(int indexRow, String actionName) {
		driver.findElement(By.xpath(String.format(btnAction, indexRow, actionName))).click();
	}
	
	public void clickYesConfirm() {
		driver.findElement(By.xpath(btnYesConfirm)).click();
	}
	
	public void clickButtonHeader(String name) {
		String btn = String.format(btnHeaderCommon, name);
		this.scrollBarToElement(btn);
		driver.findElement(By.xpath(btn)).click();
	}
	
	public boolean isShowDialog(String name) {
		return driver.findElement(By.xpath(String.format(dialogCommon, name))).isDisplayed();
	}
	
	public void clickButtonCloseDialog(String name) {
		driver.findElement(By.xpath(String.format(btnCloseDialog, name))).click();
	}
	
	public void selectMauHoaDon(String kyHieu) {
		driver.findElement(By.xpath(cbbMauHoaDon)).click();
		driver.findElement(By.xpath(String.format("//p-dropdown[@id='invoiceTemplatePartyId']//p-dropdownitem/li[@aria-label='%s']", kyHieu))).click();
//		List<WebElement> listItem = driver.findElements(By.xpath(dropdownItem));
//		for (WebElement item : listItem) {
//			String textContent = item.findElement(By.xpath("./li/div/child::div[1]")).getAttribute("textContent");
//			if (textContent == kyHieu) {
//				item.click();
//				break;
//			}
//		}
	}
	
	public String getDataMauHoaDon() {
		return driver.findElement(By.xpath("//p-dropdown[@id='invoiceTemplatePartyId']//span[contains(@class,'p-dropdown-label')]")).getAttribute("textContent");
	}
	
}
