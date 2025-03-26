package autotest.pages.admin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autocom.common.CommonPage;

public class SchoolPageAdmin extends CommonPage {
    public SchoolPageAdmin() {
    }

    public void clickSchoolMenu() {
        driver.findElement(By.xpath("//span[text()='Trường học']/ancestor::a")).click();
    }
    
    public void enterSchoolInfo(String name, String email, String phone, String slogan, String address) {
        driver.findElement(By.id("school_name")).sendKeys(name);
        driver.findElement(By.id("school_support_email")).sendKeys(email);
        driver.findElement(By.id("school_support_phone")).sendKeys(phone);
        driver.findElement(By.id("school_tagline")).sendKeys(slogan);
        driver.findElement(By.id("school_address")).sendKeys(address);
    }

    public void uploadSchoolLogo(String filePath) {
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file' and contains(@class, 'file-upload-default') and @id='school_image']"));
        fileInput.sendKeys(filePath);
    }

    public void enterAdminInfo(String firstName, String lastName, String contact, String email) {
        driver.findElement(By.id("admin_first_name")).sendKeys(firstName);
        driver.findElement(By.id("admin_last_name")).sendKeys(lastName);
        driver.findElement(By.id("admin_contact")).sendKeys(contact);
        driver.findElement(By.id("admin_email")).sendKeys(email);
    }

    public void uploadAdminImage(String filePath) {
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file' and contains(@class, 'file-upload-default') and @name='admin_image']"));
        fileInput.sendKeys(filePath);
    }

    public void clickCreateSchool() {
        driver.findElement(By.id("create-btn")).click();
    }
}
