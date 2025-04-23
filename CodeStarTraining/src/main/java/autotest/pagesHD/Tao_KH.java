package autotest.pagesHD;

import org.bouncycastle.eac.EACException;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import autocom.common.CommonPage;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ExceptionDefinition;

public class Tao_KH extends CommonPage{
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	public Tao_KH(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
	}
	private By DanhMuc = By.xpath("//span[@class='p-menuitem-text ng-star-inserted' and text()='Danh mục']");
	private By KH  = By.xpath("//span[@class='p-menuitem-text ng-star-inserted' and text()='Khách hàng']");
	private By Taomoi = By.xpath("//span[@class='p-button-label ng-star-inserted' and text()='Tạo mới'] ");
	private By LoaiKH = By.xpath("//div[@role='button']");
	
//	private By LuaChon = By.xpath("//span[@class='ng-star-inserted' and text()='Cá nhân'] ");
	
	private By InputmaKH = By.id("pseudoId");
	private By InputmaST = By.id("partyTaxId_Org");
	private By InputtenKH = By.id("partyName");
	private By InputDiaChi = By.id("address1");
	private By InputSoTK = By.id("accountNumber");
	private By InputNganHang = By.id("bankName");
	private By Inputemail = By.id("emailAddress");
	private By InputSDT = By.id("phoneNumber");
	
	private By Submit = By.xpath("//span[ @class='p-button-label ng-star-inserted' and text()='Tạo mới'] ");
	//
	private By MessageLocator = By.xpath("//div[contains(@class,'p-toast-detail')]");
 	//p-toast//p-toastitem//div[contains(@class,'p-toast-message')]

	public void click(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	public void EnterText(By locator, String text) {
		WebElement input = wait.until(ExpectedConditions.elementToBeClickable(locator));
		input.clear();
		input.sendKeys(text);
		
	}
	 public void openMenu() {
		 click(DanhMuc);
		 click(KH);
	 }
	 public void ButtonTaomoi() {
		 click(Taomoi);

	 }
	 public void LoaiKH(String loaiKH) {
		 click(LoaiKH);
		 String xpathOption;
		 switch (loaiKH.toLowerCase()) {
		 
		case "cá nhân":
			xpathOption = "//span[@class='ng-star-inserted' and text()='Cá nhân'] ";
 			break;
 			
		case "doanh nghiệp":
			xpathOption = "//span[@class='ng-star-inserted' and text()='Tổ chức'] ";
			break;

		default:
			throw new IllegalArgumentException("Loại khách hàng không hợp lệ: " + loaiKH) ;

		}
			click(By.xpath(xpathOption));
		    System.out.println("Đã chọn loại khách hàng: " + loaiKH);

		 
	 }
	 
	 public void NhapThongTinKH(String maKH, String maST, String tenKH ,
			 String DiaChi ,String SoTK ,String NganHang ,String email ,String SDT) {
		 EnterText(InputmaKH, maKH);
		 EnterText(InputmaST, maST);
		 EnterText(InputtenKH, tenKH);
		 EnterText(InputDiaChi, DiaChi);
		 EnterText(InputSoTK, SoTK);
		 EnterText(InputNganHang, NganHang);
		 EnterText(Inputemail, email);
		 EnterText(InputSDT, SDT);
		 
	 }
	
	 public void DangKy() {
		 click(Submit);
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
		     
	 public String getErrorMessage() {
 
 		    WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(MessageLocator));
 		    String error = errorMessageElement.getText();
 	        System.out.println("Thông báo lỗi thực tế: " + error);

		    return error ;
		}

	

}
