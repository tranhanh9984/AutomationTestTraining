package autotest.pages.admin;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class EditTruongHoc extends CommonPage {
	
	public  EditTruongHoc() {
		
	}
	
	public void editTruongHoc() {
		 driver.findElement(By.id("edit_school_name")).clear();
		 driver.findElement(By.id("edit_school_name")).sendKeys("Truong THCS Chat Luong Cao");
		 driver.findElement(By.linkText("Gửi")).click();
	 }

}
