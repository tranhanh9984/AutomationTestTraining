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
import autotest.pagesHD.*;
public class EditKHTest extends CommonPage  {
 	EditKH editkh;
	Tao_KH kh;

	LoginPage loginPage;

	public EditKHTest() {
		// TODO Auto-generated constructor stub
	}
	@BeforeTest
	public void startBrowser() {
	    driver = this.startBrower(KeywordConstant.urlHD, KeywordConstant.BROWSER);
	    loginPage = new LoginPage(driver);
	    editkh = new EditKH(driver);
	    kh = new Tao_KH(driver);
 	    editkh = new EditKH(driver);
 	    loginPage.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
        kh.openMenu();
//	    homePage = new HomePage();
//	    homePage.driver = driver;
	}
	@Test(priority = 1)
    public void testSuaKhachHangThanhCong() {
 		editkh.clickButtonEdit("KH03");

	    Map<String, String> data = new HashMap<>();
	    data.put("address1", "SreG");
	    data.put("emailAddress", "Na1ndinh@example.com");
	    editkh.ThongTinEdit(data);
 		editkh.CapnNhat();
 	   String text = kh.SuccessMessage();
	   String expectedMessage = "Dữ liệu đã được cập nhật!";
 	   Assert.assertEquals(text, expectedMessage);
	   pause(3);
		 
	}

	@Test(priority = 2)
    public void testTaoKhachHangThatBai() {
		editkh.clickButtonEdit("111222");

	    Map<String, String> data1 = new HashMap<>();
	    data1.put("partyName", "Nam");
	    data1.put("emailAddress", "Nandinh@example.com");
	    editkh.ThongTinEdit(data1);
		editkh.CapnNhat();

        String actualErrorMessage = kh.getErrorMessage();
 	   String expectedErrorMessage = "Tên người mua là cá nhân phải gồm tối thiểu 2 từ";

 	   pause(2);

        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
	
	@AfterTest
	public void closeBrowser() {
	    this.closeBrowser(driver);
	}

}

 