package autotest.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import autocom.common.CommonPage;
import java.nio.file.Paths;


public class SchoolManagementPage extends CommonPage {

    public SchoolManagementPage() {
        // TODO Auto-generated constructor stub
    }

    public void goToSchoolManagement() {
        driver.findElement(By.linkText("Trường học")).click();
    }

    // Điền thông tin trường học
    public void enterSchoolDetails(String schoolName, String email, String phone, 
            String slogan, String address, String prefix, 
            String logoPath,
            String adminFirstName, String adminLastName, 
            String adminEmail, String adminPhone, 
            String adminImagePath) {
        driver.findElement(By.name("school_name")).sendKeys(schoolName);
        driver.findElement(By.name("school_support_email")).sendKeys(email);
        driver.findElement(By.name("school_support_phone")).sendKeys(phone);
        driver.findElement(By.name("school_tagline")).sendKeys(slogan);
        driver.findElement(By.name("school_address")).sendKeys(address);
        driver.findElement(By.name("domain")).sendKeys(prefix);

        // Tải lên logo trường học
        String absoluteLogoPath = Paths.get(logoPath).toAbsolutePath().toString();
        WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
        uploadElement.sendKeys(absoluteLogoPath);

        driver.findElement(By.name("admin_first_name")).sendKeys(adminFirstName);
        driver.findElement(By.name("admin_last_name")).sendKeys(adminLastName);
        driver.findElement(By.name("admin_email")).sendKeys(adminEmail);
        driver.findElement(By.name("admin_contact")).sendKeys(adminPhone);

        // Tải lên ảnh quản trị viên
        String absoluteAdminImagePath = Paths.get(adminImagePath).toAbsolutePath().toString();
        WebElement adminImageUpload = driver.findElement(By.xpath("(//input[@type='file'])[2]"));
        adminImageUpload.sendKeys(absoluteAdminImagePath);
    }
    

    public void saveSchool() {
        driver.findElement(By.id("create-btn")).click();
    } 
}
