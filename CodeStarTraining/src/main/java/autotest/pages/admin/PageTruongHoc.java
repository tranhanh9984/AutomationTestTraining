package autotest.pages.admin;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class PageTruongHoc extends CommonPage {
	public PageTruongHoc() {
		
	}
	public void ClickTruongHoc() {
		driver.findElement(By.linkText("Trường học")).click();
	}
	
	public void TaoMoiTruongHoc(String school_logo, String admin_logo) {
		
		driver.findElement(By.id("school_name")).clear();
		driver.findElement(By.id("school_name")).sendKeys("Truong Tieu hoc Hat Lot");
		driver.findElement(By.id("school_image")).sendKeys(school_logo);
		driver.findElement(By.id("school_support_email")).clear();
		driver.findElement(By.id("school_support_email")).sendKeys("tieuhochatlot7@gmail.com");
		driver.findElement(By.id("school_support_phone")).clear();
		driver.findElement(By.id("school_support_phone")).sendKeys("0123456789");
		driver.findElement(By.id("school_tagline")).clear();
		driver.findElement(By.id("school_tagline")).sendKeys("Hoc, hoc nua, hoc mai");
		driver.findElement(By.id("school_address")).clear();
		driver.findElement(By.id("school_address")).sendKeys("Thi tran Hat Lot");
		driver.findElement(By.id("school_code_prefix")).clear();
		driver.findElement(By.id("school_code_prefix")).sendKeys("123");
		driver.findElement(By.id("admin_first_name")).clear();
		driver.findElement(By.id("admin_first_name")).sendKeys("Nguyen");
		driver.findElement(By.id("admin_last_name")).clear();
		driver.findElement(By.id("admin_last_name")).sendKeys("Thu Phuong");
		driver.findElement(By.id("admin_contact")).clear();
		driver.findElement(By.id("admin_contact")).sendKeys("0987654321");
		driver.findElement(By.id("admin_email")).clear();
		driver.findElement(By.id("admin_email")).sendKeys("thuphuong7@gmail.com");
		driver.findElement(By.name("admin_image")).sendKeys(admin_logo);
		
		
	}
	public void ClickTaoMoi() {
		driver.findElement(By.id("create-btn")).click();
	}
	 public void nhanDropDown() {

		 driver.findElement(By.xpath("(//button[@id='dropdownMenuButton'])[1]")).click();
		 driver.findElement(By.className("dropdown-item p-2 edit-data set-form-url")).click();
	 }
	
}
