package autotest.thuchanh;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autotest.page.LoginPage;

public class Buoi16_BTVN extends CommonPage {
	LoginPage loginPage;
	
	@FindBy(xpath="//div[@id='OKTab']//button") WebElement buttonOke;
	
	@Test
	public void test() {
		buttonOke.click();
		
	}

	public void dismissPopup() {
		driver.switchTo().alert().dismiss();
	}
	
	public void acceptPopup() {
		driver.switchTo().alert().accept();
	}
	
	public void getTextAndAcceptPopup() {
		String text = driver.switchTo().alert().getText();
		System.out.println("Popup text: " + text);
		driver.switchTo().alert().accept();
	}
	
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://demo.automationtesting.in/Alerts.html", "chrome");
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
	}
	
}
