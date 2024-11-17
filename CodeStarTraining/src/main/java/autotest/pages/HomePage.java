package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class HomePage extends CommonPage {

	String noti = "//div[@class = 'Toastify']";
	
	KeywordConstant comConstant =  new KeywordConstant();
	WebDriver driver;
	
	//click String = Hóa đơn/Tạo hoá đơn
	@Test
	public void testLoginF() {
		pause(2000);
		LoginPage login = new LoginPage(driver);
		login.login("hanhtm", "123456", "2222");
		pause(2000);
		String txtWelCome = driver.findElement(By.xpath(noti)).getText();
		
		System.out.println(txtWelCome);
	}
	
	
//	@Test
	public void testLogin() {
		pause(2000);
		LoginPage login = new LoginPage(driver);
		login.login();
		pause(2000);
		String txtWelCome = driver.findElement(By.xpath(noti)).getText();
		Assert.assertTrue(txtWelCome.contains("Nguyễn Văn Cao"));
		
		this.clickMenu("Hóa đơn/Tạo hoá đơn"); //\\=/
		pause(6000);
		
	}
		
	@BeforeTest
	public void startPage() {
		driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");
	}

	@AfterTest
	public void closePage() throws InterruptedException {
//			Thread.sleep(2);
		this.closeBrowser(driver);
	}
	
}