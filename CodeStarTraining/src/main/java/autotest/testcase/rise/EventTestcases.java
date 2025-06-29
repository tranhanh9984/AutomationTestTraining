package autotest.testcase.rise;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.rise.EventPage;
import autotest.pages.rise.LoginPage;

public class EventTestcases extends CommonPage {

    EventPage event;
    LoginPage login;

    private HashMap<String, String> eventData = new HashMap<>();

    public void initDataForTest() {
        eventData.put("title", "Ha Anh");
        eventData.put("description", "Birthday");
        eventData.put("start_date", "24-06-2025");
        eventData.put("start_time", "08:00");
        eventData.put("end_date", "24-06-2025");
        eventData.put("end_time", "10:00");
        eventData.put("location", "Thai Binh");
        eventData.put("label", "Call");
        eventData.put("client", "Abe"); 
    }

    @Test(priority = 1)
    public void testAddEvent() {
        event.clickMenu("Events");
        event.clickAdd("Add event");
        event.fillEventForm(eventData);
        event.submitForm();
        pause(3);
    }

    @Test(priority = 2, dependsOnMethods = "testAddEvent")
    public void testEditEvent() {
        event.editEvent("Ha Noi");
        pause(3);
    }

    @Test(priority = 3, dependsOnMethods = "testEditEvent")
    public void testDeleteEvent() {
        event.deleteEvent();
        pause(3);
    }

    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.urlRise, "chrome");
        event = new EventPage(driver);
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
