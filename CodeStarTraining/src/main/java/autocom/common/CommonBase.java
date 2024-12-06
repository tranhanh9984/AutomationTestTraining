package autocom.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

public class CommonBase {
	public WebDriver driver;

	public CommonBase() {
		// TODO Auto-generated constructor stub
	}

	public WebDriver startBrower(String url, String browser) {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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

	public void inputText(String giatri, String locator) {
		// Now clear the text input field
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
		Assert.assertEquals(content, driver.findElement(By.xpath(xPath)).getAttribute("value"), "value khong khop");
	}

	public String getInputText(String xpath) {
		String textFieldValue = driver.findElement(By.xpath(xpath)).getText().toString();
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
}
