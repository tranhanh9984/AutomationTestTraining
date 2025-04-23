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

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.JavascriptExecutor;



import autocom.common.CommonPage;
import autotest.pagesHD.Tao_KH;
import org.testng.Assert;
import org.openqa.selenium.Keys;

public class Tao_HD extends CommonPage {
	private WebDriverWait wait;
	private WebDriver driver;
	Tao_KH taoKH;
	
	private By MenuHD = By.xpath("//span[@class='p-menuitem-text ng-star-inserted' and text()='Hóa đơn ']");
	private By LapHD = By.xpath("//span[@class='p-menuitem-text ng-star-inserted' and text()='Lập hoá đơn']");
	//
 
	//
	private By NguoiMua = By.id("toName");
	private By CCCD = By.id("toIdentification");
	//
 	//
	private By ChietKhau = By.id("discountTypeEnumId");
	//
	private By ThemHang = By.xpath("//button[contains(@class,'p-ripple p-element p-button-rounded p-button-info')]");
	private By Them = By.xpath("//span[@class='p-button-label ng-star-inserted' and text()='Thêm']");
	
	public Tao_HD(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,10);
		this.taoKH = new Tao_KH(driver);
	}
	public void TaoHD() {
		taoKH.click(MenuHD);
		taoKH.click(LapHD);
	}
				public void ChonMST(String MaSo) {
				    
	 			        WebElement inputElement = driver.findElement(By.xpath("//input[contains(@class, 'p-autocomplete-input')]"));
				        inputElement.sendKeys(MaSo);
		        try {
	 	        String XpathGoiY = "//div[@class='p-col-2 text-break' and normalize-space(text())='" + MaSo + "']";
		        WebElement suggestionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XpathGoiY)));
	
	 	        suggestionElement.click();
	
		        System.out.println("Đã chọn mã số thuế: " + MaSo);
		    } catch (TimeoutException | NoSuchElementException e) {
		        System.err.println("Không tìm thấy mã số thuế: " + MaSo);
		        throw new IllegalArgumentException("Không tìm thấy mã số thuế: " + MaSo, e);
		    }
	}


   public void InforText(String name, String cccd) {
	   taoKH.EnterText(NguoiMua, name);
	   taoKH.EnterText(CCCD, cccd);	   
   }
   private static final Map<String, String> Pay_OPTIONS = new HashMap<>();
   static {
	   Pay_OPTIONS.put("TM/CK", "//li[@aria-label='TM/CK']");
	   Pay_OPTIONS.put("Tiền mặt", "//li[@aria-label='Tiền mặt']");
	   Pay_OPTIONS.put("Chuyển khoản", "//li[@aria-label='Chuyển khoản']");
	   Pay_OPTIONS.put("Đối trừ công nợ", "//li[@aria-label='Đối trừ công nợ']");
	   Pay_OPTIONS.put("Không thu tiền", "//li[@aria-label='Không thu tiền']");

   }
   
   public void ChonHT(String HinhThuc) {
	    WebElement HTTT = driver.findElement(By.xpath("//span[contains(@class,'p-dropdown-trigger-icon')]"));  

 	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HTTT);
 	    pause(1);
 	    HTTT.click(); 

 	    String xpathValue = Pay_OPTIONS.get(HinhThuc);
	    if (xpathValue == null) {
	        throw new IllegalArgumentException("Hình thức không hợp lệ: " + HinhThuc);
	    }

 	    WebElement payElement = driver.findElement(By.xpath(xpathValue));
	    payElement.click();
	}
   private static final Map<String, String> CK_OPTIONS = new HashMap<>();
   static {
	   CK_OPTIONS.put("Không chiết khấu", "//li[@aria-label='Không chiết khấu']");
	   CK_OPTIONS.put("Theo từng mặt hàng","//li[@aria-label='Theo từng mặt hàng']");
	   CK_OPTIONS.put("Theo tổng giá trị", "//li[@aria-label='Theo tổng giá trị']");
   }

   public void ChonChieKhau(String chiekhau,Map<String, String> GiaTriCK) {
	   taoKH.click(ChietKhau);
	   String xpathCK = CK_OPTIONS.get(chiekhau);
	   WebElement chetkhauElement = driver.findElement(By.xpath(xpathCK));
	   chetkhauElement.click();  
	   switch (chiekhau) {
       case "Không chiết khấu":
           System.out.println(" Không cần nhập thêm thông tin.");
           break;

       case "Theo từng mặt hàng":
           CK_SP(GiaTriCK);
           break;

       case "Theo tổng giá trị":
           CK_Tong(GiaTriCK.get("Tổng"));
           break;
   }
   }
   public void CK_SP(Map<String, String> GiaTriCK) {
	    try {
	        int stt = Integer.parseInt(GiaTriCK.get("STT"));
	        String chietKhau = GiaTriCK.get("GiaTri");
	        
	        WebElement row = driver.findElement(By.xpath("//table//tbody//tr["+ stt +"]"));
	        
	        row.findElement(By.xpath(".//td[8]")).click();
	        
	        WebElement ckInput = row.findElement(By.xpath(".//td[8]//input[@inputmode='decimal']"));
	        
	        ckInput.clear();
	        ckInput.sendKeys(chietKhau + Keys.ENTER);
	 		row.findElement(By.xpath(".//td[1]")).click();

	        
	        pause(1);
	        
	        String actualValue = row.findElement(By.xpath(".//td[contains(@class,'p-element')][6]//span[@class='ng-star-inserted']")).getText();
//	        Assert.assertEquals(actualValue, chietKhau, "Chiết khấu không đúng!");
	        System.out.println("Đã nhập chiết khấu " + chietKhau);
	         
	    } catch (Exception e) {
	        System.out.println("Không tìm thấy hoặc không thể nhập chiết khấu: " + e.getMessage());
	    }
	}
   private void CK_Tong(String discountPercent) {
       WebElement totalDiscountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p-inputnumber[@id='discountPercent']//input")));

       totalDiscountInput.clear();
       totalDiscountInput.sendKeys(discountPercent);
       System.out.println(" Đã nhập tổng chiết khấu: " + discountPercent + "%");
   }
   public void ButtonChonHang() {
	   taoKH.click(ThemHang);

   }
   public void ChonHangHoa(String MaSP) {
 	   WebElement SPElement =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[text()='" + MaSP + "']/preceding-sibling::td//p-tablecheckbox[@class='p-element']")));
	   SPElement.click();
   }
   public void ChonHangHoas(List<String> HangHoas) {
	   for(String hang1:HangHoas ) {
		   ChonHangHoa(hang1);
	   }
   }
   public void ButtonThem() {
 	   taoKH.click(Them);

   }
   }


