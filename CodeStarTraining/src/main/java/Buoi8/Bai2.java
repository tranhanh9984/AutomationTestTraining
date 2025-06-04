package Buoi8;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Bai2 extends CommonPage {
	
	@Test
    public void testAddProject() {
		clickMenu("Projects");
		driver.findElement(By.linkText("Add project")).click();
		
		driver.findElement(By.id("title")).sendKeys("Ha Anh");
		driver.findElement(By.id("description")).click();
		driver.findElement(By.className("note-editable")).sendKeys("Ha Anh");
		
		driver.findElement(By.id("start_date")).sendKeys("20-02-2004");
		driver.findElement(By.id("deadline")).sendKeys("20-02-2020");
		driver.findElement(By.id("price")).sendKeys("20000");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		pause(10);
		
		
	
    }
	
	public void clickMenu(String menu) {
		addCookies();
		clearAll();
		this.Login("admin@demo.com", "riseDemo");
		
		driver.findElement(By.xpath("//span[@class='menu-text ' and text()='" + menu + "']")).click();

	}
	
	public void Login(String name, String password) {
		driver.findElement(By.id("email")).sendKeys(name);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();
		
	}
	
	public void clearAll() {
		driver.findElement(By.id("email")).clear();;
		driver.findElement(By.id("password")).clear();;
	}
	
	private void addCookies() {
		Cookie cookie = new Cookie. Builder("myCookie", "0alfe6b98f99dd87da7a44927013ac19")
		.isHttpOnly(true)
		.isSecure(false)
		.build();
		driver.manage().addCookie(cookie);
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);

	}

}
