package autotest.testcase.pageHD;
import autocom.common.CommonPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;
import java.util.*;

 import autocom.constant.KeywordConstant;
import autotest.pagesHD.HomePage;
import autotest.pagesHD.LoginPage;
import autotest.pagesHD.Tao_HD;

public class TaoHDTest extends CommonPage {
	Tao_HD hd;
	LoginPage loginPage;
//	HomePage homePage;

	public TaoHDTest() {
		// TODO Auto-generated constructor stub
	}
	@BeforeTest
	public void startBrowser() {
	    driver = this.startBrower(KeywordConstant.urlHD, KeywordConstant.BROWSER);
	    loginPage = new LoginPage(driver);
 	    hd = new Tao_HD(driver);
//	    homePage = new HomePage();
//	    homePage.driver = driver;
	}
	@Test
    public void testTaoMoiHoaDon() {
		loginPage.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
		 hd.TaoHD();
		 hd.ChonMST("123456789");
		 hd.InforText("Duong","11223344");
		 pause(1);
		 hd.ChonHT("Chuyển khoản");
//		 hd.ChonChieKhau("Không chiết khấu");
		 pause(1);
		 hd.ButtonChonHang();
		 List<String> products = Arrays.asList("VA", "002");

		 hd.ChonHangHoas(products);
		 hd.ButtonThem();
		 
		 Map<String, String> totalDiscount = Map.of("Tổng", "10");
         hd.ChonChieKhau("Theo tổng giá trị", totalDiscount);

		 
	}
	
//	@AfterTest
//	public void closeBrowser() {
//	    this.closeBrowser(driver);
//	}
}
