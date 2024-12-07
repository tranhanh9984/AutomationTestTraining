package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.common.CommomBase;
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class LoginPage extends CommomBase {
//	//textInut - txt, lable: lbl, combobox - cbb, button - btn
//	String txtUserName = "//*[@id='email']";
//	String txtPassword = "//*[@id='password']";
////	String txtMST = "//input[@id = 'taxCode']";
//	String btnDangNhap = "//button";
//	String noti = "//div[@role='alert']/div[last()]";
////	
////	WebDriver driver;
////	public LoginPage(WebDriver dr){
////		driver = dr;
////	}
////	
////	public void login() {
////		driver.findElement(By.xpath(txtUserName)).sendKeys(KeywordConstant.EMAIL);
////		driver.findElement(By.xpath(txtPassword)).sendKeys(KeywordConstant.PASSWORD);
////		driver.findElement(By.xpath(txtMST)).sendKeys(KeywordConstant.MST);
////		driver.findElement(By.xpath(btnDangNhap)).click();
////	}
////	
////	
////	public void login(String email, String password, String mst) {
////		driver.findElement(By.xpath(txtUserName)).sendKeys(email);
////		driver.findElement(By.xpath(txtPassword)).sendKeys(password);
////		driver.findElement(By.xpath(txtMST)).sendKeys(mst);
////		driver.findElement(By.xpath(btnDangNhap)).click();
////	}	
////	
////	public void signIn(String email, String password, String mst) {
////		
////	}
////	
////	public void quenMatKhau(WebDriver driver, String email, String password, String mst) {
////		
////	}
//	
//	@Test
//	public void TC01_Success() {
//		this.clearText(txtUserName);
//		this.clearText(txtPassword);
//		driver.findElement(By.xpath(txtUserName)).sendKeys("0312303803-999");
//		driver.findElement(By.xpath(txtPassword)).sendKeys("0312303803-999");
//		driver.findElement(By.xpath(btnDangNhap)).click();
//		driver.findElement(By.xpath(this.ChooseMenuLevel1("Hóa đơn "))).click();
//		driver.findElement(By.xpath(this.ChooseMenuLevel2("Lập hoá đơn"))).click();
////		Assert.assertEquals("0312303803-999", "0312303803-999");
//	}
//	
////	@Test
////	public void TC01_Fail1() {
////		this.clearText(txtUserName);
////		this.clearText(txtPassword);
////		driver.findElement(By.xpath(txtUserName)).sendKeys("0312303803");
////		driver.findElement(By.xpath(txtPassword)).sendKeys("0312303803-999");
////		driver.findElement(By.xpath(btnDangNhap)).click();
//////		Assert.assertEquals(By.xpath("//*[contains(text(), 'xxxx')]"), "Có lỗi xảy ra...\r\n"
//////				+ "No account found for username 0312303803-9");
////		assert true == driver.findElement(By.xpath(noti)).isDisplayed();
////		this.pause(1000);
////	}
////	
////	@Test
////	public void TC01_Fail2() {
////		this.clearText(txtUserName);
////		this.clearText(txtPassword);
////		driver.findElement(By.xpath(txtUserName)).sendKeys("0312303803-999");
////		driver.findElement(By.xpath(txtPassword)).sendKeys("0312303803");
////		driver.findElement(By.xpath(btnDangNhap)).click();
//////		Assert.assertEquals("0312303803-999", "0312303803");
//////		Assert.assertEquals(By.xpath("//*[contains(text(), 'xxxx')]"), "Có lỗi xảy ra...\r\n"
//////				+ "Password incorrect for username 0312303803-999");
////		assert true == driver.findElement(By.xpath(noti)).isDisplayed();
////		this.pause(1000);
////	}
//	
//	@BeforeClass
//	public void startBr() {
//		this.startBrower("https://uat-invoice.kaike.vn/login", "Chrome");
//		
//		
//		
//	}
//	
//	
//	
//	@AfterClass
//	public void closeBr() {
////		this.closeBrower();
//	}
	 String txtUsername = "//*[@id='email']";
	 String txtPass = "//*[@id='password']";
	 String txtButton = "//button[@class='btn btn-login' and @type='submit' and text()='Đăng nhập']";
	 String noti = "//div[@role='alert']/div[last()]";
	// String noti = 
	
	 @Test (priority = 1)
	 public void tc_01() {
		 this.clearText(txtUsername);
		 this.clearText(txtPass);
		 driver.findElement(By.xpath(txtUsername)).sendKeys("031230303-999");
 		 driver.findElement(By.xpath(txtPass)).sendKeys("0312303803-999");
 		 driver.findElement(By.xpath(txtButton)).click();
 		assert true == driver.findElement(By.xpath(noti)).isDisplayed();
 		this.pause(1000);
	 }
	 @Test (priority = 2)
	 	public void tc_02() {
		 this.clearText(txtUsername);
		 this.clearText(txtPass);
	 		driver.findElement(By.xpath(txtUsername)).sendKeys("0312303803-999");
	 		driver.findElement(By.xpath(txtPass)).sendKeys("0312303803-9");
	 		driver.findElement(By.xpath(txtButton)).click();
	 		Assert.assertEquals("0312303803-999", "0312303803-999");
	 		this.pause(1000);
	 	}
	 @Test (priority = 3)
	 	public void tc_03() {
		 this.clearText(txtUsername);
		 this.clearText(txtPass);
	 		driver.findElement(By.xpath(txtUsername)).sendKeys("0312303803-999");
	 		driver.findElement(By.xpath(txtPass)).sendKeys("0312303803-999");
	 		driver.findElement(By.xpath(txtButton)).click();
	 		Assert.assertEquals("0312303803-999", "0312303803-999");
	 		this.pause(1000);
	 	}
	
	 
	@BeforeClass
	public void starBr() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "Chrome");
	}
	@AfterClass
	public void closeBr()
	{
		this.closeBrower();
	}
	
}
