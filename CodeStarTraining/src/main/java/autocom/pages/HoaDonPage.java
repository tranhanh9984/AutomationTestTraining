package autocom.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;

import autocom.common.CommonPage;

public class HoaDonPage extends CommonPage {

	String txtCustomerMST = "//input[@name='customerTaxCode']";
	// Chon gia tri MST da ton tai
	String txtMaKhachHang = "//div[@id='row-0']";
	String txtCustomerName = "//input[@id='customerName']";
	String txtCustomerPhone = "//input[@id='customerPhone']";
	String txtCustomerBankNo = "//input[@id='customerAccountNumber']";
	String txtCustomerEmail = "//input[@id='customerEmail']";
	String txtHinhThucThanhToan = "//span[span(text)='Hình thức TT:']//following-sibling::div";
	String txtProductCode = "//input[@id='good_name']";
	String lsProductCode = "//div[@id ='cell-good_table_code-undefined']";
	String btnLuu = "//span[@title = 'Lưu và ký']/parent::button";
	String lblTitle = "//div[@class='card-title my-0']";
	WebDriver driver;

	public HoaDonPage(WebDriver dr) {
		driver = dr;
	}

	public void fillTaoHoaDonForm(String CustomerMST, String customerName, String customerPhone, String customerEmai,
			String productCode) {
		this.enterMSTKhachHang(CustomerMST);
		this.enterCustomerName(customerName);
		this.enterCustomerPhone(customerPhone);
		this.enterCustomerEmail(customerEmai);
		this.enterProductCodeService(productCode);
		this.clickLuuvaKy();

	}

	public void enterMSTKhachHang(String CustomerMST) {
		this.enterMST(CustomerMST);
		this.selectMST();
	}

	public void enterMST(String mst) {
		driver.findElement(By.xpath(txtCustomerMST)).sendKeys(mst);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void selectMST() {
		driver.findElement(By.xpath(txtMaKhachHang)).click();
	}

	public void enterCustomerName(String customerName) {
		driver.findElement(By.xpath(txtCustomerName)).sendKeys(customerName);
	}

	public void enterCustomerPhone(String customerPhone) {
		driver.findElement(By.xpath(txtCustomerPhone)).sendKeys(customerPhone);
	}

	public void enterCustomerEmail(String customerEmail) {
		driver.findElement(By.xpath(txtCustomerEmail)).sendKeys(customerEmail);
	}

	public void enterProductCodeService(String productCode) {
		this.enterProductCode(productCode);
		this.selectProductCode();
	}

	public void enterProductCode(String proCode) {
		driver.findElement(By.xpath(txtProductCode)).sendKeys(proCode);
	}

	public void selectProductCode() {
		driver.findElement(By.xpath(lsProductCode)).click();
	}

	public void clickLuuvaKy() {
		driver.findElement(By.xpath(btnLuu)).click();
	}

	public String pageTitleVerify() {
		return driver.findElement(By.xpath(lblTitle)).getText();
	}
}
