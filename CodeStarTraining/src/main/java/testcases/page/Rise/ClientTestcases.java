package testcases.page.Rise;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import page.Rise.ClientPage;
import page.Rise.HomePageRise;
import page.Rise.LoginPageRise;

public class ClientTestcases extends CommonPage{
	LoginPageRise login;
	WebDriver driver;
	HomePageRise homePage;
	ClientPage clientPage;
	String errorExpected = "This field is required.";
	String alertExpected = "\"Oops, something went wrong!\"";
	String noMatchesExpected = "No matches found";
	
	@Test(priority = 1)
	public void LoginSuccess() {
		pause(2);
		login.Login();
		String text = homePage.getUserName();
		Assert.assertEquals(text, "John Doe");
	}
	@Test(priority = 2)
	public void taoClient() {
		homePage.clickClient();
	}
	
	@Test(priority = 3)
	public void taoClientInvalidName() {
		pause(1);
		clientPage.clickTaoClient();
		clientPage.diendiachi("Hoai Duc");
		clientPage.dienthanhpho("Hanoi");
		clientPage.dienstate("Hanoi");
		clientPage.diendatnuoc("Vietnam");
		clientPage.clickSave();
		pause(2);
		String Actual = clientPage.getNameError();
		Assert.assertEquals(Actual, "This field is required.");
		clientPage.clickClose();
		pause(1);
	}
	
	@Test(priority = 5)
	public void taoSpaceName() {
		clientPage.clickTaoClient();
//		clientPage.diendiachi("Hoai Duc");
//		clientPage.dienthanhpho("Hanoi");
//		clientPage.dienstate("Hanoi");
//		clientPage.diendatnuoc("Vietnam");
//		clientPage.clickSave();
//		String Actual = clientPage.getNameError();
//		Assert.assertEquals(Actual, "This field is required.");
		pause(1);
		clientPage.dientencongty("     ");
		pause(3);
		clientPage.clickSave();
		pause(5);
		String Actual2 = clientPage.getAlert();
		Assert.assertEquals(Actual2, "\"Oops, something went wrong!\"");
		clientPage.clickClose();
	}
	
//	@Test(priority = 4)
//	public void nhapClientInvalid() {
//		pause(1);
//		clientPage.clickTaoClient();
//		pause(1);
//		clientPage.dienOwner("aaa");
//		String Actual = clientPage.getNoMatchFound();
//		Assert.assertEquals(Actual, "No matches found");
//		clientPage.clickClose();
//	}
	  
//	@Test(priority = 6)
//	public void taoClientSuccess() {
//		pause(2);
//		clientPage.clickTaoClient();
//		clientPage.dientencongty("Test");
//		clientPage.diendiachi("Hoai Duc");
//		clientPage.dienthanhpho("Hanoi");
//		clientPage.dienstate("Hanoi");
//		clientPage.diendatnuoc("Vietnam");
//		clientPage.dienzip("10000");
//		clientPage.diensdt("091589888777");
//		clientPage.dienVAT("09128888");
//		clientPage.dienGST("99092039203");
//		clientPage.dienOwner("Sara Ann");
//		clientPage.dienClientgroups("VIP");
//		clientPage.dienCurrency("AED");
//		clientPage.dienCurrencySymbol("20000");
//		clientPage.dienLabels("Inactive");
//		clientPage.clickSave();
//		clientPage.clickdsclient();
//		clientPage.clickID();
//		pause(2);
//		String text = clientPage.gettxtName();
//		Assert.assertEquals(text, "Test");
//		String text2 = clientPage.gettxtphone();
//		Assert.assertEquals(text2, "091589888777");
//		String text3 = clientPage.gettxtClient();
//		Assert.assertEquals(text3, "VIP");
//		String text4 = clientPage.gettxtCFLabels();
//		Assert.assertEquals(text4, "Inactive");
//		String text5 = clientPage.gettxtCFProject();
//		Assert.assertEquals(text5, "0");
//		String text6 = clientPage.gettxtCFTTinvoiced();
//		Assert.assertEquals(text6, "200000.00");
//		String text7 = clientPage.gettxtCFPMReceived();
//		Assert.assertEquals(text7, "200000.00");
//		String text8 = clientPage.gettxtCCFDue();
//		Assert.assertEquals(text8, "200000.00");
//	}
	@BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.riseUrl, KeywordConstant.BROWSER);
        login = new LoginPageRise(driver);
        homePage = new HomePageRise(driver);
        clientPage = new ClientPage(driver);
    }

    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);

    }

}