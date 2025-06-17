package autotest.testcase;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.page.ProjectPage;
import autotest.pages.login.LoginPage;

public class ProjectTestCases extends CommonPage {
	LoginPage loginPage;
	ProjectPage projectPage;
	HashMap<String, String> project = new HashMap<>();
	
	@Test(priority=1)
	public void testAddProject() {
		projectPage.clickProjectMenu();
		projectPage.deleteAllProject(project.get("title"));
		
		projectPage.clickAddProject();
		pause(2);
		projectPage.addProject(project);
		projectPage.clickSaveProject();
		
		projectPage.verifyCreatedProject(project.get("title"));
	}
	
	@Test(priority=2, dependsOnMethods = "testAddProject")
	public void testEditProject() {
		projectPage.clickEditButton(project.get("title"));
		
		projectPage.changeStatus(project.get("status"));
		projectPage.clickSaveProject();
		pause(2);
	}
	
	@Test(priority=3, dependsOnMethods = "testEditProject")
	public void testDeleteProject() {		
		projectPage.deleteProject(project.get("title"));
		pause(2);
//		projectPage.verifyMessage("The record has been deleted.");
	}
	
	private void setTestProject() {
	    project.put("title", "Learning automation test - Codestar");
	    project.put("description", "Nội dung mô tả cần nhập");
	    project.put("startDate", "29-07-2025");
	    project.put("deadline", "30-11-2025");
	    project.put("price", "34000");
	    project.put("label", "On track");
	    project.put("status", "Completed");
	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		loginPage = new LoginPage(driver);
		loginPage.login("admin@demo.com", "riseDemo");
		projectPage = new ProjectPage(driver);
		setTestProject();
	}
	
	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
	}
}
