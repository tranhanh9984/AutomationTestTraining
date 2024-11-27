package autotest.testcases;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.common.CommonBase;

public class ThucHanhBuoi8 extends CommonBase {

	public ThucHanhBuoi8() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void init() {
		driver = startBrowser("https://selectorshub.com/xpath-practice-page/");
	}
	
	@AfterClass
	public void close() {
		closeBrowser();
	}
	
	@Test
	public void tc1() {
		System.out.println("Da thuc hanh start browser");
	}
	
	@Test
	public void tc2() {
		driver.findElement(By.name("email")).sendKeys("email@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("password");
		driver.findElement(By.name("company")).sendKeys("company");
		driver.findElement(By.name("mobile number")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@value='Submit']")).click();
		pauseByMiliSecond(1000);
	}
	
	@Test
	public void tc3() {
		driver.findElement(By.id("inp_val")).sendKeys("abcdef");
		driver.findElement(By.linkText("Find out how to automate these controls without XPath"));
		driver.findElement(By.linkText("Today's Special Offer: Get Free Access of Advanced XPath and CSS Selector Paid Course."));
		WebElement we = driver.findElement(By.xpath("//span[.='Inspect this element, you will see comment just below the html of this element in DOM']"));
		if (we != null) System.out.println("Found");
		else System.out.println("Not Found");
		
		List<WebElement> elements = driver.findElements(By.className("nameFld"));
		for (WebElement element : elements) {
			if (element.isEnabled()) {
				element.sendKeys("First name");
				
			} 
			
		}
		
		driver.findElement(By.xpath("//h3[text()='Useful Links for learning']"));
		driver.findElement(By.xpath("//button[@class='dropbtn' and text()='Checkout here']")).click();
		
		String tagDropdownContent = driver.findElement(By.className("dropdown-content")).getTagName();
		System.out.println("dropdown-content: " + tagDropdownContent);
		
		String textForCars = driver.findElement(By.xpath("//label[@for='cars']")).getText();
		System.out.println("Text for cars: " + textForCars);
		
		driver.findElement(By.id("cars")).click();
		driver.findElement(By.id("datepicker"));
		driver.findElement(By.xpath("//input[@type='date']")).click();
		driver.findElement(By.xpath("//a[@title='Click to donate']"));
		driver.findElement(By.xpath("//a[@traget='_blank']"));
		driver.findElement(By.id("canpro"));
		
		pauseByMiliSecond(2000);
	}
	
	@Test
	public void tcWithTable() {
		WebElement weTable = driver.findElement(By.id("resultTable"));
		List<WebElement> tableHeaders = weTable.findElements(By.xpath("//table[@id='resultTable']/thead/tr/th"));
		System.out.println("Table");
		String headerValues = tableHeaders.stream().map(x -> x.getText()).collect(Collectors.joining(" | "));
		System.out.println(headerValues);
		//System.out.println("Content table");
		List<WebElement> tableContents = weTable.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
		for (WebElement row : tableContents) {
			List<WebElement> td = row.findElements(By.tagName("td"));
		 	String values = td.stream().map(x -> x.getText()).collect(Collectors.joining(" | "));
			System.out.println(values);
		}
	}

}
