package autotest.testcase.buoi9;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.page.buoi9.Buoi9Page;


public class Buoi9 extends CommonPage {

	Buoi9Page buoi9;
	public Buoi9() {
		
	}

	@Test
	public void Test1() {
//		buoi9.addData();
	}


	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://selectorshub.com/xpath-practice-page/", KeywordConstant.BROWSER);	
		driver.findElement(By.xpath("//button[@class ='dropbtn']")).click();
		driver.findElement(By.linkText("Join Training")).click();
//		driver.findElement(By.xpath("//select[@id = 'cars']")).click();
//		driver.findElement(By.xpath("//select/option[last()]")).click();
//		driver.findElement(By.name("the_date")).click();
//		driver.findElement(By.xpath("//select/option[last()]")).click();
//		buoi9 = new Buoi9Page();
//		buoi9.driver = driver;
		pause(5);
		
		

	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);

	}

}


















//
//String Button =  "//button[@class ='dropbtn']"; 
//String DropChooseCar = "//select[@id = 'cars']";