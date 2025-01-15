package autotest.pages;

import autocom.common.HaDV_CommonBase;
import autotest.pages.HaDV_LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HaDV_ListingHoaDonPage extends HaDV_CommonBase {
	JavascriptExecutor js;
	String datePickerCalendarXPATH = "//p-calendar[@id='%sDate']";
	String datePickerTriggerXPATH = "//span[contains(@class,'p-calendar')]//input";
	String datePickerDayXPATH = "//td[not(contains(@class,'other-month'))][contains(.,'%s')]";
	String datePickerMonthXPATH = "//span[contains(@class,'datepicker-month')]";
	String datePickerYearXPATH = "//span[contains(@class,'datepicker-year')]";
	String datePickerPrev = "//button[contains(@class,'datepicker-prev')]";
	String datePickerNext = "//button[contains(@class,'datepicker-next')]";
	String tdKhachHang = "//table//tbody//tr[1]//td[4]";
	String trFilteredHoaDonResult = "//table//tbody//tr[1]";
	String breadcrumbListingHoaDon = "//app-breadcrumb[//li[contains(., 'Hóa đơn bán hàng')] and not(//li[contains(., 'Chỉnh sửa')])]";
	public String oldKhachHang = "";
	public String newKhachHang = "";
	public String editButtonXpath = "//p-button[@title='Chỉnh sửa']//button";
	public String parentEditXpath = "//table//tbody//tr[contains(.,'%s') and contains(.,'%s') and contains(.,'%s')]//td[contains(@class,'table-actions')]";
	public String ngayHD = "";
	public String khachHang = "";
	public String tongTien = "";
//	String oldKhachHang=getText(tdKhachHang);

	public HaDV_ListingHoaDonPage() {

	}

	public HaDV_ListingHoaDonPage(WebDriver driver) {
		if (this.driver == null) {
			this.driver = driver;
		}
	}

	public void editHoaDon(String ngayHD, String khachHang, String tongTien) {

	}

	public void chooseHoaDon(String ngayHD, String khachHang, String tongTien) {
		this.ngayHD = ngayHD;
		this.khachHang = khachHang;
		this.tongTien = tongTien;

		filterHoaDon(ngayHD, khachHang, tongTien);
		oldKhachHang = getText(tdKhachHang);
		System.out.println("chooseHoaDon oldKhachHang ::::" + oldKhachHang);
//		clickEditButtonXpath();
	}

	public void filterHoaDon(String ngayHD, String khachHang, String tongTien) {
		pickDate("from", ngayHD);
		pickDate("to", ngayHD);
		filterKhachHang(khachHang);
	}

	public WebElement onListingHoaDonPage() {
		return waitForElementPresent(By.xpath(breadcrumbListingHoaDon), 5);
	}

	public WebElement filteredHoaDonResultStatus() {
		return waitForElementPresent(By.xpath(trFilteredHoaDonResult), 5);
	}

	public void filterKhachHang(String khachHang) {
		// //table//thead//tr[2]//th[4]//input
		inputText(khachHang, "//table//thead//tr[2]//th[4]//input");
		runJS("const  enterEvent = new KeyboardEvent(\"keydown\", { key: \"Enter\", code: \"Enter \",  keyCode: 13, which: 13,bubbles: true,cancelable: true});document.evaluate(\"//table//thead//tr[2]//th[4]//input\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.dispatchEvent(enterEvent);");
	}

	public void filterTongTien(String tongTien) {

	}

	public void testFunction() {
		loginPage.loginSuccess();
	}

	public void testPickDate() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime oneDayBefore = now.minusDays(1);
		LocalDateTime oneDayAfter = now.plusDays(1);
		String formattedOneDayBefore = oneDayBefore.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String formattedOneDayAfter = oneDayAfter.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		pickDate("from", formattedOneDayBefore);
		pickDate("to", formattedOneDayAfter);
	}

	public void testCoutnDays() {
		countDays("08/12/2024", "07/01/2025");
	}

	public void testEditHoaDonBanHang() {
		ngayHD = "11/12/2024";
		khachHang = "to chuc a";
		tongTien = "935,000";

		clickEditButtonXpath();
		pause(500);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("https://uat-invoice.kaike.vn/customer/invoice/hdbh/update"),
				"Test failed: fail go to Edit Hoa Don Ban hang");
	}

	public boolean checkExistHoaDon(String ngayHD, String khachHang, String tongTien) {
		filterHoaDon(ngayHD, khachHang, tongTien);
//		System.out.println("Hoa don khong ton tai");
		return false;
	}

	public void clickEditButtonXpath() {
		String finalParentEditButton = String.format(parentEditXpath, ngayHD, khachHang, tongTien);
		System.out.println("clickEditButtonXpath ::::");
		System.out.println(finalParentEditButton);
		runJS("document.evaluate(\"" + finalParentEditButton
				+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollIntoView();");

		click(finalParentEditButton + editButtonXpath, NO_SCROLL);
	}

	public void checkDataHoaDon(String ngayHD, String khachHang, String tongTien) {
		int number = 1285000;
		pickDate("from", ngayHD);
		pickDate("to", ngayHD);
		// Format number to currency format
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
		String formattedCurrency = numberFormat.format(number);
		getCurrency("1285000");
		System.out.println("Currency format: " + formattedCurrency);

		String khacHangSearch = "//table//thead//tr[2]//th[4]//input";
		String tongTienSearch = "//table//thead//tr[2]//th[5]//input";
		String khacHangXpath = "//table//tbody//tr[1]//td[contains(.,'" + khachHang + "')]";
		String tongTienXpath = "//table//tbody//tr[1]//td[contains(.,'" + tongTien + "')]";
	}

	public void inputDate(String type, String selectedTime) {
		String typeText = (type == "from") ? "from" : "thru";
		driver.findElement(By.xpath(String.format(datePickerCalendarXPATH + datePickerTriggerXPATH, typeText)));
	}

	public void pickDate(String type, String selectedTime) {
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String typeText = (type == "from") ? "from" : "thru";
		int selectedDay = Integer.parseInt(selectedTime.split("/")[0]);
		int selectedMonth = Integer.parseInt(selectedTime.split("/")[1]);
		int selectedYear = Integer.parseInt(selectedTime.split("/")[2]);
		String calendarXPath = String.format(datePickerCalendarXPATH, typeText);
		String monthXPath = calendarXPath + datePickerMonthXPATH;
		String yearXPath = calendarXPath + datePickerYearXPATH;
		String dayXPath = String.format(calendarXPath + datePickerDayXPATH, selectedDay);
		String triggerXpath = calendarXPath + datePickerTriggerXPATH;

		driver.findElement(By.xpath(triggerXpath)).click();

		pause(100);
		int currentYear = Integer.parseInt(driver.findElement(By.xpath(yearXPath)).getText());
		while (selectedYear != currentYear) {
			currentYear = Integer.parseInt(driver.findElement(By.xpath(yearXPath)).getText());
			if (selectedYear > currentYear) {
				driver.findElement(By.xpath(datePickerNext)).click();
			}
			if (selectedYear < currentYear) {
				driver.findElement(By.xpath(datePickerPrev)).click();
			}
			pause(100);
		}
		pause(100);
		String currentMonth = driver.findElement(By.xpath(monthXPath)).getText();
		int currentMonthIndex = Arrays.asList(months).indexOf(currentMonth);
		while (currentMonthIndex != (selectedMonth - 1)) {
			currentMonth = driver.findElement(By.xpath(monthXPath)).getText();
			currentMonthIndex = Arrays.asList(months).indexOf(currentMonth);
			if (currentMonthIndex < (selectedMonth - 1)) {
				driver.findElement(By.xpath(datePickerNext)).click();
			}
			if (currentMonthIndex > (selectedMonth - 1)) {
				driver.findElement(By.xpath(datePickerPrev)).click();
			}
			pause(100);
		}
		pause(200);
		driver.findElement(By.xpath(dayXPath)).click();
		// int index = Arrays.asList(months).indexOf(targetMonth);
	}

	public long countDays(String fromDate, String toDate) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate start = LocalDate.parse(fromDate, formatter);
			LocalDate end = LocalDate.parse(toDate, formatter);
			long daysDifference = ChronoUnit.DAYS.between(start, end);
			System.out.println("So ngay cach nhau :::: " + daysDifference);
			return daysDifference;
		} catch (Exception e) {
			System.out.println("Sai date format");
			return 0;
		}

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

	public String getCurrencyTongTien() {
		String result = tongTien;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		try {
			Number number = currencyFormat.parse(result);
			String formattedValue = currencyFormat.format(number);
			return formattedValue;
		} catch (ParseException e) {
			System.out.println("can not convert currency");
			System.out.println(e);
			return result;
		}
	}
}
