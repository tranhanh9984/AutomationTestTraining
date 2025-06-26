//package autotest.thuchanh;
//
//import org.openqa.selenium.By;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import autocom.common.CommonPage;
//import autocom.constant.KeywordConstant;
//
//public class Buoi12TH extends CommonPage {
//
//	public Buoi12TH() {
//		// TODO Auto-generated constructor stub
//	}
//	
//	
//	@Test
//	public void handleCheckbox() {
//		boolean isChecked = driver.findElement(By.xpath("//label[@for = 'tree-node-home']/input")).isSelected();
//		if(!isChecked) {
//			driver.findElement(By.xpath("//label[@for = 'tree-node-home']")).click();
//		}
//		isChecked = driver.findElement(By.xpath("//label[@for = 'tree-node-home']/input")).isSelected();
//		System.out.println(isChecked);
//	}
//	
//	
//
//	
//	@BeforeTest
//	public void startBrowser() {
//		driver = this.startBrower("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html", KeywordConstant.BROWSER);
//	
//	}
//	
//	@AfterTest
//	public void closeBrowser() {
//		this.closeBrowser(driver);
//		
//	}
//
//}
