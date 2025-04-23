package autotest.testcase.pageHD;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pagesHD.*;

public class SuaHDTest extends CommonPage {
	Sua_HD hd;
	Tao_HD taoHD;
	SanPham sp;
	LoginPage loginPage;
 	public SuaHDTest() {
		// TODO Auto-generated constructor stub
	}
	
 
	@BeforeTest
	public void startBrowser() {
	    driver = this.startBrower(KeywordConstant.urlHD, KeywordConstant.BROWSER);
	    loginPage = new LoginPage(driver);
 	    hd = new Sua_HD(driver);
 	    taoHD = new Tao_HD(driver);
 	    sp = new SanPham(driver);
 	    loginPage.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
		hd.MenuSua();
	}
	@Test(priority = 1)
    public void testSuaHDThanhCong() {
		 
		hd.ChonTG("Năm nay");
	    hd.clickOtherButton("00000003");
	    
	    Map<String, String> invoiceData = new HashMap<>();
	    invoiceData.put("toAddress", "hCM");
 	    invoiceData.put("toEmailAddress", "LOngt@example.com");

	    String reason = "Cập nhật địa chỉ khách hàng";

	    hd.ChinhSuaTTHD(invoiceData, reason);
	    taoHD.ButtonChonHang();
		 List<String> products = Arrays.asList("VA", "001");
		 pause(1);
		 taoHD.ChonHangHoas(products);
		 taoHD.ButtonThem();
		 
//		 Map<String, String> totalDiscount = Map.of("Tổng", "10");
//		 taoHD.ChonChieKhau("Theo tổng giá trị", totalDiscount);
//		 pause(1);
		 sp.themHangtheoSTT("2", "5", "5%");

		 Map<String, String> input = new HashMap<>();
	 	 input.put("STT", "2");
	 	 input.put("GiaTri", "15%");
	 	 pause(1);
	 	 taoHD.ChonChieKhau("Theo từng mặt hàng",input);
 	 	 double expectedTongTien = sp.tinhTongTienThanhToan();
	 	 pause(3);

		 hd.Taomoi();
   		 String text = hd.SuccessMessage();
   		 Assert.assertEquals(text, "Dữ liệu đã được cập nhật!");
  		   
 		 pause(3);
 		 Map<String, String> actualData = hd.layThongTinDongHoaDonDauTien();
		 
// 		 Assert.assertEquals(actualData.get("Ngày HĐ"), LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Ngày HĐ không đúng");
// 		 System.out.println(actualData.get("Ngày HĐ"));
// 
// 		 Assert.assertEquals(actualData.get("Loại hoá đơn "), "Điều chỉnh", "Loại hoá đơn không đúng");
// 		 System.out.println(actualData.get("Loại hoá đơn "));
// 		 
 		double actualTongTien = sp.parseCurrency(actualData.get("Tổng tiền"));

  		Assert.assertEquals(actualTongTien, expectedTongTien, 0.01, "Tổng tiền không đúng"); 		 System.out.println(actualData.get("Tổng tiền"));


	}
//	@Test(priority = 2)
// 	public void testSuaHDThatBai() {
// 		System.out.println("Case2--------------------------------------------");
// 
// 		hd.ChonTG("Năm nay");
// 		pause(2);
// 	    hd.clickOtherButton("00000002");
// 	    
// 	    Map<String, String> invoiceData = new HashMap<>();
// 	    invoiceData.put("toAddress", "Hà Chí");
//  	    invoiceData.put("toEmailAddress", "te543srfdt@example.com");
// 
// 	    String reason = "";
// 
// 	    hd.ChinhSuaTTHD(invoiceData, reason);
// 	    taoHD.ButtonChonHang();
// 		 List<String> products = Arrays.asList("VA", "002");
// 
// 		 taoHD.ChonHangHoas(products);
// 		 taoHD.ButtonThem();
// 		 
// 		 Map<String, String> totalDiscount = Map.of("Tổng", "10");
// 		 taoHD.ChonChieKhau("Theo tổng giá trị", totalDiscount);
// 		 pause(1);
// 		
// 		 hd.Taomoi();
// 		 pause(3);
// 		 String text = hd.FailMessage();
//   		 Assert.assertEquals(text, "Trường không được để trống.");
//	
//	}
	@AfterTest
	public void closeBrowser() {
 	    this.closeBrowser(driver);
	}
}
