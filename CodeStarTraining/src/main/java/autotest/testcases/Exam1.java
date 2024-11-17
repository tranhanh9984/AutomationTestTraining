package autotest.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class Exam1 extends CommonPage{

	public Exam1()  {
		// TODO Auto-generated constructor stub		
		
	}

	@Test
	public void testSelect() {
		String slCar = "//select[@id='cars']";
		
		Select selectCar = new Select(driver.findElement(By.xpath(slCar)));
		selectCar.selectByValue("opel");
		pause(5000);
		System.out.println(selectCar.isMultiple());
		System.out.println(selectCar.getFirstSelectedOption().getText());
		selectCar.selectByVisibleText("Volvo");
		pause(5000);
	}
	
	
	@BeforeClass
	public void startPage() {
		driver = this.startBrower("https://selectorshub.com/xpath-practice-page", "chrome");

	}

	@AfterClass
	public void closePage() throws InterruptedException {
//			Thread.sleep(2);
		this.closeBrowser(driver);
	}
}
