package autocom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonPage;

public class DanhSachHoaDon extends CommonPage {

	WebDriver driver;

	public DanhSachHoaDon(WebDriver dr) {
		driver = dr;
	}

	String txtSearchBox = "//input[@placeholder='Tìm kiếm...']";
	String btnFilter = "//button[@title='Lọc']";
	String txtStartDate = "//input[@name='startDate']";
	String txtEndDate = "//input[@name='endDate']";

	public void locHoaDon(String startDate, String endDate) {
this.selectStartDate(startDate);
pause(1000);
this.selectEndDate(endDate);
	}

	public void openFilterDataHoaDon() {

		driver.findElement(By.xpath(btnFilter)).click();

	}

	public void selectStartDate(String startDate) {

		driver.findElement(By.xpath(txtStartDate)).click();
		driver.findElement(By.xpath(txtStartDate)).sendKeys(startDate);

	}

	public void selectEndDate(String endDate ) {

		driver.findElement(By.xpath(txtEndDate)).click();
		driver.findElement(By.xpath(txtStartDate)).sendKeys(endDate);
	}
	
	public void getNoHoaDon(String NoHoaDon) {
	}
	
	
}
