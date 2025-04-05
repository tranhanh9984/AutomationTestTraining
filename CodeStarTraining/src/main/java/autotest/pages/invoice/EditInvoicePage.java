package autotest.pages.invoice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import autocom.common.CommonPage;

public class EditInvoicePage extends CommonPage {

	public static String toAddress = "Cầu Giấy HN";
	public static String toName = "anhptm";
	public static String toIdentification = "087633552718";
	public static String toEmailAddress = "anhptm@gmail.com";
	public static String toTelecomNumber = "0987654332";
	public static String accountNumber = "987654355";
	public static String bankName = "MB";
	String prodName = "//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()]/td[3]";
	
	public void HoaDonBanHang() {
		driver.findElement(By.xpath("//ul[@class ='p-menubar-root-list']/li[2]")).click();
		driver.findElement(By.xpath("//ul[@class ='p-submenu-list']/li[2]")).click();
	}

	public void Search() {
		driver.findElement(By.id("fromDate")).click();
		driver.findElement(By.xpath("//button[contains(@class, ' p-datepicker-prev')]")).click();
		driver.findElement(By.xpath("//button[contains(@class, ' p-datepicker-prev')]")).click();
		driver.findElement(By.xpath("//button[contains(@class, ' p-datepicker-prev')]")).click();
		driver.findElement(By.xpath("//tr/td/span[text()='1']")).click();
	}

	public void MenuEdit() {
		driver.findElement(By.xpath("//tbody[contains(@class, 'p-datatable-tbody')]/tr[2]/td[last()]/p-button[@title='Chỉnh sửa']")).click();
	}
	
	public void editData(String address, String name, String cccd, String email, String phone,  String account,
			 String bankname) {

		driver.findElement(By.xpath("//div[@class ='p-fluid p-pr-3']/div[4]/div[@class ='p-col']/p-autocomplete/span/button")).click();
		driver.findElement(By.xpath("//div[contains (@class, 'p-autocomplete-panel')]/ul/li[1]")).click();
		driver.findElement(By.id("toAddress")).clear();
		driver.findElement(By.id("toAddress")).sendKeys(address);
		driver.findElement(By.id("toName")).clear();
		driver.findElement(By.id("toName")).sendKeys(name);
		driver.findElement(By.id("toIdentification")).clear();
		driver.findElement(By.id("toIdentification")).sendKeys(cccd);
		driver.findElement(By.id("toEmailAddress")).clear();
		driver.findElement(By.id("toEmailAddress")).sendKeys(email);
		driver.findElement(By.id("toTelecomNumber")).clear();
		driver.findElement(By.id("toTelecomNumber")).sendKeys(phone);
		driver.findElement(By.id("accountNumber")).clear();
		driver.findElement(By.id("accountNumber")).sendKeys(account);
		driver.findElement(By.id("bankName")).clear();
		driver.findElement(By.id("bankName")).sendKeys(bankname);
		driver.findElement(By.id("paymentInstrumentEnumId")).click();
		driver.findElement(By.xpath("//div[contains (@class, 'p-dropdown-items-wrapper ')]/ul/p-dropdownitem[1]")).click();

		driver.findElement(By.xpath("//div[contains (@class, 'p-fluid p-mt-2')]/div/div[2]/p-dropdown")).click();
		driver.findElement(By.xpath("//div[contains (@class, 'p-dropdown-open')]/div[3]/div/ul/p-dropdownitem[2]")).click();
		
		driver.findElement(By.xpath("//div[contains (@class, 'p-fluid p-mt-2')]/div/div[3]/p-inputnumber/span/input")).clear();
		driver.findElement(By.xpath("//div[contains (@class, 'p-fluid p-mt-2')]/div/div[3]/p-inputnumber/span/input")).sendKeys("25");
		
		driver.findElement(By.xpath("//div[contains (@class, 'p-fluid p-mt-2')]/div/div[4]/p-dropdown")).click();
		driver.findElement(By.xpath("//div[contains (@class, 'p-dropdown-open')]/div[3]/div/ul/p-dropdownitem[2]")).click();


//		Xoá 1 sp
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[last()]")).click();
		driver.findElement(By.xpath("//div[contains (@class, 'p-confirm-popup')]/div[last()]/button[contains (@class, 'p-confirm-popup-accept')]")).click();
		pause(3);
//		Thêm SP mới từ popup
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(
		    By.xpath("//th[@class='p-text-center action-column']//button")));
		addButton.click();
		pause(2);
		driver.findElement(By.xpath("(//div[@role='checkbox'])[" + 5 + "]")).click();
		pause(2);
		driver.findElement(By.xpath("//button[contains (@class, 'p-button-raised p-button p-component')]")).click();
		pause(3);
		
		
//		Thêm SP mới từ dòng trống
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()]/td[3]/p-autocomplete/span/input")).sendKeys("Sản Phẩm 1");pause(1);
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[4]")).click();pause(1);
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[4]/p-celleditor/input")).sendKeys("Cái");pause(1);
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[5]")).click();
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[5]/p-celleditor/p-inputnumber/span/input")).sendKeys("1");pause(1);
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[6]")).click();
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[6]/p-celleditor/p-inputnumber/span/input")).sendKeys("20000");pause(1);
////		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[7]")).click();
////		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[7]/p-celleditor/p-inputnumber/span/input")).sendKeys("20000");
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[9]")).click();
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[9]/p-celleditor/p-inputnumber/span/input")).sendKeys("2");pause(1);
//		
		
//		Thêm SP mới từ dòng trống
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()]/td[3]/p-autocomplete/span/input")).sendKeys("Sản Phẩm 1");pause(1);
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[4]")).click();pause(1);
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[4]/p-celleditor/input")).sendKeys("Cái");pause(1);
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[5]")).click();
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[5]/p-celleditor/p-inputnumber/span/input")).sendKeys("1");pause(1);
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[6]")).click();
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[6]/p-celleditor/p-inputnumber/span/input")).sendKeys("20000");pause(1);
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[7]")).click();
//		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[7]/p-celleditor/p-inputnumber/span/input")).sendKeys("20000");
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[9]")).click();
		driver.findElement(By.xpath("//tbody[contains (@class, 'p-datatable-tbody')]/tr[last()-1]/td[9]/p-celleditor/p-inputnumber/span/input")).sendKeys("2");pause(1);
	}
	
	public void Save() {
		driver.findElement(By.xpath("//button[contains (@class, 'p-ml-2 p-button p-component')]")).click();
	}
}
