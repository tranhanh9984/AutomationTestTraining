package autotest.testcases;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class ThucHanh extends CommonPage {
	//@Test
	//public void TC1() {
		//Scanner myObj = new Scanner(System.in);
		//System.out.print("Nhập x:");
		//double a = myObj.nextDouble();
		//System.out.print("Nhập y:");
		//double b = myObj.nextDouble();
		//System.out.print("Nhập z:");
		//double c = myObj.nextDouble();
		//Assert.assertEquals(a*b, c);
	//}
	//@Test
	//public void TC2() {
		//Scanner myObj = new Scanner(System.in);
		//System.out.println("Nhập đoạn văn:");
		//String doanvan = myObj.next();
		//Assert.assertEquals(doanvan, "Hello");
	//}
	@Test
	public void khoiTaoWeb() {
		this.startBrower("https://v2.vietinvoice.vn/auth/dang-nhap", "chrome");
		pause(500);
		Assert.assertEquals(false, false);
	}
}
