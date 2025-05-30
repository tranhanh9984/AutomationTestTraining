package TCRise;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import auto.page.Rise.HomePageRise;
import autocom.common.commonPage;
import autocom.constant.KeywordConstant;

public class autoRise {

    HomePageRise homepage;
    WebDriver driver;
    

    @BeforeTest
//    @Parameters("browser")
    public void setup() { //(@Optional("chrome") String browser)
        commonPage common = new commonPage();
        driver = common.startBrower(KeywordConstant.urlproject, "chrome");
        homepage = new HomePageRise(driver);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginAndAddProject() {
        homepage.loginPage(KeywordConstant.usernameproject, KeywordConstant.passwordproject);
        homepage.clickLogin();

        // Đợi trang load sau login, bạn có thể thêm wait để chắc chắn
        sleep(5000);

        homepage.clickMenuProjects();

        sleep(2000);

        homepage.clickAddProject();

        sleep(2000);

        homepage.fillProjectForm(
                "Dự án thử nghiệm",
                "2025-06-01",
                "2025-07-01",
                "15000",
                "Mô tả cho dự án thử nghiệm"
        );

        sleep(3000);
        
        homepage.clickSaveButton();

        sleep(2000);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
