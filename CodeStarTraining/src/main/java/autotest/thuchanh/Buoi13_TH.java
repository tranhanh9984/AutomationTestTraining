package autotest.thuchanh;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Buoi13_TH extends CommonPage {

	By emailField = By.id("email");
	By passwordField = By.id("password");
	By btnSubmit = By.cssSelector("button[type='submit']");
	
	public Buoi13_TH() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void thuchanh() {
		WebElement email = driver.findElement(emailField);
		WebElement btnLogin = driver.findElement(btnSubmit);
		
		email.clear();
		email.sendKeys("Hello");
		
		System.out.println("class: "+ email.getClass());
		System.out.println("text: "+ email.getText());
		System.out.println("value: "+ email.getAttribute("value"));
		System.out.println("placeholder: "+ email.getAttribute("placeholder"));
		System.out.println("equals " + email.getText().equals("hello"));
		
		System.out.println("getCssValue: " + email.getCssValue("form-control p10"));
		System.out.println("getLocation: " + email.getLocation());
		
		System.out.println("hasCode: " + email.hashCode());
		Rectangle rect = email.getRect();
		System.out.println("getRect: x=" + rect.getX() +
                ", y=" + rect.getY() +
                ", width=" + rect.getWidth() +
                ", height=" + rect.getHeight());
		btnLogin.submit();
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
//		loginPage = new LoginPage(driver);
//		loginPage.login("admin@demo.com", "riseDemo");
//		clientPage = new ClientPage(driver);
//		setClient();
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
		
	}

}
