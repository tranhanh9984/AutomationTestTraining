package autotest.testcases.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.LoginPageAdmin;
import autotest.pages.admin.CreateGoiHoc;

public class CreateGoiHocTestcases extends CommonPage {

    LoginPageAdmin login;
    CreateGoiHoc taoGoiHoc;

    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.urlAd + "login", KeywordConstant.BROWSER);
        login = new LoginPageAdmin();
        login.driver = driver;
        
        taoGoiHoc = new CreateGoiHoc();
        taoGoiHoc.driver = driver;
    }

    @Test
    public void loginAndCreateGoiHoc() {
        login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
        login.clickLogin();

        taoGoiHoc.clickGoiHoc();
        pause(5); 
        taoGoiHoc.dienThongTinGoiHoc();
        pause(10); 
        taoGoiHoc.nhanTaoGoi();
        pause(20); 
    }

    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);
    }
}
