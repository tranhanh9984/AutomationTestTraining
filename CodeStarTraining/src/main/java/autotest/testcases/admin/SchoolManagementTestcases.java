package autotest.testcases.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.LoginPageAdmin;
import autotest.pages.admin.SchoolManagementPage;

public class SchoolManagementTestcases extends CommonPage {

    LoginPageAdmin login;
    SchoolManagementPage schoolPage;

    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.urlAd + "login", KeywordConstant.BROWSER);
        login = new LoginPageAdmin();
        login.driver = driver;
        schoolPage = new SchoolManagementPage();
        schoolPage.driver = driver;
    }

    @Test(priority = 1)
    public void loginAsSuperAdmin() {
        login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
        login.clickLogin();
        pause(5);
    }

    @Test(priority = 2)
    public void createNewSchool() {
        schoolPage.goToSchoolManagement();
        pause(3);
        
        // Gọi đúng hàm với đầy đủ tham số
        schoolPage.enterSchoolDetails(
            "Trường ABC", "abc@example.com", "0123456789", "Học tập sáng tạo", 
            "123 Đường ABC, TP.HCM", "abc", 
            "C:\\Users\\Admin\\Pictures\\Camera Roll\\test.jpg",  
            "Nguyễn", "Văn A", 
            "admin@example.com", "0987654321", 
            "C:\\Users\\Admin\\Pictures\\Camera Roll\\test.jpg" 
        );
        
        schoolPage.saveSchool();
        pause(20);
    }


    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);
    }
}
