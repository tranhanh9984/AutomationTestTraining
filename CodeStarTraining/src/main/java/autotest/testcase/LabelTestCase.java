package autotest.testcase;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.common.LabelPopup;
import autocom.constant.KeywordConstant;
import autotest.page.LoginPage;

public class LabelTestCase extends CommonPage {
	LoginPage loginPage;
	LabelPopup labelPopup;
	HashMap<String, String> label = new HashMap<>();
	HashMap<String, String> labelNew = new HashMap<>();
	
	@Test(priority=1)
	public void testAddLabel() {
		labelPopup.clickMenuLink("Notes");
		System.out.print("Add label");
		labelPopup.clickManageLabels();
		
		// delete all labels
		labelPopup.deleteLabel(label);
		pause(2);
		
		// add new label
		labelPopup.addLabel(label);
		
		pause(2);
		labelPopup.verifyAddedLabel(label);
	}
	
	@Test(priority=2, dependsOnMethods = "testAddLabel")
	public void testEditLabel() {
		pause(2);
		labelPopup.editLabel(label, labelNew);
//		labelPopup.verifyAddedLabel(labelNew);
	}
	
	@Test(priority=3, dependsOnMethods = "testEditLabel")
	public void testDeleteLabel() {
		pause(2);
		labelPopup.deleteLabel(labelNew);
	}
	
	
	private void setLabel() {
		label.put("name", "Skills");
		label.put("color", "#e18a00");
		labelNew.put("name", "Skills");
		labelNew.put("color", "#83c340");
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		loginPage = new LoginPage(driver);
		
		loginPage.loginWithCookie();
		
		if (!loginPage.isLoggedIn()) {
			loginPage.login("admin@demo.com", "riseDemo");
		}
		
		labelPopup = new LabelPopup(driver);
		setLabel();
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
	}
}
