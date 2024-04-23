package autocom.common;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class CommonPage {
	public WebDriver driver;

	protected int DEFAULT_TIMEOUT = 20000;
	protected int WAIT_INTERVAL = 100;
	public int loopCount = 0;
	public final int ACTION_REPEAT = 5;
	public Actions action;

	public WebDriver startBrower(String url, String browser) {
		if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if ("safari".equals(browser)) {
			driver = new SafariDriver();
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
		return driver;
	}

	public void closeBrowser(WebDriver dr) {
		dr.close();
	}

	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public WebElement getElement(Object locator, WebDriver dr) {
		By by = locator instanceof By ? (By) locator : By.xpath(locator.toString());
		WebElement elem = null;
		try {
			elem = dr.findElement(by);
		} catch (NoSuchElementException e) {

			pause(WAIT_INTERVAL);
			getElement(locator, dr);
		} catch (StaleElementReferenceException e) {

			pause(WAIT_INTERVAL);
			getElement(locator, dr);
		} catch (WebDriverException e) {

			pause(WAIT_INTERVAL);
			getElement(locator, dr);
		}

		return elem;
	}

	public List<WebElement> getListElement(Object locator) {
		By by = locator instanceof By ? (By) locator : By.xpath(locator.toString());
		List<WebElement> elementOptions;
		try {
			elementOptions = driver.findElements(by);
			return elementOptions;
		} catch (NoSuchElementException ex) {
			pause(WAIT_INTERVAL);
			getListElement(locator);
		} catch (StaleElementReferenceException ex) {
			pause(WAIT_INTERVAL);
			getListElement(locator);
		} finally {
			loopCount = 0;
		}
		return null;

	}

	public WebElement getDisplayedElement(Object locator, WebDriver dr) {
		By by = locator instanceof By ? (By) locator : By.xpath(locator.toString());
		WebElement e = null;
		try {
			if (by != null)
				e = dr.findElement(by);
			if (e != null) {
				if (isDisplay(by, dr))
					return e;
			}
		} catch (NoSuchElementException ex) {

			pause(WAIT_INTERVAL);
//			getDisplayedElement(locator);
		} catch (StaleElementReferenceException ex) {
			pause(WAIT_INTERVAL);
//			getDisplayedElement(locator);
		} catch (WebDriverException ex) {
			pause(WAIT_INTERVAL);
//			getDisplayedElement(locator);
		} finally {
			loopCount = 0;
		}
		return null;
	}

	public boolean isDisplay(Object locator, WebDriver dr) {
		boolean bool = false;
		WebElement e = getElement(locator, dr);
		try {
			if (e != null)
				bool = e.isDisplayed();
		} catch (StaleElementReferenceException ex) {
			pause(WAIT_INTERVAL);
			isDisplay(locator, dr);
		} finally {
			loopCount = 0;
		}
		return bool;
	}

	public void clickMenu(String strSelected) {
		String txtMenu = "//span[text() = '%s']/ancestor::a";
		String[] menus = strSelected.split("/");
		pause(1000);

		for (int i = 0; i < menus.length; i++) {
			if (!driver.findElement(By.xpath(String.format(txtMenu, menus[i]))).isDisplayed()) {
				pause(1000);
			}
			driver.findElement(By.xpath(String.format(txtMenu, menus[i]))).click();
		}

	}
}
