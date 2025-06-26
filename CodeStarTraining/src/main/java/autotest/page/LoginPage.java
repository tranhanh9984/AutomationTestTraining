package autotest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.utils.CookieUtil;

public class LoginPage extends CommonPage {
	
	@FindBy(xpath="//input[@id='email']") @CacheLookup WebElement emailField;
	@FindBy(id="password") @CacheLookup WebElement passwordField;
	@FindBy(css="button[type='submit']") @CacheLookup WebElement btnSubmit;
	
//	By emailField = By.id("email");
//	By passwordField = By.id("password");
//	By btnSubmit = By.cssSelector("button[type='submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
//		addCookies();
		clearAll();
		fillLogin(username, password);
		pause(2);
		CookieUtil.saveCookies(driver);
	}
	
	public void loginWithCookie() {
        CookieUtil.loadCookies(driver, KeywordConstant.urlRise2);
        driver.navigate().refresh();
    }
		
	public void fillLogin(String username, String password) {
		emailField.sendKeys(username);
		passwordField.sendKeys(password);
		btnSubmit.click();
	}
	
	public void clearAll() {
		emailField.clear();
		passwordField.clear();
	}
	
	private void addCookies() {		 
		 Cookie cookie = new Cookie.Builder("myCookie", "cb86cd7a6a91c4e281fdeb3aa669f41f")
	                .isHttpOnly(true)
	                .isSecure(false)
	                .build();
		 driver.manage().addCookie(cookie);
		 driver.navigate().refresh();
	}
	
	public boolean isLoggedIn() {
		System.out.println(driver.findElements(By.xpath("//div[contains(@class, 'dashboard-view')]")).isEmpty());
		return !driver.findElements(By.xpath("//div[contains(@class, 'dashboard-view')]")).isEmpty();
    }
}
