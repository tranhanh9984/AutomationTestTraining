package autotest.testcases.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.*;

public class LoginTestcases extends CommonPage{

	
	LoginPageAdmin login;
	PageTruongHoc truongHoc;
	EditTruongHoc editTruongHoc;
	PageGoiHoc taoGoiHoc;
	public LoginTestcases() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void loginadmin() {
		login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
	
		truongHoc.ClickTruongHoc();
		truongHoc.TaoMoiTruongHoc(KeywordConstant.schoollogoAd, KeywordConstant.logoAd);
		truongHoc.ClickTaoMoi();
		//editTruongHoc.editTruongHoc(); chưa nhấn được vào dropdown
		taoGoiHoc.clickGoiHoc();
		taoGoiHoc.dienThongTinGoiHoc();
		//taoGoiHoc.chonTinhNang(); đang lỗi chưa chạy được
		taoGoiHoc.nhanTaoGoi();
		
	}
	
	
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd+"login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
		
		truongHoc = new PageTruongHoc();
		truongHoc.driver = driver;
		editTruongHoc = new EditTruongHoc();
		editTruongHoc.driver = driver;
		taoGoiHoc = new PageGoiHoc();
		taoGoiHoc.driver = driver;
	}
	
	@AfterTest
	public void closeBrowser() {
	//	this.closeBrowser(driver);
		
	}

}
