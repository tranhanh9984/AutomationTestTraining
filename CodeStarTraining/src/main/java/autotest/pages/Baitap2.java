package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;

public class Baitap2 extends CommonPage{
	

	public Baitap2() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void Submit() {
		
		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456789");
		driver.findElement(By.name("company")).sendKeys("Công ty TNHH ANZ");
		driver.findElement(By.name("mobile number")).sendKeys("0973 112 444");
		driver.findElement(By.xpath("//button[@value='Submit']")).click();
		// chọn xe
		Select dropdown = new Select(driver.findElement(By.id("cars")));
		dropdown.selectByIndex(2);
		// chọn ngày
		driver.findElement(By.xpath("//input[@name='the_date']")).sendKeys("07-09-2024");
	
	//edit tên
		//driver.findElement(By.name("First Enter name ")).sendKeys("cập nhật tên");
		
	// Link 
		 driver.findElement(By.linkText("https://www.youtube.com/c/SelectorsHub?sub_confirmation=1"));
		


		pause(5000);
	}

@BeforeTest
public void startPage()
{
	this.startBrower("https://selectorshub.com/xpath-practice-page/","chrome");
	pause(500);
	
}
@AfterTest
public void closePage()
{
	this.closeBrowser(driver);
}
}


