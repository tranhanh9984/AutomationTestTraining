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

public class Client extends CommonPage {
    private HashMap<String, String> infoNewClient = new HashMap<>();

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
        this.login("admin@demo.com", "riseDemo");
    }

    @Test(dependsOnMethods = "testLogin")
    public void testAddClient() {
        selectMenu("Clients");
        addClient();
        pause(2);
    }

    @Test(dependsOnMethods = "testAddClient")
    public void testEditClient() {
        selectMenu("Clients");
        searchClient(infoNewClient.get("companyName"));
        editClient();
        pause(2);
    }

    @Test(dependsOnMethods = "testEditClient")
    public void testDeleteClient() {
        selectMenu("Clients");
        searchClient(infoNewClient.get("companyName"));
        driver.findElement(By.xpath("//a[@title='Delete client' and contains(@class, 'delete')]")).click();
        pause(2);
        driver.findElement(By.id("confirmDeleteButton")).click();
        pause(2);
    }

    private void addClient() {
        driver.findElement(By.linkText("Add client")).click();
        driver.findElement(By.id("company_name")).sendKeys(infoNewClient.get("companyName"));
        driver.findElement(By.id("address")).sendKeys(infoNewClient.get("address"));
        driver.findElement(By.id("city")).sendKeys(infoNewClient.get("city"));
        driver.findElement(By.id("state")).sendKeys(infoNewClient.get("state"));
        driver.findElement(By.id("zip")).sendKeys(infoNewClient.get("zip"));
        driver.findElement(By.id("country")).sendKeys(infoNewClient.get("country"));
        driver.findElement(By.id("phone")).sendKeys(infoNewClient.get("phone"));
        driver.findElement(By.id("website")).sendKeys(infoNewClient.get("website"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private void editClient() {
        driver.findElement(By.xpath("//a[@class='edit' and @title='Edit client']")).click();
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("TP HCM");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    private void searchClient(String keyword) {
        clickClientTab();
        By searchInput = By.xpath("//input[@placeholder='Search' and @aria-controls='client-table']");
        driver.findElement(searchInput).clear();
        driver.findElement(searchInput).sendKeys(keyword, Keys.ENTER);
        pause(2);
    }

    private void clickClientTab() {
        driver.findElement(By.xpath("//a[contains(@data-bs-toggle, 'tab') and contains(text(), 'Clients')]")).click();
        pause(2);
    }

    private void selectMenu(String menu) {
        driver.findElement(By.xpath("//span[text()='%s']/parent::a".formatted(menu))).click();
    }

    private void initData() {
        infoNewClient.put("companyName", "CodeStar_" + System.currentTimeMillis());
        infoNewClient.put("address", "Hà Nội");
        infoNewClient.put("city", "Hà Nội");
        infoNewClient.put("state", "HN");
        infoNewClient.put("zip", "1234");
        infoNewClient.put("country", "Việt Nam");
        infoNewClient.put("phone", "123456789");
        infoNewClient.put("website", "https://facebook.com");
    }

    public void login(String username, String password) {
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
