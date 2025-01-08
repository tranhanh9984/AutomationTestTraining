package autocom.common;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import autotest.pages.HaDV_LoginPage;

import java.time.Duration;

public class HaDV_CommonBase {
	public WebDriver driver;
	public static final boolean SCROLL = true;
	public static final boolean NO_SCROLL = false;
	private static final String LOGIN_EMAIL = "0312303803-999";
	private static final String LOGIN_PASSWORD = "0312303803-999";
	private static final String XPATH_EMAIL = "//input[@id='email']";
	private static final String XPATH_PASSWORD = "//input[@id='password']";
	private static final String XPATH_BTN_LOGIN_SUBMIT = "//button[@type='submit']";
	public HaDV_LoginPage loginPage;

	public HaDV_CommonBase() {
	}

	public HaDV_CommonBase(WebDriver driver) {
		if (this.driver == null) {
			this.driver = driver;
		}
	}

	public WebDriver startBrower(String url, String browser) {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.navigate().to(url);
		switch (browser.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Unsupported browser: " + browser);
			break;
		}
		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.navigate().to(url);
		}
		return driver;
	}

	public void commonLoginSuccess() {
		inputText(LOGIN_EMAIL, XPATH_EMAIL);
		inputText(LOGIN_PASSWORD, XPATH_PASSWORD);
		driver.findElement(By.xpath(XPATH_BTN_LOGIN_SUBMIT)).click();
		pause(1000);
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://uat-invoice.kaike.vn/dashboard",
				"User should be redirected to the dashboard after successful login.");
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

	public void checkURLMatched(String expectedURL, long timeoutInSeconds, String assertMessage) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until((ExpectedCondition<Boolean>) wd -> driver.getCurrentUrl().equals(expectedURL));
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals(currentUrl, expectedURL, assertMessage);
		} catch (Exception e) {
			System.out.println("checkURLMatched :::: fail - error occured" + e.getMessage());
		}
	}
	public void checkNOTMatchedURL(String expectedURL, long timeoutInSeconds, String assertMessage) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
			wait.until((ExpectedCondition<Boolean>) wd -> !driver.getCurrentUrl().equals(expectedURL));
			String currentUrl = driver.getCurrentUrl();
			Assert.assertNotEquals(currentUrl, expectedURL, assertMessage);
		} catch (Exception e) {
			System.out.println("checkURLMatched :::: fail - error occured" + e.getMessage());
		}
	}

	public void inputText(String giatri, String locator) {
		driver.findElement(By.xpath(locator)).clear();
		driver.findElement(By.xpath(locator)).sendKeys(giatri);
		driver.findElement(By.xpath(locator)).getAttribute("value");
		// assert giatri == driver.findElement(By.xpath(locator)).getAttribute("value");
		Assert.assertEquals(giatri, driver.findElement(By.xpath(locator)).getAttribute("value"),
				"input va value khong khop");
	}

	public void click(String xPath, boolean doScroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("click xpath ::::" + xPath);
		if (doScroll == true) {
			js.executeScript("document.evaluate(\"" + xPath
					+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollIntoView();");

		}
		pause(300);
		driver.findElement(By.xpath(xPath)).click();
		pause(200);
	}

	public void scrollTo(String xpath) {
		runJS("document.evaluate(\"" + xpath
				+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollIntoView();");
	}

	public void scrollBy(String xpath, int x, int y) {
		runJS("document.evaluate(\"" + xpath
				+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollBy(" + x + ","
				+ y + ");");
	}

	public Object runJS(String script, Object... args) {
		return ((JavascriptExecutor) driver).executeScript(script, args);
	}

	public void setText(String xPath, String content, boolean doClear) {
		String textFieldValue = getInputText(xPath);
		System.out.println("textFieldValue ::::" + textFieldValue);
		if (textFieldValue.isEmpty()) {
			runJS("document.evaluate(\"" + xPath
					+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='';");
			pause(200);
			driver.findElement(By.xpath(xPath)).sendKeys(content);

		} else {
			if (doClear == true) {
				runJS("document.evaluate(\"" + xPath
						+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='"
						+ content + "';");
			}
			pause(100);
		}
		pause(500);
		textFieldValue = getInputText(xPath);
		System.out.println("after set text ::::" + textFieldValue);
		System.out.println("after set text xpath::::" + xPath);
		Assert.assertEquals(content, driver.findElement(By.xpath(xPath)).getAttribute("value"), "value khong khop");
	}

	public String getInputText(String xpath) {
		String textFieldValue = driver.findElement(By.xpath(xpath)).getAttribute("value").toString();
		System.out.println("getInputText textFieldValue ::::" + textFieldValue);
		return textFieldValue;
	}

	public String getAttribute(String xpath, String att) {
		return driver.findElement(By.xpath(xpath)).getAttribute(att);
	}

	public void setCommasIntText(String xPath, String content, boolean doClear) {
		runJS("document.evaluate(\"" + xPath
				+ "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.value='';");
		pause(200);
		driver.findElement(By.xpath(xPath)).sendKeys(content);
	}

	public String getCurrency(String xPath) {
		String inputValue = driver.findElement(By.xpath(xPath)).getText();
		int parseIntput = 1;
		try {
			parseIntput = Integer.parseInt(inputValue);
		} catch (NumberFormatException e) {
			System.out.println("fail parse interger xPath::: " + xPath);
			System.out.println("fail parse interger value::: " + inputValue);
		}
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
		String formattedCurrency = numberFormat.format(parseIntput);
		return formattedCurrency;
	}

	public String convertCurrencyType(String number) {
		int parseIntput = 1;
		try {
			parseIntput = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			System.out.println("fail parse interger value::: " + number);
		}
		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
		String formattedCurrency = numberFormat.format(parseIntput);
		return formattedCurrency;
	}

	public void goToPage(String menuStep) {
		String[] menuItems = menuStep.split("/");
		String MenuXPath = "//ul[contains(@role,'menubar')]";
		for (String menuItem : menuItems) {
			String xPath = MenuXPath + "//a[contains(.,'" + menuItem + "')]";
			try {
				new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(By.xpath(xPath))).click();
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Error click xPath menu :::: " + xPath);
				e.printStackTrace();
			}
		}
	}

	public void checkElementPresent(String xpath, int timeoutSecond, String message) {
		driver.manage().timeouts().implicitlyWait(timeoutSecond, java.util.concurrent.TimeUnit.SECONDS);
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Assert.assertNotNull(element, message);
			System.out.println("Element " + xpath + " is present.");
		} catch (NoSuchElementException e) {
			Assert.fail("fail checkElementPresent :::: " + e.getMessage());
		}
	}

	public WebElement waitForElementPresent(By by, int timeoutInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeoutInSeconds, java.util.concurrent.TimeUnit.SECONDS);
		try {
			WebElement element = driver.findElement(by);
			System.out.println("Element " + by + " is present.");
			return element;
		} catch (NoSuchElementException e) {
			System.out.println("Element " + by + " not found within " + timeoutInSeconds + " seconds.");
			return null;
		}
	}

	public WebElement waitForElementVisible(WebDriver driver, By by, int timeoutInSeconds) {
		driver.manage().timeouts().implicitlyWait(timeoutInSeconds, java.util.concurrent.TimeUnit.SECONDS);
		try {
			WebElement element = driver.findElement(by);
			if (element.isDisplayed()) {
				System.out.println("Element " + by + " is visible.");
				return element;
			} else {
				System.out.println("Element " + by + " is present but not visible.");
				return null;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element " + by + " not found within " + timeoutInSeconds + " seconds.");
			return null;
		}
	}
}
