package autotest.testcases;

import java.time.LocalDate;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.common.ChietKhauEnum;
import autocom.common.CommonFuncs;
import autocom.common.CommonPage;
import autocom.common.HangHoa;
import autocom.common.HinhThucThanhToanEnum;
import autocom.common.LoaiTienEnum;
import autocom.common.NguoiMua;
import autocom.constant.KeywordConstant;
import autotest.pages.HoaDonBanHangPage;
import autotest.pages.LoginPage;
import autotest.pages.TaoHoaDonPage;

public class TaoHoaDonPageTestCase extends CommonPage {

	LoginPage loginPage;
	TaoHoaDonPage taoHoaDonPage;
	
	public TaoHoaDonPageTestCase() {
		// TODO Auto-generated constructor stub
	}
	
	@BeforeClass
	public void init() {
		this.startBrowser(KeywordConstant.LOGIN_URL);
		this.loginPage = new LoginPage(driver);
		this.loginPage.login();
		this.goToMenu(KeywordConstant.MENUBAR_INVOICE, KeywordConstant.MENUBAR_INVOICE_SUB_LHD);
		this.taoHoaDonPage = new TaoHoaDonPage(driver);
	}
	
	@AfterClass
	public void close() {
		this.closeBrowser();
	}
	
	private void compareDataNguoiMua(NguoiMua actual, NguoiMua expected) {
		Assert.assertEquals(actual.getMstNguoiMua().contains(expected.getMstNguoiMua()), true);
		Assert.assertEquals(actual.getTenDonVi(), expected.getTenDonVi());
		Assert.assertEquals(actual.getDiaChi(), expected.getDiaChi());
		Assert.assertEquals(actual.getTenNguoiMuaHang(), expected.getTenNguoiMuaHang());
		Assert.assertEquals(actual.getCccd(), expected.getCccd());
		Assert.assertEquals(actual.getEmailAddress(), expected.getEmailAddress());
		Assert.assertEquals(actual.getSoDienThoai(), expected.getSoDienThoai());
		Assert.assertEquals(actual.getSoTaiKhoan(), expected.getSoTaiKhoan());
		Assert.assertEquals(actual.getTenNganHang(), expected.getTenNganHang());
		Assert.assertEquals(actual.getHinhThuThanhToan(), expected.getHinhThuThanhToan());
		Assert.assertEquals(actual.getLoaiTien(), expected.getLoaiTien());
		Assert.assertEquals(actual.getTyGia(), expected.getTyGia());
		Assert.assertEquals(actual.getChietKhau(), expected.getChietKhau());
	}
	
	private void compareDataTotal(ArrayList<HangHoa> lstHangHoa, long tyGia) {
		// compare total value
		long totalThanhTien = lstHangHoa.stream().mapToLong(x -> x.getThanhTien()).sum();
		long totalTienThue = lstHangHoa.stream().mapToLong(x -> x.getTienThue()).sum();
		long totalThanhToan = (totalThanhTien + totalTienThue);
								 
		// compare tien goc
		Assert.assertEquals(this.taoHoaDonPage.getDataTotal("grandTotal"), CommonFuncs.formatLongToString(totalThanhTien));
		Assert.assertEquals(this.taoHoaDonPage.getDataTotal("taxAmount"), CommonFuncs.formatLongToString(totalTienThue));
		Assert.assertEquals(this.taoHoaDonPage.getDataTotal("invoiceTotal"), CommonFuncs.formatLongToString(totalThanhToan));
		
		// compare tien quy doi
		Assert.assertEquals(this.taoHoaDonPage.getDataTotal("exchangeGrandTotal"), CommonFuncs.formatLongToString(totalThanhTien * tyGia));
		Assert.assertEquals(this.taoHoaDonPage.getDataTotal("exchangeTaxAmount"), CommonFuncs.formatLongToString(totalTienThue * tyGia));
		Assert.assertEquals(this.taoHoaDonPage.getDataTotal("exchangeInvoiceTotal"), CommonFuncs.formatLongToString(totalThanhToan * tyGia));
							
		// compare number to string
		String convertValue = CommonFuncs.convertNumberToTextVND(totalThanhToan, "euro");
		String actualValue = driver.findElement(By.xpath("//input[@id='amountInWords']")).getAttribute("value").trim();
		Assert.assertEquals(actualValue, convertValue);
	}
	
	@Test
	public void tc_taoHoaDon_thanhCong() {
		String tenDonVi = CommonFuncs.generateRandomUUID();
		NguoiMua nguoiMua = new NguoiMua("0123456", tenDonVi, "dia chi 2", "tenNMH 2", "cccd 2", "email@gg.com", "sdt2", "stk2", "nganHang2", 
				HinhThucThanhToanEnum.CHUYEN_KHOAN.getText(), LoaiTienEnum.EUR.getText(), 0, ChietKhauEnum.KHONG_CHIET_KHAU.getText());
		
		this.taoHoaDonPage.fillData(nguoiMua);
		
		NguoiMua actualNguoiMua = this.taoHoaDonPage.getData();

		this.compareDataNguoiMua(actualNguoiMua, nguoiMua);
		
		long tyGia = this.taoHoaDonPage.getTyGia();
		
		ArrayList<HangHoa> lstHangHoa = new ArrayList<HangHoa>();
		lstHangHoa.add(new HangHoa("Ten hang 1", "Cai", 2, 200, 5));
		lstHangHoa.add(new HangHoa("Ten hang 2", "Cai", 3, 500, 8));
		lstHangHoa.add(new HangHoa("Ten hang 3", "Cai", 4, 600, 10));
		for (int i = 0; i < lstHangHoa.size(); i ++) {
			HangHoa hangHoa = lstHangHoa.get(i);
			int index = i + 1;
			this.taoHoaDonPage.themSPMoi(index, hangHoa);
			pause(3);
			
			Assert.assertEquals(this.taoHoaDonPage.getDataFromTableHangHoa(index, 7), CommonFuncs.formatLongToString(hangHoa.getThanhTien())); // compare thanh tien
			Assert.assertEquals(this.taoHoaDonPage.getDataFromTableHangHoa(index, 8), CommonFuncs.formatLongToString(hangHoa.getThanhTienQD(tyGia))); // compare thanh tien quy doi
			Assert.assertEquals(this.taoHoaDonPage.getDataFromTableHangHoa(index, 10), CommonFuncs.formatLongToString(hangHoa.getTienThue())); // compare tien thue
		}
		
		this.compareDataTotal(lstHangHoa, tyGia);
		
		this.taoHoaDonPage.clickTaoMoi();
		
		pause(5);
		
		String hoaDonBanHangPageUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(hoaDonBanHangPageUrl, KeywordConstant.INVOICE_URL);
		
		LocalDate currentDate = LocalDate.now();
		HoaDonBanHangPage hdbhPage = new HoaDonBanHangPage(driver);
		hdbhPage.quickSearch(currentDate, nguoiMua.getTenDonVi());
		
		LocalDate actualFromDate = hdbhPage.getSelectedate(hdbhPage.txtFromDate);
		LocalDate actualToDate = hdbhPage.getSelectedate(hdbhPage.txtToDate);
		Assert.assertEquals(actualFromDate.isEqual(currentDate), true);
		Assert.assertEquals(actualToDate.isEqual(currentDate), true);
		
		pause(3);
		
		hdbhPage.goToActionHoaDon(1, "Chỉnh sửa");
		
		pause(5);
		// compare
		NguoiMua nguoiMuaCreated = this.taoHoaDonPage.getData();
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
		
		pause(3);
	}
	
	//@Test
	public void tc() {
		this.taoHoaDonPage.selectMSTNguoiMua("0123456");
		
		pause(4);
	}

}
