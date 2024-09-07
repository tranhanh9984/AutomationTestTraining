package autotest.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class Practice extends CommonPage {
	
	public Practice() {
		// TODO Auto-generated constructor stub
	}
	@BeforeTest
	public void StartPage() {
		this.startBrower("https://selectorshub.com/xpath-practice-page/", "chrome");
		pause(50);
	}
	@Test
	public void TC1() {
		//pause(1000);
		//Actions builder = new Actions(driver);
		//builder.click(driver.findElement(By.xpath("//label[contains(text(),'Can you enter name here through automation')]/*[local-name()='svg']/*[local-name()='path'][1]"))).build().perform();
		//driver.findElement(By.xpath("//input[@placeholder='First Enter name']")).sendKeys("Khoa Trần");
		//Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='First Enter name']")).getText(), "Khoa Trần");
		
		//Chọn Audi trong Choose a car
		driver.findElement(By.id("cars")).click();
		driver.findElement(By.xpath("//select[@id='cars']/option[contains(text(),'Audi')]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//select[@id='cars']/option[contains(text(),'Audi')]")).getText(), "Audi");
		
		//Tick vào Checkbox
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//table[@id='resultTable']//following::input[@id='ohrmList_chkSelectRecord_25']"))).perform();
		driver.findElement(By.xpath("//table[@id='resultTable']//following::input[@id='ohrmList_chkSelectRecord_25']")).click();
		
		//Chọn Join Training trong Checkout Here button
		driver.findElement(By.xpath("//button[contains(text(),'Checkout here')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Join Training')]")).click();
		pause(1000);
		Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
		assertEquals("Bootcamp - SelectorsHub",driver.getTitle());
	}
	@AfterTest
	public void ClosePage() {
		this.closeBrowser(driver);
	}
}
