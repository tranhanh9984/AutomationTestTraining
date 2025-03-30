package autotest.pages.fclass;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class HomePage extends CommonPage{

	public HomePage() {
		// TODO Auto-generated constructor stub
	}
	
	public void clickMenu(String text) {
//	    driver.findElement(By.linkText(text)).click();
        driver.findElement(By.partialLinkText(text)).click();
	}
}