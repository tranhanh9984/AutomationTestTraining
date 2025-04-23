package autotest.pagesHD;
import org.openqa.selenium.By;
import java.math.BigDecimal;
import java.math.RoundingMode;  
import org.testng.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.openqa.selenium.Keys;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.JavascriptExecutor;

import autocom.common.CommonPage;
import autotest.pagesHD.Tao_KH;
import autotest.pagesHD.Tao_HD;

import autotest.testcase.pageHD.TaoKHTest;

import autocom.common.CommonPage;
import org.openqa.selenium.support.ui.Select;
public class SanPham extends CommonPage{
	public WebDriverWait wait;
	public WebDriver driver;
	
	public SanPham(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver,5);
	}
	public void themHangtheoSTT(String stt, String soluong, String thue) {
		try {
			
		WebElement row = driver.findElement(By.xpath("//table//tbody//tr["+ stt +"]"))	;

		row.findElement(By.xpath(".//td[5]")).click();
		WebElement SlInput = row.findElement(By.xpath(".//td[5]//input[@inputmode='decimal']"));

		SlInput.clear();
		SlInput.sendKeys(soluong + Keys.ENTER);
		pause(1);
		String actualValue = row.findElement(By.xpath(".//td[contains(@class,'p-element')][4]//span[@class='ng-star-inserted']")).getText();
		Assert.assertEquals(actualValue, soluong,"Số lượng không đúng!");
        System.out.println("Hiển thị đúng số lượng " );

		chonThueTheoSTT(stt,thue);
		 
 		} catch (Exception e) {
	        System.out.println("Không tìm thấy sản phẩm STT " + stt + ": " + e.getMessage());

		}
		
		
	}
	public void chonThueTheoSTT(String stt, String thue) {

		WebElement row = driver.findElement(By.xpath("//table//tbody//tr["+ stt +"]"))	;
		row.findElement(By.xpath(".//td[8]")).click();
 		WebElement ButtonChonThue = row.findElement(By.xpath(".//td[8]//div[@role]")) ;
		ButtonChonThue.click();
 		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath(" //div[contains(@class,'dropdown')]//span[text()='"+ thue +"']")));
//		option.sendKeys(Keys.ENTER); 
		option.click();

 		row.findElement(By.xpath(".//td[1]")).click();

		pause(1);
 		String actualValue = row.findElement(By.xpath(".//td[8]//span[@class='ng-star-inserted']")).getText();
		Assert.assertEquals(actualValue, thue,"Giá trị thuế được chọn không đúng!");
        System.out.println("Hiển thị đúng thuế:  " + thue );
        

	}
	public void checkTienTungSP(int stt) {
		List<String> data = layThongTinSP(stt);
		double soluong = Double.parseDouble(data.get(0).replace(",", ""));
		double dongia = Double.parseDouble(data.get(1).replace(",", ""));
		double thanhTien = Double.parseDouble(data.get(2).replace(",", ""));
		double expert = soluong*dongia;
		Assert.assertEquals(thanhTien, expert,"Số tiền không đúng với dòng: "+stt);
	    System.out.println("Thành tiền đúng tại dòng " + stt);

	}
	public double tinhTienThueTungSP_CKT(int stt) {	
		double expert = 0;
	    List<String> data = layThongTinSP(stt);
	    double soluong = Double.parseDouble(data.get(0).replace(",", ""));	    
 	    String thueStr = data.get(3).replace("%", "").replace(",", "");
	    double thue = Double.parseDouble(thueStr);
	    
	    double thanhTien = Double.parseDouble(data.get(2).replace(",", ""));
	    String tienThueStr = data.get(4) != null ? data.get(4).trim() : "";

	    double tienThue = (tienThueStr.isEmpty()) ? 0.0 : Double.parseDouble(tienThueStr.replace(",", ""));
	    
	    if (soluong > 1) {
 	          expert = thanhTien * (thue / 100);
	        double delta = 0.01;  
	        Assert.assertEquals(tienThue, expert, delta, "Tiền thuế không đúng tại dòng: " + stt);
	        System.out.println("Tiền thuế đúng tại dòng " + stt);
	    } else {
	        Assert.assertEquals(tienThue, 0.0, "Tiền thuế phải = 0 khi số lượng <= 1 tại dòng: " + stt);
	        System.out.println("Tiền thuế không có với dòng " + stt);
	    }
	    return thanhTien;
	}
	public double tinhTienThueTungSP_CKSP(int stt) {
		List<String> data = layThongTinSP(stt);
		 double expert = 0;
	    double soluong = Double.parseDouble(data.get(0).replace(",", ""));	    
 	    String thueStr = data.get(5).replace("%", "").replace(",", "");
	    double thue = Double.parseDouble(thueStr);
	    
	    double thanhTien = Double.parseDouble(data.get(2).replace(",", ""));
	    String tienThueStr = data.get(6) != null ? data.get(6).trim() : "";

	    double tienThue = (tienThueStr.isEmpty()) ? 0.0 : Double.parseDouble(tienThueStr.replace(",", ""));
	    double tienCK = tinhTienCKTheoSP();
	    if (soluong > 1) {
 	          expert = (thanhTien-tienCK) * (thue / 100);
	        double delta = 0.01;  
	        Assert.assertEquals(tienThue, expert, delta, "Tiền thuế không đúng tại dòng: " + stt);
	        System.out.println("Tiền thuế đúng tại dòng " + stt);
	    } else {
	        Assert.assertEquals(tienThue, 0.0, "Tiền thuế phải = 0 khi số lượng <= 1 tại dòng: " + stt);
	        System.out.println("Tiền thuế không có với dòng " + stt);
	    }
	    return expert;
	}
	public double tinhTongTienHang() {
		double Tongtien = 0;
		int slmathang = driver.findElements(By.xpath("//form//p-table//tbody/tr")).size()	;
		for(int i = 1; i< slmathang; i++ ) {
 			String thanhTien = driver.findElement(By.xpath("//form//p-table//tbody/tr[" + i + "]//td[7]")).getText();
 			double numberthanhTien = Double.parseDouble(thanhTien.replace(",", ""));
 			 Tongtien += numberthanhTien;

		}
		return Tongtien;
	}
	
	public double tinhTongTienThue() {
	    double Tongtienthue = 0;  
	    int soDong = driver.findElements(By.xpath("//form//p-table//tbody/tr")).size();

	    if (isChietKhauTheoTong()) {
	        System.out.println("Tính thuế theo trường hợp CHIẾT KHẤU TỔNG");

	        for (int i = 1; i < soDong; i++) {
	            try {
	                double tienthue = tinhTienThueTungSP_CKT(i);
	                Tongtienthue += tienthue;
	            } catch (Exception e) {
	                System.out.printf("Không kiểm tra được thuế dòng %d: %s\n", i, e.getMessage());
	            }
	        }
	    } else if (isChietKhauTheoDong()) { 
	        System.out.println("Tính thuế theo trường hợp CHIẾT KHẤU TỪNG SẢN PHẨM");

	        for (int i = 1; i < soDong; i++) {
	            try {
	                double tienthue = tinhTienThueTungSP_CKSP(i);
	                Tongtienthue += tienthue;
	            } catch (Exception e) {
	                System.out.printf("Không kiểm tra được thuế dòng %d: %s\n", i, e.getMessage());
	            }
	        }
	    }

	    return Tongtienthue;  
	}
	
	public double tinhTongTienThanhToan() {
        double tongTienHang = tinhTongTienHang();
        double tongTienThue = tinhTongTienThue();
        double tongchietkhau = tinhTongTienChietKhau();
        double expectedTienTT = tongTienHang - tongchietkhau + tongTienThue;
 
        return expectedTienTT;	
	}
	public double tinhTienCKTheoTong() {
        double tongTienHang = tinhTongTienHang();
        double tyleCK = parseCurrency(getValueByFormControl("discountPercent"));
 
        return tongTienHang * tyleCK / 100;
    }
	public double tinhTienCKTheoSP() {
	    double tongCK = 0;
	    int soDong = driver.findElements(By.xpath("//form//p-table//tbody/tr")).size();

	    for (int i = 1; i < soDong; i++) {
	        try {
	            tongCK += tinhTienChietKhauTungDong(i);
	        } catch (IndexOutOfBoundsException | NumberFormatException e) {
	            System.out.printf("Lỗi tính CK ở dòng %d: %s\n", i, e.getMessage());
	        }
	    }

	    return tongCK;
	}

	public double tinhTienChietKhauTungDong(int stt) {
	    List<String> data = layThongTinSP(stt);

	    if (data.size() < 4) {
	        throw new IndexOutOfBoundsException("Không đủ dữ liệu ở dòng " + stt + ": " + data);
	    }

	    double thanhTien = parseCurrency(data.get(2)); // Thành tiền
	    String ckStr = data.get(3);                    // Tỷ lệ CK (%)

	    double tyLeCK = (ckStr == null || ckStr.trim().isEmpty()) ? 0.0 : Double.parseDouble(ckStr.replace("%", "").trim());

	    return thanhTien * (tyLeCK / 100);
	}

 
	public double getTienChietKhauTungDongFromUI(int stt) {
	    WebElement cell = driver.findElement(By.xpath("//form//p-table//tbody/tr[" + stt + "]//td[8]")); // Giả sử cột 8 là CK
	    String value = cell.getText().trim();
	    return value.isEmpty() ? 0.0 : parseCurrency(value);
	}

	public double getTienCKFromUI() {
        return parseCurrency(getValueByFormControl("discountAmount"));
    }

	public String getValueByFormControl(String name) {
	    WebElement input = driver.findElement(By.xpath("//p-inputnumber[@formcontrolname='" + name + "']//input"));
	    return input.getAttribute("value").trim();
	}
	public boolean isChietKhauTheoTong() {
	    return driver.findElements(By.xpath("//p-inputnumber[@formcontrolname='discountPercent']")).size() > 0 &&
	           !getValueByFormControl("discountPercent").isEmpty();
	}

	public boolean isChietKhauTheoDong() {
	    return driver.findElements(By.xpath("//thead//th[contains(text(),'Tỷ lệ CK (%)')]")).size() > 0;
	}
    public double tinhTongTienChietKhau() {
        if (isChietKhauTheoTong()) {
            System.out.println("Tiền CK tính được: "+tinhTienCKTheoTong() + " Và tính theo Tong" );

            return tinhTienCKTheoTong();

        } else if (isChietKhauTheoDong()) {
            System.out.println("Tiền CK tính được: "+tinhTienCKTheoSP()+ " Và tính theo SP");

            return tinhTienCKTheoSP();
        }
        return 0.0;
    }
 
 
	public String soSangChu(double number) {
	    String[] units = {"", "nghìn", "triệu", "tỷ"};
	    String[] digits = {"không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
	    
	    if (number == 0) return "không đồng";
	    
	    StringBuilder result = new StringBuilder();
	    int unitIndex = 0;
	    
	    while (number > 0) {
	        int chunk = (int)(number % 1000);
	        if (chunk != 0) {
	            String chunkInWords = convertThreeDigits(chunk, digits);
	            result.insert(0, chunkInWords + " " + units[unitIndex] + " ");
	        }
	        number /= 1000;
	        unitIndex++;
	    }
	    
	    return result.toString().trim() + " đồng";
	}

	public String convertThreeDigits(int n, String[] digits) {
	    StringBuilder sb = new StringBuilder();
	    if (n >= 100) {
	        sb.append(digits[n / 100]).append(" trăm ");
	        n %= 100;
	    }
	    if (n >= 10) {
	        sb.append(digits[n / 10]).append(" mươi ");
	        n %= 10;
	    }
	    if (n > 0) {
	        sb.append(digits[n]);
	    }
	    return sb.toString().trim();
	}
	public  double parseCurrency(String value) {
	    if (value == null || value.trim().isEmpty()) return 0.0;
	    return Double.parseDouble(value.replace(",", "").replace("₫", "").trim());
	}


	public List<String> layThongTinSP(int stt) {
		List<String> data = new ArrayList<String>();
		WebElement row = driver.findElement(By.xpath("//table//tbody//tr["+ stt +"]"))	;
 		for(int i=5; i<=11; i++) {
			String value = row.findElement(By.xpath(".//td["+i+"]//span")).getText().trim();
			data.add(value);		
		}
 		return data;
		}
}
