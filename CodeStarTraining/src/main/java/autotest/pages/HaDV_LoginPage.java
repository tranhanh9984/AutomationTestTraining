package autotest.pages;

import java.lang.annotation.*;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;

import org.openqa.selenium.WebDriver;

import autocom.common.HaDV_CommonBase;
import autocom.constant.KeywordConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class HaDV_LoginPage extends HaDV_CommonBase {
	public String LOGIN_EMAIL = "0312303803-999";
	public String LOGIN_PASSWORD = "0312303803-999";

	private String XPATH_EMAIL = "//input[@id='email']";
	private String XPATH_PASSWORD = "//input[@id='password']";
	private String XPATH_BTN_LOGIN_SUBMIT = "//button[@type='submit']";
	private String XPATH_LOGIN_FAIL = "//div[contains(@class,'p-toast-message-error')]//div[text()='Có lỗi xảy ra...']";
	private String XPATH_LOGIN_SUCCESS = "//a[@title='Thông tin cá nhân']";
	//

	public HaDV_LoginPage() {
	}

	public HaDV_LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginSuccess() {
		login(LOGIN_EMAIL, LOGIN_PASSWORD);
	}

	public void login(String email, String password) {
		inputText(email, XPATH_EMAIL);
		inputText(password, XPATH_PASSWORD);
		driver.findElement(By.xpath(XPATH_BTN_LOGIN_SUBMIT)).click();
	}

	public void loginFail(String email, String password) {
		login(email, password);
	}

	public WebElement loginFailStatus() {
		return waitForElementPresent(By.xpath(XPATH_LOGIN_FAIL), 5);
	}

	public WebElement loginSuccessStatus() {
		return waitForElementPresent(By.xpath(XPATH_LOGIN_SUCCESS), 5);
	}

}