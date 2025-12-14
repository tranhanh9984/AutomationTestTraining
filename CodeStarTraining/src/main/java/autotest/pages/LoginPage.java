package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage {

	
	
	By byEmaillll = By.id("email");
	By byPassword = By.id("password");
	By btnSigin = By.xpath("//button");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	private void Login(String username, String password) {			
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].setAttribute('value','admin02@mailinator.com');", driver.findElement(byEmaillll));
//		driver.findElement(byPassword).sendKeys(password);
//		driver.findElement(byEmaillll).sendKeys(username);	
//		driver.findElement(btnSigin).click();
	}
	
	private void clearAll() {
		driver.findElement(byEmaillll).clear();
		driver.findElement(byPassword).clear();		
	}
	
	private void addCookies() {		 
		 Cookie cookie = new Cookie.Builder("myCookie", "c280f25339bf216293336e5ec0cb57fe")
	                .isHttpOnly(true)
	                .isSecure(false)
	                .build();
		 driver.manage().addCookie(cookie);
	}
	
}
