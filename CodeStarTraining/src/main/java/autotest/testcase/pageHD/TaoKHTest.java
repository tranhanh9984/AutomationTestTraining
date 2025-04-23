package autotest.testcase.pageHD;

import autocom.common.CommonPage;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.*;
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pagesHD.HomePage;
import autotest.pagesHD.LoginPage;
import autotest.pagesHD.Tao_KH;

public class TaoKHTest extends CommonPage {
	Tao_KH kh;
	LoginPage loginPage;
//	HomePage homePage;

	public TaoKHTest() {
		// TODO Auto-generated constructor stub
	}
	@BeforeTest
	public void startBrowser() {
	    driver = this.startBrower(KeywordConstant.urlHD, KeywordConstant.BROWSER);
	    loginPage = new LoginPage(driver);
 	    kh = new Tao_KH(driver);
 	   loginPage.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
       kh.openMenu();
//	    homePage = new HomePage();
//	    homePage.driver = driver;
	}
	@Test(priority = 1)
    public void testTaoKhachHangThanhCong() {
//		loginPage.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
		kh.ButtonTaomoi();
		kh.LoaiKH("Cá nhân");
		kh.NhapThongTinKH("KH01301", "12344456789", "Nguyễn Văn An", "Hà Nội", 
				"1234567890", "Vietcombank", "125gg@example.com", "09312345678");
		kh.DangKy();
	   String text = kh.SuccessMessage();
	   String expectedMessage = "Dữ liệu đã được cập nhật!";
	   pause(1);
	   Assert.assertEquals(text, expectedMessage);
	   pause(3);

		 
	}

	@Test(priority = 2)
    public void testTaoKhachHangThatBai() {
		kh.ButtonTaomoi();
        kh.LoaiKH("Cá nhân");
        kh.NhapThongTinKH("00001", "123456789", "Nguyễn Văn A", "Hà Nội", "1234567890", 
        		"Vietcombank", "eqqmail@example.com", "0912345678");
        kh.DangKy();
        
        String actualErrorMessage = kh.getErrorMessage();
 	   String expectedErrorMessage = "Mã khách hàng 00001 đã tồn tại";

 	   pause(2);

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
	
	@AfterTest
	public void closeBrowser() {
	    this.closeBrowser(driver);
	}
}
