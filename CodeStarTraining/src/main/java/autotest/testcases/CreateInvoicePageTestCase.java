package autotest.testcases;

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
	
	@Test(priority = 1)
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
	
	@Test(priority=2, dataProvider = "dataProvider_TaoMoiFail_ValidateEmail")
	public void tc2_ClickTaoMoi_Validate_Email(String tc, String email, boolean expectedError) {
		System.out.println(String.format("%s with email = %s", tc, email));
		this.fillData_Email(email);
		
		String classEmail = this.getElementEmail().getAttribute("className");
		boolean isHaveInvalidClass = classEmail.contains("ng-invalid");
		
		Assert.assertEquals(isHaveInvalidClass, expectedError);
		this.fillData_Email("");
	}

	@DataProvider(name = "dataProvider_TaoMoiFail_FullValue_NotHangHoa")
	public Object[][] providerData3(){
		return new Object[][] {
			{ "Test case 1", new NguoiMua("", ""), false, KeywordConstant.ERROR_TENDONVI_OR_NGUOIMUAHANG_NOTEMPTY },
			{ "Test case 2", new NguoiMua("fakeMSTNguoiMua", "fakeTenDonVi"), false, KeywordConstant.ERROR_HOADON_CHUACOHANGHOA },
			{ "Test case 3", new NguoiMua("", "fakeTenDonVi"), false, KeywordConstant.ERROR_HOADON_CHUACOHANGHOA },
			{ "Test case 4", new NguoiMua("fakeMSTNguoiMua", ""), false, KeywordConstant.ERROR_HOADON_CHUACOHANGHOA },
			{ 
				"Test case 5", 
				new NguoiMua("mst", "tendv", "dia chi", "tenNMH", "cccd", "email@dd.com", "sdt", "stk", "nganHang", 
						HinhThucThanhToanEnum.TM_CK.getText(), LoaiTienEnum.USD.getText(), 1400, ChietKhauEnum.KHONG_CHIET_KHAU.getText()), 
				true,
				String.format(KeywordConstant.ERROR_MST_KHONGHOPLE, "mst") 
			}
		};
	}
	
	@Test(priority=3, dataProvider = "dataProvider_TaoMoiFail_FullValue_NotHangHoa")
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
	
	@Test(priority=4)
	public void tc4_TaoMoiThanhCong() {
		this.clearTextFormInvoice();
		this.clearSelectedHangHoa();
		
		NguoiMua nguoiMua = new NguoiMua("0123456", "tendv_2", "dia chi 2", "tenNMH 2", "cccd 2", "email2@dd.com", "sdt2", "stk2", "nganHang2", 
				HinhThucThanhToanEnum.CHUYEN_KHOAN.getText(), LoaiTienEnum.EUR.getText(), 1600, ChietKhauEnum.KHONG_CHIET_KHAU.getText());
		
		this.fillData_All(nguoiMua);
		this.themHangHoa(3);
		
		// click button Tao Moi
		this.clickTaoMoi();
		
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, KeywordConstant.INVOICE_URL);
		boolean isSuccess = this.isShowAlert(KeywordConstant.INFO_SUCCESSFULL);
		Assert.assertEquals(isSuccess, true);
		
		pause(3);
	}
	
	//@Test
	public void them() {
		//this.themSanPhamMoi();
		WebElement test = driver.findElement(By.xpath("//form//table/tbody/tr[1]/td[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", test);
		((JavascriptExecutor) driver).executeScript("arguments[0].classList.add('p-cell-editing');", test);
		
		
		new Actions(driver).moveToElement(test).perform();
		driver.findElement(By.xpath("//form//table/tbody/tr[1]/td[4]/p-celleditor//input")).sendKeys("Cai");
		System.out.println(test.getAttribute("class"));
		pause(5);
	}
	
}
