package autotest.pages.admin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import autocom.common.CommonPage;

import org.openqa.selenium.By;


public class PackagePage extends CommonPage {
       
	 public PackagePage() {
	        // Constructor mặc định
	    }
	public void createPackage(String name, String description, String days, String studentCharge, String staffCharge) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.xpath("//label[contains(text(),'Loại')]/following::input[@id='postpaid']")).click();
        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("description")).sendKeys(description);
        driver.findElement(By.name("days")).sendKeys(days);
        driver.findElement(By.name("student_charge")).sendKeys(studentCharge);
        driver.findElement(By.name("staff_charge")).sendKeys(staffCharge);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1000);");

        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='Quản lý website']")));
        checkbox.click();

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("create-btn")));
        submitButton.click();
    }

}
