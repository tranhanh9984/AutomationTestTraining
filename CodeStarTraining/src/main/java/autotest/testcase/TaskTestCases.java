package autotest.testcase;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.page.TaskPage;
import autotest.page.LoginPage;

public class TaskTestCases extends CommonPage {

	private LoginPage loginPage;
	private TaskPage taskPage;
	
	HashMap<String, String> task = new HashMap<>();

	@Test(priority=1)
	public void testAddTask() {
		taskPage.clickTasksMenu();
		taskPage.deleteAllTask("task", task.get("title"));
		pause(2);
		
		taskPage.clickAdd("Add task");
		taskPage.addTask(task);
		pause(2);
		taskPage.verifyAddedTask("task", task.get("title"));
	}
	
	@Test(priority=2, dependsOnMethods = "testAddTask")
	public void testEditTask() {
		taskPage.clickEditButton("task", task.get("title"));
		taskPage.editTask(task);
		pause(2);
	}
	
	@Test(priority=3, dependsOnMethods = "testEditTask")
	public void testDeleteTask() {
		taskPage.deleteTask("task", task.get("title"));
		pause(2);
//		taskPage.verifyMessage("The record has been deleted.");
	}
	
	public void setTask() {
		task.put("title", "Learning Selenium");
		task.put("description", "Reliable quarterly releases and critical updates, delivered on time for over two decades.");
		task.put("related", "Client");
		task.put("relatedRender", "Blaze Rohan");
		task.put("collaborators", "John Doe");
		task.put("startDate", "29-06-2025");
		task.put("endDate", "29-08-2025");
		task.put("status", "Done");
		task.put("priority", "Major");
		task.put("label", "Bug");
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlRise, "chrome");
		loginPage = new LoginPage(driver);
		taskPage = new TaskPage(driver);
		loginPage.login("admin@demo.com", "riseDemo");
		setTask();
	}
	
	@AfterTest
	public void closeBrowser() {
//		this.closeBrowser(driver);
		
	}
}
