package autotest.pages.practice;

import autocom.common.CommonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;                                                                                                               
public class HomePractice extends CommonPage {
	WebDriver driver;
	public HomePractice() {
	super();	
	}
	public void click(String name) {
		driver.findElement(By.xpath(name)).click();	
	}
	

}
