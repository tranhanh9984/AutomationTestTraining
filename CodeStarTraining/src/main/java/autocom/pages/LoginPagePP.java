package autocom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.constant.KeywordConstant;

public class LoginPagePP {
	
	@FindBy(id= "companyUsername")
	WebElement textEmail;
	
	@FindBy(id= "password")
	WebElement textPassWord;
	
	@FindBy(id= "taxCode")
	WebElement textTaxCode;
	
	@FindBy(xpath = "//button[(text()='Đăng nhập')]")
	WebElement buttonLogin;
	
	
	WebDriver driver;

	public LoginPagePP(WebDriver dr) {
		driver = dr;
		PageFactory.initElements(driver, this);
	}
	
public void loginPP(String Email, String PassWord, String TaxCode) {
	
	textEmail.sendKeys(Email);
	textPassWord.sendKeys(PassWord);
	textTaxCode.sendKeys(TaxCode);
	buttonLogin.click();
	
	//public void loginPP() {
	//textEmail.sendKeys(KeywordConstant.EMAIL);
	//textPassWord.sendKeys(KeywordConstant.PASSWORD);
	//textTaxCode.sendKeys(KeywordConstant.MST);
	//buttonLogin.click();
	//}


	
}

}
