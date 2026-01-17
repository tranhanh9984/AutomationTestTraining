//package autotest.thuchanh;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import autocom.common.CommonPage;
//import autocom.constant.KeywordConstant;
//import autotest.pagesHD.HomePage;
//import autotest.pagesHD.LoginPage;
//
//import java.util.List;
//import java.util.Set;
//
//import org.openqa.selenium.Alert;
//
//public class Buoi17TH2 extends CommonPage {
//
//	public Buoi17TH2() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	public void alertProcesing() {
//		driver.findElement(By.linkText("Alert with OK")).click();
//		driver.findElement(By.xpath("//div[@id = 'OKTab']/button")).click();		
//		String alertText = driver.switchTo().alert().getText();		
//		Assert.assertEquals("I am an alert box!", alertText);
//		System.out.println(alertText);
//		pause(5);		
//		driver.switchTo().alert().accept();
//	}
//	
//	//@Test
//	public void getWindowHandles() {
//		
//		String frsWd = driver.getWindowHandle();
//		driver.findElement(By.linkText("Click Here")).click();
//		String currentWD = driver.getWindowHandle();
//		driver.switchTo().window(frsWd).getCurrentUrl();
//		driver.findElement(By.linkText("Click Here")).click();
//		Set<String> setA = driver.getWindowHandles();
//		String lastWindow = "";
//		for(String a : setA) {
//			System.out.println(a);
//			lastWindow = a;
//		}
//		
//		String url = driver.switchTo().window(lastWindow).getCurrentUrl();
//		System.out.println(url);
//		url = driver.switchTo().window(frsWd).getCurrentUrl();
//		driver.switchTo().defaultContent();
//		System.out.println(url);
//		pause(10);
//	}
//	
//	@Test
//	public void handleIframe() {
//		List<WebElement> lstIframe = driver.findElements(By.xpath("//iframe"));
//		int size = lstIframe.size();
//		for(int i = 0; i < size; i++) {
//			driver.switchTo().frame(i);
//			System.out.println(driver.findElements(By.xpath("//button[contains(text(),'Gửi ngay')]")).size());
//			driver.switchTo().defaultContent();
//		}
////		this.scrollToElement("(//iframe)[2]");
////		driver.switchTo().frame(1);
////		
////		driver.findElement(By.xpath("//input[@id = 'name']")).sendKeys("test");
////		driver.findElement(By.xpath("//input[@id = 'phone_number']")).sendKeys("0333123456");
////		driver.findElement(By.xpath("//input[@id = 'email']")).sendKeys("hanhtm@gmail.com");
////		driver.findElement(By.xpath("//button[contains(text(), 'Gửi ngay')]")).click();
//	}
//	
//	
//	@BeforeTest
//	public void startBrowser() {
//		driver = this.startBrower("https://codestar.vn/", KeywordConstant.BROWSER);
//	}
//	
//	@AfterTest
//	public void closeBrowser() {
//		this.closeBrowser(driver);
//		
//	}
//
//}
