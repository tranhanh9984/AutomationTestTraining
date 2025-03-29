package autotest.pages.practice;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import autotest.pages.practice.HomePractice; 
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
public class Thuc_hanh extends CommonPage {
	WebDriver driver; 
	HomePractice home;
	@BeforeTest	
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlPra, KeywordConstant.BROWSER);
		home = new HomePractice();
		home.driver = driver;
	}
	@Test
	public void logi() {
		home.click("//button[@class='dropbtn']");
		home.click("//a[contains(text(),'Join Training')]");
// 		driver.get("https://selectorshub.com/xpath-practice-page/");
		pause(5);
		Set<String> windowHandles = driver.getWindowHandles();
	    List<String> windowList = new ArrayList<>(windowHandles);
	    if (windowList.size() > 1) {
	        driver.switchTo().window(windowList.get(1));  
	        pause(2);
	        driver.close();  

	        driver.switchTo().window(windowList.get(0));
	
		}
	    home.click("//select[@id='cars']");
	    home.click("//option[@value='audi']");
	    driver.findElement(By.name("the_date")).sendKeys("30/04/2003");

	}
	
//	@AfterTest
 
//	public void closeBrowser() {
//		this.closeBrowser(driver);
//		
//	}    
        
	      
    }


