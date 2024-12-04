package autotest.testcases;

import java.text.DecimalFormat;
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

public class CreateInvoicePageTestCase extends CreateInvoicePage {

	public CreateInvoicePageTestCase() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void init() {
		this.startBrowser(KeywordConstant.LOGIN_URL);
		this.gotoCreateInvoicePage();
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
	
	// @Test(priority=1)
	public void tc4_TaoMoiThanhCong() {
		this.clearTextFormInvoice();
		this.clearSelectedHangHoa();
		
		NguoiMua nguoiMua = new NguoiMua("0123456", "tendv_2", "dia chi 2", "tenNMH 2", "cccd 2", "", "sdt2", "stk2", "nganHang2", 
				HinhThucThanhToanEnum.CHUYEN_KHOAN.getText(), LoaiTienEnum.EUR.getText(), 0, ChietKhauEnum.KHONG_CHIET_KHAU.getText());
		
		this.fillData_All(nguoiMua);
		this.themHangHoa(3);
		
		// click button Tao Moi
		this.clickTaoMoi();
		
		pause(5);
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(currentUrl, KeywordConstant.INVOICE_URL);
		
	}
	
	private void tcThemSPMoi(int index, HangHoa hangHoa) {
		this.themSPMoi(index, hangHoa);
		
		String actualThanhTien = this.getDataFromTableHangHoa(index, 7);
		Assert.assertEquals(actualThanhTien, CommonFuncs.formatLongToString(hangHoa.getThanhTien()));
		
		String actualTienThue = this.getDataFromTableHangHoa(index, 10);
		Assert.assertEquals(actualTienThue, CommonFuncs.formatLongToString(hangHoa.getTienThue()));
	}
	
	// Compare with Loai Tien khac VND
	//@Test
	public void tc_themSPMoi() {
		this.fillData_LoaiTien("EUR");
		
		this.tcThemSPMoi(1, new HangHoa("Ten hang 1", "Cai", 2, 200, 5));
		this.tcThemSPMoi(2, new HangHoa("Ten hang 2", "Cai", 3, 300, 8));
		this.tcThemSPMoi(3, new HangHoa("Ten hang 3", "Cai", 4, 400, 10));
		
		this.themHangHoa(3);
		
		ArrayList<HangHoa> lstHangHoa = this.getDanhSachHangHoa();
		System.out.println(CommonFuncs.getJson(lstHangHoa));
		
		// compare total value
		long totalThanhTien = lstHangHoa.stream().mapToLong(x -> x.ThanhTien).sum();
		long totalTienThue = lstHangHoa.stream().mapToLong(x -> x.TienThue).sum();
		long totalThanhToan = (totalThanhTien + totalTienThue);
		
		 String actualTongThanhTien = this.getDataTotal("grandTotal");
		 String actualTongTienThue = this.getDataTotal("taxAmount");
		 String actualTongTienThanhToan = this.getDataTotal("invoiceTotal");
		 
		 Assert.assertEquals(actualTongThanhTien, CommonFuncs.formatLongToString(totalThanhTien));
		 Assert.assertEquals(actualTongTienThue, CommonFuncs.formatLongToString(totalTienThue));
		 Assert.assertEquals(actualTongTienThanhToan, CommonFuncs.formatLongToString(totalThanhToan));
		 
		 // compare number to string
		 String convertValue = CommonFuncs.convertNumberToTextVND(totalThanhToan, "euro");
		 String actualValue = driver.findElement(By.xpath("//input[@id='amountInWords']")).getAttribute("value").trim();
		 Assert.assertEquals(actualValue, convertValue);
		
		pause(5);
	}
	
}
