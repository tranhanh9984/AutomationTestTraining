package autotest.buoi8;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class Bai1 extends CommonPage {

    private HashMap<String, String> infoNewProject = new HashMap<>();

    @BeforeTest
    public void startBrowser() {
        this.driver = startBrower(KeywordConstant.urlRise, "chrome");
        this.initData();
    }

    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);
    }

    @Test
    public void testLogin() {
        addCookies();
        clearAll();
        this.Login("admin@demo.com", "riseDemo");
    }

    @Test(dependsOnMethods = "testLogin")
    public void testAddProject() {
        selectMenu("Projects");
        addProject();
        pause(3);
    }

    @Test(dependsOnMethods = "testAddProject")
    public void testEditProject() {
        selectMenu("Projects");
        searchProject(infoNewProject.get("title"));
        editProject();
        pause(3);
    }

    @Test(dependsOnMethods = "testEditProject")
    public void testDeleteProject() {
        selectMenu("Projects");
        searchProject(infoNewProject.get("title"));
        deleteProject();
        pause(3);
    }

    private void addProject() {
        driver.findElement(By.linkText("Add project")).click();

        driver.findElement(By.name("title")).sendKeys(infoNewProject.get("title"));
        driver.findElement(By.id("description")).click();
        driver.findElement(By.className("note-editable")).sendKeys(infoNewProject.get("description"));
        driver.findElement(By.id("start_date")).sendKeys(infoNewProject.get("start_date"));
        driver.findElement(By.id("deadline")).sendKeys(infoNewProject.get("deadline"));
        driver.findElement(By.id("price")).sendKeys(infoNewProject.get("price"));
        driver.findElement(By.xpath("//label[text()='Labels']/following-sibling::input"))
              .sendKeys(infoNewProject.get("label"), Keys.ENTER);

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private void editProject() {
        driver.findElement(By.xpath("//a[@class='edit' and @title='Edit project']")).click();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys("50000");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private void deleteProject() {
        driver.findElement(By.xpath("//a[@class='delete' and @title='Delete project']")).click();
        driver.findElement(By.id("confirmDeleteButton")).click();
    }

    private void searchProject(String projectTitle) {
        driver.findElement(By.xpath("//input[@placeholder='Search' and @aria-controls='project-table']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Search' and @aria-controls='project-table']"))
              .sendKeys(projectTitle, Keys.ENTER);
    }

    private void selectMenu(String menu) {
        driver.findElement(By.xpath("//span[text()='%s']/parent::a".formatted(menu))).click();
    }

    private void initData() {
        infoNewProject.put("title", "Automation Testing");
        infoNewProject.put("description", "Automation Testing Description");
        infoNewProject.put("start_date", "15-02-2024");
        infoNewProject.put("deadline", "01-07-2025");
        infoNewProject.put("price", "720000");
        infoNewProject.put("label", "Upcoming");
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
                .isHttpOnly(true)
                .isSecure(false)
                .build();
        driver.manage().addCookie(cookie);
    }

    private void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
