package autocom.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonBase {
	protected WebDriver driver;
	

	public CommonBase() {
		// TODO Auto-generated constructor stub
	}
	
	public void setText(String content, String xpath) {
		driver.findElement(By.xpath(xpath)).sendKeys(content);
//		assert content == this.getAtrribute(xpath, "value");
	}
	
	public void clearData(String xpath) {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].value = '';", driver.findElement(By.xpath(xpath)));
	}
	
	public void scrollScreen (String xpath) {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpath)));
	}
	
	
	public void setButton( String xpath) {
		driver.findElement(By.xpath(xpath)).click();
//		assert content == this.getAtrribute(xpath, "value");
	}
	public String getText( String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
		
	}
	
	//ham dung de cho 1 element xuat hien
	public WebElement awaitElementVisible(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return element;
	}
	
	public WebDriver startBrower(String url, String browser) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
		return driver;
		
	}
	
	public void closeBrowser() {
		driver.close();
	}

	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
