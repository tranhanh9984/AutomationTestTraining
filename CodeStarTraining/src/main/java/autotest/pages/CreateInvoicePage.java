package autotest.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import autocom.common.CommonFuncs;
import autocom.common.HangHoa;
import autocom.common.NguoiMua;
import autocom.constant.KeywordConstant;

public class CreateInvoicePage extends LoginPage {
	
	String xpathBtnTaoMoi = "//button[@type='submit']";
	
	String xpathAutoComplete = "//p-autocomplete[@id='%s']//input";
	String idMSTNguoiMua = "toPartyTaxId";
	String idTenDonVi = "toPartyName";
	
	String xpathBtnDropdownOfAutoComplete = "//p-autocomplete[@id='%s']//button[contains(@class,'p-autocomplete-dropdown')]";
	String xpathListItem = "//p-autocomplete[@id='%s']//ul[contains(@class,'p-autocomplete-items')]/li";
	
	String xpathInput = "//input[@id='%s']";
	String idDiaChi = "toAddress";
	String idNguoiMuaHang = "toName";
	String idCCCD = "toIdentification";
	String idEmail = "toEmailAddress";
	String idSoDienThoai = "toTelecomNumber";
	String idSoTaiKhoan = "accountNumber";
	String idNganHang = "bankName";
	
	String xpathDropDown = "//p-dropdown[@id='%s']";
	String xpathSpanOfDropDown = "//p-dropdown[@id='%s']/div/span";
	String idHinhThucThanhToan = "paymentInstrumentEnumId";
	String idLoaiTien = "currencyUomId";
	String idChietKhau = "discountTypeEnumId";
	
	String xpathDropDownItem = "//p-dropdown[@id='%s']//ul//li//span[text()='%s']";
	
	String xpathInputNumber = "//p-inputnumber[@id='%s']//input";
	String idTyGia = "exchangeRate";
	
	String xpathBtnThemHangHoa = "//p-button[@icon='pi pi-plus']/button[@type='button']";
	String xpathCheckAllHangHoa = "//app-dialog-add-product//table/thead/tr/th/p-tableheadercheckbox";
	String xpathThemOnThemHangHoaPopup = "//app-dialog-add-product//p-footer//p-button[contains(@icon,'pi-check')]";
	String xpathDongOnThemHangHoaPopup = "//app-dialog-add-product//p-footer//p-button[contains(@icon,'pi-times')]";
	
	String xpathTableHangHoa = "//form//table/tbody/tr";
	String xpathBtnRemove = "./td/p-button[@icon='pi pi-trash']";
	String xpathBtnConfirmYes = "//div[contains(@class,'p-confirm-popup')]//div[contains(@class,'p-confirm-popup-footer')]/button[contains(@class,'p-confirm-popup-accept')]";

	String xpathCommonTable = "//form//table/tbody/tr[%d]/td[%d]";
	String xpathCommonInput = "//form//table/tbody/tr[%d]/td[%d]//input";
	String xpathCommonDropdown = "//form//table/tbody/tr[%d]/td[%d]//p-dropdown";
	String xpathCommonDropdownItem = "//ul[contains(@class,'p-dropdown-items')]//p-dropdownitem/li/span[text()='%s']";
	String xpathCommonSpan = "//form//table/tbody/tr[%d]/td[%d]//span";
	String xpathInputTotal = "//p-inputnumber[@id='%s']//input";
	
	
	public CreateInvoicePage() {
		// TODO Auto-generated constructor stub
	}
	
	public void gotoCreateInvoicePage() {
		this.login(KeywordConstant.USER_NAME, KeywordConstant.PASS_WORD);
		
		MenuBar menuBar = new MenuBar(driver);
		menuBar.getMenuItemByText(KeywordConstant.MENUBAR_INVOICE).click();
		menuBar.getSubMenuItemByText(KeywordConstant.MENUBAR_INVOICE_SUB_LHD).click();
		
		pause(2);
	}
	
	public void clickTaoMoi() {
		driver.findElement(By.xpath(xpathBtnTaoMoi)).click();
	}
	
	// using p-autocomplete
	public void fillData_MSTNguoiMua(String value) {
		this.setValue(String.format(xpathAutoComplete, idMSTNguoiMua), value);
	}
	
	public String getData_MSTNguoiMua() {
		return this.getValue(String.format(xpathAutoComplete, idMSTNguoiMua));
	}
	
	public void select_MSTNguoiMua(String value) {
		driver.findElement(By.xpath(String.format(xpathBtnDropdownOfAutoComplete, idMSTNguoiMua))).click();
		
		List<WebElement> items = driver.findElements(By.xpath(String.format(xpathListItem, idMSTNguoiMua)));
		boolean find = false;
		for (WebElement item : items) {
			List<String> divItems = item.findElements(By.xpath("./div[contains(@class,'p-grid')]/child::div"))
					.stream().map(x -> x.getAttribute("textContent")).filter(x -> x.contains(value)).collect(Collectors.toList());
			if (divItems != null && divItems.size() > 0) {
				item.click();
				find = true;
				break;
			}
		}
		if (!find) {
			this.setValue(String.format(xpathAutoComplete, idMSTNguoiMua), value);
		}
	}
	
	// using p-autocomplete
	public void fillData_TenDonVi(String value) {
		this.clearText(String.format(xpathAutoComplete, idTenDonVi));
		this.setValue(String.format(xpathAutoComplete, idTenDonVi), value);
	}
	// using input
	public void fillData_DiaChi(String value) {
		this.clearText(String.format(xpathInput, idDiaChi));
		this.setValue(String.format(xpathInput, idDiaChi), value);
	}
	// using input
	public void fillData_NguoiMuaHang(String value) {
		this.clearText(String.format(xpathInput, idNguoiMuaHang));
		this.setValue(String.format(xpathInput, idNguoiMuaHang), value);
	}
	// using input
	public void fillData_CCCD(String value) {
		this.clearText(String.format(xpathInput, idCCCD));
		this.setValue(String.format(xpathInput, idCCCD), value);
	}
	// using input
	public void fillData_Email(String value) {
		this.clearText(String.format(xpathInput, idEmail));
		this.setValue(String.format(xpathInput, idEmail), value);
	}
	
	public void clear_Email() {
		this.clearText(String.format(xpathInput, idEmail));
	}
	
	public WebElement getElementEmail() {
		return driver.findElement(By.xpath(String.format(xpathInput, idEmail)));
	}
	
	public void fillData_SDT(String value) {
		this.clearText(String.format(xpathInput, idSoDienThoai));
		this.setValue(String.format(xpathInput, idSoDienThoai), value);
	}

	public void fillData_STK(String value) {
		this.clearText(String.format(xpathInput, idSoTaiKhoan));
		this.setValue(String.format(xpathInput, idSoTaiKhoan), value);
	}
	
	public void fillData_NganHang(String value) {
		this.clearText(String.format(xpathInput, idNganHang));
		this.setValue(String.format(xpathInput, idNganHang), value);
	}
	
	public void fillData_HinhThucThanhToan(String value) {
		this.scrollBarToElement(String.format(xpathDropDown, idHinhThucThanhToan));
		driver.findElement(By.xpath(String.format(xpathDropDown, idHinhThucThanhToan))).click();
		driver.findElement(By.xpath(String.format(xpathDropDownItem, idHinhThucThanhToan, value))).click();
	}
	
	public void fillData_LoaiTien(String value) {
		this.scrollBarToElement(String.format(xpathDropDown, idLoaiTien));
		driver.findElement(By.xpath(String.format(xpathDropDown, idLoaiTien))).click();
		driver.findElement(By.xpath(String.format(xpathDropDownItem, idLoaiTien, value))).click();
	}
	
	public void fillData_TyGia(double value) {
		this.setValue(String.format(xpathInputNumber, idTyGia), value + "");
	}
	
	public long getTyGia() {
		return CommonFuncs.convertStringToLong(this.getValue(String.format(xpathInputNumber, idTyGia)));
	}
	
	public void fillData_ChietKhau(String value) {
		driver.findElement(By.xpath(String.format(xpathDropDown, idChietKhau))).click();
		driver.findElement(By.xpath(String.format(xpathDropDownItem, idChietKhau, value))).click();
	}
	
	public void fillData_All(NguoiMua nguoiMua) {
		this.select_MSTNguoiMua(nguoiMua.getMstNguoiMua());
		this.fillData_TenDonVi(nguoiMua.getTenDonVi());
		this.fillData_DiaChi(nguoiMua.getDiaChi());
		this.fillData_NguoiMuaHang(nguoiMua.getTenNguoiMuaHang());
		this.fillData_CCCD(nguoiMua.getCccd());
		this.fillData_Email(nguoiMua.getEmailAddress());
		this.fillData_SDT(nguoiMua.getSoDienThoai());
		this.fillData_STK(nguoiMua.getSoTaiKhoan());
		this.fillData_NganHang(nguoiMua.getTenNganHang());
		this.fillData_HinhThucThanhToan(nguoiMua.getHinhThuThanhToan());
		this.fillData_LoaiTien(nguoiMua.getLoaiTien());
//		this.fillData_TyGia(nguoiMua.getTyGia());
		this.fillData_ChietKhau(nguoiMua.getChietKhau());
	}
	
	public NguoiMua getDataNguoiMua() {
		// NguoiMua nguoiMua = new NguoiMua();
		String mstNguoiMua = this.getValue(String.format(xpathAutoComplete, idMSTNguoiMua));
		String tenDV = this.getValue(String.format(xpathAutoComplete, idTenDonVi));
		String diaChi = this.getValue(String.format(xpathInput, idDiaChi));
		String nguoiMuaHang = this.getValue(String.format(xpathInput, idNguoiMuaHang));
		String cccd = this.getValue(String.format(xpathInput, idCCCD));
		String email = this.getValue(String.format(xpathInput, idEmail));
		String sdt = this.getValue(String.format(xpathInput, idSoDienThoai));
		String stk = this.getValue(String.format(xpathInput, idSoTaiKhoan));
		String tenNganHang = this.getValue(String.format(xpathInput, idNganHang));
		NguoiMua nguoiMua = new NguoiMua(mstNguoiMua, tenDV, diaChi, nguoiMuaHang, cccd, email, sdt, stk, tenNganHang, "", "", 0, "");
		return nguoiMua;
	}
	
	public void clickThemHangHoa() {
		WebElement btnThemHangHoa = driver.findElement(By.xpath(xpathBtnThemHangHoa));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnThemHangHoa);
		btnThemHangHoa.click();
	}
	
	public void checkAllHangHoa() {
		driver.findElement(By.xpath(xpathCheckAllHangHoa)).click();
	}
	
	public void clickThemOnThemHangHoaPopup() {
		driver.findElement(By.xpath(xpathThemOnThemHangHoaPopup)).click();
	}
	
	public void clickDongOnThemHangHoaPopup() {
		driver.findElement(By.xpath(xpathDongOnThemHangHoaPopup)).click();
	}
	

	public void themAllHangHoa() {
		this.clickThemHangHoa();
		this.checkAllHangHoa();
		this.clickThemOnThemHangHoaPopup();
	}
	
	public void themHangHoa(int numberOfHangHoa) {
		this.clickThemHangHoa();
		String xpathCheckbox = "//app-dialog-add-product//table/tbody/tr[%d]/td/p-tablecheckbox";
		for (int i = 1; i <= numberOfHangHoa; i++) {
			driver.findElement(By.xpath(String.format(xpathCheckbox, i))).click();
		}
		this.clickThemOnThemHangHoaPopup();
	}
	
	public void filterMaSanPham(String maSP) {
		String txtFilterMaSP = "//app-dialog-add-product//table//p-columnfilter[@field='pseudoId']//input";
		WebElement filterMaSP = driver.findElement(By.xpath(txtFilterMaSP));
		this.clearText(txtFilterMaSP);
		filterMaSP.sendKeys(maSP);
		filterMaSP.sendKeys(Keys.ENTER);
	}
	
	public HangHoa selectHangHoaByMSP(String maSP) {
		this.clickThemHangHoa();
		String xpathCheckbox = "//app-dialog-add-product//table/tbody/tr[%d]/td/p-tablecheckbox";
		this.filterMaSanPham(maSP);
		driver.findElement(By.xpath(String.format(xpathCheckbox, 1))).click();
		// get data
		String spField = "//app-dialog-add-product//table//tbody/tr[%d]/td[%d]";
		
		String tenHangHoa = driver.findElement(By.xpath(String.format(spField, 1, 3))).getAttribute("textContent");
		long donGia = CommonFuncs.convertStringToLong(driver.findElement(By.xpath(String.format(spField, 1, 4))).getAttribute("textContent"));
		String donVi = driver.findElement(By.xpath(String.format(spField, 1, 5))).getAttribute("textContent");
		
		this.clickThemOnThemHangHoaPopup();
		
		return new HangHoa(tenHangHoa, donVi, 1, donGia, 0);
		
	}
	
	public void clearSelectedHangHoa() {
		List<WebElement> tableRows = driver.findElements(By.xpath(xpathTableHangHoa));
		if (tableRows.size() < 2) return;
		for (int i = tableRows.size() - 2; i >= 0; i--) {
			WebElement btnRemove = tableRows.get(i).findElement(By.xpath(xpathBtnRemove));
			if (btnRemove.isDisplayed()) {
				btnRemove.click();
				driver.findElement(By.xpath(xpathBtnConfirmYes)).click();
			}
		}
	}
	
	public void clearTextFormInvoice() {
		this.clearText(String.format(xpathAutoComplete, idMSTNguoiMua));
		this.clearText(String.format(xpathAutoComplete, idTenDonVi));
		this.clearText(String.format(xpathInput, idDiaChi));
		this.clearText(String.format(xpathInput, idNguoiMuaHang));
		this.clearText(String.format(xpathInput, idCCCD));
		this.clearText(String.format(xpathInput, idEmail));
		this.clearText(String.format(xpathInput, idSoDienThoai));
		this.clearText(String.format(xpathInput, idSoTaiKhoan));
		this.clearText(String.format(xpathInput, idNganHang));
		this.clearText(String.format(xpathInputNumber, idTyGia));
	}
	
	public String getDataFromTableHangHoa(int indexRow, int indexColumn) {
		return driver.findElement(By.xpath(String.format(xpathCommonSpan, indexRow, indexColumn))).getAttribute("textContent").trim();
	}
	
	public void setDataFromTableHangHoa(int indexRow, int indexColumn, String value) {
		driver.findElement(By.xpath(String.format(xpathCommonTable, indexRow, indexColumn))).click();
		if (indexColumn == 9) {
			driver.findElement(By.xpath(String.format(xpathCommonDropdown, indexRow, indexColumn))).click();
			driver.findElement(By.xpath(String.format(xpathCommonDropdownItem, value))).click();
		} else {
			driver.findElement(By.xpath(String.format(xpathCommonInput, indexRow, indexColumn))).sendKeys(value);
		}
	}
	
	public void themSPMoi(int indexRow, HangHoa hangHoa) {
		// fill ten hang hoa
		this.setDataFromTableHangHoa(indexRow, 3, hangHoa.getTenHangHoa());
		this.setDataFromTableHangHoa(indexRow, 4, hangHoa.getDonViTinh());
		this.setDataFromTableHangHoa(indexRow, 5, hangHoa.getSoLuong() + "");
		this.setDataFromTableHangHoa(indexRow, 6, hangHoa.getDonGia() + "");
		this.setDataFromTableHangHoa(indexRow, 9, hangHoa.getThueGTGT() + "%");
	}
	
	public ArrayList<HangHoa> getDanhSachHangHoa(){
		List<WebElement> tableRows = driver.findElements(By.xpath(xpathTableHangHoa));
		if (tableRows.size() < 2) return null;
		ArrayList<HangHoa> lstHangHoa = new ArrayList<HangHoa>();
		for(int i = 1; i < tableRows.size(); i ++) {
			String tenHangHoa = this.getDataFromTableHangHoa(i, 3);
			String donViTinh = this.getDataFromTableHangHoa(i, 4);
			String soLuong = this.getDataFromTableHangHoa(i, 5);
			String donGia = this.getDataFromTableHangHoa(i, 6);
			String thueGTGT = this.getDataFromTableHangHoa(i, 9);
			
			String thanhTien = this.getDataFromTableHangHoa(i, 7);
			String thanhTienQD = this.getDataFromTableHangHoa(i, 8);
			String tienThue = this.getDataFromTableHangHoa(i, 10);
			
			HangHoa hh = new HangHoa(tenHangHoa, donViTinh, CommonFuncs.convertStringToInt(soLuong), CommonFuncs.convertStringToLong(donGia), CommonFuncs.convertStringToInt(thueGTGT),
					CommonFuncs.convertStringToLong(thanhTien), CommonFuncs.convertStringToLong(thanhTienQD), CommonFuncs.convertStringToLong(tienThue));
			lstHangHoa.add(hh);
		}
		return lstHangHoa;
	}
	
	public String getDataTotal(String fieldName) {
		return driver.findElement(By.xpath(String.format(xpathInputTotal, fieldName))).getAttribute("value");
	}
}
