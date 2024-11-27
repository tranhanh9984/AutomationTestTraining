package autotest.pages;
import java.lang.annotation.*;
import org.testng.annotations.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonBase;
import autocom.constant.KeywordConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//public class LoginPage extends CommonPage {
//	//textInut - txt, lable: lbl, combobox - cbb, button - btn
//	String txtUserName = "//input[@id = 'companyUsername']";
//	String txtPassword = "//input[@id = 'password']";
//	String txtMST = "//input[@id = 'taxCode']";
//	String btnDangNhap = "//button[text() = 'Đăng nhập']";
//	
//	WebDriver driver;
//	public LoginPage(WebDriver dr){
//		driver = dr;
//	}
//	
//	public void login() {
//		driver.findElement(By.xpath(txtUserName)).sendKeys(KeywordConstant.EMAIL);
//		driver.findElement(By.xpath(txtPassword)).sendKeys(KeywordConstant.PASSWORD);
//		driver.findElement(By.xpath(txtMST)).sendKeys(KeywordConstant.MST);
//		driver.findElement(By.xpath(btnDangNhap)).click();
//	}
//	
//	
//	public void login(String email, String password, String mst) {
//		driver.findElement(By.xpath(txtUserName)).sendKeys(email);
//		driver.findElement(By.xpath(txtPassword)).sendKeys(password);
//		driver.findElement(By.xpath(txtMST)).sendKeys(mst);
//		driver.findElement(By.xpath(btnDangNhap)).click();
//	}	
//	
//	public void signIn(String email, String password, String mst) {
//		
//	}
//	
//	public void quenMatKhau(WebDriver driver, String email, String password, String mst) {
//		
//	}
//	
//}

public class LoginPage extends CommonBase { 
	@Test
	public void tc_01() {
		System.out.println("HaDV_start Browser");
		driver.findElement(By.id("email")).sendKeys("0312303803-999");
		driver.findElement(By.id("password")).sendKeys("0312303803-999");
		driver.findElement(By.xpath("//button")).click();
		pause(5000);
		driver.findElement(By.xpath("//ul[@role=\"menubar\"]//span[contains(@class,\"p-menuitem-text\")][text()=\"Hóa đơn \"]")).click();
		driver.findElement(By.xpath("//ul[@role=\"menubar\"]//span[contains(@class,\"p-menuitem-text\")][text()=\"Lập hoá đơn\"]")).click();
		this.tc_dienThongtin();
	 
	}
	public void tc_dienThongtin() {
		//             driver.findElement(By.xpath(""));
		
		driver.findElement(By.xpath("//p-dropdown[@id=\"invoiceTemplatePartyId\"]")).click();
		System.out.println("1");
		driver.findElement(By.xpath("//li[@aria-label=\"1C24TAA\"]")).click();
		System.out.println("2");
		driver.findElement(By.xpath("//p-autocomplete[@id=\"toPartyTaxId\"]//input")).sendKeys("0312303803-999");
		
		//click vào Lấy Thông Tin btn để pre-filled các thông tin có trong data
		driver.findElement(By.xpath("//span[text()=\"Lấy thông tin\"]")).click();
		
		//Check các filed xem đã được pre-filled chưa. Nếu trống thì điền thông tin vào
		String filedValue = driver.findElement(By.xpath("//input[@id=\"toName\"]")).getAttribute("value");
		if(filedValue.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"toName\"]")).sendKeys("Do Viet Ha");
		}
		
		
		String toIdentification = driver.findElement(By.xpath("//input[@id=\"toIdentification\"]")).getAttribute("value");
		if(toIdentification.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"toIdentification\"]")).sendKeys("001191123456");
		}
		//Check giá trị pre-filled
		
		String toEmailAddress = driver.findElement(By.xpath("//input[@id=\"toEmailAddress\"]")).getAttribute("value");
		if(toEmailAddress.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"toEmailAddress\"]")).sendKeys("vietha@gmail.com");
		}
		//Check giá trị pre-filled
		
		String toTelecomNumber = driver.findElement(By.xpath("//input[@id=\"toTelecomNumber\"]")).getAttribute("value");
		if(toTelecomNumber.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"toTelecomNumber\"]")).sendKeys("09777111123");
		}
		//Check giá trị pre-filled
		
		String accountNumber = driver.findElement(By.xpath("//input[@id=\"accountNumber\"]")).getAttribute("value");
		if(accountNumber.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"accountNumber\"]")).sendKeys("001002003");
		}
		//Check giá trị pre-filled
		
		String bankName = driver.findElement(By.xpath("//input[@id=\"bankName\"]")).getAttribute("value");
		if(bankName.isEmpty()) {
			driver.findElement(By.xpath("//input[@id=\"bankName\"]")).sendKeys("Vietcombank");
		}
		driver.findElement(By.xpath("//p-dropdown[@id=\"paymentInstrumentEnumId\"]")).click();
		System.out.println("2");
		driver.findElement(By.xpath("//p-dropdown[@id=\"paymentInstrumentEnumId\"]//span[@id=\"pr_id_14_label\"]")).click();
		System.out.println("3");
		
		driver.findElement(By.xpath("//p-dropdown[@id=\"currencyUomId\"]")).click();
		System.out.println("4");
		driver.findElement(By.xpath("//li[@id=\"p-highlighted-option\" and @aria-label=\"VND\"]")).click();
		System.out.println("5");
		
		
		//Check giá trị pre-filled
		
		String exchangeRate = driver.findElement(By.xpath("//p-inputnumber[@id=\"exchangeRate\"]//input")).getAttribute("value");
		System.out.println("6");
		if(exchangeRate.isEmpty()) {
			driver.findElement(By.xpath("//p-inputnumber[@id=\\\"exchangeRate\\\"]//input")).sendKeys("20000");
			System.out.println("7");
		}
		
		driver.findElement(By.xpath("//p-dropdown[@id=\"discountTypeEnumId\"]")).click();
		System.out.println("8");
		driver.findElement(By.xpath("//p-dropdown[@id=\"discountTypeEnumId\"]//li[@aria-label=\"Không chiết khấu\"]")).click();
		System.out.println("9");
		driver.findElement(By.xpath("//p-button[@title=\"Thêm\"]")).click();
		System.out.println("10");
		// Add hàng vào hóa đơn
		// Kiểm tra nếu checkbox chưa được chọn, thì click để chọn
		
		
		String ariaChecked = driver.findElement(By.xpath("//div[@id=\"pr_id_44\"]//tr[3]//div[@role=\"checkbox\"]")).getAttribute("aria-checked");
		if (ariaChecked.equals("false")) {
		    // Checkbox chưa được chọn, thực hiện click để chọn
			driver.findElement(By.xpath("//div[@id=\"pr_id_44\"]//tr[3]//div[@role=\"checkbox\"]")).click();
		}
		
		
		String ariaChecked2 = driver.findElement(By.xpath("//div[@id=\"pr_id_44\"]//tr[5]//div[@role=\"checkbox\"]")).getAttribute("aria-checked");
		if (ariaChecked2.equals("false")) {
		    // Checkbox chưa được chọn, thực hiện click để chọn
			driver.findElement(By.xpath("//div[@id=\"pr_id_44\"]//tr[5]//div[@role=\"checkbox\"]")).click();
		}
		
		driver.findElement(By.xpath("//p-footer//span[text()=\"Thêm dòng trống\"]")).click();
		driver.findElement(By.xpath("//p-button[@type=\"submit\"]//span[text()=\"Tạo mới\"]")).click();
	}
	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
		

	}
//@AfterClass
//	public void close() {
//		this.closeBrowser();
//	}
	
}