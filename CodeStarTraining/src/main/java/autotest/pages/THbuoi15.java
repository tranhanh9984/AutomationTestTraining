package autotest.pages;

import java.lang.annotation.*;

import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonBase;
import autocom.constant.KeywordConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class THbuoi15 extends CommonBase {
	private static final String XPATH_PASSWORD = "//input[@id='password']";
	private static final String XPATH_BTN_LOGIN_SUBMIT = "//button[@type='submit']";

	@Test
	public void LoginFunction() {
		System.out.println("Run LoginFunction");
		// Switch to iframe by name or ID
		WebElement idIframe = driver.findElement(By.xpath("//iframe[@title ='reCAPTCHA']"));

		driver.switchTo().frame(idIframe);

		pause(2000);

		driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
		pause(2000);
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		pause(3000);

		click("//ul[@id ='sidebar-menu']//a[contains( .,'Clients')]", NO_SCROLL);
		pause(2000);
		click("//a[@title='Add client']", NO_SCROLL);
		pause(500);
		click("//input[@id='type_person']", NO_SCROLL);
		setText("//input[@id='company_name']", "Do Viet Ha", true);
		click("//div[@id='s2id_created_by']", NO_SCROLL);
		pause(500);
		click("//li[contains(.,'Mark Thomas')]", NO_SCROLL);
		setText("//textarea[@id='address']", "Ha Noi", true);
		setText("//input[@id='city']", "Ha Noi", true);
		setText("//input[@id='state']", "Ha Noi", true);
		setText("//input[@id='zip']", "10000", true);
		setText("//input[@id='country']", "Viet Nam", true);
		setText("//input[@id='phone']", "123456789", true);
		setText("//input[@id='website']", "dovietha.com", true);
		setText("//input[@id='vat_number']", "123456789", true);
		setText("//input[@id='gst_number']", "123456789", true);
		scrollTo("//input[@id='s2id_autogen2']");
		scrollBy("//*[contains(@class,'modal-body ')]", 0, 70);
		click("//input[@id='s2id_autogen2']", NO_SCROLL);
		click("//div[@id='select2-drop']//li[contains(.,'VIP')]", NO_SCROLL);
		pause(200);
		click("//input[@id='s2id_autogen4']", NO_SCROLL);
		click("//div[@id='select2-drop']//li[contains(.,'Referral')]", SCROLL);
		click("//button[@id='save-and-continue-button']", SCROLL);
	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://rise.fairsketch.com/signin", "chrome");
	}

}
