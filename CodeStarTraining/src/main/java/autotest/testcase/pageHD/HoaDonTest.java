package autotest.testcase.pageHD;
import java.time.LocalDate;
import org.testng.annotations.BeforeClass;

import java.time.format.DateTimeFormatter;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pagesHD.*;
public class HoaDonTest extends CommonPage {
	Sua_HD hd;
	Tao_HD taoHD;
	SanPham sp;
	LoginPage loginPage;
	public HoaDonTest() {
		// TODO Auto-generated constructor stub
	}
	@BeforeTest
	public void setupEnvironment() {
		 driver = this.startBrower(KeywordConstant.urlHD, KeywordConstant.BROWSER);
		    loginPage = new LoginPage(driver);
	 	    hd = new Sua_HD(driver);
	 	    taoHD = new Tao_HD(driver);
	 	    sp = new SanPham(driver);
	 	    loginPage.login(KeywordConstant.usernameHD, KeywordConstant.passwordHD);
	}
	
	@BeforeClass
	public void prepareTestData() {
		hd.MenuSua();
		hd.ChonTG("Năm nay");
	    hd.clickOtherButton("00000003");
	    
	    Map<String, String> invoiceData = new HashMap<>();
	    invoiceData.put("toAddress", "hCM");
 	    invoiceData.put("toEmailAddress", "LOngt@example.com");
	    String reason = "Cập nhật địa chỉ khách hàng";
	    hd.ChinhSuaTTHD(invoiceData, reason);
	    taoHD.ButtonChonHang();
	    
//	    Chọn mặt hàng
		 List<String> products = Arrays.asList("VA", "002");
		 taoHD.ChonHangHoas(products);
		 taoHD.ButtonThem();
		 
//		 Map<String, String> totalDiscount = Map.of("Tổng", "10");
//		 taoHD.ChonChieKhau("Theo tổng giá trị", totalDiscount);
		 
//		 Nhập số lượng và thuế theo số thứ tự
		 sp.themHangtheoSTT("2", "5", "5%");
		 
//		 Nhập chiết khấu theo số thứ tự
		 Map<String, String> input = new HashMap<>();
	 	 input.put("STT", "2");
	 	 input.put("GiaTri", "15%");
	 	 taoHD.ChonChieKhau("Theo từng mặt hàng",input);

 
	}
 
	@Test(priority = 1, description = "Kiểm tra tổng số tiền chiết khấu được tính toán và hiển thị chính xác")
	public void verifyTinhTienCK() {
	    System.out.println("Case 1-------------------------------------------- ");

	    double expected = sp.tinhTongTienChietKhau();
	    double actual = sp.getTienCKFromUI();

	    if (expected == 0.0 && actual == 0.0) {
	        System.out.println("Không áp dụng chiết khấu. Bỏ qua kiểm tra.");
	        return;
	    }
		verifyAmount("Tổng tiền số tiền chiết khấu", expected, actual);

	}

	@Test(priority = 2,description = "Kiểm tra tổng số tiền được tính toán và hiển thị chính xác")
    public void verifyTongTien() {
		System.out.println("Case2--------------------------------------------");
		double Tongtien = sp.tinhTongTienHang();
 		double numberTongthanhTien = sp.parseCurrency(sp.getValueByFormControl("grandTotal"));
		verifyAmount("Tổng tiền số tiền được tính toán", Tongtien, numberTongthanhTien);

 	    }
	
	@Test(priority = 3,description = "Kiểm tra tổng tiền thuế được tính toán và hiển thị chính xác")
    public void verifyTongTienThue() {
		System.out.println("Case3--------------------------------------------");
		double TongtienThue = sp.tinhTongTienThue();		
 		double numberTongtienThue = sp.parseCurrency(sp.getValueByFormControl("taxAmount"));
		verifyAmount("Tổng tiền tiền thuế", TongtienThue, numberTongtienThue);

		}

	@Test(priority = 4, description = "Kiểm tra tổng số tiền thanh toán được tính toán và hiển thị chính xác")
    public void verifyTongTienTT() {
		System.out.println("Case4--------------------------------------------");
 		double TongtienThanhtoan = sp.tinhTongTienThanhToan();
 		double actual = sp.parseCurrency(sp.getValueByFormControl("invoiceTotal"));
		verifyAmount("Tổng tiền thanh toán", TongtienThanhtoan, actual);
 		}
	
	@Test(priority = 5,description = "Kiểm tra tổng số tiền được tính toán và hiển thị bằng chữ chính xác")
    public void verifySoTienBangChu() {
		System.out.println("Case5--------------------------------------------");
		double TongtienThanhtoan = sp.tinhTongTienThanhToan(); 
		WebElement amountInWordsInput = driver.findElement(By.id("amountInWords"));
		String actualText = amountInWordsInput.getAttribute("value").trim();
		String expectedText = sp.soSangChu(TongtienThanhtoan);
 		Assert.assertEquals(actualText.toLowerCase(), expectedText.toLowerCase(), "Số tiền bằng chữ không đúng với tổng tiền thanh toán");
 	
 
 		}
	private void verifyAmount(String label, double expected, double actual) {
	    System.out.printf("So sánh %s | Expected: %.0f | Actual: %.0f\n", label, expected, actual);
	    Assert.assertEquals(actual, expected, 1.0, label + " không đúng!");
	}

	@AfterTest
	public void closeBrowser() {
 	    this.closeBrowser(driver);
 	    
	}
}
