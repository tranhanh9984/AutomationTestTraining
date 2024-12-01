package autocom.common;

public enum HinhThucThanhToanEnum {
	TM_CK("TM/CK"), TIEN_MAT("Tiền mặt"), CHUYEN_KHOAN("Chuyển khoản"), DOI_TRU_CONG_NO("Đối trừ công nợ"), KHONG_THU_TIEN("Không thu tiền");
	
	private String text;
	
	HinhThucThanhToanEnum(String text){
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
}
