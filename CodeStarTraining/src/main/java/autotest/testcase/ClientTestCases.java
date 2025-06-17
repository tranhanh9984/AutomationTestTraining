package autotest.testcase;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.page.ClientPage;
import autotest.pages.login.LoginPage;

public class ClientTestCases extends CommonPage {

	private LoginPage loginPage;
	private ClientPage clientPage;
	HashMap<String, String> client = new HashMap<>();
	
	@Test(priority=1)
	public void testAddClients() {
		clientPage.clickProjectMenu();
		clientPage.clickTabClients();
		
		clientPage.deleteAllClient(client.get("name"));
		clientPage.clickAddClient();
		
		clientPage.addClients(client);
		pause(2);
		
		clientPage.verifyAddedClient(client.get("name"));
	}
	
	@Test(priority=2, dependsOnMethods = "testAddClients")
	public void testEditClients() {
		clientPage.searchClient(client.get("name"));
		clientPage.clickEditButton(client.get("name"));
		pause(2);
		
		clientPage.editClients(client);
		pause(2);
	}
	
	@Test(priority=3, dependsOnMethods = "testEditClients")
	public void testDeleteClients() {
		clientPage.deleteClient(client.get("name"));
		pause(2);
		clientPage.verifyMessage("The record has been deleted.");
	}
	
	private void setClient() {
		client.put("type", "person");
	    client.put("name", "Bich Lien");
	    client.put("owner", "Michael Wood");
	    client.put("address", "Nam Tu Liem");
	    client.put("city", "Ha Noi");
	    client.put("state", "Khong");
	    client.put("zip", "10000");
	    client.put("country", "Viet Nam");
	    client.put("clientGroups", "Silver");
	    client.put("currency", "AMD");
	    client.put("label", "Inactive");
	    client.put("currencySymbol", "Đ");
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		loginPage = new LoginPage(driver);
		loginPage.login("admin@demo.com", "riseDemo");
		clientPage = new ClientPage(driver);
		setClient();
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
		
	}
}
