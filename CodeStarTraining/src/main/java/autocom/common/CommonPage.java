package autocom.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import autocom.constant.KeywordConstant;
import autotest.pages.MenuBar;

public class CommonPage {
	
	public WebDriver driver;

	String xpathMessage = "//div[contains(@class, 'p-toast-detail') and contains(text(), '%s')]";
	
	public CommonPage() {
		// TODO Auto-generated constructor stub
	}
	
	public WebDriver startBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
		return driver;
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void pause(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clearTextByWebElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].value = '';", element);
	}

	public void clearText(String xpath) {
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].value = '';", driver.findElement(By.xpath(xpath)));
	}
	
	public void setValue(String xpath, String value) {
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	
	public String getValue(String xpath) {
		return driver.findElement(By.xpath(xpath)).getAttribute("value");
	}
	
	public boolean isShowAlert(String message) {
		return driver.findElement(By.xpath(String.format(xpathMessage, message))).isDisplayed();
	}
	
	public void scrollBarToWebElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollBarToElement(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void goToMenu(String menuName, String subMenuName) {
		MenuBar menuBar = new MenuBar(driver);
		menuBar.getMenuItemByText(menuName).click();
		menuBar.getSubMenuItemByText(subMenuName).click();
	}

}
