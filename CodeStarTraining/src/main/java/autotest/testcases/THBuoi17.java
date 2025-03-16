package autotest.testcases;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class THBuoi17 extends CommonPage {

	public THBuoi17() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void tc1() {
	driver.findElement(By.linkText("Click Here")).click();
	String currentWindow = driver.getWindowHandle();
	Set<String> windowHandles = driver.getWindowHandles();
	for (String window : windowHandles) {
	System.out.println(window);
	if (!window.equals(currentWindow)) {
	driver.switchTo().window(window);
	String currentUrl = driver.getCurrentUrl();
	Assert.assertEquals(currentUrl, "https://demo.guru99.com/articles_popup.php");
	driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("emailtest@rrr.com");
	driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	pause(4);
	driver.close();
	driver.switchTo().window(currentWindow);
	Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/popup.php");
	break;
	}
	}
	pause(4);
	}

}
