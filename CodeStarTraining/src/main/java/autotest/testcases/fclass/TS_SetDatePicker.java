package autotest.testcases.fclass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import java.time.Duration;

public final class TS_SetDatePicker extends CommonPage {

    @BeforeMethod
    public void init() {
        driver = this.startBrower(KeywordConstant.xPathPage, KeywordConstant.BROWSER);
    }

    @Test
    public void testSetDatePicker() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Actions actions = new Actions(driver);
        
        // Fill User Email
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("test@example.com");

        // Fill Password
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("password123");

        // Fill Company
        WebElement companyField = driver.findElement(By.name("company"));
        companyField.sendKeys("Test Company");

        // Fill Mobile Number
        WebElement mobileField = driver.findElement(By.name("mobile number"));
        mobileField.sendKeys("1234567890");

        // Click to enable name fields
        WebElement editIcon = driver.findElement(By.cssSelector("[onclick='nameField()']"));
        editIcon.click();

        // Fill First Enter Name
        WebElement firstNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='First Enter name']")));
        firstNameField.sendKeys("Bui");

        // Enable Last Name
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Last name']")));
        js.executeScript("arguments[0].removeAttribute('disabled');", lastNameInput);
        lastNameInput.sendKeys("Huong");

        // First Crush
        WebElement crushField =driver.findElement(By.id("inp_val"));
        crushField.sendKeys("Jane");

        WebElement dateInput = driver.findElement(By.name("the_date"));
        dateInput.sendKeys("12/20/2024");
        
        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.clear();
        datepicker.sendKeys("12/20/2024");
        
        pause(10);
        closeBrowser(driver);
    }
}