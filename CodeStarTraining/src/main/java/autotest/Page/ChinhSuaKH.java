package autotest.Page;

import org.openqa.selenium.By;
import autocom.common.CommonPage;

public class ChinhSuaKH extends CommonPage {
	public ChinhSuaKH(){
		
	}
	String txtLoaiKH = "//div[contains(@class , 'p-dropdown p-component')]";
	String texttochuc = "//span[text()='Tổ chức']";
	String txtCapNhat = "//span[text() = 'Cập nhật']";
	String txtHoVaTen = "//input[@id = 'buyerName']";
	
	public void thayDoiLoaiKH(String HoVaTen) {
		pause(5);
		driver.findElement(By.xpath(txtLoaiKH)).click();
		driver.findElement(By.xpath(texttochuc)).click();
		driver.findElement(By.xpath(txtHoVaTen)).clear();
		driver.findElement(By.xpath(txtHoVaTen)).click();
		driver.findElement(By.id("emailAddress_Org")).click();
		if (HoVaTen != "") {
		driver.findElement(By.xpath(txtHoVaTen)).sendKeys(HoVaTen);
		}
		pause(2);
		driver.findElement(By.xpath(txtCapNhat)).click();
	}
	
	String txtTenKH = "//input[@id='partyName']";
	public void thayDoiTenKH(String TenKH) {
		driver.findElement(By.xpath(txtTenKH)).clear();
		driver.findElement(By.xpath(txtTenKH)).sendKeys(TenKH);
		driver.findElement(By.xpath(txtCapNhat)).click();
	}
	
	String txtMaKH = "//input[@id='pseudoId']";
	public void thayDoiMaKH(String MaKH) {
		driver.findElement(By.xpath(txtMaKH)).clear();
		driver.findElement(By.xpath(txtMaKH)).sendKeys(MaKH);
		pause(1);
		driver.findElement(By.xpath(txtCapNhat)).click();
	}
	
	String txtKhongDuocDeTrong = "//small[text() = 'Trường không được để trống.']";
	public String getmsgKhongDuocDeTrong() {
		boolean isDisplayed = driver.findElement(By.xpath(txtKhongDuocDeTrong)).isDisplayed();
		if(isDisplayed) {
			return driver.findElement(By.xpath(txtKhongDuocDeTrong)).getText();
		} 
		return "";
	}
	
	String txtKhongDungDinhDang = "//small[text() = 'Định dạng không hợp lệ.']";
	public String getmsgKhongDungDinhDang() {
		boolean isDisplayed = driver.findElement(By.xpath(txtKhongDungDinhDang)).isDisplayed();
		if(isDisplayed) {
			return driver.findElement(By.xpath(txtKhongDungDinhDang)).getText();
		} 
		return "";
	}
	
	String msgTenNguoiMua = "//div[contains(@class , 'p-toast-detail')]";
	public String getmsgTenNguoiMua() {
		boolean isDisplayed = driver.findElement(By.xpath(msgTenNguoiMua)).isDisplayed();
		if(isDisplayed) {
			return driver.findElement(By.xpath(msgTenNguoiMua)).getText();
		} 
		return "";
		
	}

}
