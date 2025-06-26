package autotest.thuchanh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Buoi12_BTVN extends CommonPage {
	
	@Test
	public void handleSearch() {
//		driver.findElement(By.xpath("//input[contains(.,'What are you looking')]")).click();
		pause(2);
		handleSelect("Select a Country", "Vietnam");
		pause(1);
		handleSelect("Select a Category", "Travel");
	}
		
	public void handleSelect(String label, String value) {
		WebElement selectDropdown = xpathConvert(label);
		
		String xpathOption = String.format(
			"//a[@class='chosen-single' and contains(.,'%s')]/following-sibling::div//ul//li[contains(.,'%s')]",
			label,
			value
		);
		
		selectDropdown.click();
		
		WebElement selectOption = driver.findElement(By.xpath(xpathOption));
		
		pause(1);
		boolean selected = selectOption.getAttribute("class").contains("result-selected");
		if(!selected) {			
			selectOption.click();
		}
		
		WebElement selectedText = xpathConvert(value);
		Assert.assertEquals(selectedText.getText().trim(), value.trim(), "Don't selected");
	}
	
 
	public WebElement xpathConvert(String label) {
		WebElement xpathOption = driver.findElement(By.xpath(String.format("//a[@class='chosen-single' and contains(.,'%s')]", label)));
		return xpathOption;
	}
	
//	public String xpath(String label) {
//		String xpath = String.format("//a[@class='chosen-single' and contains(.,'%s')]", label);
//		return xpath;
//	}
//	
	public void handleSeachSelect(String label, String value) {
		String xpath = String.format("//a[@class='chosen-single' and contains(.,'%s')]", label);
		WebElement selectDropdown = driver.findElement(By.xpath(xpath));
		
		String xpathOption = String.format(
			"//a[@class='chosen-single' and contains(.,'%s')]/following-sibling::div//ul//li[contains(.,'%s')]",
			label,
			value
		);
		
		selectDropdown.click();
		
		WebElement selectOption = driver.findElement(By.xpath(xpathOption));
		
		pause(1);
		boolean selected = selectOption.getAttribute("class").contains("result-selected");
		if(!selected) {			
			selectOption.click();
		}
	}
	
	public void handleClickMenu() {
		
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html#", KeywordConstant.BROWSER);
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
	}
}
