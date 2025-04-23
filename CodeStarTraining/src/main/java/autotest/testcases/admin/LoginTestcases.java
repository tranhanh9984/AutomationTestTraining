package autotest.testcases.admin;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
<<<<<<< HEAD
import autotest.pages.admin.*;
=======
import autotest.pages.admin.LoginPageAdmin;
import autotest.pages.admin.TruonghocPage;
>>>>>>> 3d88af4 (BTVN buoi 15)

public class LoginTestcases extends CommonPage{

	
	LoginPageAdmin login;
<<<<<<< HEAD
	PageTruongHoc truongHoc;
	EditTruongHoc editTruongHoc;
	PageGoiHoc taoGoiHoc;
=======
	TruonghocPage truonghocpage;
>>>>>>> 3d88af4 (BTVN buoi 15)
	public LoginTestcases() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void loginadmin() {
		login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
<<<<<<< HEAD
	
		truongHoc.ClickTruongHoc();
		truongHoc.TaoMoiTruongHoc(KeywordConstant.schoollogoAd, KeywordConstant.logoAd);
		truongHoc.ClickTaoMoi();
		//editTruongHoc.editTruongHoc(); chưa nhấn được vào dropdown
		taoGoiHoc.clickGoiHoc();
		taoGoiHoc.dienThongTinGoiHoc();
		//taoGoiHoc.chonTinhNang(); đang lỗi chưa chạy được
		taoGoiHoc.nhanTaoGoi();
		
=======
		truonghocpage.clickTruonghoc();
		truonghocpage.dientttruonghoc();
		truonghocpage.dienttquantrivien();
		truonghocpage.clickGui();
		pause(10);
>>>>>>> 3d88af4 (BTVN buoi 15)
	}
	
	
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd+"login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
<<<<<<< HEAD
		
		truongHoc = new PageTruongHoc();
		truongHoc.driver = driver;
		editTruongHoc = new EditTruongHoc();
		editTruongHoc.driver = driver;
		taoGoiHoc = new PageGoiHoc();
		taoGoiHoc.driver = driver;
=======
		truonghocpage = new TruonghocPage();
		truonghocpage.driver = driver;
>>>>>>> 3d88af4 (BTVN buoi 15)
	}
	
	@AfterTest
	public void closeBrowser() {
	//	this.closeBrowser(driver);
		
	}

}
