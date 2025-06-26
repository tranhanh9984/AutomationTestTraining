package autotest.thuchanh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Buoi12_TH_Webdriver extends CommonPage {

	public Buoi12_TH_Webdriver() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void test() {
		WebElement email = driver.findElement(By.id("email"));
		System.out.println(email);
		
		List<WebElement> inputs =  driver.findElements(By.xpath("input"));
		for(WebElement input: inputs) {
			System.out.println(input);
		}
		
		driver.get("https://www.selenium.dev/documentation/webdriver/");
		driver.getCurrentUrl();
		driver.getTitle();
		driver.navigate().to("https://www.selenium.dev/documentation/webdriver/");
		driver.get("https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html");
		driver.quit();
		driver.switchTo();
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
