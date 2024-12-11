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
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TH_buoi12_HaDV extends CommonBase {
	public TH_buoi12_HaDV() {
		// TODO Auto-generated constructor stub

	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html", "chrome");
	}

	@Test
	public void checkSelectType() {
		System.out.println("HaDV");
		pause(5000);
		String xPath;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		xPath = "//a[contains(.,'Country')]";
		driver.findElement(By.xpath(xPath)).click();
		pause(1000);

		WebElement ul = driver.findElement(
				By.xpath("//a[contains(.,'Country')]/following-sibling::div[contains(@class,'chosen-drop')]//ul"));
		WebElement li = driver.findElement(By.xpath(
				"//a[contains(.,'Country')]/following-sibling::div[contains(@class,'chosen-drop')]//li[contains(.,'Poland')]"));
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + arguments[1].getBoundingClientRect().top;",
				ul, li);
		new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOf(li));
		xPath = "//a[contains(.,'Country')]/following-sibling::div[contains(@class,'chosen-drop')]//li[contains(.,'Poland')]";
		driver.findElement(By.xpath(xPath)).click();
		
		xPath = "//a[contains(.,'Country')]";
		driver.findElement(By.xpath(xPath)).click();
		xPath = "//a[contains(.,'Country')]/following-sibling::div[contains(@class,'chosen-drop')]//li[contains(.,'Fitness')]";
		driver.findElement(By.xpath(xPath)).click();
	}

}
