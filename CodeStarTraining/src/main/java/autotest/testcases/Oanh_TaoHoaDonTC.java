package autotest.testcases;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.common.CommonBase;
import autotest.pages.LoginPage;
import autotest.pages.Oanh_B9_LoginPage;
import autotest.pages.Oanh_B9_TaoHoaDon;

public class Oanh_TaoHoaDonTC extends CommonBase{

	public Oanh_TaoHoaDonTC() {
		// TODO Auto-generated constructor stub
	}
	@BeforeClass
	public void startPage() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");

	}
	@Test
	public void taoHoaDon() {
		Oanh_B9_LoginPage loginTC= new Oanh_B9_LoginPage(driver);// phai truyen driver cua hoa don de chay ham login ben class login page do chi goi ham login k goi ham startBrower nen khong co driver
		loginTC.successLogin();
		System.out.println("TC1");
		
		driver.findElement(By.xpath("//span[@class='p-menuitem-text ng-star-inserted' and text()='Hóa đơn ']")).click();
		driver.findElement(By.xpath("//a[@role='menuitem']/span[text()='Lập hoá đơn']")).click();
		
		pause(2000);
		
		Oanh_B9_TaoHoaDon taoHoaDon= new Oanh_B9_TaoHoaDon(driver);
		taoHoaDon.checkValidate_email();
		taoHoaDon.clearAllData();
		taoHoaDon.checkValidateTax_notFound();
		taoHoaDon.clearAllData();
		taoHoaDon.checkValidateTax_empty();
		taoHoaDon.clearAllData();
		taoHoaDon.checkValuePaymentMethod();
		taoHoaDon.clearAllData();
		taoHoaDon.createInvoiceFail();
		taoHoaDon.creatInvoiceSuccess();
	
		
	}
	
	@AfterClass
	public void closePage() {
		this.closeBrowser();
	}

}
