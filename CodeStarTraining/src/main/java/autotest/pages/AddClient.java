package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import autocom.common.CommonPage;

public class AddClient extends CommonPage{

	public AddClient(WebDriver driver) {
		// TODO Auto-generated constructor stub		
		this.driver = driver;
	}

	String iframeX = "//iframe[@title = 'reCAPTCHA']";
	String txtEmail = "//input[@id = 'email']";
	String txtPass = "//input[@id = 'password']";
	String btnSubmit = "//button[@type = 'submit']";
	String cbCapcha = "//span[@role = 'checkbox']";
	
	String txtMenu = "//span[text() = '%s']/ancestor::a";
	
	String btnAddClient = "";
	
	public void loginP(String email, String password) {
		driver.findElement(By.xpath(txtEmail)).sendKeys(email);
		driver.findElement(By.xpath(txtPass)).sendKeys(password);
		driver.switchTo().frame(driver.findElement(By.xpath(iframeX)));
		driver.findElement(By.xpath(cbCapcha)).click();
		driver.switchTo().defaultContent();
		pause(3000);
		driver.findElement(By.xpath(btnSubmit)).click();
	}
	
	public void clickMenu(String textMenu) {
		driver.findElement(By.xpath(String.format(txtMenu,textMenu ))).click();;
	}
	
	public void addClient() {
		driver.findElement(By.linkText("Add client")).click();
		driver.findElement(By.name("account_type")).click();
		driver.findElement(By.name("company_name")).sendKeys("Client US");
		
	}
	
	
}
