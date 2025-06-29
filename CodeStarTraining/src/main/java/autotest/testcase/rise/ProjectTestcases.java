package autotest.testcase.rise;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.rise.LoginPage;
import autotest.pages.rise.ProjectPage;

public class ProjectTestcases extends CommonPage {

    ProjectPage project;
    LoginPage login;
    
    private HashMap<String, String> projectData = new HashMap<>();

    public void initDataForTest() {
        projectData.put("title", "Ha Anh");
        projectData.put("description", "Ha Anh");
        projectData.put("start_date", "20-02-2004");
        projectData.put("deadline", "20-02-2020");
        projectData.put("price", "20000");
        projectData.put("label", "Perfect");
    }


    @Test(priority = 1)
    public void testAddProject() {
    	project.clickMenu("Projects");
        project.deleteAllByName(projectData.get("title"));
        project.clickAdd("Add project");
        project.fillProjectForm(projectData);
        project.submitForm();
        pause(3);
    }

    @Test(priority = 2, dependsOnMethods = "testAddProject")
    public void testEditProject() {
        project.clickMenu("Projects");
        project.search(projectData.get("title"));
        project.editProject("50000");
        pause(3);
    }

    @Test(priority = 3, dependsOnMethods = "testEditProject")
    public void testDeleteProject() {
        project.clickMenu("Projects");
        project.search(projectData.get("title"));
        project.delete();
        project.search(projectData.get("title"));
        pause(3);
    }

    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.urlRise, "chrome");
        project = new ProjectPage(driver);
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
