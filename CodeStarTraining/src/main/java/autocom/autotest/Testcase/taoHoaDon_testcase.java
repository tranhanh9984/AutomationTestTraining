package autocom.autotest.Testcase;

import autocom.common.CommonFuncs;
import autocom.common.CommonPage;
import autotest.pages.DanhSachHoaDon;
import autotest.pages.HomePage;
import autotest.pages.SignInPage;
import autotest.pages.TaoHoaDon;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import autocom.constant.KeywordConstant;

public class taoHoaDon_testcase extends CommonPage {
    private WebDriver driver;
    private CommonFuncs commonFuncs;
    public SignInPage signInPage;
    public HomePage homePage;
    private TaoHoaDon taoHoaDon;
    private DanhSachHoaDon danhSachHoaDon;



    @BeforeTest
    public void startPage() {
        driver = this.startBrower("https://v2.vietinvoice.vn/dang-nhap", "chrome");
    }

    @AfterTest
    public void closePage() {
        this.closeBrowser(driver);
    }

    @Test
    public void TaoHoaDon() throws Exception{
        signInPage = new SignInPage(driver);
        homePage = signInPage.sigin();
        pause(4000);
        //Assert.assertTrue(homePage.verifySignInPageTitle());
        taoHoaDon = homePage.taoHD();
        pause(400);
        danhSachHoaDon = taoHoaDon.luu("Nguyễn Thị Cẩm Ly","0899054389", "098765", "VietComBank");
        pause(40000);
      //  danhSachHoaDon.Loctheongay();
      //  pause(40000);

    }

}
