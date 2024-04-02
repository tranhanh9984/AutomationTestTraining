package autotest.pages;

import autocom.common.CommonPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Exam2 extends CommonPage {

	@BeforeMethod
	public void init() {
		driver = this.initDriverTestWeb("https://selectorshub.com/xpath-practice-page/", "chrome");
	}

	@Test
	public void DemoTest() {
		pause(3000);

		String titleWeb = driver.getTitle();
		System.out.println(titleWeb);

		List<WebElement> emailElements = driver.findElements(By.name("email"));
		if (emailElements.size() > 0) {
			System.out.println("There is an Email field");
		} else {
			System.out.println("There is NO Email field");
		}

		List<WebElement> PasswordElements = driver.findElements(By.name("Password"));
		if (PasswordElements.isEmpty() == false) {
			System.out.println("There is a Password field");
		} else {
			System.out.println("There is NO Password field");
		}

		List<WebElement> companyElements = driver.findElements(By.name("company"));
		if (companyElements.size() > 0) {
			System.out.println("There is a Company field");
		} else {
			System.out.println("There is NO Company field");
		}

		List<WebElement> mobileNumberElements = driver.findElements(By.name("mobile number"));
		if (mobileNumberElements.isEmpty() == false) {
			System.out.println("There is a Mobile Number field");
		} else {
			System.out.println("There is Mobile Number field");
		}

	}

}