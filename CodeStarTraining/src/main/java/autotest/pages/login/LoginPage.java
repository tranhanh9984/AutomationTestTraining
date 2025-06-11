package autotest.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonPage;

public class LoginPage extends CommonPage {
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String username, String password) {
		addCookies();
		clearAll();
		fillLogin(username, password);
		pause(2);
	}
		
	public void fillLogin(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	public void clearAll() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
	}
	
	private void addCookies() {		 
		 Cookie cookie = new Cookie.Builder("myCookie", "cb86cd7a6a91c4e281fdeb3aa669f41f")
	                .isHttpOnly(true)
	                .isSecure(false)
	                .build();
		 driver.manage().addCookie(cookie);
		 driver.navigate().refresh();
	}
}
