package autocom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class HomePage extends CommonPage {

	String txtTitle = "//div[@id='company-info']";
	String txtHoaDon = "//span[(text()='Hóa đơn')]/ancestor::a";
	String txtTaoHoaDon = "//span[(text()='Tạo hoá đơn')]/ancestor::a";

	WebDriver driver;

	public HomePage(WebDriver dr) {
		driver = dr;
	}

	public void clickMenuHoaDon() {
		driver.findElement(By.xpath(txtHoaDon)).click();
	}

	public void clickMenuTaoHoaDon() {
		driver.findElement(By.xpath(txtTaoHoaDon)).click();
	}

	public void logout() {

	}

}

// public void clickHoaDonMenu(String text) {
// String a = String.format(txtHoaDon, "Hóa đơn");
// driver.findElement(By.xpath(txtHoaDon)).click();
// }

// public void clickTaoHoaDon(String text) {
// //String a = String.format(txtHoaDon, "Tạo hoá đơn");
// driver.findElement(By.xpath(txtHoaDon)).click();
// }
