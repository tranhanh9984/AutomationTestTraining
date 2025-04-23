package autotest.testcasepage.Rise;

import autocom.common.CommonPage;

import java.util.Collections;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pagesHD.HomePage;
import autotest.page.Rise.*;
public class CreatTaskTest extends CommonPage{
	LoginPageRise login;
	CreatProject_Task add;
	JavaTest jss;
	public CreatTaskTest() {
		// TODO Auto-generated constructor stub
	}
	 @BeforeTest

	public void startBrowser() {
		driver = this.startBrower("https://rise.fairsketch.com/tasks/all_tasks", KeywordConstant.BROWSER);
	    login = new LoginPageRise(driver);
	    add = new CreatProject_Task(driver);
	    jss = new JavaTest();
	    jss.driver = driver;
  	}
	
//	@AfterTest
//	public void closeBrowser() {
//	    this.closeBrowser(driver);
// 
//	}
//	@Test(priority = 1, description = "Kiểm tra tạo task cảnh báo thời gian")
//	public void addtaskError() {
//		login.login(KeywordConstant.usernameRise, KeywordConstant.passwordRise);
// 		String text = login.getTitle();
//		Assert.assertEquals(text, "John Doe", "Đăng nhập tài khoản không đúng");
// 		add.clickAddTask();
//		pause(1);
//		add.writeInput("Title","Tạo một task");
//		add.writeDescription("Tạo một task và test xem có thành công không");
//		pause(1);
//
//		add.selectFromDropdown("s2id_task-context", "Client"); // Related to
//		pause(1);
//		add.selectFromDropdown("s2id_client_id", "Demo Client");
//		add.selectFromDropdown("s2id_autogen5", "4 Points");
//		add.selectFromDropdown("s2id_assigned_to", "John Doe");
// 		add.selectFromDropdowns("s2id_collaborators", "Mark Thomas");
// 		add.selectFromDropdowns("s2id_collaborators", "Michael Wood");//lựa chọn lặp
//		add.selectFromDropdown("s2id_task_status_id", "To do");
//		add.selectFromDropdown("s2id_priority_id", "Major");
//		add.selectFromDropdowns("s2id_project_labels", "Bug"); //lựa chọn lặp
//		add.writeInput("Start date","30-04-2025");
//	    add.writeInput("Deadline","25-04-2025");
//	    driver.findElement(By.tagName("body")).click(); 
//		String expectedText = add.getValEmailMsg();
//		System.out.println("Thông báo tìm thấy: "+ expectedText);
//		Assert.assertEquals(expectedText, "Deadline must be equal or greater than Start date.");
//		pause(3);
//
//	}
	@Test(priority = 1, description = "Kiểm tra tạo task thành công")
	public void addtaskSucsess() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.get("https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/tasks/all_tasks");
		pause(2);
		js.executeScript("document.getElementById('email').value = '';");  
		js.executeScript("document.getElementById('email').value = 'admin@demo.com';"); 
		pause(2);

		js.executeScript("document.getElementById('password').value = '';");
		js.executeScript("document.getElementById('password').value ='riseDemo';");
		pause(2);
		js.executeScript("document.getElementsByClassName('btn-primary')[0].click()");
		System.out.println("Clicking button...");
		String text = login.getTitle();
		Assert.assertEquals(text, "John Doe", "Đăng nhập tài khoản không đúng");
 		pause(1);
 		js.executeScript("document.querySelector('a[data-title=\"Add task\"]').click();");
 		pause(1);
		jss.writeInputPureJS("Title","Create task dashboards and reports");
		add.writeDescription("Quis quisquam cumque quia aut nesciunt quia. Omnis omnis rerum nulla ut quisquam sit. Qui est necessitatibus sit eius omnis.");
//		pause(1);
//		jss.selectFromDropdownJS("s2id_task-context", "Client");
//		jss.selectFromDropdownJS("s2id_project_id", "Video Animation and Editing");  
//		pause(1);
//		jss.selectFromDropdownJS("s2id_autogen5", "4 Points");
//		add.selectFromDropdown("s2id_milestone_id", "Beta Release");
//		jss.selectFromDropdownJS("s2id_task-context", "Client");
//		jss.selectFromDropdownJS("s2id_assigned_to", "Sara Ann");
//		jss.selectFromDropdownJS("s2id_collaborators", "Mark Thomas");
//		jss.selectFromDropdownJSs("s2id_collaborators", "Michael Wood");//lựa chọn lặp
// 		jss.selectFromDropdownJS("s2id_task_status_id", "To do");
// 		jss.selectFromDropdownJS("s2id_priority_id", "Major");
// 		jss.selectFromDropdownJSs("s2id_project_labels", "Bug"); //lựa chọn lặp
//		jss.writeInputPureJS("Start date","25-04-2025");
//		jss.writeInputPureJS("Deadline","30-04-2025");
//	    driver.findElement(By.tagName("body")).click();
		add.selectFromDropdown("s2id_task-context", "Project"); // Related to
		pause(1);
		add.selectFromDropdown("s2id_project_id", "Video Animation and Editing");
		add.selectFromDropdown("s2id_autogen17", "4 Points");
		add.selectFromDropdown("s2id_assigned_to", "John Doe");
  		add.selectFromDropdowns("s2id_collaborators", "Michael Wood");//lựa chọn lặp
		add.selectFromDropdown("s2id_task_status_id", "To do");
		add.selectFromDropdown("s2id_priority_id", "Major");
		add.selectFromDropdowns("s2id_project_labels", "Bug"); //lựa chọn lặp
		add.writeInput("Start date","25-04-2025");
	    driver.findElement(By.tagName("body")).click();

		pause(1);
	    add.writeInput("Deadline","12-05-2025");
	    driver.findElement(By.tagName("body")).click();
	    pause(2);  
//		js.executeScript("document.getElementsByClassName('btn btn-primary')[0].click();");
	    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		 pause(2);  
//	    WebElement searchInput = driver.findElement(By.cssSelector("#task-table_filter input"));
//		  searchInput.sendKeys("Create task dashboards and reports");
//		  searchInput.sendKeys(Keys.ENTER);
		 pause(5);  

	 	 Map<String, String> info = getClientInfo("Create task dashboards and reports");
	 	 Assert.assertNotNull(info, "Không tìm thấy thông tin khách hàng!");

	     Assert.assertEquals(info.get("Title"), "Create task dashboards and reports","Tên không đúng");
//	     Assert.assertEquals(info.get("Status"), "To do","Status không đúng");
	     System.out.println("Đã tìm thấy khách hàng và có ID là: "+info.get("id"));

	}
	public Map<String, String> getClientInfo(String title) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    String script =
	        "const rows = document.querySelectorAll('tbody tr');" +
	        "for (let row of rows) {" +
	        "  const cells = row.querySelectorAll('td');" +
	        "  if (cells[1]) {" +
	        "    const taskTitle = cells[1].querySelector('a')?.innerText.trim();" +
	        "    if (taskTitle && taskTitle === '" + title + "') {" +
	        "      return {" +
	        "        id: cells[0].innerText.trim()," +
	        "        title: cells[1].innerText.trim()," +
	        "        startDate: cells[2].innerText.trim()," +
	        "        endDate: cells[3].innerText.trim()," +
	        "        milestone: cells[4].innerText.trim()," +
	        "        project: cells[5].innerText.trim()," +
	        "        assignedTo: cells[6].innerText.trim()," +
	        "        collaborators: cells[7].innerText.trim()," +
	        "        status: cells[8].innerText.trim()" +
	        "      };" +
	        "    }" +
	        "  }" +
	        "}" ;
 	    
	    return (Map<String, String>) js.executeScript(script);
	}


	
}