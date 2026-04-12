package autotest.aution.partner.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class LoginTestcases extends CommonPage {

//	public LoginTestcases() {
//		 TODO Auto-generated constructor stub
//	}
	WebDriver driver;
	
	@Test
	public void TaoTS() {
		loginSuccess();
		clickMenu("Tài sản");
		taoTS();
	}
	
	public void taoTS() {
		driver.findElement(By.xpath("//button[text() = ' Tạo mới ']")).click();
		pause(1);
		
		System.out.println("yyyyyyyyyyyyyyyyyyyyy");
		driver.findElement(By.xpath("//input[@placeholder = 'Nhập tên tài sản']")).sendKeys("Tài sản test số 1");
		
		pause(2);
		System.out.println("xxxxxxxxxxxxxxxxxxxxx");
	}
	
	public void clickMenu(String text) {
		pause(1);
		String  xpathMenu = "//span[text() = '%s']/ancestor::a";
		xpathMenu = String.format(xpathMenu, text);
		driver.findElement(By.xpath(xpathMenu)).click();
	}
	
	public void loginSuccess() {
		driver.findElement(By.xpath("//input[@placeholder ='Email']")).sendKeys("chuyenvienpartner@yopmail.com");
		driver.findElement(By.xpath("//input[@placeholder ='******']")).sendKeys("Abc@123z");
		driver.findElement(By.xpath("//span[text() = 'Đăng nhập']/ancestor::button")).click();
		pause(2);
		driver.findElement(By.xpath("//span[text() = 'Đăng nhập']/ancestor::button")).click();
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://tmp-auction-partner.tamvietgroup.vn/", "chrome");		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("Da chay xong, toi se closed broser web");
		this.closeBrowser(driver);		
	}

}
