package autotest.pagesHD;
 
 import org.openqa.selenium.By;
 
 import autocom.common.CommonPage;
 
 public class HomePage extends CommonPage{
 
 	public HomePage() {
 		// TODO Auto-generated constructor stub
 	}
 
 	
 	String lblTitle = "//a[@title = 'Thông tin cá nhân']";
 	
 	public String getTitle() {
 		return driver.findElement(By.xpath(lblTitle)).getText();
 	}
 	
 }