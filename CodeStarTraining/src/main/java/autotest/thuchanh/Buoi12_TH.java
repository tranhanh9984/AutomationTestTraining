package autotest.thuchanh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Buoi12_TH extends CommonPage {

	By resultText = By.id("result");
	By text = By.xpath("//div[contains(text(),'Do you like the site')]/parent::div/p");
	
//	@Test
	public void clickCheckbox() {
		driver.findElement(By.xpath("//button[@title='Expand all']")).click();
		pause(1);
		handleCheckbox("//label[@for = 'tree-node-notes']");
		handleCheckbox("//label[@for = 'tree-node-react']");
		handleCheckbox("//label[@for = 'tree-node-private']");
	}
	
	public void handleCheckbox(String xpath) {
//		boolean isChecked = driver.findElement(By.xpath("//label[@for = 'tree-node-home']/input")).isSelected();
//		if(!isChecked) {
//			driver.findElement(By.xpath("//label[@for = 'tree-node-home']")).click();
//		}
//		isChecked = driver.findElement(By.xpath("//label[@for = 'tree-node-home']/input")).isSelected();
//		System.out.println(isChecked);
//		
//		driver.findElement(By.xpath("//button[@title='Toggle']")).click();
//		
		pause(2);
		
		boolean isDocumentChecked = driver.findElement(By.xpath(xpath + "/input")).isSelected();
		if(!isDocumentChecked) {
			driver.findElement(By.xpath(xpath)).click();
		}
		
		isDocumentChecked = driver.findElement(By.xpath(xpath + "/input")).isSelected();
		if(isDocumentChecked) {
			System.out.println(driver.findElement(resultText).getText());
		}
		
	}
	
	@Test
	public void clickRadio() {
		handleRadio("//input[@id='yesRadio']");
		handleRadio("//input[@id='impressiveRadio']");
		handleRadio("//input[@id='noRadio']");
	}
	
	public void handleRadio(String xpath) {
		WebElement radio = driver.findElement(By.xpath(xpath));
		WebElement radioLabel = driver.findElement(By.xpath(xpath + "/following-sibling::label"));
		boolean isEnabled = radio.isEnabled();
		System.out.println(isEnabled);
		
		if(isEnabled) {
			radioLabel.click();
		}
		
		boolean isChecked = radio.isSelected();
		if(isChecked && isEnabled) {
			System.out.println(driver.findElement(text).getText());
		}
	}
	
	@BeforeTest
	public void startBrowser() {
//		driver = this.startBrower("https://demoqa.com/checkbox", KeywordConstant.BROWSER);
		driver = this.startBrower("https://demoqa.com/radio-button", KeywordConstant.BROWSER);
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
		
	}
}
