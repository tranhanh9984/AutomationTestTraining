package autotest.testcase.rise;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.rise.LeadPage;
import autotest.pages.rise.LoginPage;

public class LeadTestcases extends CommonPage {

    LeadPage lead;
    LoginPage login;
    
    private HashMap<String, String> leadData = new HashMap<>();

    public void initDataForTest() {
        leadData.put("company", "Ha Anh");
        leadData.put("status", "New");
        leadData.put("owner", "Mark");
        leadData.put("source", "Facebook");
        leadData.put("address", "123 Hn");
        leadData.put("city", "Hanoi");
        leadData.put("state", "Nam Tu Liem");
        leadData.put("zip", "100000");
        leadData.put("country", "Vietnam");
        leadData.put("phone", "0123456789");
        leadData.put("website", "https://haanh.vn");
        leadData.put("vat", "VAT001");
        leadData.put("gst", "GST001");
        leadData.put("currency", "VND");
        leadData.put("symbol", "₫");
        leadData.put("label", "Potential");
    }

    @Test(priority = 1)
    public void testAddLead() {
        lead.clickMenu("Leads"); 
        lead.deleteAllByName(leadData.get("company"));
        lead.clickAdd("Add lead");
        lead.fillClientForm(leadData);
        lead.submitForm();
        pause(3);
    }

    @Test(priority = 2, dependsOnMethods = "testAddLead")
    public void testEditLead() {
        lead.clickMenu("Leads");
        lead.search(leadData.get("company"));
        lead.editClient("456 Updated Address");
        pause(3);
    }
    
    @Test(dependsOnMethods = "testEditLead")
    public void testDeleteLead() {
    	lead.search(leadData.get("company"));
    	lead.delete();
    	lead.search(leadData.get("company"));
    	shortPause();
    }
    
    

    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.urlRise, "chrome");
        lead = new LeadPage(driver);
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
