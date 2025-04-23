package autotest.Page;

import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import autocom.common.CommonPage;

public class ChinhSuaHD extends CommonPage {
	public ChinhSuaHD(){
		
	}
	
	String txtChonMST = "//p-autocomplete[@id = 'toPartyTaxId']//descendant::button";
	String txtChonKH = "//div[text() = '0001000999']";
	String txtClickLuu = "//span[text() = 'Cập nhật']";
	
	String txtMST = "//label[contains(text(), 'MST người mua')]/following::input[1]";
	String txtMsgSuccess = "//div[contains(@class, 'p-toast-summary')]";
	String txtEmail = "//input[@id = 'toEmailAddress']";
	
	String txtInputNum = "(//input[contains(@class, 'p-inputtext p-component p-element p-inputnumber-input')])";
	String txtThanhTien = "//table[@role='table']//tr[1]/td[count(//th[text()='Thành tiền']/preceding-sibling::th)+1 ]"; 
	
	
	public void chinhSuaMST() {
		driver.findElement(By.xpath(txtChonMST)).click();
		driver.findElement(By.xpath(txtChonKH)).click();

	}
	String txtThem = "//button[contains(@class , 'p-button-rounded p-button-info')]";
	String txtChonVayHoa = "//td[text() = 'Váy hoa']/preceding-sibling::td/p-tablecheckbox";
	String txtChonGiay = "//td[text() = 'Giày']/preceding-sibling::td/p-tablecheckbox";
	String txtThemDong = "//span[contains(text () , 'Thêm')]/parent::button";
	public void themMatHang() {
		scrollToElement(txtThem);
		WebElement them = driver.findElement(By.xpath(txtThem));
		them.click();
		pause(5);
		driver.findElement(By.xpath(txtChonVayHoa)).click();
		driver.findElement(By.xpath(txtChonGiay)).click();
		WebElement themDong = driver.findElement(By.xpath(txtThemDong));
		themDong.click();
	}
	
	String txtNhapMST = "//label[contains(text(), 'MST người mua')]/following::input[1]";
	public void chinhSuaMSTInvalid(String mst) {
		driver.findElement(By.xpath(txtNhapMST)).click();
		driver.findElement(By.xpath(txtNhapMST)).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.xpath(txtNhapMST)).sendKeys(Keys.DELETE);
		pause(1);
		driver.findElement(By.xpath(txtNhapMST)).sendKeys(mst);
		driver.findElement(By.xpath(txtNhapMST)).sendKeys(Keys.ENTER);
	}
	
	public void chinhSuaMail(String mail) {
		scrollToElement(txtEmail);
		driver.findElement(By.xpath(txtEmail)).click();
		driver.findElement(By.xpath(txtEmail)).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.xpath(txtEmail)).sendKeys(Keys.DELETE);
		pause(1);
		driver.findElement(By.xpath(txtEmail)).sendKeys(mail);
		driver.findElement(By.xpath(txtClickLuu)).click();
	}
	int SL;
	String txtSoLuong ="//table[@role='table']//tr[1]/td[count(//th[text()='Số lượng']/preceding-sibling::th)+1 ]";
	String txtChinhSuaSL = "//table[@role='table']//tr[1]//td[count(//th[text()='Số lượng']/preceding-sibling::th)+1 ]/descendant::input";
	String txtSoDongTrongBang = "//tr[@class = 'primary ng-star-inserted']";
	public void chinhSuaSL(String quantity) {
		scrollToElement(txtSoLuong);
		driver.findElement(By.xpath(txtSoLuong)).click();
		driver.findElement(By.xpath(txtChinhSuaSL)).clear();
		driver.findElement(By.xpath(txtChinhSuaSL)).sendKeys(quantity);
		driver.findElement(By.xpath(txtChinhSuaSL)).sendKeys(Keys.ENTER);
	}

	public void chinhSuaSLNhieuSP(String quantity) {
		List<WebElement> elements = driver.findElements(By.xpath(txtSoDongTrongBang));
		SL = elements.size();
		System.out.println("Số dòng:"+SL);
		for(int i = 1; i<= SL; i++) {
		String txtSoLuong ="//table//tr["+i+"]/td[count(//th[text()='Số lượng']/preceding-sibling::th)+1 ]";
		String txtChinhSuaSL = "//table//tr["+i+"]//td[count(//th[text()='Số lượng']/preceding-sibling::th)+1 ]/descendant::input";
		
		scrollToElement(txtSoLuong);
		driver.findElement(By.xpath(txtSoLuong)).click();
		driver.findElement(By.xpath(txtChinhSuaSL)).clear();
		driver.findElement(By.xpath(txtChinhSuaSL)).sendKeys(quantity);
		driver.findElement(By.xpath(txtChinhSuaSL)).sendKeys(Keys.ENTER);
		}
	}
//	String myStr = "Hello %s! One kilobyte is %,d bytes.";
//	String result = String.format(myStr, "World", 1024);
//	System.out.println(result);
	public int tinhTongTien() {
		List<WebElement> elements = driver.findElements(By.xpath(txtSoDongTrongBang));
		SL = elements.size();
		int TongTien = 0;
		for(int i = 1; i<= SL; i++) {
		String txtThanhTien ="//table//tr["+i+"]/td[count(//th[text()='Thành tiền']/preceding-sibling::th)+1 ]";
		String thanhtien = driver.findElement(By.xpath(txtThanhTien)).getText();
		thanhtien = thanhtien.replace(",", ""); 
   	    int thanhtien1 = Integer.parseInt(thanhtien);// chuyen doi thanh int
		TongTien +=thanhtien1;
		System.out.println("Tong tien la:" +TongTien);
		}
		return TongTien;
	}
	
	
	String thueGTGT = "//label[text() ='Thuế GTGT']/following::input[1]";
	String txtChonMucThue = "//span[text() = '";
	public void chinhSuaThue(String mucThue) {
		scrollToElement(thueGTGT);
		driver.findElement(By.xpath(thueGTGT)).click();
		driver.findElement(By.xpath(txtChonMucThue+mucThue+"']")).click();
	}

	public void clickLuu() {
		driver.findElement(By.xpath(txtClickLuu)).click();
	}
	String txtDonGia ="//table[@role='table']//tr[1]/td[count(//th[text()='Đơn giá']/preceding-sibling::th)+1 ]";
	public String getDonGia() {
		return driver.findElement(By.xpath(txtDonGia)).getText();
	}
	 public String getThanhTien() {
		 return driver.findElement(By.xpath(txtThanhTien)).getText();
	 }
	 
	String txtTenDonVi = "//label[contains(text(), 'Tên đơn vị')]/following::input[1]";
	public String getTenDonVi() {
		return driver.findElement(By.xpath(txtTenDonVi)).getAttribute("value");
		
	}
	
	String txtgetTongTien = "//label[contains(text() ,'Tổng tiền hàng')]//parent::div//descendant::input";
	public int getTongTien() {
		String TongTien = driver.findElement(By.xpath(txtgetTongTien)).getAttribute("value").replace(",", "").replaceAll("[^\\d]", "");
		int TongTienActual = Integer.parseInt(TongTien);
		return TongTienActual;
	}
	
	String txtTongTienBangChu = "//label[contains(text() ,'Số tiền bằng chữ')]//parent::div//descendant::input";
	public String getTongTienBangChu(){
		return driver.findElement(By.xpath(txtTongTienBangChu)).getText();			
		
	}
	public String getMST(){
		return driver.findElement(By.xpath(txtMST)).getAttribute("value");				
		
	}
	public String getMsg() {
		return driver.findElement(By.xpath(txtMsgSuccess)).getText();
	}
	
	String txtgetTienThue = "//label[text()= 'Tiền thuế GTGT']//following::input[1]";
	public String getTienThue() {
		return driver.findElement(By.xpath(txtgetTienThue)).getAttribute("aria-valuenow");
	}
	
	String txtgetTongTienHang = "//label[text()= 'Tổng tiền hàng']//following::input[1]";
	public String getTongTienHang() {
		return driver.findElement(By.xpath(txtgetTongTienHang)).getAttribute("value");
	}
	
	String txtError = "//div[text() = 'Có lỗi xảy ra...']";
	public String getError() {
		List<WebElement> elements = driver.findElements(By.xpath(txtError));
	    if (!elements.isEmpty()) {
	        return elements.get(0).getText();
	    }
	    return "";
	}

}