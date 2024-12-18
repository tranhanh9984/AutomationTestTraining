package autotest.testcases;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import autocom.common.ChietKhauEnum;
import autocom.common.CommonFuncs;
import autocom.common.HangHoa;
import autocom.common.HinhThucThanhToanEnum;
import autocom.common.LoaiTienEnum;
import autocom.common.NguoiMua;
import autocom.constant.KeywordConstant;
import autotest.pages.CreateInvoicePage;
import autotest.pages.TempHoaDonBanHangPage;
import autotest.pages.LoginPage;

public class CreateInvoicePageTestCase extends CreateInvoicePage {
	
	LoginPage loginPage;

	public CreateInvoicePageTestCase() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void init() {
		this.startBrowser(KeywordConstant.LOGIN_URL);
		this.loginPage = new LoginPage(driver);
		this.loginPage.login();
		this.goToMenu(KeywordConstant.MENUBAR_INVOICE, KeywordConstant.MENUBAR_INVOICE_SUB_LHD);
	}
	
	@AfterClass
	public void close() {
		this.closeBrowser();
	}
	
	//@Test(priority = 1)
	public void tc1_GoToPage_Successful() {
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, KeywordConstant.CREATE_INVOICE_URL);
	}
	
	@DataProvider(name = "dataProvider_TaoMoiFail_ValidateEmail")
	public Object[][] provideData2(){
		return new Object[][] {
			{ "Test case 1", "abc", true },
			{ "Test case 2", "abc@", true },
			{ "Test case 3", "abc@abdb", false },
			{ "Test case 4", "abc@ahsjk.", true },
			{ "Test case 5", "abc@ahsjk.com", false},
			{ "Test case 6", "abc@ahsjk@fsds", true }
		};
	}
	
	// @Test(priority=2, dataProvider = "dataProvider_TaoMoiFail_ValidateEmail")
	public void tc2_ClickTaoMoi_Validate_Email(String tc, String email, boolean expectedError) {
		System.out.println(String.format("%s with email = %s", tc, email));
		this.clear_Email();
		this.fillData_Email(email);
		
		String classEmail = this.getElementEmail().getAttribute("className");
		boolean isHaveInvalidClass = classEmail.contains("ng-invalid");
		
		Assert.assertEquals(isHaveInvalidClass, expectedError);
//		this.fillData_Email("");
	}

	@DataProvider(name = "dataProvider_TaoMoiFail_FullValue_NotHangHoa")
	public Object[][] providerData3(){
		return new Object[][] {
			{ "Test case 1", new NguoiMua("", ""), false, KeywordConstant.ERROR_TENDONVI_OR_NGUOIMUAHANG_NOTEMPTY }
//			{ "Test case 2", new NguoiMua("fakeMSTNguoiMua", "fakeTenDonVi"), false, KeywordConstant.ERROR_HOADON_CHUACOHANGHOA },
//			{ "Test case 3", new NguoiMua("", "fakeTenDonVi"), false, KeywordConstant.ERROR_HOADON_CHUACOHANGHOA },
//			{ "Test case 4", new NguoiMua("fakeMSTNguoiMua", ""), false, KeywordConstant.ERROR_HOADON_CHUACOHANGHOA },
//			{ 
//				"Test case 5", 
//				new NguoiMua("mst", "tendv", "dia chi", "tenNMH", "cccd", "email@dd.com", "sdt", "stk", "nganHang", 
//						HinhThucThanhToanEnum.TM_CK.getText(), LoaiTienEnum.USD.getText(), 1400, ChietKhauEnum.KHONG_CHIET_KHAU.getText()), 
//				true,
//				String.format(KeywordConstant.ERROR_MST_KHONGHOPLE, "mst") 
//			}
		};
	}
	
	//@Test(priority=3, dataProvider = "dataProvider_TaoMoiFail_FullValue_NotHangHoa")
	public void tc3_ClickTaoMoi_Validate_Error(String tc, NguoiMua nguoiMua, boolean isCheckAllHangHoa, String errorText) {
		this.clearTextFormInvoice();
		this.clearSelectedHangHoa();
		
		this.fillData_All(nguoiMua);
		if (isCheckAllHangHoa) {
			this.themAllHangHoa();
		} 
		// click button Tao Moi
		this.clickTaoMoi();
		
		// check show error
		boolean isShowError = this.isShowAlert(errorText);
		System.out.println(tc + " with " + CommonFuncs.getJson(nguoiMua));
		Assert.assertEquals(isShowError, true);
		pause(3);
	}
	
	@Test //(priority=1)
	public void tc4_TaoMoiThanhCong() {
		this.clearTextFormInvoice();
		this.clearSelectedHangHoa();
		
		NguoiMua nguoiMua = new NguoiMua("0123456", "tendv_22", "dia chi 2", "tenNMH 2", "cccd 2", "email@gg.com", "sdt2", "stk2", "nganHang2", 
				HinhThucThanhToanEnum.CHUYEN_KHOAN.getText(), LoaiTienEnum.EUR.getText(), 0, ChietKhauEnum.KHONG_CHIET_KHAU.getText());
		
		this.fillData_All(nguoiMua);
		this.themHangHoa(3);
		
		// click button Tao Moi
		this.clickTaoMoi();
		
		pause(5);
		String hoaDonBanHangPageUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(hoaDonBanHangPageUrl, KeywordConstant.INVOICE_URL);
		
		// Filter data inserted
		TempHoaDonBanHangPage hdbhPage = new TempHoaDonBanHangPage(driver);
		LocalDate currentDate = LocalDate.now();
		 hdbhPage.quickSearch(currentDate, nguoiMua.getTenDonVi());
		// compare date
//		LocalDate fromDate = hdbhPage.getSelectedate("fromDate");
//		LocalDate toDate = hdbhPage.getSelectedate("thruDate");
//		Assert.assertEquals(fromDate.isEqual(currentDate), true);
//		Assert.assertEquals(toDate.isEqual(currentDate), true);
		
	    pause(3);
		hdbhPage.goToActionHoaDon(1, "Chỉnh sửa");
		
		// compare
		NguoiMua nguoiMuaCreated = this.getDataNguoiMua();
		System.out.println(String.format("1. Assert.assertEquals(%s, %s);", nguoiMuaCreated.getTenNguoiMuaHang(), nguoiMua.getTenNguoiMuaHang()));
		Assert.assertEquals(nguoiMuaCreated.getTenNguoiMuaHang(), nguoiMua.getTenNguoiMuaHang());
		System.out.println(String.format("2. Assert.assertEquals(%s, %s);", nguoiMuaCreated.getTenDonVi(), nguoiMua.getTenDonVi()));
		Assert.assertEquals(nguoiMuaCreated.getTenDonVi(), nguoiMua.getTenDonVi());
		System.out.println(String.format("3. Assert.assertEquals(%s, %s);", nguoiMuaCreated.getDiaChi(), nguoiMua.getDiaChi()));
		Assert.assertEquals(nguoiMuaCreated.getDiaChi(), nguoiMua.getDiaChi());
		System.out.println(String.format("4. Assert.assertEquals(%s, %s);", nguoiMuaCreated.getCccd(), nguoiMua.getCccd()));
		Assert.assertEquals(nguoiMuaCreated.getCccd(), nguoiMua.getCccd());
		System.out.println(String.format("5. Assert.assertEquals(%s, %s);", nguoiMuaCreated.getEmailAddress(), nguoiMua.getEmailAddress()));
		Assert.assertEquals(nguoiMuaCreated.getEmailAddress(), nguoiMua.getEmailAddress());
		System.out.println(String.format("6. Assert.assertEquals(%s, %s);", nguoiMuaCreated.getSoDienThoai(), nguoiMua.getSoDienThoai()));
		Assert.assertEquals(nguoiMuaCreated.getSoDienThoai(), nguoiMua.getSoDienThoai());
		System.out.println(String.format("7. Assert.assertEquals(%s, %s);", nguoiMuaCreated.getSoTaiKhoan(), nguoiMua.getSoTaiKhoan()));
		Assert.assertEquals(nguoiMuaCreated.getSoTaiKhoan(), nguoiMua.getSoTaiKhoan());
		
		// remove data inserted
		this.goToMenu(KeywordConstant.MENUBAR_INVOICE, KeywordConstant.MENUBAR_INVOICE_SUB_HDBH);
		
		pause(3);
		hdbhPage.quickSearch(currentDate, nguoiMua.getTenDonVi());

		pause(3);
		hdbhPage.goToActionHoaDon(1, "Xóa");
		hdbhPage.clickYesConfirm();
		// compare
		
		pause(5);
		
	}
	
	//@Test
	public void tc_themSPMoi() {
		this.fillData_LoaiTien("EUR");
		long tyGia = this.getTyGia();
		
		ArrayList<HangHoa> lstHangHoa = new ArrayList<HangHoa>();
		lstHangHoa.add(new HangHoa("Ten hang 1", "Cai", 2, 200, 5));
		lstHangHoa.add(new HangHoa("Ten hang 2", "Cai", 3, 500, 8));
		lstHangHoa.add(new HangHoa("Ten hang 3", "Cai", 4, 600, 10));
		for (int i = 0; i < lstHangHoa.size(); i ++) {
			HangHoa hangHoa = lstHangHoa.get(i);
			int index = i + 1;
			this.themSPMoi(index, hangHoa);
			pause(3);
			
			Assert.assertEquals(this.getDataFromTableHangHoa(index, 7), CommonFuncs.formatLongToString(hangHoa.getThanhTien())); // compare thanh tien
			Assert.assertEquals(this.getDataFromTableHangHoa(index, 8), CommonFuncs.formatLongToString(hangHoa.getThanhTienQD(tyGia))); // compare thanh tien quy doi
			Assert.assertEquals(this.getDataFromTableHangHoa(index, 10), CommonFuncs.formatLongToString(hangHoa.getTienThue())); // compare tien thue
		}
		
//		HangHoa hh = this.selectHangHoaByMSP("VAY_HOA");
//		lstHangHoa.add(hh);
		
		System.out.println(CommonFuncs.getJson(lstHangHoa));
		
		// compare total value
		long totalThanhTien = lstHangHoa.stream().mapToLong(x -> x.getThanhTien()).sum();
		long totalTienThue = lstHangHoa.stream().mapToLong(x -> x.getTienThue()).sum();
		long totalThanhToan = (totalThanhTien + totalTienThue);
				 
		// compare tien goc
		Assert.assertEquals(this.getDataTotal("grandTotal"), CommonFuncs.formatLongToString(totalThanhTien));
		Assert.assertEquals(this.getDataTotal("taxAmount"), CommonFuncs.formatLongToString(totalTienThue));
		Assert.assertEquals(this.getDataTotal("invoiceTotal"), CommonFuncs.formatLongToString(totalThanhToan));
		// compare tien quy doi
		Assert.assertEquals(this.getDataTotal("exchangeGrandTotal"), CommonFuncs.formatLongToString(totalThanhTien * tyGia));
		Assert.assertEquals(this.getDataTotal("exchangeTaxAmount"), CommonFuncs.formatLongToString(totalTienThue * tyGia));
		Assert.assertEquals(this.getDataTotal("exchangeInvoiceTotal"), CommonFuncs.formatLongToString(totalThanhToan * tyGia));
			
		// compare number to string
		String convertValue = CommonFuncs.convertNumberToTextVND(totalThanhToan, "euro");
		String actualValue = driver.findElement(By.xpath("//input[@id='amountInWords']")).getAttribute("value").trim();
		Assert.assertEquals(actualValue, convertValue);
		 
		pause(5);
	}
	
	//@Test
	public void tc_themHangHoaInPopup() {
		//ArrayList<>
		HangHoa hh = this.selectHangHoaByMSP("VAY_HOA");
		System.out.println(CommonFuncs.getJson(hh));
	}
	
}
