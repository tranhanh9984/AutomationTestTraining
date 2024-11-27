package autocom.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CommomBase {
	
	public WebDriver driver;

	public CommomBase() {
		// TODO Auto-generated constructor stub
	}
	public void setText(String text) {
		driver.findElement(By.xpath(text));
	}
	
	public WebDriver startBrower(String url, String browser) {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");	// chrome.driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
		return driver;
		
//		if ("chrome".equals(browser)) {
//			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
//			driver = new ChromeDriver();
//		} else if ("iexplorer".equals(browser)) {
//			driver = new InternetExplorerDriver();
//		} else if ("safari".equals(browser)) {
//			driver = new SafariDriver();
//		} else {
//			driver = new FirefoxDriver();
//		}
//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.navigate().to(url);
		
	}
	
	public String ChooseMenuLevel1( int level) {
		return ("/html/body/app-root/app-entities/div/div[1]/app-menu/p-menubar/div/p-menubarsub/ul/li[" + level +"]");
	}
	
	public String ChooseMenuLevel2( int level) {
		return ("/html/body/app-root/app-entities/div/div[1]/app-menu/p-menubar/div/p-menubarsub/ul/li[2]/p-menubarsub/ul/li[" + level +"]");
	}
	
	public void clearText(String xpath) {
		JavascriptExecutor jse6 = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript(
	            "arguments[0].value = '';", driver.findElement(By.xpath(xpath)));
	}
	
	public void closeBrower() {
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
