package autotest.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class LoginPage extends CommonPage {
	WebDriver driver;
	//textInut - txt, lable: lbl, combobox - cbb, button - btnTaoMoi, tbl, td, tr, ...
	@FindBy(id="email") @CacheLookup WebElement txtEmail;
	@FindBy(xpath = "//input[@id = 'password']") WebElement txtPassword;
	@FindBy(xpath = "//button[@type = 'submit']") WebElement btnDangNhap;
//	String txtUserName = "//input[@id = 'email']";
//	String txtPassword = "//input[@id = 'password']";
//	String btnDangNhap = "//button[@type = 'submit']";
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login_at(String name, String pass) {		
		txtEmail.sendKeys(name);
		txtPassword.sendKeys(pass);
		btnDangNhap.click();
		pause(5000);
	}
	
	
	
//	public void login() {
////		driver.findElement(By.xpath(txtUserName)).clear();
////		driver.findElement(By.xpath(txtPassword)).clear();
////		
//		driver.findElement(By.xpath(txtUserName)).sendKeys(KeywordConstant.EMAIL);
//		driver.findElement(By.xpath(txtPassword)).sendKeys(KeywordConstant.PASSWORD);
////		
////		driver.findElement(By.xpath(txtMST)).clear();
////		driver.findElement(By.xpath(txtMST)).sendKeys(KeywordConstant.MST);
//		driver.findElement(By.xpath(btnDangNhap)).click();
//	}
	
	
//	
//	public void login(String email, String password, String mst) {
//		pause(5000);
//		driver.findElement(By.xpath(txtUserName)).clear();
//		pause(5000);
//		driver.findElement(By.xpath(txtPassword)).clear();		
//		driver.findElement(By.xpath(txtUserName)).sendKeys(email);
//		driver.findElement(By.xpath(txtPassword)).sendKeys(password);
//		pause(5000);
//		driver.findElement(By.xpath(txtMST)).clear();
//		driver.findElement(By.xpath(txtMST)).sendKeys(mst);
//		driver.findElement(By.xpath(btnDangNhap)).click();
//	}	
//	
//	public void signIn(String email, String password, String mst) {
//		
//	}
//	
//	public void quenMatKhau(WebDriver driver, String email, String password, String mst) {
//		
//	}
	//@Test
	public void tc_01() {
		System.out.println("thuc hanh start browser");
		driver.findElement(By.id("email")).sendKeys("0312303803-999");
		driver.findElement(By.id("password")).sendKeys("0312303803-999");
		
		driver.findElement(By.xpath("//button")).click();
		
		pause(30000);
		
		///html/body/app-root/app-entities/div/div[2]/div/app-invoice-hdbh-crup/form/div[1]/p-card/div/div/div/div[4]/div/p-table/div/div/table/tbody/tr/td[5]
	}
	
//	@Test
	public void test1() {
//		Select select1 = new Select(driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')]/select[@class ='user-chosen-select'])[1]")));
//		System.out.println(select1.getAllSelectedOptions().size());
//		select1.
//		select1.selectByValue("DZ");
//		pause(10000);
//		boolean isEnable = driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[1]")).isEnabled();
//		System.out.println(isEnable);
		
//		WebElement element;
//		element.submit();
//		
//	
		String handleTr1 = driver.getWindowHandle();
		((JavascriptExecutor) driver).executeScript("window.open()");
		((JavascriptExecutor) driver).executeScript("window.open()");		
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.get("https://drive.google.com/file/d/1d1q8bOXsWYauFQubWoURdhttSpfcJjXk/view");
		driver.switchTo().window(tabs.get(2));
		driver.get("https://drive.google.com/file/d/1Pkfk3qqgOhMbpYpo8L_mHtV0JrxFECZs/view");
		driver.switchTo().window(tabs.get(3));
		driver.get("https://drive.google.com/file/d/1PY_1IJNZvU-P39pmQfxXcjpzIHrANMev/view");
		
		
		driver.close();
		System.out.println(tabs);
		driver.switchTo().window(handleTr1);
		
//		String wd = driver.getWindowHandles();
		System.out.println(driver.getWindowHandles());
//		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[2]/div")).findElement(By.xpath(btnDangNhap));
		
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[2]/div")).click();
		
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[2]/div//input")).sendKeys("Vietnam");
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[2]/div//input")).sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[3]/div")).click();
		
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[3]/div//input")).sendKeys("Event");
		driver.findElement(By.xpath("(//div[contains(@class, 'main-search-input-item')])[3]/div//input")).sendKeys(Keys.ENTER);
		
		
		pause(10000);
		
		
	}
	
//	@BeforeClass
//	public void startBrowser() {
//		//this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
//		System.out.println("TC start");
//		this.startBrower("https://uat-invoice.kaike.vn/login", "chrome");
//		dr = driver;
//	}
//	
//	@AfterClass
//	public void close() {
//		this.closeBrowser(driver);
//		System.out.println("test finiesh");
//	}
	
//	@Test
	public void tc_1() {
		System.out.println("test annotation");
	}
	
//	@Test
	public void tc_2() {
		System.out.println("test annotation");
	}
}
