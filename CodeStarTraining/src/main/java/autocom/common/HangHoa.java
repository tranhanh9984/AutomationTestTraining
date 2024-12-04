package autocom.common;

public class HangHoa {
	private String tenHangHoa;
	private String donViTinh;
	private int soLuong;
	private long donGia;
	private int thueGTGT;
	private long thanhTienQuyDoi;
	private long tienThue;
	
	public long ThanhTienQuyDoi;
	public long ThanhTien;
	public long TienThue;
	
	public String getTenHangHoa() {
		return tenHangHoa;
	}
	
	public void setTenHangHoa(String tenHangHoa) {
		this.tenHangHoa = tenHangHoa;
	}
	
	public String getDonViTinh() {
		return donViTinh;
	}
	
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	
	public int getSoLuong() {
		return soLuong;
	}
	
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public long getDonGia() {
		return donGia;
	}
	
	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}
	
	public int getThueGTGT() {
		return thueGTGT;
	}
	
	public void setThueGTGT(int thueGTGT) {
		this.thueGTGT = thueGTGT;
	}
	
	public long getThanhTien() {
		return this.soLuong * this.donGia;
	}
	
	public long getTienThue() {
		return (this.getThanhTien() * this.thueGTGT) / 100;
	}
	
	public long getThanhTienQD() {
		return thanhTienQuyDoi;
	}
	
	public void setThanhTienQD(long thanhTienQD) {
		this.thanhTienQuyDoi = thanhTienQD;
	}
	
	public HangHoa(String tenHH, String dvt, int sl, long dg, int thue) {
		this.tenHangHoa = tenHH;
		this.donViTinh = dvt;
		this.soLuong = sl;
		this.donGia = dg;
		this.thueGTGT = thue;
	}
	
	public HangHoa(String tenHH, String dvt, int sl, long dg, int thue, long thanhTien, long thanhTienQD, long tienThue) {
		this.tenHangHoa = tenHH;
		this.donViTinh = dvt;
		this.soLuong = sl;
		this.donGia = dg;
		this.thueGTGT = thue;
		// public field
		this.ThanhTien = thanhTien;
		this.ThanhTienQuyDoi = thanhTienQD;
		this.TienThue = tienThue;
	}
	
	public HangHoa() {
		
	}
}
