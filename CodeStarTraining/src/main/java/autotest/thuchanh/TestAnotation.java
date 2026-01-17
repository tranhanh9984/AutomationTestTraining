package autotest.thuchanh;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnotation {

	public TestAnotation() {
		// TODO Auto-generated constructor stub
	}

	
	@Test
	public void checkTest() {
		System.out.println("---@Test --------------");
	}
	
	@BeforeTest
	public void checkBefore() {
		System.out.println("---@BeforeTest --------------");
	}
	

	@AfterTest
	public void checkAfterTest() {
		System.out.println("---@@AfterTest --------------");
	}
	
	@BeforeSuite
	public void checkBefore1() {
		System.out.println("---@BeforeSuite --------------");
	}
	

	@AfterSuite
	public void checkAfterTest1() {
		System.out.println("---@@AfterSuite --------------");
	}
}
