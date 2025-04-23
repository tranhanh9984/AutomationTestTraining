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

public class UploadExcel_TC extends CommonPage {
	LoginPage login;
    HomePage homePage;
    KhachHang khachhang;
    WebDriver driver;
    
    @Test (priority =1)
    public void UploadSucess() {
    	khachhang.clickUploadExcel("C:\\Users\\pc\\Downloads\\mau-import-khach-hang.xlsx");
    	pause(1);
    	String text = khachhang.getTenKhachHang();
    	Assert.assertEquals(text, "Công ty TNHH Test 4");
    }
    
    @Test (priority =2)
    //file sai dinh dang
    public void UploadFail() {
    	khachhang.clickUploadExcel("C:\\Users\\pc\\Desktop\\Danh sach.xlsx");
    	pause(1);
    }
    
    @BeforeTest
    public void startBrowser() {
        driver = this.startBrower(KeywordConstant.hoaDonUrl, KeywordConstant.BROWSER);
        login = new LoginPage(driver);
        homePage = new HomePage();
        homePage.driver= driver;
        khachhang = new KhachHang();
        khachhang.driver = driver;
        login.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
        homePage.clickkhachhang();
        

    }

    @AfterTest
    public void closeBrowser() {
        this.closeBrowser(driver);

    }

}
