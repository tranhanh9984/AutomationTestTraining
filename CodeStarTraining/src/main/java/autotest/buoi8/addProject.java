package autotest.buoi8;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class addProject extends CommonPage {

@Test
	public void testLogin(){
		addCookies();
		clearAll();
		this.Login("admin@demo.com", "riseDemo");
		addProject();
		pause(10);
	}
	
	public void Login(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();
	}

	public void addProject() {
		driver.findElement(By.linkText("Projects")).click();
		pause(1);
		driver.findElement(By.xpath("//a[@title='Add project']")).click();
		pause(1);
		driver.findElement(By.id("title")).sendKeys("Autotest Selenium TestNG Day 8");
		pause(1);
		driver.findElement(By.id("description")).click();
		driver.findElement(By.className("note-editable")).sendKeys("Nội dung");
		pause(1);
		driver.findElement(By.id("start_date")).sendKeys("06-04-2025");
		driver.findElement(By.id("start_date")).sendKeys(Keys.ENTER);
		pause(1);
		driver.findElement(By.id("deadline")).sendKeys("06-04-2025");
		driver.findElement(By.id("deadline")).sendKeys(Keys.ENTER);
		pause(1);
		driver.findElement(By.id("price")).sendKeys("100000");
		pause(1);
		driver.findElement(By.id("s2id_project_labels")).click();
		driver.findElement(By.id("s2id_autogen8")).sendKeys("Perfect");
		driver.findElement(By.id("s2id_autogen8")).sendKeys(Keys.ENTER);
		pause(1);
		driver.findElement(By.xpath("//button[contains(., 'Save') and contains(@class, 'btn-primary')]")).click();
		pause(1);
	}
	
	public void clearAll() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
	}
	private void addCookies() {		 
		 Cookie cookie = new Cookie.Builder("myCookie", "90697424f47dc5542d1d7b3cbefd9f4e")
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
