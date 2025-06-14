package autotest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;

public class testXpath extends CommonPage {

    @BeforeTest
    public void startBrowser() {
        this.driver = startBrower(KeywordConstant.sltHub, "chrome");
    }

    @Test
    public void fill() {
    	Actions actions = new Actions(driver);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("tngan03@gmail.com");
        driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("12345678");
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Google");
        driver.findElement(By.xpath("//input[@name='mobile number']")).sendKeys("0339885125");

        driver.findElement(By.xpath("//button[@value='Submit']")).click();

        driver.findElement(By.xpath("//input[@title='Enter your first crush name']")).sendKeys("C012345");

        actions.moveToElement(driver.findElement(By.xpath("//button[text()='Checkout here']"))).perform();

        driver.findElement(By.xpath("//div[@class='dropdown-content']/a[1]")).click();

        driver.findElement(By.xpath("//select[@id='cars']")).click();
        driver.findElement(By.xpath("//select[@id='cars']/option[text()='Audi']")).click();

        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10-06-2000");
        driver.findElement(By.xpath("//input[@name='the_date']")).sendKeys("10-06-2000");
    }

    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);
    }
}
