package autotest.testcases;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.common.CommonFuncs;
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class ThucHanhBuoi7_TuyenNguyen extends CommonPage  {

	public ThucHanhBuoi7_TuyenNguyen() {
		// TODO Auto-generated constructor stub
	}
	
	//@Test
//	public void tc1() {
//		System.out.println("Test case 1");
//	}
//	@Test
//	public void tc_convertNumberToString() {
//		long number = 850420;
//		String value = CommonFuncs.convertNumberToTextVND(number, "euro");
//		System.out.println(value);
//	}
//
//	@Test
//	public void tc_convertMonthStringToInt() {
//		String month = "January";
//		int value = CommonFuncs.convertMonthStringToInt(month);
//		System.out.println(value);
//	}
//	
//	@Test
//	public void tc_convertMonthIntToString() {
//		int month = 1;
//		String value = CommonFuncs.convertMonthIntToString(month);
//		System.out.println(value);
//	}
//	
//	@Test
//	public void tc_convertDate() {
//		LocalDate fromDate = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, "23/09/2024");
//		//this.setFromDate(fromDate);
//		
//		LocalDate toDate = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, "24/01/2025");
//		//this.setToDate(toDate);
//		
//		long monthsBetween = ChronoUnit.MONTHS.between(fromDate, toDate);
//		System.out.println(monthsBetween);
//	}
	
	@BeforeClass
	public void init() {
		this.startBrowser("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
//		this.gotoCreateInvoicePage();
	
		
	}
	
	@AfterClass
	public void close() {
		 this.closeBrowser();
	}
	
	@Test
	public void tc() {

		pause(3);
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[2]/div")).click();
		pause(3);
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[2]/div//input")).sendKeys("Vietnam");
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[2]/div//input")).sendKeys(Keys.ENTER);
		
		
		pause(3);
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[3]/div")).click();
		pause(3);
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[3]/div//input")).sendKeys("Travel");
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[3]/div//input")).sendKeys(Keys.ENTER);
		
		
		
		pause(3);
	}
	
}
