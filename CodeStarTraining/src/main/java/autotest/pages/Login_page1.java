package autotest.pages;

import autocom.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Login_page1 extends CommonPage {
    WebDriver driver;

    @BeforeTest
    public void startPage() {
        driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");
    }

    @AfterTest
    public void closePage() {
        this.closeBrowser(driver);
    }

    @Test
    public void testLogin() {
        WebElement username = driver.findElement(By.id("companyUsername"));
        WebElement password = driver.findElement(By.id("password"));

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='taxCode']"));

        username.sendKeys("caonv174@gmail.com");
        password.sendKeys("123456");

        WebElement taxcode = driver.findElement(By.id("taxCode"));
        taxcode.sendKeys("0312303803-999");
        loginButton.click();

//        // Wait for the expected URL
//        String expectedUrl = "https://v2.vietinvoice.vn/hoa-don-dau-ra/ban-lam-viec";
//        WebDriverWait wait = new WebDriverWait(driver, 5000);
//        wait.until(ExpectedConditions.urlToBe(expectedUrl));
         pause(40000);
//        String actualUrl = driver.getCurrentUrl();
//        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
