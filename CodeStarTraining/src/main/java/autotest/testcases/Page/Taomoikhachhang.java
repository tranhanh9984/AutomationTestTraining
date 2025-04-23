package autotest.testcases.Page;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.Page.HomePage;
import autotest.Page.KhachHang;
import autotest.Page.LoginPage;
import autotest.Page.TaomoiKH;

public class Taomoikhachhang extends CommonPage {
    LoginPage login;
    HomePage homePage;
    KhachHang khachhang;
    TaomoiKH taomoikh;
    WebDriver driver;
     
     @Test(priority = 2)
     public void clickkhachhang() {
    	 homePage.clickkhachhang();
    	 String text = homePage.gettextKH();
    	 pause(2);
    	 Assert.assertEquals(text, "Tên khách hàng");
     }
     @Test(priority = 3)
     public void clicktaomoi() {
    	khachhang.clickTaomoi();
    	 String text = khachhang.gettextTaomoi();
    	 pause(2);
    	 Assert.assertEquals(text, "Tạo mới");
     }
   
     @Test(priority = 4)
    public void taomoithanhcong() {
    	taomoikh.TaomoitochucTC();
    	taomoikh.clicktaomoi();
    	String text = khachhang.getmsgthanhcong();
   	    pause(2);
    	Assert.assertEquals(text, "Thành công!");
    	String textKH = khachhang.getTenKhachHang();
    	Assert.assertEquals(textKH, "Hoang Minh");	
     }
     @Test(priority = 5)
     public void taomoithatbai() {
    	khachhang.clickTaomoi();
     	taomoikh.TaomoitochucTC();
     	taomoikh.clicktaomoi();
     	String text = khachhang.getmsgerror();
    	 pause(2);
    	Assert.assertEquals(text, "Có lỗi xảy ra...");
      }
     
     @BeforeTest
     public void startBrowser() {
         driver = this.startBrower(KeywordConstant.hoaDonUrl, KeywordConstant.BROWSER);

         login = new LoginPage(driver);
         homePage = new HomePage();
         homePage.driver= driver;
         khachhang = new KhachHang();
         khachhang.driver = driver;
         taomoikh = new TaomoiKH();
         taomoikh.driver = driver;
         login.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);

     }

     @AfterTest
     public void closeBrowser() {
         this.closeBrowser(driver);

     }
     }