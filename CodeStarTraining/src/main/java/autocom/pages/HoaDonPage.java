package autocom.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;

import autocom.common.CommonPage;

public class HoaDonPage extends CommonPage {

	String txtCustomerMST = "//input[@name='customerTaxCode']"; //div[@data-column-id = '4']/p[contains(text(), '45')]"
	// Chon gia tri MST da ton tai
	String drMST = "//div[@data-column-id='4']/p[contains(text(),'44444')]";
	String txtMaKhachHang = "//div[@id='row-0']";
	String txtDonvi = "input[@name='customerCompanyName']";
	String txtAddressCustomer = "//input[@name='customerFullAddress']";
	String txtCustomerName = "//input[@name='customerName']";
	String txtCustomerPhone = "//input[@id='customerPhone']";
	String txtCustomerBankNo = "//input[@id='customerAccountNumber']";
	String txtCustomerEmail = "//input[@id='customerEmail']";

	String txtHinhThucThanhToan = "//span[text()='Hình thức TT:']/following-sibling::div"; 
	String lblTextHTTT = "//*[contains(text(),'%s')]";

	String txtProductCode = "//input[@id='good_name']";
	String lsProductCode = "//div[@id='cell-good_table_name-undefined']";
	String lblTenHHDV = "//div[text() = '1']/parent::td/following-sibling::td[1]//input";
	String btnLuuvaKy = "//span[@title = 'Lưu và ký']/parent::button";
	String lblTitle = "//div[@class='card-title my-0']";
	WebDriver driver;

	public HoaDonPage(WebDriver dr) {
		driver = dr;
	}

	/*
	 * public void fillTaoHoaDonForm() {
	 
		this.clickMenu("Hóa đơn/Tạo hoá đơn");
		driver.findElement(By.xpath(txtCustomerMST)).sendKeys("44444");
		driver.findElement(By.xpath(drMST)).click();
		
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", driver.findElement(By.xpath(txtHinhThucThanhToan)));
		
		driver.findElement(By.xpath(txtHinhThucThanhToan)).click();
		driver.findElement(By.xpath(lblTextHTTT)).click();
		pause(4000);
		driver.findElement(By.xpath(lblTenHHDV)).sendKeys("RON 95-V");
		pause(1000);
		driver.findElement(By.xpath(btnLuuvaKy)).click();
		
	}
	 
*/
	public void fillTaoHoaDonForm(String MST, String customerName, String productCode) {
		this.clickMenu("Hóa đơn/Tạo hoá đơn");
		pause(1000);
		this.selectMSTKhachHang(drMST);
		pause(1000);
		this.inputCustomerName(customerName);
		//this.selectHTTT(txtHinhThucThanhToan);
		//pause(1000);
		this.selectProductCodeService(productCode);
		pause(1000);
		this.clickLuuvaKyButton();
		
	}

	public void selectMSTKhachHang(String mst) {
		this.enterMST(mst);
		pause(5000);
		this.selectMST();
		pause(1000);
	}

		//public void enterMST (String CustomerMST) {
		//driver.findElement(By.xpath(txtCustomerMST)).sendKeys(CustomerMST);
		//pause(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath(drMST)).click();

	//}

	public void enterMST(String mst) {
	driver.findElement(By.xpath(txtCustomerMST)).sendKeys(mst);
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }

	public void selectMST() {
	driver.findElement(By.xpath(drMST)).click();
	}

	public void inputCustomerName(String customerName) {
		driver.findElement(By.xpath(txtCustomerName)).clear();
		driver.findElement(By.xpath(txtCustomerName)).sendKeys(customerName);
	}

	public void inputCustomerPhone(String customerPhone) {
		driver.findElement(By.xpath(txtCustomerPhone)).clear();
		driver.findElement(By.xpath(txtCustomerPhone)).sendKeys(customerPhone);
	}

	public void inputCustomerEmail(String customerEmail) {
		driver.findElement(By.xpath(txtCustomerEmail)).sendKeys(customerEmail);
	}

	public void selectHTTT(String HinhthucTT) {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor)driver).executeScript("arguments(0).scrollIntoView();", driver.findElement(By.xpath(txtHinhThucThanhToan)));
		driver.findElement(By.xpath(txtHinhThucThanhToan)).click();;
		pause(1000);
		driver.findElement(By.xpath(lblTextHTTT)).click();
	}

	public void selectProductCodeService(String productCode) {
		driver.findElement(By.xpath(txtProductCode)).sendKeys(productCode);
		pause(5000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(lsProductCode)).click();
		pause(5000);
	}

	public void clickLuuvaKyButton() {
		driver.findElement(By.xpath(btnLuuvaKy)).click();
	}

	public String pageTitleVerify() {
		return driver.findElement(By.xpath(lblTitle)).getText();
	}

	// truyen vao String StrSelected = Hoa Don/Tao Hoa Don
	public void clickMenu(String strSelected) {
		String txtMenu = "//span[text() = '%s']/ancestor::a";
		String[] menus = strSelected.split("/");
		pause(1000);

		for (int i = 0; i < menus.length; i++) {
			if (!driver.findElement(By.xpath(String.format(txtMenu, menus[i]))).isDisplayed()) {
				pause(1000);
			}
			driver.findElement(By.xpath(String.format(txtMenu, menus[i]))).click();
		}
	}
}
