package autotest.testcase.rise;

import java.util.HashMap;

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
        client.deleteAllClientsByName(clientData.get("company"));
        client.clickMenu("Clients");

        client.clickAddClient();
        client.fillClientForm(clientData);
        client.submitForm();
        pause(5);
    }

    @Test(dependsOnMethods = "testAddClient")
    public void testEditClient() {
        client.searchClient(clientData.get("company"));
        client.editClient("456 Changed Address");
        pause(3);
    }

    @Test(dependsOnMethods = "testEditClient")
    public void testDeleteClient() {
    	client.clickMenu("Clients");
    	client.searchClient(clientData.get("company"));
    	client.deleteClient();
    	client.searchClient(clientData.get("company"));
        pause(3);
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
