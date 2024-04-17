package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class LoginPage extends CommonPage {
	//textInut - txt, lable: lbl, combobox - cbb, button - btn
	String txtUserName = "//input[@id = 'companyUsername']";
	String txtPassword = "//input[@id = 'password']";
	String txtMST = "//input[@id = 'taxCode']";
	String btnDangNhap = "//button[text() = 'Đăng nhập']";
	
	WebDriver driver;
	public LoginPage(WebDriver dr){
		driver = dr;
	}
	
	public void login() {
		driver.findElement(By.xpath(txtUserName)).sendKeys(KeywordConstant.EMAIL);
		driver.findElement(By.xpath(txtPassword)).sendKeys(KeywordConstant.PASSWORD);
		driver.findElement(By.xpath(txtMST)).sendKeys(KeywordConstant.MST);
		driver.findElement(By.xpath(btnDangNhap)).click();
	}
	
	
	public void login(String email, String password, String mst) {
		driver.findElement(By.xpath(txtUserName)).sendKeys(email);
		driver.findElement(By.xpath(txtPassword)).sendKeys(password);
		driver.findElement(By.xpath(txtMST)).sendKeys(mst);
		driver.findElement(By.xpath(btnDangNhap)).click();
	}	
	
	public void signIn(String email, String password, String mst) {
		
	}
	
	public void quenMatKhau(WebDriver driver, String email, String password, String mst) {
		
	}
	
}
