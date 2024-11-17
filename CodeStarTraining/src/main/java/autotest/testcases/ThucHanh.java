package autotest.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import autocom.common.CommonPage;

public class ThucHanh extends CommonPage {

	
	
	public ThucHanh() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void khoitaoweb() {
//		this.startBrower("https://v2.vietinvoice.vn/auth/dang-nhap", "chrome");
//		pause(500);
//		Assert.assertEquals(5*4, 20);		
		System.out.println(" Test được gọi");
	}
	
	@BeforeClass
	public void tc2() {
		System.out.println("Before Class được gọi");
		
	}
		
	@AfterClass
	public void tc3() {
		System.out.println("After Class được gọi");
		
	}
	
	@AfterTest
	public void tc4() {
		System.out.println("After test được gọi");
		
	}
	
	@BeforeTest
	public void tc5() {
		System.out.println("Before test được gọi");
		
	}
	
	@AfterMethod
	public void tc6() {
		System.out.println("After method được gọi");
		
	}
	
	@BeforeMethod
	public void tc7() {
		System.out.println("Before method được gọi");
		
	}

}
