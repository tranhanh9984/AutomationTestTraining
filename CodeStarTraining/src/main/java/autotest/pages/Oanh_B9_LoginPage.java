package autotest.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonBase;

public class Oanh_B9_LoginPage extends CommonBase {
	private String email = "//input[@id='email']";
	private String pass = "//input[@id='password']";
	private String button = "//button[@class='btn btn-login']";
	String noti = "//div[@role='alert']/div[last()]";
	String success = "//a[@title='Thông tin cá nhân']/span[@class='p-ml-2 ng-star-inserted']";
	public Oanh_B9_LoginPage() {
		// TODO Auto-generated constructor stub
	}
	@BeforeClass
	public void startPage() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");

	}
	@Test(priority=1)
	public void notFound() {
		// khong tim thay account
		clearData(email);
		clearData(pass);
		this.setText("0312303803", email);
		this.setText("0312303803-999", pass);
		this.setButton(button);

		String result = this.getText(noti);
		System.out.println(result);
		String expected = "No account found for username";
		System.out.println(result.contains(expected));
		assertEquals(result.contains(expected), true);
		pause(3000);
	}

	@Test(priority=1)
	public void wrongPw() {
		// Sai pw
		clearData(email);
		clearData(pass);
		this.setText("0312303803-999", email);
		this.setText("0312303803", pass);
		this.setButton(button);
		String result = this.getText(noti);
		System.out.println(result);
		String expected = "Password incorrect";
		assertEquals(result.contains(expected), true);
	}
	
	@Test(priority=2)
	public void successLogin() {
		clearData(email);
		clearData(pass);
		this.setText("0312303803-999", email);
		this.setText("0312303803-999", pass);
		this.setButton(button);
		pause(3000);
		String result = driver.getCurrentUrl();
		System.out.println(result);
		String expected = "https://uat-invoice.kaike.vn/dashboard";
		assertEquals(result, expected);
	}

	@AfterClass
	public void closePage() {
		this.closeBrowser();
	}

}
