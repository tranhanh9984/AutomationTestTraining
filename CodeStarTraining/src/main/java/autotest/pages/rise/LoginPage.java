package autotest.pages.rise;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage {
	
	public LoginPage(WebDriver driver) {
	    this.driver = driver;
	}

	By email = By.id("email");
	By pass = By.id("password");
	By btnSignin = By.xpath("//button");
	
	
	public void Login(String name, String password) {
		driver.findElement(email).sendKeys(name);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(btnSignin).click();
		
	}
	
	public void clearAll() {
		driver.findElement(email).clear();;
		driver.findElement(pass).clear();;
	}
	
	public void addCookies() {
		Cookie cookie = new Cookie. Builder("myCookie", "0alfe6b98f99dd87da7a44927013ac19")
		.isHttpOnly(true)
		.isSecure(false)
		.build();
		driver.manage().addCookie(cookie);
	}
}
