package autotest.pagesHD;

import autocom.common.CommonPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;
import java.util.NoSuchElementException;

import autotest.pagesHD.*;

public class EditKH extends CommonPage{
	private WebDriver driver;
	private WebDriverWait wait;
	Tao_KH taokh;
	private By ButtonCapNhat = By.xpath("//span[ @class='p-button-label ng-star-inserted' and text()='Cập nhật'] ");	
//	private ButtonEdit = By.
	
	
	public EditKH(WebDriver driver)  {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.wait = new WebDriverWait(driver,5);
		this.taokh = new Tao_KH(driver);
	}
	public void clickButtonEdit(String MaKH) {
		try {
			WebElement edit = driver.findElement(By.xpath("//td[contains(normalize-space(), '" + MaKH+"')]/following-sibling::td//p-button[@title='Chỉnh sửa']/button"));
			edit.click(); 
		} catch (NoSuchElementException e) {
		    System.out.println("Không tìm thấy nút Chỉnh sửa cho mã KH: " + MaKH);
		}
			}
	public void timVaClickEditKH(String maKH) {
	    boolean found = false;

	    while (true) {
	        try {
 	            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//td")));


 	            By xpathEdit = By.xpath("//td[contains(normalize-space(), '" + maKH + "')]/following-sibling::td//p-button[@title='Chỉnh sửa']/button");

 	            WebElement nutEdit = wait.until(ExpectedConditions.elementToBeClickable(xpathEdit));
	            nutEdit.click();
	            System.out.println("Đã tìm và click 'Chỉnh sửa' cho mã KH: " + maKH);
	            found = true;
	            break;

	        } catch (TimeoutException e) {
	            System.out.println("KH '" + maKH + "' không có ở trang hiện tại. Thử chuyển trang tiếp...");

	            try {
 	                WebElement nextButton = driver.findElement(By.xpath("//button[contains(@class, 'p-paginator-next')]"));
	                if (nextButton.getAttribute("class").contains("p-disabled")) {
	                    System.out.println("Đã đến trang cuối. Không tìm thấy mã KH: " + maKH);
	                    break;
	                }

 	                WebElement tableBefore = driver.findElement(By.xpath("//table"));
	                nextButton.click();
	                wait.until(ExpectedConditions.stalenessOf(tableBefore));

	            } catch (Exception ex) {
	                System.out.println("Lỗi khi tìm hoặc click nút Next.");
	                break;
	            }
	        }
	    }

	    if (!found) {
	        System.out.println("Không tìm thấy mã KH: " + maKH + " trong toàn bộ bảng.");
	    }
	}

	public void ThongTinEdit(Map<String, String> data) {
		for(Map.Entry<String , String> data1: data.entrySet()) {
			String key = data1.getKey();
		    String value = data1.getValue();
		
		try {
			WebElement inputField = driver.findElement(By.xpath("//input[@formcontrolname='" + key + "']"));
			 inputField.clear();
	         inputField.sendKeys(value);
		} catch (NoSuchElementException  e) {
            System.out.println("Không tìm thấy trường: " + key);
		}
		}
	}
	public void CapnNhat() {
		 taokh.click(ButtonCapNhat);
			
			
		}
		
	}
	


