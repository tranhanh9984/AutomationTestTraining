package autocom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import autocom.constant.KeywordConstant;

public class LoginPage {

	
public void login() {
	
}
	
	String txtEmail = "//input[@id='companyUsername']";
	String txtPass = "//input[@id='password']";
	String txtTaxCode = "//input[@id='taxCode']";
	String btnDangNhap = "//button[contains(text(),'Đăng nhập')]";

	WebDriver driver;

	public LoginPage(WebDriver dr) {
		driver = dr;
	}

	public void login(String userEmail, String password, String taxCode) {
		this.enterEmail(userEmail);
		this.enterPassword(password);
		this.enterTaxCode(taxCode);
		this.clickDangNhap();
	}

	public void enterEmail(String userEmail) {
		driver.findElement(By.xpath(txtEmail)).sendKeys(userEmail);
	}

	public void enterPassword(String password) {
		driver.findElement(By.xpath(txtPass)).sendKeys(password);
	}

	public void enterTaxCode(String taxCode) {
		driver.findElement(By.xpath(txtTaxCode)).sendKeys(taxCode);
	}

	public void clickDangNhap() {
		driver.findElement(By.xpath(btnDangNhap)).click();
	}

	public void signIn(String userEmail, String password, String taxCode) {

	}

}
