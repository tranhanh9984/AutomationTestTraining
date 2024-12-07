package autocom.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autotest.pages.LoginPage;

public class hoadon extends LoginPage  {
	

	 String btnHoadon = "//p-menubarsub//ul/li[2]";
	 String btnTaoHD = "//a[.//span[text()='Lập hoá đơn']]";
	 String txtMST = "//*[@id='toPartyTaxId']/span/input";
	 String txtTendv = "//*[@id='toPartyName']/span/input";
	 String txtDC = "//*[@id='toAddress']";
	 String txtNguoimua = "//*[@id='toName']";
	 String txtCCCD = "//*[@id='toIdentification']";
	 String txtEmail = "//*[@id='toEmailAddress']";
	 String txtSDT = "//*[@id='toTelecomNumber']";
	 String txtSTK = "//*[@id='accountNumber']";
	 String txtNH = "//*[@id='bankName']";
	 String txt1 = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[2]";
	 String checkLoaiTien = " //*[@id='currencyUomId']/div";
	 String checkCKhau = "//*[@id='discountTypeEnumId']/div";
	 String dropHinhthuc = "//*[@id='paymentInstrumentEnumId']";
	 String btnTao ="/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[2]/div[3]/p-button";
	 String btnQuaylai = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[2]/div[2]/p-button";
	 String noti = "//div[@role='alert']/div[last()]";
	 String btnDV = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[3]";
	 String txtDv = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[3]/p-autocomplete/span/input";
	 String btndvi = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[4]";
	 String txtdvi = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[4]/p-celleditor/input";
	 String btnSL = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[5]";
	 String txtSL = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[5]/p-celleditor/p-inputnumber/span/input";
	 String btnDG = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[6]";
	 String txtDG = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[6]/p-celleditor/p-inputnumber/span/input";
	 String btnThanhtien = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[7]";
	 String txtThanhtien = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[7]/p-celleditor/p-inputnumber/span/input";
	 String btnThue = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[8]";
	 String txtThue = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[8]/p-celleditor/p-dropdown/div/span";
	 String btnTienthue = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[9]";
	 String txtTienthue = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[9]/p-celleditor/p-inputnumber/span/input";
//	 String txtdvi = "/html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[4]";
	 @BeforeClass
		public void starBr() {
			this.startBrower("https://uat-invoice.kaike.vn/customer/invoice/hdbh/create", "Chrome");
		   
		}
	 
	@Test (priority = 4)
	 public void tc_04() {
		 driver.findElement(By.xpath(btnHoadon)).click();
		 driver.findElement(By.xpath(btnTaoHD)).click();
		 this.pause(1000);
	 }
	
	@Test (priority = 5)
	public void tc_05() {
		driver.findElement(By.xpath(txtMST)).sendKeys("0312303803");
		 driver.findElement(By.xpath(txtTendv)).sendKeys("110");
		 driver.findElement(By.xpath(txtDC)).sendKeys("hahah");
		 driver.findElement(By.xpath(txtNguoimua)).sendKeys("Hong");
		 driver.findElement(By.xpath(txtCCCD)).sendKeys("00034735487");
		 driver.findElement(By.xpath(txtEmail)).sendKeys("test2@gmail.com");
		 driver.findElement(By.xpath(txtSDT)).sendKeys("0182734");
		 driver.findElement(By.xpath(txtSTK)).sendKeys("110");
		 driver.findElement(By.xpath(txtNH)).sendKeys("0182734");
		 //driver.findElement(By.xpath("//select[@id='dropdownId']"));

		// Click để mở dropdown
		 driver.findElement(By.xpath(dropHinhthuc)).click();

		 // Chọn một mục từ danh sách
		 driver.findElement(By.xpath("//li[.//span[text()='Chuyển khoản']]")).click();
		 driver.findElement(By.xpath(checkLoaiTien)).click();
		 driver.findElement(By.xpath("//li[.//span[text()='ADP']]")).click();
		 driver.findElement(By.xpath(checkCKhau)).click();
		 driver.findElement(By.xpath("//li[.//span[text()='Theo tổng giá trị']]")).click();
		 driver.findElement(By.xpath(txt1)).click();
		 driver.findElement(By.xpath(txt1)).click();
		 driver.findElement(By.xpath("//li[.//span[text()='Chiết khấu thương mại']]")).click();
//		 driver.findElement(By.xpath("//div[contains(@class,'p-dropdown-items-wrapper')]//li[@aria-label='Chiết khấu thương mại']")).click();
		 driver.findElement(By.xpath(btnDV)).click();
		 driver.findElement(By.xpath(txtDv)).sendKeys("Chuyển phát");
		 driver.findElement(By.xpath(btndvi)).click();
		 driver.findElement(By.xpath(txtdvi)).sendKeys("VND");
		 driver.findElement(By.xpath(btnSL)).click();
		 driver.findElement(By.xpath(txtSL)).sendKeys("1000");
		 driver.findElement(By.xpath(btnDG)).click();
		 driver.findElement(By.xpath(txtDG)).sendKeys("2309000");
		 driver.findElement(By.xpath(btnThanhtien)).click();
		 driver.findElement(By.xpath(txtThanhtien)).sendKeys("1000000");
		 driver.findElement(By.xpath(btnThue)).click();
		 driver.findElement(By.xpath(txtThue)).sendKeys("10%");
		 driver.findElement(By.xpath(btnTienthue)).click();
		 driver.findElement(By.xpath(txtTienthue)).sendKeys("10000");
		 driver.findElement(By.xpath(btnTao)).click();
		 this.pause(10000);
		 assert true == driver.findElement(By.xpath(noti)).isDisplayed();
	}
//	@Test (priority = 6)
//	public void tc_06() {
//		
//	}
    
	@AfterClass
	public void closeBr() {
		this.closeBrower();
	}

}
