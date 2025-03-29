package autotest.pages.admin;

import autocom.common.CommonPage;


import org.openqa.selenium.By;

public class Homepage extends CommonPage {

	public Homepage() {
		super();
 	}
	public void clickMenu(String Menuname) {
		driver.findElement(By.partialLinkText(Menuname)).click();
	}
 	public void click_tao(String menu) {    
	    driver.findElement(By.partialLinkText(menu)).click();
	}
}

 