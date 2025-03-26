package autotest.testcases.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.*;

public class SchoolTestcases extends CommonPage {
    LoginPageAdmin login;
    SchoolPageAdmin schoolPage;

    @BeforeTest
    public void setUp() {
        driver = this.startBrower(KeywordConstant.urlAd + "login", KeywordConstant.BROWSER);
        login = new LoginPageAdmin();
        schoolPage = new SchoolPageAdmin();
        
        login.driver = driver;
        schoolPage.driver = driver;

        loginAsAdmin();
    }

    public void loginAsAdmin() {
        login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
        login.clickLogin();
        pause(10);
    }

    @Test
    public void testCreateNewSchool() {
        schoolPage.clickSchoolMenu();
        schoolPage.enterSchoolInfo("Trường THPT ABC", "contact@abc.edu.vn", "0987654321", "Học tập - Sáng tạo", "123 Đường Nguyễn Văn A, Quận 1, TP.HCM");

        schoolPage.uploadSchoolLogo("C:\\Users\\Admin\\Downloads\\school_logo.png");

        schoolPage.enterAdminInfo("Nguyễn", "Văn A", "0123456789", "admin@abc.edu.vn");

        schoolPage.uploadAdminImage("C:\\Users\\Admin\\Downloads\\qtv.jpeg");

        schoolPage.clickCreateSchool();

        pause(5000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
