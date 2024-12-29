package autotest.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.common.CommonBase;

public class THday16 extends CommonBase {

	public THday16() {
		// TODO Auto-generated constructor stub

	}

	public void tc01() {
		click("//a[@href='#OKTab']", NO_SCROLL);
		WebElement menuContent1 = waitForElementPresent(driver, By.xpath("//div[@id='OKTab']"), 10);
		if (menuContent1 != null) {
			System.out.println("Element OK is present.");
			driver.findElement(By.xpath("//div[@id='OKTab']//button")).click();
			pause(5000);
		} else {
			System.out.println("Element not found.");
		}
		pause(5000);
		String alertContent = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert content : " + alertContent);
	}

	public void tc02() {
		click("//a[@href='#CancelTab']", NO_SCROLL);
		WebElement menuContent2 = waitForElementPresent(driver, By.xpath("//div[@id='CancelTab']"), 10);
		if (menuContent2 != null) {
			System.out.println("Element OK & Cancel is present.");
			driver.findElement(By.xpath("//div[@id='CancelTab']//button")).click();
			pause(5000);
		} else {
			System.out.println("Element not found.");
		}
		pause(5000);
		String alertContent = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
//		driver.switchTo().alert().dismiss();
		System.out.println("Alert content : " + alertContent);

	}

	@Test
	public void tc03() {
		click("//a[@href='#Textbox']", NO_SCROLL);
		WebElement menuContent3 = waitForElementPresent(driver, By.xpath("//div[@id='Textbox']"), 10);
		if (menuContent3 != null) {
			System.out.println("Element Textbox is present.");
			driver.findElement(By.xpath("//div[@id='Textbox']//button")).click();
			driver.switchTo().alert().sendKeys("--- HaDV enter ---");
			pause(5000);
		} else {
			System.out.println("Element not found.");
		}

		String alertContent = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Alert content : " + alertContent);

	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://demo.automationtesting.in/Alerts.html", "chrome");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
