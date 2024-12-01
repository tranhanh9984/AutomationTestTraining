package autotest.pages;

import static org.testng.Assert.assertEquals;

import java.awt.Color;
import java.awt.color.ColorSpace;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonBase;

public class Oanh_B9_TaoHoaDon extends CommonBase {
	private String mst="//input[@class='ng-tns-c110-12 p-autocomplete-input p-inputtext p-component p-autocomplete-dd-input ng-star-inserted']";
	private String getInfo ="//ul[@role='listbox']/li[1]";
	private String btnAddHangHoa = "//th[@class='p-text-center action-column']";
	String checkboxProductItem= "//div[@role='dialog']//tbody[@class='p-element p-datatable-tbody']/tr[1]/td[1]";
	String btnAddItem= "//div[@role='dialog']//span[text()='Thêm']";
	String btnCreate = "//p-button[@type='submit' and @class='p-element']";
	String noti = "//div[@role='alert']/div[last()]";
	String email="//input[@id='toEmailAddress']";
	String paymentMethodDropdown ="//p-dropdown[@id='paymentInstrumentEnumId']";
	String paymentMethodItem= "//ul[@role='listbox']//p-dropdownitem[%d]//span[1]";
	
	public Oanh_B9_TaoHoaDon(WebDriver dr) {
		driver = dr;
	}
	
	@BeforeClass
	public void startPage() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");

	}
	@Test
	public void checkValuePaymentMethod() {
		
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", driver.findElement(By.xpath(paymentMethodDropdown)));
		
		this.setButton(paymentMethodDropdown);
		this.awaitElementVisible("//ul[@role='listbox']");
		String[] expected = {"TM/CK", "Tiền mặt", "Chuyển khoản","Đối trừ công nợ", "Không thu tiền"};
		for (int i = 1; i <= 5 ; i++) {
			assertEquals(getText(String.format(paymentMethodItem, i)), expected[i-1]);
		}
		
	}
	
	
	@Test
	public void checkValidateTax_notFound() {
		//Check nhap mst khong ton Tai
		clearData(mst);
		this.setText("3939", mst);
		this.setButton("//span[contains(text(),\"Lấy thông tin\")]");
		String result = awaitElementVisible(noti).getText();
		String expected = "Không tìm thấy thông tin doanh nghiệp/cá nhân có mã số thuế";
		assertEquals(result.contains(expected), true);
		
	}
	
	@Test
	public void checkValidateTax_empty() {
		clearData(mst);
		//check khi khong nhap mst
		this.setText("", mst);
		boolean statusBtn= driver.findElement(By.xpath("//span[contains(text(),\"Lấy thông tin\")]")).isEnabled();
		assertEquals(statusBtn,false );
		
	}
	
	@Test
	public void checkValidate_email(){
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", driver.findElement(By.xpath(email)));
		String attribute;
		clearData(email);
		this.setText("Oanh@gmail", email);
		attribute= driver.findElement(By.xpath(email)).getAttribute("class");
		assertEquals(attribute.contains("ng-invalid"), true);
		
		clearData(email);
		this.setText("Oanh@gmail.n", email);
		attribute= driver.findElement(By.xpath(email)).getAttribute("class");
		assertEquals(attribute.contains("ng-invalid"), true);
		
		clearData(email);
		this.setText("Oanhgmail.vn", email);
		attribute= driver.findElement(By.xpath(email)).getAttribute("class");
		assertEquals(attribute.contains("ng-invalid"), true);
		
		clearData(email);
		this.setText("@gmail.vn", email);
		attribute= driver.findElement(By.xpath(email)).getAttribute("class");
		assertEquals(attribute.contains("ng-invalid"), true);	
		
		
	}
	
	@AfterTest
	public void clearAllData() {
		clearData(mst);
		clearData(email);
//		clearData();
	}
	
	public void createInvoiceFail() {
		//Tao hoa don khi khong nhap truong gia tri nao
		this.setButton(btnCreate);
		String result= this.awaitElementVisible(noti).getText();
		System.out.print(result);
		assertEquals(result.contains("Tên đơn vị hoặc người mua hàng không được bỏ trống"), true);
	}
	
	@Test
	public void creatInvoiceSuccess() {
		// khong tim thay account
		this.setText("123456789", mst);
//		pause(30000);
//		this.setButton(getInfo);
		this.awaitElementVisible(getInfo).click();
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", driver.findElement(By.xpath(btnAddHangHoa)));
		this.setButton(btnAddHangHoa);
		this.awaitElementVisible(checkboxProductItem).click();
		this.setButton(btnAddItem);
		pause(1000);
		this.setButton(btnCreate);
		pause(2000);
		assertEquals(driver.getCurrentUrl(), "https://uat-invoice.kaike.vn/customer/invoice/hdbh");
		
	}

}
