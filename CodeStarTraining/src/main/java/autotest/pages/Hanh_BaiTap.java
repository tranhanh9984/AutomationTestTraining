package autotest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class Hanh_BaiTap extends CommonPage {

	WebDriver driver;
	By byName = By.id("resultTable");
	By byCbbName = By.name("cars"); // select[@name = 'cars']

	@BeforeTest
	public void startPage() {
		driver = this.startBrower("https://selectorshub.com/xpath-practice-page/", "chrome");
	}

	@AfterTest
	public void closePage() throws InterruptedException {
//			Thread.sleep(2);
		this.closeBrowser(driver);
	}

	//strSelected = "Hóa đơn/Tạo hoá đơn"
	public void clickDropList(String strSelected) {
		
		String[] menus = strSelected.split("\\");		
		
		for(int i = 0; i < menus.length; i++) {
			if(!driver.findElement(byCbbName).isDisplayed()) {
				pause(2000);
			}
			Select ccbName = new Select(driver.findElement(byCbbName));
			
			ccbName.selectByVisibleText(strSelected);	
						
			System.out.println(ccbName.getFirstSelectedOption().getText());
			
			Assert.assertEquals(strSelected, ccbName.getFirstSelectedOption().getText());	
		}
					
	}

	public void testXpath() throws InterruptedException {
		WebElement tableResult = driver.findElement(byName);
		List<WebElement> rows = tableResult.findElements(By.tagName("tr"));

		for (int rnum = 0; rnum < rows.size(); rnum++) {
			List<WebElement> columns = rows.get(rnum).findElements(By.tagName("th"));
			System.out.println("Number of columns:" + columns.size());

			for (int cnum = 0; cnum < columns.size(); cnum++) {
				String text = columns.get(cnum).getText();
				if (text.contains("Jo")) {
					System.out.println("OK------------------");
				}
			}
		}

	}

}
