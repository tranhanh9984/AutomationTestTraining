package autocom.common;

public class NguoiMua {
	
	private String mstNguoiMua;
	private String tenDonVi;
	private String diaChi;
	private String tenNguoiMuaHang;
	private String cccd;
	private String emailAddress;
	private String soDienThoai;
	private String soTaiKhoan;
	private String tenNganHang;
	private String hinhThuThanhToan;
	private String loaiTien;
	private double tyGia;
	private String chietKhau;
	
	public String getMstNguoiMua() {
		return mstNguoiMua == null ? "" : mstNguoiMua;
	}

	public void setMstNguoiMua(String mstNguoiMua) {
		this.mstNguoiMua = mstNguoiMua;
	}

	public String getTenDonVi() {
		return tenDonVi == null ? "" : tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	public String getDiaChi() {
		return diaChi == null ? "" : diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTenNguoiMuaHang() {
		return tenNguoiMuaHang == null ? "" : tenNguoiMuaHang;
	}

	public void setTenNguoiMuaHang(String tenNguoiMuaHang) {
		this.tenNguoiMuaHang = tenNguoiMuaHang;
	}

	public String getCccd() {
		return cccd == null ? "" : cccd;
	}

	public void setCccd(String cccd) {
		this.cccd = cccd;
	}

	public String getEmailAddress() {
		return emailAddress == null ? "" : emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSoDienThoai() {
		return soDienThoai == null ? "" : soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getSoTaiKhoan() {
		return soTaiKhoan == null ? "" : soTaiKhoan;
	}

	public void setSoTaiKhoan(String soTaiKhoan) {
		this.soTaiKhoan = soTaiKhoan;
	}

	public String getTenNganHang() {
		return tenNganHang == null ? "" : tenNganHang;
	}

	public void setTenNganHang(String tenNganHang) {
		this.tenNganHang = tenNganHang;
	}

	public String getHinhThuThanhToan() {
		return hinhThuThanhToan == null ? HinhThucThanhToanEnum.TM_CK.getText() : hinhThuThanhToan;
	}

	public void setHinhThuThanhToan(String hinhThuThanhToan) {
		this.hinhThuThanhToan = hinhThuThanhToan;
	}

	public String getLoaiTien() {
		return loaiTien == null ? LoaiTienEnum.USD.getText() : loaiTien;
	}

	public void setLoaiTien(String loaiTien) {
		this.loaiTien = loaiTien;
	}

	public double getTyGia() {
		return tyGia;
	}

	public void setTyGia(double tyGia) {
		this.tyGia = tyGia;
	}

	public String getChietKhau() {
		return chietKhau == null ? ChietKhauEnum.KHONG_CHIET_KHAU.getText() : chietKhau;
	}

	public void setChietKhau(String chietKhau) {
		this.chietKhau = chietKhau;
	}

	public NguoiMua() {
		
	}

	public NguoiMua(String mst, String tenDV, String dc, String tenNMH, String cccd, String email, String sdt, String stk, String nganHang, String httt, String loaiTien, double tyGia, String ck) {
		// TODO Auto-generated constructor stub
		this.mstNguoiMua = mst;
		this.tenDonVi = tenDV;
		this.diaChi = dc;
		this.tenNguoiMuaHang = tenNMH;
		this.cccd = cccd;
		this.emailAddress = email;
		this.soDienThoai = sdt;
		this.soTaiKhoan = stk;
		this.tenNganHang = nganHang;
		this.hinhThuThanhToan = httt;
		this.loaiTien = loaiTien;
		this.tyGia = tyGia;
		this.chietKhau = ck;
	}
	
	public NguoiMua(String mst, String tenDV) {
		this.mstNguoiMua = mst;
		this.tenDonVi = tenDV;
	}

}
