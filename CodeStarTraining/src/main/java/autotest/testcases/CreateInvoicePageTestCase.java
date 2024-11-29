package autotest.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.constant.KeywordConstant;
import autotest.pages.CreateInvoicePage;

public class CreateInvoicePageTestCase extends CreateInvoicePage {

	public CreateInvoicePageTestCase() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void init() {
		this.startBrowser(KeywordConstant.LOGIN_URL);
		this.gotoCreateInvoicePage();
	}
	
	@AfterClass
	public void close() {
		this.closeBrowser();
	}
	
	@Test(priority = 1)
	public void tc1_GoToPage_Successful() {
		String currentURL = driver.getCurrentUrl();
		
		Assert.assertEquals(currentURL, KeywordConstant.CREATE_INVOICE_URL);
	}
	
	@Test
	public void tc2_ClickTaoMoi_Fail() {
		this.clickTaoMoi();
		
		String errorText = driver.findElement(By.xpath("")).getText();
	}

}
