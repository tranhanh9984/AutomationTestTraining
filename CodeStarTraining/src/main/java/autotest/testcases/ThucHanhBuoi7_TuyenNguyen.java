package autotest.testcases;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.testng.annotations.Test;

import autocom.common.CommonFuncs;
import autocom.constant.KeywordConstant;

public class ThucHanhBuoi7_TuyenNguyen {

	public ThucHanhBuoi7_TuyenNguyen() {
		// TODO Auto-generated constructor stub
	}
	
	//@Test
	public void tc1() {
		System.out.println("Test case 1");
	}
	@Test
	public void tc_convertNumberToString() {
		long number = 850420;
		String value = CommonFuncs.convertNumberToTextVND(number, "euro");
		System.out.println(value);
	}

	@Test
	public void tc_convertMonthStringToInt() {
		String month = "January";
		int value = CommonFuncs.convertMonthStringToInt(month);
		System.out.println(value);
	}
	
	@Test
	public void tc_convertMonthIntToString() {
		int month = 1;
		String value = CommonFuncs.convertMonthIntToString(month);
		System.out.println(value);
	}
	
	@Test
	public void tc_convertDate() {
		LocalDate fromDate = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, "23/09/2024");
		//this.setFromDate(fromDate);
		
		LocalDate toDate = CommonFuncs.convertToDateByFormat(KeywordConstant.FORMAT_DATE, "24/01/2025");
		//this.setToDate(toDate);
		
		long monthsBetween = ChronoUnit.MONTHS.between(fromDate, toDate);
		System.out.println(monthsBetween);
	}
	
}
