package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonPage;

public class TaoHoaDonFactory extends CommonPage {
	WebDriver driver;
	@FindBy(xpath = "//input[@name = 'customerTaxCode']")
	private WebElement txtMST;
	//String mst = "//input[@name = 'customerTaxCode']";
	// chọn gia trị mst da ton tai
	// String drMst = "(//p[contains(text(), '123')])[1]/parent::div";//%s
	@FindBy(xpath  = "//div[@data-column-id = '4']/p[contains(text(), '1501080368')]")
	private WebElement drMst;
	
	@FindBy(xpath = "//input[@name = 'customerCompanyName']")
	private WebElement donvi ;
	
	@FindBy(xpath = "//input[@name = 'customerFullAddress']")
	private WebElement diachiNguoiMua;
	
	@FindBy(xpath  = "//input[@name = 'customerName']")
	private WebElement nguoiMuaHang ;
	
	@FindBy(xpath  = "//input[@name = 'customerPhone']")
	private WebElement sdtNguoiMua ;
	
	@FindBy(xpath  = "//input[@name = 'customerAccountNumber']")
	private WebElement stknguoiMua ;
	
	@FindBy(xpath  = "//input[@name = 'customerName']")
	private WebElement bankNam ;
	
	@FindBy(xpath  = "//span[text()= 'Hình thức TT:']/following-sibling::div") @CacheLookup
	private WebElement hinhThucThanhToan ;
	
	@FindBy(xpath  = "//*[contains(text(), 'Đối trừ công nợ')]")
	private WebElement xyzTextHTTT ;
	
	@FindBy(xpath  = "//input[@name = 'customerName'")
	private WebElement email ;
	
	@FindBy(xpath  = "//span[text()='Lưu và ký']/parent::button")
	private WebElement btnSaveKy ;
	
//	String xyzTextHTTT = "//*[contains(text(), '%s')]"; // click //Đối trừ công nợ
//	String.format("//*[contains(text(), '%s')]", "123456")
	
//	String email = "//input[@name = 'customerName'";
	String tenHHDV = "//div[text() = '1']/parent::td/following-sibling::td[1]//input"; // %s
//	String btnSaveKy = "//span[text()='Lưu và ký']/parent::button";



	public TaoHoaDonFactory(WebDriver dr) {
		// TODO Auto-generated constructor stub
		driver = dr;
		PageFactory.initElements(driver, this);
	}

	public void createNew() {

		txtMST.sendKeys("123456");
//		driver.findElement(By.xpath(mst)).sendKeys("123");
//		driver.findElement(By.xpath(drMst)).click();
		drMst.click();
//		(driver.findElement(By.xpath(drMst))).getAttribute(bankNam).compareTo("test");

		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				hinhThucThanhToan);

//		driver.findElement(By.xpath(hinhThucThanhToan)).click();
		hinhThucThanhToan.click();
//		driver.findElement(By.xpath(String.format(xyzTextHTTT, "Đối trừ công nợ"))).click();
		xyzTextHTTT.click();
//		pause(4000);
		driver.findElement(By.xpath("//span[text()='Hiện cột \"Tính chất HHDV\"']/preceding-sibling::span/input")).click();
		
//		pause(5000);
//		driver.findElement(By.xpath(btnSaveKy)).click();
		btnSaveKy.click();
	}
}
