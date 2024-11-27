package autotest.testcases;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import autocom.common.CommonBase;
import autotest.pages.LoginPage;

public class Oanh_taoHoaDon extends CommonBase{
//	private WebDriver dirver;
	public Oanh_taoHoaDon() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void taoHoaDon() {
		LoginPage loginTC= new LoginPage();
		loginTC.login();
		System.out.println("TC1");
		this.driver.findElement(By.xpath("//span[@class='p-menuitem-text ng-star-inserted' and text()='Hóa đơn ']")).click();
		
		pause(5000);
		
	}

}
