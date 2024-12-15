package autotest.pages;

import autocom.common.CommonBase;
import autotest.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoaDonBanHang extends CommonBase {
	String datePickerCalendarXPATH = "//p-calendar[@id='%sDate']";
	String datePickerTriggerXPATH = "//span[contains(@class,'p-calendar')]//input";
	String datePickerDayXPATH = "//td[not(contains(@class,'other-month'))][contains(.,'%s')]";
	String datePickerMonthXPATH = "//span[contains(@class,'datepicker-month')]";
	String datePickerYearXPATH = "//span[contains(@class,'datepicker-year')]";
	String datePickerPrev = "//button[contains(@class,'datepicker-prev')]";
	String datePickerNext = "//button[contains(@class,'datepicker-next')]";

	@Test
	public void testFunction() {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime oneDayBefore = now.minusDays(1);
		LocalDateTime oneDayAfter = now.plusDays(1);
		String formattedOneDayBefore = oneDayBefore.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String formattedOneDayAfter = oneDayAfter.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		pickDate("from", formattedOneDayBefore);
		pickDate("to", formattedOneDayAfter);
	}

	public void checkDataHoaDon() {
		int number = 1285000;

		// Format number to currency format
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
		String formattedCurrency = numberFormat.format(number);

		System.out.println("Currency format: " + formattedCurrency);

		String khacHangSearch = "//table//thead//tr[2]//th[4]//input";
		String tongTienSearch = "//table//thead//tr[2]//th[5]//input";
		String khacHang = "//table//tbody//tr[1]//td[contains(.,'Do Viet Ha')]";
		String tongTien = "//table//tbody//tr[1]//td[contains(.,'" + number + "')]";

	}

	@BeforeClass
	public void openPage() {
		startBrower("https://uat-invoice.kaike.vn/login", "chrome");
		commonLoginSuccess();
		pause(5000);

		String currentUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(currentUrl, "https://uat-invoice.kaike.vn/login",
				"Test failed: User is still on the login page.");

		goToPage("Hóa đơn/Hóa đơn bán hàng");
		pause(2000);
		currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://uat-invoice.kaike.vn/customer/invoice/hdbh",
				"Test failed: fail go to Hoa Don Ban hang");
	}

	public void inputDate(String type, String selectedTime) {

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
		pause(500);
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
}
