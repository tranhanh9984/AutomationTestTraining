package autotest.pagesHD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
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


public class Sua_HD extends CommonPage {
	private WebDriverWait wait;
	private WebDriver driver;
	Tao_KH taoKH;
	Tao_HD taoHD;

	private By MenuHD = By.xpath("//span[@class='p-menuitem-text ng-star-inserted' and text()='Hóa đơn ']");

	private By SuaHD = By.xpath("//span[@class='p-menuitem-text ng-star-inserted' and text()='Hóa đơn bán hàng']");
	
	private By ButtonTG = By.xpath("//p-dropdown[@id='period']");
//	<span class="p-menuitem-text ng-star-inserted">Điều chỉnh hóa đơn</span>
	private By Lydo = By.id("adjustDescription");
	
	private By EditHD = By.xpath("(//li //span[text()='Điều chỉnh hóa đơn'])[2]");
	
	By buttonOtherLocator = By.xpath(".//p-button[@title='Other']/button");

	private By ButtonTaoMoi = By.xpath("//p-button[@type='submit']");
	
	private By MessageLocator = By.xpath("//div[contains(@class,'p-toast-detail')]");


	public Sua_HD(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,5);
		this.taoKH = new Tao_KH(driver);
		
	}
	public void MenuSua() {
		taoKH.click(MenuHD);
		taoKH.click(SuaHD);

	}
 
	public void ChonTG(String time) {
		taoKH.click(ButtonTG);
		try {
		 WebElement ThoiGian =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@aria-label='" + time + "' and @role='option']")));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ThoiGian);
 		 ThoiGian.click();
		}
		catch (Exception e) {
	        System.out.println("Lỗi khi chọn thời gian: " + e.getMessage());
		}
	}
	public void clickOtherButton(String maSo) {
	    try {
	    	//tr[.//td[normalize-space()='"+maSo+"']]
  	        WebElement row = driver.findElement(By.xpath("//tr[td[2][contains(text(),'" + maSo +"')]]"));
   	         

  	        WebElement btnOther = row.findElement(buttonOtherLocator);
    	     
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", btnOther);
	        
// 	        Thread.sleep(500);
	        
	        wait.until(ExpectedConditions.elementToBeClickable(btnOther)).click();
	        driver.findElement(EditHD).click()	;        
	    } catch (NoSuchElementException e) {
	        System.out.println("Không tìm thấy mã số: " + maSo);
	    } 
	}
	public void ChinhSuaTTHD(Map<String, String> data,String lydo) {
		for(Map.Entry<String , String> data1: data.entrySet()) {
			String key = data1.getKey();
		    String value = data1.getValue();
		
		    try {
		        WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='" + key + "']"));
		        
		        inputField.click();
		        pause(1);
 		        inputField.clear(); 

		        inputField.sendKeys(value);

		        System.out.println("Giá trị mới đã nhập: " + inputField.getAttribute("value"));
		    } catch (NoSuchElementException e) {
		        System.out.println("Không tìm thấy trường: " + key);
		    }

	      WebElement LydoElement = driver.findElement(Lydo);

		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", LydoElement);
		 LydoElement.clear();
		 LydoElement.sendKeys(lydo);
	}
		}
	public void Taomoi() {
		try {
			taoKH.click(ButtonTaoMoi);
	        System.out.println("Đã sửa hoá đơn ");

		} catch (Exception e) {
	        System.out.println("Không nhấn được nút tạo mới ! ");
		}
	}
	public String SuccessMessage() {
	    try {
	        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));
	        Thread.sleep(1000);
	        String actualMessage = successMessage.getText();
	        System.out.println("Thông báo lấy được: " + actualMessage);
	        return actualMessage;
	    } catch (Exception e) {
		    	return "";
	    }
 }
	public Map<String, String> layThongTinDongHoaDonDauTien() {
	    Map<String, String> data = new HashMap<>();
	    
	    WebElement firstRow = driver.findElement(By.xpath("//table/tbody/tr[1]"));
	    List<WebElement> cells = firstRow.findElements(By.tagName("td"));
	    
	    data.put("Ký hiệu", cells.get(0).getText());
	    data.put("Số", cells.get(1).getText());
	    data.put("Ngày HĐ", cells.get(2).getText());
 	    data.put("Khách hàng", cells.get(3).getText());
	    data.put("Tổng tiền", cells.get(4).getText());
	    data.put("Loại hoá đơn ", cells.get(5).getText());

	    
	    return data;
	}
	public String FailMessage() {
	    try {
	        WebElement failMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//small[@class='p-error']")));
	        Thread.sleep(1000);
	        String actualMessage = failMessage.getText();
	        System.out.println("Thông báo lấy được: " + actualMessage);
	        return actualMessage;
	    } catch (Exception e) {
		    	return "";
	    }
 }

	 
}
