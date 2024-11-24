package autocom.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CommonBase {

	public CommonBase() {
		// TODO Auto-generated constructor stub
	}

	public WebDriver startBrower(String url, String browser) {
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
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
//		return driver;
	}

}
