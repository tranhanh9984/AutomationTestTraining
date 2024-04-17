package autocom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DanhSachHoaDon {

	WebDriver driver;

	public DanhSachHoaDon(WebDriver dr) {
		driver = dr;
	}

	String txtSearchBox = "//input[@placeholder='Tìm kiếm...']";
	String btnFilter = "//button[@title='Lọc']";
	String txtStartDate = "//input[@name='startDate']";
	String txtEndDate = "//input[@name='endDate']";

	public void locHoaDon(String tuNgay, String denNgay) {

	}

	public void openFilterDataHoaDon() {

		driver.findElement(By.xpath(btnFilter)).click();

	}

	public void selectStartDate() {

		driver.findElement(By.xpath(txtStartDate)).click();

	}

	public void selectEndDate() {

		driver.findElement(By.xpath(txtEndDate)).click();

	}
}
