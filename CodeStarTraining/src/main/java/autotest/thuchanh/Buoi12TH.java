package autotest.thuchanh;
import autocom.common.CommonPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;
import java.util.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.constant.KeywordConstant;
import autotest.pagesHD.HomePage;
import autotest.pagesHD.LoginPage;

import autotest.pagesHD.*;
public class Buoi12TH extends CommonPage{
	private WebDriverWait wait;

	public Buoi12TH() {
		// TODO Auto-generated constructor stub
	}
//	@Test
//	public void handleCheckbox() {
//	    List<WebElement> checkboxList = driver.findElements(By.xpath("//li[contains(@class,'rct-node')]"));
////
////	    boolean isChecked = driver.findElement(By.xpath("//input[@id='tree-node-home']")).isSelected();
////	    if(!isChecked) {
////	    	driver.findElement(By.xpath("//label[@for = 'tree-node-home']")).click();	    	
////	    }
////	    System.out.println(isChecked);
//	    
//    	driver.findElement(By.xpath("//button[@title = 'Toggle']")).click();	    	
//
//    	//span[contains(text(),'Home')]/ancestor::label
//	  for (int i = 1; i <= checkboxList.size(); i++) {
//         String xpath = "(//label[contains(@for,'tree-node')])[" + i + "]";
//        WebElement checkbox = driver.findElement(By.xpath(xpath));
//
//         if (!checkbox.isSelected()) {
//            checkbox.click();
//        }
//    }
//	}
	
//	@Test
//	public void ChonMST() throws InterruptedException {
//		Thread.sleep(3000);
//	    driver.findElement(By.xpath("//div[contains(@class, 'main-search-input-item user-chosen-select-container')]")).click();
//	    WebDriverWait wait = new WebDriverWait(driver,10);
//	    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='chosen-search']/child::input[@type='text']")));
//	    element.sendKeys("vietnam");
//        try {
//        	String XpathGoiY = "//li[text()='Vietnam']";
//        	WebElement suggestionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathGoiY)));
//
// 			suggestionElement.click();
//
// 			System.out.println("Đã chọn Vietnam ");
//        } catch (TimeoutException | NoSuchElementException e) {
//        	System.err.println("Không tìm thấy Vietnam");
//         }
//	}
	
	 
	@Test
	public void TC_SelectCountry() throws InterruptedException {
	    WebDriverWait wait = new WebDriverWait(driver, 15);
	    Thread.sleep(3000);

 	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
	        By.xpath("//div[contains(@class, 'main-search-input-item user-chosen-select-container')]")));
	    dropdown.click();

	    WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    By.xpath("(//div[@class='chosen-search']//input[@type='text'])[2]")));
	    input.sendKeys("Vietnam"+ Keys.ENTER);
//	    input.sendKeys("Vietnam" );

// 	    Thread.sleep(1000);
//
// 	    WebElement vietnamOption = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	    By.xpath("//ul[@class='chosen-results']//li[contains(.,'Vietnam')]")));
//	    vietnamOption.click();

 	    WebElement selectedCountry = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    By.xpath("//div[contains(@class,'main-search-input-item user-chosen-select-container')]//span")));
	    String selectedText = selectedCountry.getText();
	    Assert.assertEquals(selectedText, "Vietnam", "Selected country is not correct.");
	}




	@BeforeTest
	public void startBrower() {
	    driver = this.startBrower("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html", KeywordConstant.BROWSER);
	}

	@AfterTest
	public void closeBrowser() {
		pause(5);
	    this.closeBrowser(driver);
	}

}
