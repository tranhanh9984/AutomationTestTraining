package autocom.common;

public enum LoaiTienEnum {
	VND("VND"), USD("USD"), EUR("EUR"), CNY("CNY"), ADP("ADP");
	
	private String text;
	
	LoaiTienEnum(String text){
		this.text = text;
	}
	
	public String getText() {
		return this.text;
	}
}
