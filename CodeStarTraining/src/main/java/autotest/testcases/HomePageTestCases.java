package autotest.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.HomePage;
import autotest.pages.LoginPage1;

public class HomePageTestCases extends CommonPage {

	String option = "Tạo hoá đơn";	
	KeywordConstant comConstant =  new KeywordConstant();

	
	@BeforeClass
	public void StartPage() {
		this.startBrower("https://v2.vietinvoice.vn/auth/dang-nhap", "chrome");
		pause(50);
	}
	
	@Test
	public void clickOnMenuHoaDon() {
		LoginPage1 loginPage1 = new LoginPage1(driver);
		HomePage homePage = new HomePage(driver);
		// Kiem tra click vao menu
		loginPage1.inputAllFields(comConstant.EMAIL, comConstant.PASSWORD, comConstant.MST);
		loginPage1.clickSubmitButton();
		homePage.clickOnAvatar();
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(text(), '" + comConstant.EMAIL + "')]")).getText().contains(comConstant.EMAIL));
		homePage.clickHoadonMenu(option);
		Assert.assertEquals(driver.getTitle(), "VIETINVOICE - Giải pháp hóa đơn điện tử" );
		pause(1000);
	}
	
	@AfterClass
	public void ClosePage() {
		this.closeBrowser(driver);
	}
}
