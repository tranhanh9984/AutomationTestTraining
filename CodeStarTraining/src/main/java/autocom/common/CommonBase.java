package autocom.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonBase {
	
	public WebDriver driver;

	public CommonBase() {
		// TODO Auto-generated constructor stub
	}
	
	public WebDriver startBrowser(String url) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
		return driver;
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void pauseByMiliSecond(int miliSecond) {
		try {
			Thread.sleep(miliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
