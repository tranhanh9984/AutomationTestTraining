package autotest.testcase.rise;

import java.util.HashMap;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.rise.LoginPage;
import autotest.pages.rise.TaskPage;

public class TaskTestcases extends CommonPage {

    TaskPage task;
    LoginPage login;
    private HashMap<String, String> taskData = new HashMap<>();

    public void initDataForTest() {
        taskData.put("title", "Ha Anh");
        taskData.put("description", "Ha Anh test task");
        taskData.put("related", "Client");
        taskData.put("client", "Demo");
        taskData.put("collaborator", "John Doe");
        taskData.put("priority", "Minor");
        taskData.put("label", "Bug");
        taskData.put("start_date", "20-02-2004");
        taskData.put("deadline", "20-02-2020");
    }

    @Test
    public void testAddTask() {
        task.deleteAllByName(taskData.get("title")); 
        task.clickMenu("Tasks");
        
        task.clickAdd("Add task");
        task.fillTaskForm(taskData);
        task.submitForm();
        pause(5);
       
    }

    @Test(dependsOnMethods = "testAddTask")
    public void testEditTask() {
        task.search(taskData.get("title"));
        task.editTask("Ha Anh da sua description");
    }

    @Test(dependsOnMethods = "testEditTask")
    public void testDeleteClient() {
    	task.search(taskData.get("title"));
    	task.delete();
    	task.search(taskData.get("title"));
        pause(3);
    }

    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.urlRise, "chrome");
        task = new TaskPage(driver);
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
