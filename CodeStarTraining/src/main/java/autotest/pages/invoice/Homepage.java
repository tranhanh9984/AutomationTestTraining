package autotest.pages.invoice;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class Homepage extends CommonPage{

	String lblTitle ="//a[@title = 'Thông tin cá nhân']";
	public String getTitle() {
		return driver.findElement(By.xpath(lblTitle)).getText();
	}
	
//	public void HoaDon() {
//		driver.findElement(By.xpath("//ul[@class ='p-menubar-root-list']/li[2]")).click();
//		driver.findElement(By.xpath("//ul[@class ='p-submenu-list']/li[2]")).click();
//	}
}
