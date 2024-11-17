package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import autocom.common.CommonPage;

public class TaoHoaDon extends CommonPage {

//	@FindBy(mst = "//input[@name = 'customerTaxCode']")
	String mst = "//input[@name = 'customerTaxCode']";
	// chọn gia trị mst da ton tai
	// String drMst = "(//p[contains(text(), '123')])[1]/parent::div";//%s
	String drMst = "//div[@data-column-id = '4']/p[contains(text(), '1501080368')]";
	String donvi = "//input[@name = 'customerCompanyName']";
	String diachiNguoiMua = "//input[@name = 'customerFullAddress']";
	String nguoiMuaHang = "//input[@name = 'customerName']";
	String sdtNguoiMua = "//input[@name = 'customerPhone']";
	String stknguoiMua = "//input[@name = 'customerAccountNumber']";
	String bankNam = "//input[@name = 'customerName']";
	String hinhThucThanhToan = "//span[text()= 'Hình thức TT:']/following-sibling::div"; // click
	String xyzTextHTTT = "//*[contains(text(), '%s')]"; // click //Đối trừ công nợ
	String email = "//input[@name = 'customerName'";
	String tenHHDV = "//div[text() = '1']/parent::td/following-sibling::td[1]//input"; // %s
	String btnSaveKy = "//span[text()='Lưu và ký']/parent::button";

	WebDriver driver;

	public TaoHoaDon(WebDriver dr) {
		// TODO Auto-generated constructor stub
		driver = dr;
	}

	public void createNew() {

		driver.findElement(By.xpath(mst)).sendKeys("123");
		driver.findElement(By.xpath(drMst)).click();

//		(driver.findElement(By.xpath(drMst))).getAttribute(bankNam).compareTo("test");

		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.xpath(hinhThucThanhToan)));

		driver.findElement(By.xpath(hinhThucThanhToan)).click();

		driver.findElement(By.xpath(String.format(xyzTextHTTT, "Đối trừ công nợ"))).click();

		pause(4000);
		driver.findElement(By.xpath("//span[text()='Hiện cột \"Tính chất HHDV\"']/preceding-sibling::span/input")).click();
		
		pause(5000);
		driver.findElement(By.xpath(btnSaveKy)).click();
	}
}
