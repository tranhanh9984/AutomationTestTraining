package autotest.pages.admin;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class CreateGoiHoc extends CommonPage {
	public CreateGoiHoc(){
		
	}
	
	public void clickGoiHoc() {
		driver.findElement(By.linkText("Gói")).click();
	}

	public void dienThongTinGoiHoc() {
		driver.findElement(By.linkText("Tạo mới Gói")).click();
		driver.findElement(By.id("prepaid")).click();
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("Gói số 1");
		driver.findElement(By.name("description")).clear();
		driver.findElement(By.name("description")).sendKeys("Gói học số 1 cho người học giỏi");
		driver.findElement(By.name("tagline")).clear();
		driver.findElement(By.name("tagline")).sendKeys("Học giỏi số 1");
		driver.findElement(By.name("days")).clear();
		driver.findElement(By.name("days")).sendKeys("25");
		driver.findElement(By.name("no_of_students")).clear();
		driver.findElement(By.name("no_of_students")).sendKeys("15");
		driver.findElement(By.name("no_of_staffs")).clear();
		driver.findElement(By.name("no_of_staffs")).sendKeys("2");
		driver.findElement(By.name("charges")).clear();
		driver.findElement(By.name("charges")).sendKeys("2000");
	}
	public void chonTinhNang() {
		driver.findElement(By.id("Quản lý bài tập")).click();
		driver.findElement(By.id("Quản lý hình ảnh trường học")).click();
	}
	 public void nhanTaoGoi() {
		 driver.findElement(By.id("create-btn")).click();
	 }
}