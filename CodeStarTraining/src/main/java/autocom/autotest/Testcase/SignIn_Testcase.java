package autocom.autotest.Testcase;

import autocom.common.CommonPage;
import autotest.pages.HomePage;
import autotest.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignIn_Testcase extends CommonPage {
    private WebDriver driver;
    public SignInPage signInPage;
    public HomePage homePage;

    @BeforeTest
    public void startPage() {
        driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");
    }

    @AfterTest
    public void closePage() {
        this.closeBrowser(driver);
    }

    @Test
    public void signIn() throws Exception{
        System.out.println(driver);
        signInPage = new SignInPage(driver);
        homePage = signInPage.sigin();
        pause(40000);
    }


}
