package autotest.testcase.rise;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.rise.ClientPage;
import autotest.pages.rise.LoginPage;

public class ClientTestcases extends CommonPage {

	ClientPage client;
    LoginPage login;

    private HashMap<String, String> clientData = new HashMap<>();

    public void initDataForTest() {
        clientData.put("company", "Ha Anh");
        clientData.put("owner", "Mark");
        clientData.put("address", "123 Thai Binh");
        clientData.put("city", "ThaiBinh");
        clientData.put("state", "Hung Ha");
        clientData.put("zip", "100000");
        clientData.put("country", "Vietnam");
        clientData.put("phone", "0123456789");
        clientData.put("website", "haanh.test");
        clientData.put("vat", "VAT001");
        clientData.put("gst", "GST001");
        clientData.put("group", "Gold");
        clientData.put("currency", "vnd");
        clientData.put("symbol", "d");
        clientData.put("label", "potential");
    }

    @Test
    public void testAddClient() {
        client.clickClient();
        client.deleteAllByName(clientData.get("company"));
        client.clickMenu("Clients");
        client.clickAdd("Add client");
        client.fillClientForm(clientData);
        client.submitForm();
        shortPause();
    }

    @Test(dependsOnMethods = "testAddClient")
    public void testEditClient() {
        client.search(clientData.get("company"));
        client.editClient("456 Changed Address");
        shortPause();
    }

    @Test(dependsOnMethods = "testEditClient")
    public void testDeleteClient() {
    	client.search(clientData.get("company"));
    	client.delete();
    	client.search(clientData.get("company"));
    	shortPause();
    }

    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.urlRise, "chrome");
        client = new ClientPage(driver);
        login = new LoginPage(driver);
        initDataForTest();
        login.addCookies();
        login.clearAll();
        login.Login("admin@demo.com", "riseDemo");
    }

    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);
    }
}
