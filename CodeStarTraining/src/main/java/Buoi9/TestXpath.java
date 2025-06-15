package Buoi9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class TestXpath extends CommonPage {
	
	@Test
    public void testAddProject() {
		List<WebElement> inputElements = driver.findElements(By.xpath("//input[@class='selectors-input jsSelector']"));

	    for (WebElement input : inputElements) {
	            input.sendKeys("Ha Anh");
	    }
		driver.findElement(By.xpath("//input[@name = 'company']")).sendKeys("Ha Anh");
		driver.findElement(By.xpath("//div[@class = 'element-companyId']/parent::div[not(@style)]//input[@name = 'mobile number']")).sendKeys("012345678");
		driver.findElement(By.xpath("//input[@id='inp_val']")).sendKeys("Ha Anh");
		driver.findElement(By.xpath("//button[@value='Submit']")).click();
		WebElement dropdownElement = driver.findElement(By.xpath("//select[@name='cars']"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("Opel");
		
//		driver.findElement(By.xpath("//input[@type='date' and @name='the_date']")).sendKeys("02202004");
		
		
		driver.findElement(By.xpath("//input[@type='date' and @name='the_date']")).click();

        WebElement yearElement = driver.findElement(By.xpath("//select[contains(@class, 'ui-datepicker-year')]"));
        Select yearSelect = new Select(yearElement);
        yearSelect.selectByVisibleText("2025"); 

        WebElement monthElement = driver.findElement(By.xpath("//select[contains(@class, 'ui-datepicker-month')]"));
        Select monthSelect = new Select(monthElement);
        monthSelect.selectByVisibleText("December"); 

        WebElement dayElement = driver.findElement(By.xpath("//table[contains(@class, 'ui-datepicker-calendar')]//td[contains(text(), '12')]"));
        dayElement.click();
        
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		
		
//		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody[contains(@class, 'row-striping')]/tr"));

        
        
        
		pause(5);
		
		
	
    }
	
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlTestXpath, "chrome");
	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);

	}

}
