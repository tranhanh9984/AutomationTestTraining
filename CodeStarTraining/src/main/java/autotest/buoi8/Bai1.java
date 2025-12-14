package autotest.buoi8;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Bai1 extends CommonPage {

	private HashMap<String, String> inforNewTask = new HashMap<>();
	
		
	@Test
	public void testLogin() {
		
		
//		clearAll();
		this.Login("admin@demo.com", "riseDemo");
		
		
		addCookies();
//		selectMenu("Projects");
		pause(1);
		driver.navigate().to("https://rise.fairsketch.com/index.php/clients");
		
//		driver.findElement(By.xpath("//a[contains(@data-bs-target, 'clients_list')]")).click();
//		
//		pause(2);
//		scrollToElement("//div[@id = 'client-table_info']");
//		pause(3);
//		Select select = new Select (driver.findElement(By.name("client-table_length")));
		
//		Select select = new Select (driver.findElement(By.xpath("//select[contains(@name, 'client-table_length')]")));
	//	select.selectByValue("50");
//		select.getOptions();
//		select.selectByIndex(3);
	
		handleSelect("50");
		pause(3);
		handleSelect("100");
		pause(3);
		handleSelect("100");
		pause(3);
	//	addNewProject();
		pause(10);
	}
	
	private void initDataTest() {
		inforNewTask.put("title", "Title Add New Task");
		inforNewTask.put("description", "Mo ta ve task");
		inforNewTask.put("relatedTo", "....");
		
		inforNewTask.get("description");// => "Mo ta ve task"
		
	}
	
	private void addNewProject() {
		driver.findElement(By.linkText("Add project")).click();
		
		driver.findElement(By.name("title")).sendKeys("Automation Testing");
		driver.findElement(By.id("description")).click();
		driver.findElement(By.className("note-editable")).sendKeys("Automation Testing is one of multi projects outsource of UK customer.....");
		driver.findElement(By.name("start_date")).sendKeys("15-02-2024");
		driver.findElement(By.name("start_date")).sendKeys(Keys.ENTER);
		pause(1);
		driver.findElement(By.xpath("//input[@name = 'deadline']")).sendKeys("27-7-2025");
		driver.findElement(By.xpath("//input[@name = 'deadline']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("price")).sendKeys("720000");
		
		driver.findElement(By.xpath("//label[text() = 'Labels']/following-sibling::input")).click();
		driver.findElement(By.xpath("//label[text() = 'Labels']/following-sibling::input")).sendKeys("Upcoming");
		driver.findElement(By.xpath("//label[text() = 'Labels']/following-sibling::input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();	
		
	}
	
	private void selectMenu(String menu) {
		driver.findElement(By.xpath("//span[text()= '%s']/parent::a".formatted(menu))).click();
	}
	
	private void Login(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();
	}
	
	private void clearAll() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();		
	}
	
	private void addCookies() {		 
		 Cookie cookie = new Cookie.Builder("ci_session", "824e6fddf801fe248214a50ae226e406")
	                .isHttpOnly(true)
	                .isSecure(false)
	                .build();
		 driver.manage().addCookie(cookie);
	}
	
	public void handleSelect(String label) {
		driver.findElement(By.xpath("//div[@id = 'select2-drop-mask']")).click();
		pause(2);
		jsClick("//select/option[contains(text(), '"+label+"')]");
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://rise.fairsketch.com/index.php/clients", "edge");		
		this.initDataTest();
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}
	

}
