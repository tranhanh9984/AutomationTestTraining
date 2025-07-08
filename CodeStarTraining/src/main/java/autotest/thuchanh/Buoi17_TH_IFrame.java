package autotest.thuchanh;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class Buoi17_TH_IFrame extends CommonPage {
	@Test
	public void testIFrame() {
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("So luong frame: " + size);
		
		String xpath = "//h2[@class='masterstudy-custom-title' and contains(text(),'Đăng kí nhận tư vấn lộ trình phát triển nghề nghiệp')]";
    	scrollToElement(xpath);
    	
		for(int i = 0; i < size; i++) {
					
			WebElement frame = iframes.get(i);
		    String src = frame.getAttribute("src");
		    String title = frame.getAttribute("title");
		    String dataSrc = frame.getAttribute("data-src");
		    String width = frame.getAttribute("width");
		    
		    
		    if (src != null && !src.isEmpty()) {
		        System.out.println("iframe[" + i + "] src: " + src);
		    }
		    
		    if (title != null && !title.isEmpty()) {
		        System.out.println("iframe[" + i + "] title: " + title);
		    }
		    
		    if (dataSrc != null && !dataSrc.isEmpty()) {
		        System.out.println("iframe[" + i + "] data-src: " + dataSrc);
		    }
		    
		    if (width != null && !width.isEmpty()) {
		        System.out.println("iframe[" + i + "] width: " + width);
		    }
		    driver.switchTo().frame(frame);
		    
		    if (i == 0) {
		    	
		    	
		    	
		    	driver.findElement(By.id("name")).sendKeys("test 123");
		    	driver.findElement(By.id("phone_number")).sendKeys("087617111");
		    	driver.findElement(By.id("email")).sendKeys("test123@gmail.com");
		    	driver.findElement(By.xpath("//button[contains(text(),'Gửi ngay')]")).click();
		    	
		    	
		    }
		    
		    driver.switchTo().defaultContent();
		    
		    
		}
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower("https://codestar.vn", "chrome");
		pause(5);
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
	}
}
