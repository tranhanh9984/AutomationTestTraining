package autocom.constant;

import java.nio.file.Paths;

public class KeywordConstant {


//	public static final int DEFAULT_TIMEOUT = 30;
//	public static final int WAIT_INTERVAL = 10;
//	public static final int LOOPCOUNT = 5;
	
	//trang admin
	public static final String urlAd = "https://f-class.site/";
	public static final String usernameAd = "superadmin@gmail.com";
	public static final String passwordAd = "superadmin";
	public static final String schoollogoAd = Paths.get("C:\\Users\\PC\\Downloads\\Logo_TH Hat Lot.jpg").toAbsolutePath().toString();
	public static final String logoAd= Paths.get("C:\\Users\\PC\\Downloads\\pb192415_500.jpg").toAbsolutePath().toString();
	
	//trang giáo viên
	public static final String urlTea = "https://main.f-class.site/login";
	public static final String usernameTea = "bri4n0.t@gmail.com";
	public static final String passwordTea = "0979008320";
	
	//trang học sinh
	public static final String urlStu = "https://student.f-class.site/";
	public static final String usernameStu = "20240101";
	public static final String passwordStu = "01082020";
	public static final String schoolStu = "SCH20241";
	
	public static final String BROWSER = "chrome";
}
