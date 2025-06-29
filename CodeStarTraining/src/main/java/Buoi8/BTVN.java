package Buoi8;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class BTVN extends CommonPage {
	
	@Test
	public void deleteProject() {
		testAddProject();

		searchProject("Ha Anh");
		
		editProject();
		
		driver.findElement(By.xpath("//*[@id=\"project-table\"]/tbody/tr/td[9]/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"confirmDeleteButton\"]")).click();

		searchProject("Ha Anh");
	
	}
	
	
	public void editProject() {
		driver.findElement(By.xpath("//*[@id=\"project-table\"]/tbody/tr/td[9]/a[1]")).click();
		driver.findElement(By.id("price")).clear();
		driver.findElement(By.id("price")).sendKeys("50000");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
	}
	
	
	public void searchProject(String str) {
//		testAddProject();
//		clickMenu("Projects");
		driver.findElement(By.xpath("//*[@id=\"project-table_filter\"]/label/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"project-table_filter\"]/label/input")).sendKeys(str, Keys.ENTER);
	
		
	}
	

    public void testAddProject() {
		clickMenu("Projects");
		driver.findElement(By.linkText("Add project")).click();
		
		driver.findElement(By.id("title")).sendKeys("Ha Anh");
		driver.findElement(By.id("description")).click();
		driver.findElement(By.className("note-editable")).sendKeys("Ha Anh");
		
		driver.findElement(By.id("start_date")).sendKeys("20-02-2004");
		driver.findElement(By.id("deadline")).sendKeys("20-02-2020");
		driver.findElement(By.id("price")).sendKeys("20000");

		driver.findElement(By.xpath("//label[text() = 'Labels']/following-sibling::input")).click();
		driver.findElement(By.xpath("//label[text() = 'Labels']/following-sibling::input")).sendKeys("Perfect");
		driver.findElement(By.xpath("//label[text() = 'Labels']/following-sibling::input")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	

	
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
