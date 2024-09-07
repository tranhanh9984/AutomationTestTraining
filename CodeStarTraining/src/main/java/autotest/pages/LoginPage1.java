package autotest.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class LoginPage1 extends CommonPage {
	private String gmail = "caonv174@gmail.com";
	private String password = "123456";
	private String MST = "0312303803-999";
	private String text = "Xin chào, Nguyễn Văn Cao";

	@BeforeTest
	public void StartPage() {
		this.startBrower("https://v2.vietinvoice.vn/auth/dang-nhap", "chrome");
		pause(50);
	}

	@Test
	public void TC1() {
		driver.findElement(By.id("companyUsername")).sendKeys(gmail);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("taxCode")).sendKeys(MST);
		driver.findElement(By.xpath("//button[@title='Đăng nhập']")).click();
		pause(1500);
		Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]")).getText(), text);
	}

	@AfterTest
	public void ClosePage() {
		this.closeBrowser(driver);
	}
}
