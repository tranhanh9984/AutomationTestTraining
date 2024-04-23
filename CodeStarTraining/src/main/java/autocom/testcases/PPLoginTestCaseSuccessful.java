package autocom.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.pages.LoginPagePP;

public class PPLoginTestCaseSuccessful extends CommonPage {
	

	WebDriver driver;
	@FindBy (xpath = "//div[@role = 'alert']")
WebElement noti;
	
	@BeforeTest
	public void startPage() {
		driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");

	}
	
	@Test
	public void loginSucessful() {
		LoginPagePP loginPage = new LoginPagePP(driver);
		loginPage.loginPP("caonv174@gmail.com","123456", "0312303803-999");
		pause(3000);
		
		
	}

}
