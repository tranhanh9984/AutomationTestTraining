package autocom.common;

public enum ChietKhauEnum {
	KHONG_CHIET_KHAU("Không chiết khấu"), THEO_TUNG_MAT_HANG("Theo từng mặt hàng"), THEO_TONG_GIA_TRI("Theo tổng giá trị");
	
	private String text;
	
	ChietKhauEnum(String text){
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
}
