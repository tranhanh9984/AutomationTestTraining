package autocom.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonBase {
	
	public WebDriver driver;

	public CommonBase() {
		// TODO Auto-generated constructor stub
	}
	// start browser
	public WebDriver startBrowser(String url, String browser) {
		
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// open maximize browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// navigate to Url
		driver.navigate().to(url);
		return driver;
		
	}
	// pause browser
	public void pauseBrowser(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	// close browser
	public void closeBrowser() {
		//close(): Đóng cửa sổ hiện tại
		//driver.close();
		
		//Đóng toàn bộ phiên trình duyệt.
		if (driver != null) {
            driver.quit(); // Đóng trình duyệt
            //driver = null; // Ngăn chặn vòng lặp
        }
	}
	
	
	
	

}
