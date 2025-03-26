package autotest.pages.admin;

import autocom.common.CommonPage;


import org.openqa.selenium.By;

public class Homepage extends CommonPage {

	public Homepage() {
		super();
 	}
	public void clickMenu() {
		driver.findElement(By.partialLinkText("Gói")).click();
	}
 	public void click_tao() {    
	    driver.findElement(By.partialLinkText("Tạo mới Gói")).click();
	}
}

 