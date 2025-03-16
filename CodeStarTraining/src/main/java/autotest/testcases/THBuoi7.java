package autotest.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
//import org.testng.Assert;
import org.testng.annotations.*;

import autocom.common.CommonPage;
import autotest.pages.LoginPage;


public class THBuoi7 extends CommonPage {

	
	public void tc01() {
		System.out.println("hanh test thu");
	}
	
	@Test
	public void tc02() {
		
		driver.findElement(By.linkText("Alert with OK & Cancel")).click();
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).click();
		pause(5);
	
		String text = 	driver.switchTo().alert().getText();
		System.out.println(text);
		//driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		
		pause(5);
		System.out.println("hanh test thu");
	}
	
	
	@BeforeTest
	@Parameters("browser")
	public void startPage(@Optional("chrome") String browser) {
		this.startBrower("https://demo.automationtesting.in/Alerts.html", browser);
		//loginPage = new LoginPage(driver);
		System.out.print("Khoi tao");
	}

	@AfterTest
	public void closePage() throws InterruptedException {
//			Thread.sleep(2);
		this.closeBrowser(driver);
	}
	
}
