package autotest.Page;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class TaomoiKH extends CommonPage {
public TaomoiKH() {
	
}
String textdropdownloaiKH = "//p-dropdown[@id='partyTypeEnumId']//div[@role='button']";
String texttochuc = "//span[text()='Tổ chức']";
String txtMaKH = "//input[@id='pseudoId']";
String txtTenKH = "//input[@id='partyName']";
String txtMSTKH = "//input[@id='partyTaxId_Org']";
String txtdiachiKH = "//input[@id='address1']";
String txtSTKKH = "//input[@id='accountNumber']";
String txtnganhangKH = "//input[@id='bankName']";
String txtemailKH = "//input[@id='emailAddress']";
String txtsdtKH = "//input[@id='phoneNumber']";
String txttaomoi = "//span[@class='p-button-label ng-star-inserted'and text()='Tạo mới']";
String txttenngmuahang = "//input[@id='buyerName']";
String txtemailngmuahang = "//input[@id='emailAddress_Org']";
String txtsdtngmuahang = "//input[@id='phoneNumber_Org']";

String msgerrorcanhan = "//div[contains(@class, 'p-toast-detail')]";


public void TaomoitochucTC() {
	driver.findElement(By.xpath(textdropdownloaiKH)).click();
	driver.findElement(By.xpath(texttochuc)).click();
	driver.findElement(By.xpath(txtMaKH)).clear();
	driver.findElement(By.xpath(txtMaKH)).sendKeys("010043002");
	driver.findElement(By.xpath(txtTenKH)).clear();
	driver.findElement(By.xpath(txtTenKH)).sendKeys("Hoang Minh");
	driver.findElement(By.xpath(txtMSTKH)).clear();
	driver.findElement(By.xpath(txtMSTKH)).sendKeys("0001000999");
	driver.findElement(By.xpath(txtdiachiKH)).clear();
	driver.findElement(By.xpath(txtdiachiKH)).sendKeys("Hà Nội, Việt Nam");
	driver.findElement(By.xpath(txtSTKKH)).clear();
	driver.findElement(By.xpath(txtSTKKH)).sendKeys("0392888999");
	driver.findElement(By.xpath(txtnganhangKH)).clear();
	driver.findElement(By.xpath(txtnganhangKH)).sendKeys("BIDV");
	driver.findElement(By.xpath(txtemailngmuahang)).clear();
	driver.findElement(By.xpath(txtemailngmuahang)).sendKeys("nguyenhoang@gmail.com");
	driver.findElement(By.xpath(txtsdtngmuahang)).clear();
	driver.findElement(By.xpath(txtsdtngmuahang)).sendKeys("0915892999");
	driver.findElement(By.xpath(txttenngmuahang)).clear();
	driver.findElement(By.xpath(txttenngmuahang)).sendKeys("Nguyen Van A");
}


public void TaomoicanhanTC() {	
	driver.findElement(By.xpath(txtMaKH)).clear();
	driver.findElement(By.xpath(txtMaKH)).sendKeys("0100430004");
	driver.findElement(By.xpath(txtTenKH)).clear();
	driver.findElement(By.xpath(txtTenKH)).sendKeys("Nguyen Hoang");
	driver.findElement(By.xpath(txtMSTKH)).clear();
	driver.findElement(By.xpath(txtMSTKH)).sendKeys("0001000999");
	driver.findElement(By.xpath(txtdiachiKH)).clear();
	driver.findElement(By.xpath(txtdiachiKH)).sendKeys("Hà Nội, Việt Nam");
	driver.findElement(By.xpath(txtSTKKH)).clear();
	driver.findElement(By.xpath(txtSTKKH)).sendKeys("0392888999");
	driver.findElement(By.xpath(txtnganhangKH)).clear();
	driver.findElement(By.xpath(txtnganhangKH)).sendKeys("BIDV");
	driver.findElement(By.xpath(txtemailKH)).clear();
	driver.findElement(By.xpath(txtemailKH)).sendKeys("nguyenhoang@gmail.com");
	driver.findElement(By.xpath(txtsdtKH)).clear();
	driver.findElement(By.xpath(txtsdtKH)).sendKeys("0915892999");
}

public void Taomoicanhanfail () {
	driver.findElement(By.xpath(txtTenKH)).clear();
	driver.findElement(By.xpath(txtTenKH)).sendKeys("123");
	driver.findElement(By.xpath(txtMaKH)).clear();
	driver.findElement(By.xpath(txtMaKH)).sendKeys("010000004");
}
public String getmsgerrorcanhan() {
	boolean isDisplayed = driver.findElement(By.xpath(msgerrorcanhan)).isDisplayed();
	if(isDisplayed) {
		return driver.findElement(By.xpath(msgerrorcanhan)).getText();
	} 
	return "";
}
public void clicktaomoi() {
	driver.findElement(By.xpath(txttaomoi)).click();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
