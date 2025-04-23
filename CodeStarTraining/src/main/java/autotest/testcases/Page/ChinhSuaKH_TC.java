package autotest.testcases.Page;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.Page.ChinhSuaKH;
import autotest.Page.HomePage;
import autotest.Page.KhachHang;
import autotest.Page.LoginPage;
import autotest.Page.TaomoiKH;

public class ChinhSuaKH_TC extends CommonPage {
	LoginPage login;
    HomePage homePage;
    KhachHang khachhang;
    TaomoiKH taomoikh;
    ChinhSuaKH chinhSuaKH;
    WebDriver driver;
    
    @Test (priority =1)
    public void thayDoiLoaiKHSuccess() {
    	khachhang.clickChinhSua("[2]");
    	chinhSuaKH.thayDoiLoaiKH("Nguyen Van Nguyen");
    	pause(1);
    	String text = khachhang.getmsgthanhcong();
    	 Assert.assertEquals(text, "Thành công!");
    }
    
    @Test (priority =2)
    //nhap toan dau cach
    public void thayDoiLoaiKHFail() {
    	khachhang.clickChinhSua("[3]");
    	chinhSuaKH.thayDoiLoaiKH(" ");
    	pause(2);
    	String text = chinhSuaKH.getmsgTenNguoiMua();
 	    Assert.assertEquals(text, "Tên người mua là cá nhân phải gồm tối thiểu 2 từ");
    }
    
    @Test (priority =3)
    //bo trong ten khach hang
    public void thayDoiLoaiKHFail2() {
    	khachhang.clickChinhSua("[7]");
    	chinhSuaKH.thayDoiLoaiKH("");
    	String text = chinhSuaKH.getmsgKhongDuocDeTrong();
    	 Assert.assertEquals(text, "Trường không được để trống.");
    }
    
    @Test (priority =4)
    public void thayDoiTenKHSucess() {
    	homePage.clickkhachhang();
    	khachhang.clickChinhSua("[5]");
    	chinhSuaKH.thayDoiTenKH("Ha ha ha");
    	pause(2);
    	String text = khachhang.getmsgthanhcong();
   	    Assert.assertEquals(text, "Thành công!");
    }
    
    @Test (priority =5)
    //bo trong ten khach hang
    public void thayDoiTenKHFail() {
    	homePage.clickkhachhang();
    	khachhang.clickChinhSua("[5]");
    	chinhSuaKH.thayDoiTenKH(" ");
    	pause(1);
    	String text = chinhSuaKH.getmsgTenNguoiMua();
   	 Assert.assertEquals(text, "Tên người mua là cá nhân phải gồm tối thiểu 2 từ");
    }
    @Test (priority =6)
    //bo trong ten khach hang
    public void thayDoiMaKHSuccess() {
    	homePage.clickkhachhang();
    	khachhang.clickChinhSua("[5]");
    	chinhSuaKH.thayDoiMaKH("1122");
    	pause(2);
    	String text = khachhang.getmsgthanhcong();
   	    Assert.assertEquals(text, "Thành công!");
    }
    @Test (priority =7)
    //bo trong ten khach hang
    public void thayDoiMaKHFail() {
    	homePage.clickkhachhang();
    	khachhang.clickChinhSua("[5]");
    	chinhSuaKH.thayDoiMaKH(" ");
    	pause(2);
    	String text = chinhSuaKH.getmsgKhongDungDinhDang();
   	 Assert.assertEquals(text, "Định dạng không hợp lệ.");
    }
    
    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.hoaDonUrl, KeywordConstant.BROWSER);

        login = new LoginPage(driver);
        homePage = new HomePage();
        homePage.driver= driver;
        khachhang = new KhachHang();
        khachhang.driver = driver;
        chinhSuaKH = new ChinhSuaKH();
        chinhSuaKH.driver = driver;
        login.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
        homePage.clickkhachhang();
        

    }

    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);

    }

}
