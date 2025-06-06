package autotest.buoi8;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Bai1 extends CommonPage {

	public Bai1() {
		
	}
	
//	@Test
//	public void testLogin() {
//		addCookies();
//		clearAll();
//		login("admin@demo.com", "riseDemo");
//		pause(10);
//	}
	
//	@Test
//	public void testAddProject() {
//		addCookies();
//		clearAll();
//		login("admin@demo.com", "riseDemo");
//		pause(2);
//		clickProjectMenu();
//		clickAddProject();
//		pause(2);
//		addProject("Learning automation test - Codestar", "Nội dung mô tả cần nhập", "29-07-2025", "30-11-2025", "34000", "On track");
//		clickSaveProject();
//		verifyCreatedProject("Learning automation test - Codestar");
//		pause(10);
//	}
	
//	@Test
//	public void testEditProject() {
//		addCookies();
//		clearAll();
//		login("admin@demo.com", "riseDemo");
//		pause(2);
//		clickProjectMenu();
//		clickAddProject();
//		pause(2);
//		addProject("Learning automation test - Codestar", "Nội dung mô tả cần nhập", "29-07-2025", "30-11-2025", "34000", "On track");
//		clickSaveProject();
//		pause(2);
//		clickEditButton("Learning automation test - Codestar");
//		
//		changeStatus("Completed");
//		clickSaveProject();
//	}
	
	@Test
	public void testDeleteProject() {
		addCookies();
		clearAll();
		login("admin@demo.com", "riseDemo");
		pause(2);
		clickProjectMenu();
		clickAddProject();
		pause(2);
		addProject("Learning automation test - Codestar", "Nội dung mô tả cần nhập", "29-07-2025", "30-11-2025", "34000", "On track");
		clickSaveProject();
		
		deleteProject("Learning automation test - Codestar");
		pause(2);
		verifyMessage("The record has been deleted.");
	}
	
	public void login(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	private void clickProjectMenu() {
		driver.findElement(By.linkText("Projects")).click();
		
	}
	
	private void clickAddProject() {
		driver.findElement(By.cssSelector("[title='Add project']")).click();
	}
	
	private void addProject(String title, String description, String startDate, String deadline, String price, String label) {
		driver.findElement(By.id("title")).sendKeys(title);
		driver.findElement(By.id("description")).click();
		driver.findElement(By.className("note-editable")).sendKeys(description);
		driver.findElement(By.id("start_date")).sendKeys(startDate);
		driver.findElement(By.id("start_date")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("deadline")).sendKeys(deadline);
		driver.findElement(By.id("deadline")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("price")).sendKeys(price);
		driver.findElement(By.xpath("//label[text()='Labels']/following::input[1]")).sendKeys(label);
		driver.findElement(By.xpath("//label[text()='Labels']/following::input[1]")).sendKeys(Keys.ENTER);
	}
	
	private void clickSaveProject() {
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	private void verifyCreatedProject(String title) {
		Assert.assertTrue(driver.findElement(By.id("project-table")).getText().contains(title));
	}
	
	public void clearAll() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
	}
	
	private void clickEditButton(String title) {
		WebElement titleLink = driver.findElement(By.linkText(title));
		WebElement rowProject = titleLink.findElement(By.xpath("./ancestor::tr"));
		
		rowProject.findElement(By.cssSelector("[title='Edit project'")).click();
		
	}
	
	private void deleteProject(String title) {
		WebElement titleLink = driver.findElement(By.linkText(title));
		WebElement rowProject = titleLink.findElement(By.xpath("./ancestor::tr"));
		
		rowProject.findElement(By.cssSelector("[title='Delete project'")).click();
		
		pause(2);
		driver.findElement(By.id("confirmDeleteButton")).click();
	}
	
	private void verifyMessage(String message) {
		WebElement element = driver.findElement(By.className("app-alert"));
		Assert.assertTrue(element.isDisplayed(), "Element should be visible on the page");
		Assert.assertTrue(driver.findElement(By.className("app-alert-message")).getText().contentEquals(message),  "Message text does not match");
	}
	
	private void changeStatus(String status) {
		driver.findElement(By.xpath("//label[text()='Status']/following::div[1]//div[contains(@class, 'select2-container')]")).click();
		String xpath = String.format("//ul[contains(@class, 'select2-results')]//div[contains(@class, 'select2-result-label') and text()='%s']", status);

		driver.findElement(By.xpath(xpath)).click();
		pause(2);
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
		
	}
	
	private void addCookies() {		 
		 Cookie cookie = new Cookie.Builder("myCookie", "cb86cd7a6a91c4e281fdeb3aa669f41f")
	                .isHttpOnly(true)
	                .isSecure(false)
	                .build();
		 driver.manage().addCookie(cookie);
		 driver.navigate().refresh();
	}
}
