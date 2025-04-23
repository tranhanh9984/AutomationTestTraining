package autotest.testcases.Page;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.Page.HomePage;
import autotest.Page.LoginPage;
import autotest.Page.ChinhSuaHD;
import autotest.Page.HoaDon;

public class ChinhSuaHD_TC extends CommonPage {
    LoginPage login;
    HomePage homePage;
    HoaDon hoaDon;
    ChinhSuaHD chinhSuaHD;
    WebDriver driver;
    
    String errorExpect = "Có lỗi xảy ra...";
    String successExpect = "Thành công!";
    
     @Test(priority = 1)
     public void chinhSuaMSTValid() {
       hoaDon.chonHD();
    	 chinhSuaHD.chinhSuaMST();
    	 String textTenDV = chinhSuaHD.getTenDonVi();
    	 String textMST = chinhSuaHD.getMST();
    	 pause(1);
    	 Assert.assertEquals(textTenDV, "Hoang Minh");
    	 Assert.assertEquals(textMST, "0001000999");
       chinhSuaHD.clickLuu();
       pause(1);
     }
     
     @Test(priority = 7)
     public void chinhSuaMSTInvalid() {
       hoaDon.chonHD();
    	 chinhSuaHD.chinhSuaMSTInvalid("55500");
    	 String text = chinhSuaHD.getError();
    	 pause(1);	
    	 Assert.assertEquals(text, errorExpect);
       chinhSuaHD.clickLuu();
     }
     
     @Test (priority =2)
     public void chinhSuaMailValid() {
    	 hoaDon.chonHD();
    	 chinhSuaHD.chinhSuaMail("sample1@test.com");
    	 pause(1);
    	 String text = chinhSuaHD.getMsg();
    	 Assert.assertEquals(text, successExpect);
    	 pause(1);
     }
     @Test (priority =8)
     public void chinhSuaMailInValid() {
    	 homePage.clickHDBanHang();
	     hoaDon.chonHD();
    	 homePage.clickHDBanHang();
    	 hoaDon.chonHD();
    	 chinhSuaHD.chinhSuaMail("hahaha");
    	 pause(1);
    	 String text = chinhSuaHD.getError();
    	 Assert.assertEquals(text, errorExpect);
     }
     @Test (priority =5)
     public void chinhSuaSLValid() {
    	 hoaDon.chonHD();
    	 pause(1);
    	 chinhSuaHD.chinhSuaSL("5");
    	 pause(1);
    	 String donGia = chinhSuaHD.getDonGia();
    	 donGia = donGia.replace(",", ""); //thay the dau ,
    	 int dongia = Integer.parseInt(donGia);// chuyen doi thanh int
    	 int TongTien = (dongia*5);
    	 
    	 String text = chinhSuaHD.getThanhTien();
    	 text = text.replace(",", "");
    	 int num2 = Integer.parseInt(text);
    	 Assert.assertEquals(num2, TongTien);
    	 chinhSuaHD.clickLuu();
    	 pause(1);
     }
    @Test (priority = 6)
    public void chinhSuaMucThue() {
    	hoaDon.chonHD();
    	chinhSuaHD.chinhSuaThue("5%");
    	String tongTienHang = chinhSuaHD.getTongTienHang();
    	tongTienHang = tongTienHang.replace(",", ""); //thay the dau ,
   	    int tongTien = Integer.parseInt(tongTienHang);// chuyen doi thanh int
   	    int thueExpect = (tongTien*5/100);
    	String tienThue = chinhSuaHD.getTienThue();
    	tienThue = tienThue.replace(",", ""); //thay the dau ,
      	 int thueActual = Integer.parseInt(tienThue);// chuyen doi thanh int
      	 Assert.assertEquals(thueActual, thueExpect);
    	}
     
     @Test (priority =6)
     public void chinhSuaSLInvalid() {
    	 hoaDon.chonHD();
    	 chinhSuaHD.chinhSuaSL("");
    	 pause(1);
    	 String donGia = chinhSuaHD.getDonGia();
    	 donGia = donGia.replace(",", ""); //thay the dau ,
    	 int dongia = Integer.parseInt(donGia);// chuyen doi thanh int
    	 int TongTien = (dongia*5);
    	 
    	 String text = chinhSuaHD.getThanhTien();
    	 text = text.replace(",", "");
    	 int num2 = Integer.parseInt(text);
    	 Assert.assertEquals(num2, TongTien);
    	 chinhSuaHD.clickLuu();
    	 pause(1);
     }
    @Test
    public void ThemHangHoa() {
    	hoaDon.chonHD();
    	chinhSuaHD.themMatHang();
    	chinhSuaHD.chinhSuaSLNhieuSP("4");
    	int TongTienExpected = chinhSuaHD.tinhTongTien();
    	int TongTienActual = chinhSuaHD.getTongTien();
    	Assert.assertEquals(TongTienActual, TongTienExpected);
    }
     

     @BeforeTest
        public void startBrowser() {
            driver = this.startBrower(KeywordConstant.hoaDonUrl, KeywordConstant.BROWSER);

            login = new LoginPage(driver);
            homePage = new HomePage();
            homePage.driver= driver;
            hoaDon = new HoaDon();
            hoaDon.driver = driver;
            chinhSuaHD = new ChinhSuaHD();
            chinhSuaHD.driver = driver;
            login.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
            homePage.clickHDBanHang();  
            

        }

        @AfterTest
        public void closeBrowser() {
            this.closeBrowser(driver);

        }

}