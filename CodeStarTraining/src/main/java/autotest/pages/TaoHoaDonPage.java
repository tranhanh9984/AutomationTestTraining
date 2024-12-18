package autotest.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import autocom.common.CommonFuncs;
import autocom.common.CommonPage;
import autocom.common.HangHoa;
import autocom.common.NguoiMua;

public class TaoHoaDonPage extends CommonPage {

	String txtTotal = "//p-inputnumber[@id='%s']//input";
	
	@FindBy(xpath = "//button[@type='submit']") WebElement btnTaoMoi;
	@FindBy(xpath = "//p-autocomplete[@id='toPartyTaxId']//input") WebElement txtMSTNguoiMua;
	@FindBy(xpath = "//p-autocomplete[@id='toPartyTaxId']//button[contains(@class,'p-autocomplete-dropdown')]") WebElement btnDropdownMSTNguoiMua;
	@FindBy(xpath = "//p-autocomplete[@id='toPartyTaxId']//ul[contains(@class,'p-autocomplete-items')]/li") List<WebElement> listMSTNguoiMua;
	@FindBy(xpath = "//p-autocomplete[@id='toPartyName']//input") WebElement txtTenDonVi;
	@FindBy(xpath = "//input[@id='toAddress']") WebElement txtDiaChi;
	@FindBy(xpath = "//input[@id='toName']") WebElement txtNguoiMuaHang;
	@FindBy(xpath = "//input[@id='toIdentification']") WebElement txtCCCD;
	@FindBy(xpath = "//input[@id='toEmailAddress']") WebElement txtEmail;
	@FindBy(xpath = "//input[@id='toTelecomNumber']") WebElement txtSoDienThoai;
	@FindBy(xpath = "//input[@id='accountNumber']") WebElement txtSoTaiKhoan;
	@FindBy(xpath = "//input[@id='bankName']") WebElement txtNganHang;
	@FindBy(xpath = "//p-dropdown[@id='paymentInstrumentEnumId']") WebElement ddHinhThucThanhToan;
	@FindBy(xpath = "//p-dropdown[@id='paymentInstrumentEnumId']/div/span") WebElement spHinhThucThanhToan;
	@FindBy(xpath = "//p-dropdown[@id='currencyUomId']") WebElement ddLoaiTien;
	@FindBy(xpath = "//p-dropdown[@id='currencyUomId']/div/span") WebElement spLoaiTien;
	@FindBy(xpath = "//p-dropdown[@id='discountTypeEnumId']") WebElement ddChietKhau;
	@FindBy(xpath = "//p-dropdown[@id='discountTypeEnumId']/div/span") WebElement spChietKhau;
	@FindBy(xpath = "//p-button[@icon='pi pi-plus']/button[@type='button']") WebElement btnThemHangHoa;
	@FindBy(xpath = "//p-inputnumber[@id='exchangeRate']//input") WebElement txtTyGia;

	String xpathDropDownItem = "//p-dropdown[@id='%s']//ul//li//span[text()='%s']";
	String idHinhThucThanhToan = "paymentInstrumentEnumId";
	String idLoaiTien = "currencyUomId";
	String idChietKhau = "discountTypeEnumId";
	
	String xpathCommonTable = "//form//table/tbody/tr[%d]/td[%d]";
	String xpathCommonInput = "//form//table/tbody/tr[%d]/td[%d]//input";
	String xpathCommonDropdown = "//form//table/tbody/tr[%d]/td[%d]//p-dropdown";
	String xpathCommonDropdownItem = "//ul[contains(@class,'p-dropdown-items')]//p-dropdownitem/li/span[text()='%s']";
	String xpathCommonSpan = "//form//table/tbody/tr[%d]/td[%d]//span";
	
	
	public TaoHoaDonPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectMSTNguoiMua(String value) {
		btnDropdownMSTNguoiMua.click();
		
		boolean find = false;
		for (WebElement item : listMSTNguoiMua) {
			List<String> divItems = item.findElements(By.xpath("./div[contains(@class,'p-grid')]/child::div"))
					.stream().map(x -> x.getAttribute("textContent")).filter(x -> x.contains(value)).collect(Collectors.toList());
			if (divItems != null && divItems.size() > 0) {
				item.click();
				find = true;
				break;
			}
		}
		if (!find) {
			txtMSTNguoiMua.sendKeys(value);
		}
	}
	
	public void setData_tenDonVi(String value) {
		this.clearTextByWebElement(txtTenDonVi);
		txtTenDonVi.sendKeys(value);
	}
	
	public void setData_diaChi(String value) {
		this.clearTextByWebElement(txtDiaChi);
		txtDiaChi.sendKeys(value);
	}
	
	public void setData_nguoiMuaHang(String value) {
		this.clearTextByWebElement(txtNguoiMuaHang);
		txtNguoiMuaHang.sendKeys(value);
	}
	
	public void setData_cccd(String value) {
		this.clearTextByWebElement(txtCCCD);
		txtCCCD.sendKeys(value);
	}
	
	public void setData_email(String value) {
		this.clearTextByWebElement(txtEmail);
		txtEmail.sendKeys(value);
	}

	public void setData_soDienThoai(String value) {
		this.clearTextByWebElement(txtSoDienThoai);
		txtSoDienThoai.sendKeys(value);
	}
	
	public void setData_soTaiKhoan(String value) {
		this.clearTextByWebElement(txtSoTaiKhoan);
		txtSoTaiKhoan.sendKeys(value);
	} 

	public void setData_nganHang(String value) {
		this.clearTextByWebElement(txtNganHang);
		txtNganHang.sendKeys(value);
	}
	
	public void selectHinhThucThanhToan(String value) {
		this.scrollBarToWebElement(ddHinhThucThanhToan);
		ddHinhThucThanhToan.click();
		driver.findElement(By.xpath(String.format(xpathDropDownItem, idHinhThucThanhToan, value))).click();
	}
	
	public void selectLoaiTien(String value) {
		this.scrollBarToWebElement(ddLoaiTien);
		ddLoaiTien.click();
		driver.findElement(By.xpath(String.format(xpathDropDownItem, idLoaiTien, value))).click();
	}
	
	public void selectChietKhau(String value) {
		this.scrollBarToWebElement(ddChietKhau);
		ddChietKhau.click();
		driver.findElement(By.xpath(String.format(xpathDropDownItem, idChietKhau, value))).click();
	}
	
	public long getTyGia() {
		return CommonFuncs.convertStringToLong(this.txtTyGia.getAttribute("value"));
	}
	
	public void fillData(NguoiMua nguoiMua) {
		this.selectMSTNguoiMua(nguoiMua.getMstNguoiMua());
		this.setData_tenDonVi(nguoiMua.getTenDonVi());
		this.setData_diaChi(nguoiMua.getDiaChi());
		this.setData_nguoiMuaHang(nguoiMua.getTenNguoiMuaHang());
		this.setData_cccd(nguoiMua.getCccd());
		this.setData_email(nguoiMua.getEmailAddress());
		this.setData_soDienThoai(nguoiMua.getSoDienThoai());
		this.setData_soTaiKhoan(nguoiMua.getSoTaiKhoan());
		this.setData_nganHang(nguoiMua.getTenNganHang());
		this.selectHinhThucThanhToan(nguoiMua.getHinhThuThanhToan());
		this.selectLoaiTien(nguoiMua.getLoaiTien());
		this.selectChietKhau(nguoiMua.getChietKhau());
	}
	
	public NguoiMua getData() {
		NguoiMua nguoiMua = new NguoiMua();
		nguoiMua.setMstNguoiMua(this.txtMSTNguoiMua.getAttribute("value"));
		nguoiMua.setTenDonVi(this.txtTenDonVi.getAttribute("value"));
		nguoiMua.setDiaChi(this.txtDiaChi.getAttribute("value"));
		nguoiMua.setTenNguoiMuaHang(this.txtNguoiMuaHang.getAttribute("value"));
		nguoiMua.setCccd(this.txtCCCD.getAttribute("value"));
		nguoiMua.setEmailAddress(this.txtEmail.getAttribute("value"));
		nguoiMua.setSoDienThoai(this.txtSoDienThoai.getAttribute("value"));
		nguoiMua.setSoTaiKhoan(this.txtSoTaiKhoan.getAttribute("value"));
		nguoiMua.setTenNganHang(this.txtNganHang.getAttribute("value"));
		nguoiMua.setHinhThuThanhToan(this.spHinhThucThanhToan.getAttribute("textContent"));
		nguoiMua.setLoaiTien(this.spLoaiTien.getAttribute("textContent"));
		nguoiMua.setChietKhau(this.spChietKhau.getAttribute("textContent"));
		return nguoiMua;
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
	
	public String getDataFromTableHangHoa(int indexRow, int indexColumn) {
		return driver.findElement(By.xpath(String.format(xpathCommonSpan, indexRow, indexColumn))).getAttribute("textContent").trim();
	}

	public String getDataTotal(String fieldName) {
		return driver.findElement(By.xpath(String.format(txtTotal, fieldName))).getAttribute("value");
	}
	
	public void clickTaoMoi() {
		this.btnTaoMoi.click();
	}
}
