package autotest.thuchanh;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Buoi12TH extends CommonPage {

	public Buoi12TH() {
		// TODO Auto-generated constructor stub
	}

//	
//	public void checkFunction() {
//		WebElement a = driver.findElement(By.xpath("//input[@name = 'email']"));
//		a.clear();
//		a.click();
//		System.out.println(a.equals(driver.findElement(By.xpath("//input[@name = 'email']"))));
//		//...
//	}
//	
//	
//	public void checkDrver() {
//		WebDriver driver  = new ChromeDriver();
//	}

	@Test
	public void clickCheckbox() {
		driver.findElement(By.xpath("//button[@title='Expand all']")).click();
		pause(1);
		handleCheckbox("//label[@for = 'tree-node-notes']");
		pause(5);
		handleCheckbox("//label[@for = 'tree-node-angular']");
		pause(5);
		handleCheckbox("//label[@for = 'tree-node-commands']");
		pause(5);
	}

	@Test
	public void handleSelect() {
		Select select = new Select (driver.findElement(By.name("client-table_length")));
		select.selectByVisibleText("50");
	}

	public void handleCheckbox(String xpath) {

		boolean isChecked = driver.findElement(By.xpath(xpath + "/input")).isSelected();
		System.out.println(isChecked);
		if (!isChecked) {
			driver.findElement(By.xpath(xpath)).click();
		}
		isChecked = driver.findElement(By.xpath(xpath + "/input")).isSelected();
		System.out.println(isChecked);

		if (isChecked) {
			System.out.println(driver.findElement(By.xpath("//div[@id = 'result']")).getText());
		}

	}

	
	private void handleRadio() {
		
		
		String xpath = "//input[@id = 'yesRadio']";
		boolean isEnabled = driver.findElement(By.xpath(xpath)).isEnabled();
		boolean isSelected = driver.findElement(By.xpath(xpath)).isSelected();
		System.out.println(isSelected);
//		if(isEnabled & !isSelected) {
		driver.findElement(By.xpath(xpath + "/following-sibling::label")).click();
//		}
		pause(5);
		isSelected = driver.findElement(By.xpath(xpath)).isSelected();
		System.out.println(isEnabled);
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://demoqa.com/checkbox", KeywordConstant.BROWSER);

	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);

	}

}
