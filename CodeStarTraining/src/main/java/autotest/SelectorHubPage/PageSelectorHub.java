package autotest.SelectorHubPage;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class PageSelectorHub extends CommonPage {
	PageSelectorHub(){
		
	}
	public void clickCheckOut() {
		driver.findElement(By.xpath("//button[@class = 'dropbtn']")).click();
		driver.findElement(By.linkText("Join Training")).click();
	}
	
	public void clickCar() {
		driver.findElement(By.id("cars")).click();
		driver.findElement(By.xpath("//option[@value = 'audi']")).click();
	}
	
	public void chonNgay() {
		driver.findElement(By.name("the_date")).clear();
		driver.findElement(By.name("the_date")).sendKeys("20/12/024");
	}
	
	public void clickUserTable() {
		driver.findElement(By.xpath("//input[@name ='chkSelectRow[]' and @value = '25']")).click();
		driver.findElement(By.xpath("//input[@id ='ohrmList_chkSelectRecord_14']")).click();
	}
	public void clickUserName() {
		driver.findElement(By.xpath("//input[@class='selectors-input jsSelector']")).sendKeys("lala");
		driver.findElement(By.xpath("//input[@id ='pass']")).sendKeys("lala123");
		driver.findElement(By.xpath("//input[@id ='company']")).sendKeys("Cong ty A");
		driver.findElement(By.xpath("//input[@name ='mobile number']")).sendKeys("phuonglala");
	}

}
