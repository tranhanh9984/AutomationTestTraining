package autotest.pages;

import autocom.common.*;
import autocom.common.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import autocom.common.CommonFuncs;

public class TestVietTinVoice extends CommonPage {
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

    @Test(priority = 1)
    public void signIn() throws Exception{
        System.out.println(driver);
        signInPage = new SignInPage(driver);
        homePage = signInPage.sigin("caonv174@gmail.com","123456","0312303803-999");
        pause(4000);
    }

    @Test(priority = 2)
    public void openTaoHoaDon() throws Exception{
        //Assert.assertTrue(homePage.verifySignInPageTitle());
        taoHoaDon = homePage.taoHD();
        pause(40);

    }

    @Test(priority = 3)
    public void LuuHoaDon() throws Exception{

       danhSachHoaDon = taoHoaDon.luu("Nguyễn Thị Cẩm Ly", "0899054389", "098765", "VietComBank");
        pause(400);

    }

    @Test(priority = 4)
    public void kiemTraHoaDonTrongDanhSach() throws Exception{
       danhSachHoaDon.Loctheongay();
       pause(40000);
    }



}
