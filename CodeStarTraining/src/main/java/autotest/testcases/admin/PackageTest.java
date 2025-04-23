package autotest.testcases.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.LoginPageAdmin;
import autotest.pages.admin.Homepage;
import autotest.pages.admin.PackagePage;

public class PackageTest extends CommonPage {

	private WebDriver driver;
    private LoginPageAdmin login;
    private Homepage homepage;
    private PackagePage packagePage;

    @BeforeTest
    public void setUp() {
        driver = this.startBrower(KeywordConstant.urlAd + "login", KeywordConstant.BROWSER);
        login = new LoginPageAdmin();
		login.driver = driver;

        homepage = new Homepage();
		homepage.driver = driver;

        packagePage = new PackagePage();
        packagePage.driver = driver;
    }

    @Test
    public void testCreatePackage() {
        login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
        login.clickLogin();
        
        homepage.clickMenu("Gói");
        homepage.click_tao("Tạo gói");
 
        packagePage.createPackage("Gói chuyên môn Toán", "Gói chuyên môn dành cho chuyên Toán", "25", "3000000", "2500000");
		pause(5);

        driver.get("https://f-class.site/package/");
 
    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }

}
