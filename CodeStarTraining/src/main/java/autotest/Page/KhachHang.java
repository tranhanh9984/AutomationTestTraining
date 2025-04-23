package autotest.Page;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class KhachHang extends CommonPage {
	public KhachHang() {
		
	}
String txttaomoi = "//span[text()='Tạo mới']";
String txttaomoiKH = "(//span[text()='Tạo mới'])[1]";
public void clickTaomoi() {
	driver.findElement(By.xpath(txttaomoi)).click();
}
public String gettextTaomoi () {
	return driver.findElement(By.xpath(txttaomoiKH)).getText();
}

String txtTaiExcel = "//span[text() = 'Upload excel']";
String txtFile = "//input[@id = 'file']";
String txtTaiLen = "//span[text()= 'Tải lên']";
String txtDong = "//span[text()= 'Đóng']";
public void clickUploadExcel(String fileLink) {
	driver.findElement(By.xpath(txtTaiExcel)).click();
	driver.findElement(By.xpath(txtFile)).clear();
	driver.findElement(By.xpath(txtFile)).sendKeys(fileLink);
	driver.findElement(By.xpath(txtTaiLen)).click();
	driver.findElement(By.xpath(txtDong)).click();
}

String getTenKhachHang = "//tr/td[@class = 'ng-star-inserted'][3]";
public String getTenKhachHang() {
	boolean isDisplayed = driver.findElement(By.xpath(getTenKhachHang)).isDisplayed();
	if(isDisplayed) {
		return driver.findElement(By.xpath(getTenKhachHang)).getText();
	} 
	return "";
}

String txtChinhSua = "(//button[contains(@class, 'p-button-warning p-button')])";
public void clickChinhSua(String stt) {
	driver.findElement(By.xpath(txtChinhSua +stt)).click();
}

String msgthanhcong = "//div[contains(@class, 'p-toast-summary')]";
String msgerror = "//div[contains(@class, 'p-toast-summary')]";

public String getmsgthanhcong() {
	boolean isDisplayed = driver.findElement(By.xpath(msgthanhcong)).isDisplayed();
	if(isDisplayed) {
		return driver.findElement(By.xpath(msgthanhcong)).getText();
	} 
	return "";
}

public String getmsgerror() {
	boolean isDisplayed = driver.findElement(By.xpath(msgerror)).isDisplayed();
	if(isDisplayed) {
		return driver.findElement(By.xpath(msgerror)).getText();
	} 
	return "";
}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
