package autotest.thuchanh;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Buoi12TH extends CommonPage{
	public Buoi12TH(){
		
	}
	
//	@Test
//	public void handleCheckBox() {
//		boolean isChecked = driver.findElement(By.xpath("//label[@for = 'tree-node-home']")).isSelected();
//		if (!isChecked) {
//			driver.findElement(By.xpath("//label[@for = 'tree-node-home']")).click();
//			pause(2);
//		}
//		isChecked = driver.findElement(By.xpath("//label[@for = 'tree-node-home']")).isSelected();
//		System.out.println(isChecked);
//		driver.findElement(By.xpath("(//button[@title = 'Toggle'])[1]")).click();
//		driver.findElement(By.xpath("(//button[@title = 'Toggle'])[2]")).click();
//		pause(2);
//		String ten;
//		String checkBox = "//span[contains(text(), '"+ten+"')]//ancestor::label";
//		
//		}
//	}
	@Test(priority = 1)
	public void chonVN() {
		pause(2);
		String chonQG = "(//div[contains(@class, 'user-chosen-select-container')]//*[text()='Select a Country'])[2]";
		//xpath cua co //span[text() = 'Select a Country']/parent::a/following-sibling::div//input
		// * là tất cả các elements
		driver.findElement(By.xpath(chonQG)).click();
		pause(2);
		String chonVN = "//div[contains(@class ,'chosen-with-drop')]//descendant::input";
		driver.findElement(By.xpath(chonVN)).clear();
		driver.findElement(By.xpath(chonVN)).sendKeys("Vietnam");
		driver.findElement(By.xpath(chonVN)).sendKeys(Keys.ENTER);
		pause(1);
		String txtVN = "//div[@class='chosen-container chosen-container-single chosen-container-active']";
		String text = driver.findElement(By.xpath(txtVN)).getText();
		Assert.assertEquals(text, "Vietnam");
		
	}
	@Test(priority = 2)
	public void chonKS() {
		pause(1);
		String chonCata = "(//div[contains(@class, 'main-search-input-item user-chosen-select-container')]//*[text()='Select a Category'])[2]";
		driver.findElement(By.xpath(chonCata)).click();
		pause(1);
		String chonKS = "//div[contains(@class ,'chosen-with-drop')]//descendant::input";
		driver.findElement(By.xpath(chonKS)).clear();
		driver.findElement(By.xpath(chonKS)).sendKeys("Hotels");
		driver.findElement(By.xpath(chonKS)).sendKeys(Keys.ENTER);
		pause(1);
		String txtKS = "//div[@class='chosen-container chosen-container-single chosen-container-active']";
		String text = driver.findElement(By.xpath(txtKS)).getText();
		Assert.assertEquals(text, "Hotels");
		pause(1);
	}
	
	
	 @BeforeTest
	    public void startBrowser() {
	        driver = this.startBrower("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html", KeywordConstant.BROWSER);
	 }

	 @AfterTest
	    public void closeBrowser() {
	       this.closeBrowser(driver);

	    }

}
