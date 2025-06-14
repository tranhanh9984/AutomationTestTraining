package autotest.buoi8;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

import java.util.HashMap;

public class Task extends CommonPage {

    private HashMap<String, String> InforNewTask = new HashMap<>();

    @Test
    public void testLogin() {
        addCookies();
        clearAll();
        this.Login("admin@demo.com", "riseDemo");
    }

    @Test
    public void testAddTask() {
        selectMenu("Tasks");
        addTask();
        pause(2);
    }

    @Test
    public void testEditTask() {
        selectMenu("Tasks");
        searchTask(InforNewTask.get("title"));
        driver.findElement(By.xpath("//button[normalize-space(text())='All tasks']\r\n")).click();
        editTask();
        pause(2);
    }

    @Test
    public void testDeleteTask() {
        selectMenu("Tasks");
        searchTask(InforNewTask.get("title"));
        driver.findElement(By.xpath("//button[normalize-space(text())='All tasks']\r\n")).click();
        driver.findElement(By.xpath("//table[@id='task-table']//tr[1]//a[@title='Delete task']")).click();
        pause(2);
        driver.findElement(By.id("confirmDeleteButton")).click();
        pause(2);
    }

    public void editTask() {
        driver.findElement(By.xpath("//a[@title='Edit task' and contains(@class, 'edit')]")).click();
        driver.findElement(By.id("deadline")).clear();
        driver.findElement(By.id("deadline")).sendKeys("14/06/2025");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        pause(2);
    }

    public void searchTask(String str) {
        driver.findElement(By.xpath("//input[@aria-controls='task-table']")).clear();
        driver.findElement(By.xpath("//input[@aria-controls='task-table']")).sendKeys(str, Keys.ENTER);
        driver.findElement(By.xpath("//button[contains(@class, 'bookmarked-filter-button') and text()='All tasks']")).click();
        pause(2);
    }

    private void addTask() {
        driver.findElement(By.linkText("Add task")).click();
        driver.findElement(By.id("title")).sendKeys(InforNewTask.get("title"));
        driver.findElement(By.id("description")).click();
        driver.findElement(By.className("note-editable")).sendKeys(InforNewTask.get("description"));

        driver.findElement(By.xpath("//label[@for='context']//following::div[1]/div")).click();
        driver.findElement(By.xpath("//ul[@class='select2-results']/li/div[contains(text(), '" + InforNewTask.get("context") + "')]")).click();
        pause(1);

        driver.findElement(By.xpath("//label[text()='Project']//following-sibling::div[1]/div")).click();
        pause(1);

        WebElement projectInput = driver.findElement(By.xpath("//div[@class='select2-search']/parent::div[contains(@style,'display: block')]//input"));
        projectInput.sendKeys(InforNewTask.get("project"));
        projectInput.sendKeys(Keys.ENTER);

        driver.findElement(By.id("start_date")).sendKeys(InforNewTask.get("start_date"));
        driver.findElement(By.id("deadline")).sendKeys(InforNewTask.get("deadline"));

        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
    }

    private void initData() {
        InforNewTask.put("title", "Create testcase");
        InforNewTask.put("description", "Viết các test case chức năng chính cho hệ thống");
        InforNewTask.put("context", "Project");
        InforNewTask.put("project", "Online Course Creation and Launch");
        InforNewTask.put("start_date", "15-02-2024");
        InforNewTask.put("deadline", "01-07-2025");
    }

    private void selectMenu(String menu) {
        driver.findElement(By.xpath("//span[text() = '%s']/parent::a".formatted(menu))).click();
    }

    public void Login(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button")).click();
    }

    public void clearAll() {
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("password")).clear();
    }

    private void addCookies() {
        Cookie cookie = new Cookie.Builder("myCookie", "0a1fe6b98f99dd87da7a44927013ac19")
                .isHttpOnly(true).isSecure(false).build();
        driver.manage().addCookie(cookie);
    }

    @BeforeTest
    public void startBrowser() {
        this.driver = startBrower(KeywordConstant.urlRise, "chrome");
        this.initData();
    }

    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);
    }
}
