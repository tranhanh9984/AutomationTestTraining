package autotest.SelectorHubPage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.SelectorHubPage.PageSelectorHub;
public class Testcases extends CommonPage {
	PageSelectorHub selector;
	
	@Test
	
	public void nhanCheckOut() {
		selector.clickUserName();
		selector.clickUserTable();
		
		pause(5);
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.selectorUrl, KeywordConstant.BROWSER);
		
		selector = new PageSelectorHub();
		selector.driver = driver;
		pause(3);
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
		
	}

}
