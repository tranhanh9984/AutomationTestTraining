package page.Rise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class LoginPageRise extends CommonPage {
	
	public LoginPageRise(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//button[text() = 'Sign in']") @CacheLookup WebElement txtClickLogin;
	@FindBy (name = "email") @CacheLookup WebElement txtEmail;
	@FindBy (name = "password") @CacheLookup WebElement txtPass;
	public void Login() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].setAttribute('value','admin@demo.com');", txtEmail);
	 js.executeScript("arguments[0].setAttribute('value','riseDemo');", txtPass);
	 js.executeScript("arguments[0].click();", txtClickLogin);
		pause(5);
	}
//	public void Login() {
//		txtEmail.clear();
//		txtEmail.sendKeys("admin@demo.com");
//		txtPass.clear();
//		txtPass.sendKeys("riseDemo");
//		txtClickLogin.click();
//	}

}
