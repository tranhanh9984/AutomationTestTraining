package autotest.pages.admin;

import autocom.common.CommonPage;
import java.util.List;
import java.util.ArrayList; // Nếu bạn khởi tạo List bằng ArrayList
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SchoolPage extends CommonPage {

	public SchoolPage() {
		super();
	}
	public void clickMenu(String name) {
		driver.findElement(By.xpath(name)).click();	
	}
	public void creat_School(String name, String email, String phone, String tagline, String address, String code) {
		driver.findElement(By.id("school_name")).sendKeys(name);
			WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));
			uploadElement.sendKeys("C:\\Users\\Admin\\123.png"); 

			
		
		driver.findElement(By.id("school_support_email")).sendKeys(email);
		driver.findElement(By.id("school_support_phone")).sendKeys(phone);
		driver.findElement(By.id("school_tagline")).sendKeys(tagline);
		driver.findElement(By.id("school_address")).sendKeys(address);
		driver.findElement(By.id("school_code_prefix")).sendKeys(code);		
		
	}
	public void create_Admin(String firstName, String lastName, String contact, String email) {
		//((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1000);");

	    driver.findElement(By.id("admin_first_name")).sendKeys(firstName);
	    driver.findElement(By.id("admin_last_name")).sendKeys(lastName);
	    driver.findElement(By.id("admin_contact")).sendKeys(contact);
	    driver.findElement(By.id("admin_email")).sendKeys(email);

	   
		WebElement adminImageUpload = driver.findElement(By.name("admin_image"));
	    adminImageUpload.sendKeys("C:\\Users\\Admin\\123.png");
	    	
	}
	public void submit() {
		driver.findElement(By.id("create-btn")).click();
		
	}
	public void edit(String email) {
 	    WebElement row = driver.findElement(By.xpath("//td//small[normalize-space(text())='" + email + "']/ancestor::tr"));

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(row.findElement(By.xpath(".//button[contains(@id, 'dropdownMenuButton')]"))));
		menuButton.click();

		WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(row.findElement(By.xpath(".//a[contains(text(),'Chỉnh sửa')]"))));
		editButton.click();

	}
	public void update(String tag) {
 
 	    WebElement taglineInput = driver.findElement(By.id("edit_school_tagline"));
	    taglineInput.clear();
	    taglineInput.sendKeys(tag);
	    driver.findElement(By.xpath("//input[@class='btn btn-theme']")).click();
	}
 		
	
 	
	public void create_Nhan_vien(String Ten, String Ho, String DiDong, String email, String HinhAnh) {
		clickMenu("//span[text()='Quản lý nhân viên']");
		clickMenu("//a[text()='Nhân viên']");
		clickMenu("//input[@class='btn btn-theme float-right ml-3']");
		clickMenu("//select[@id='role_id']/option[@value='2']");
 
 		driver.findElement(By.id("first_name")).sendKeys(Ten);
		driver.findElement(By.id("last_name")).sendKeys(Ho);
		driver.findElement(By.id("mobile")).sendKeys(DiDong);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(HinhAnh);		
		Date_NhanVien();
		pause(3);
		clickMenu("//ul[@class='select2-selection__rendered']");
		clickMenu("//li[text()='Trường Tiểu học Võ Chí Công']");
		pause(3);
		clickMenu("//input[@class='btn btn-theme float-right ml-3']");
	
	}
 
	public void Date_NhanVien() {
		
	    driver.findElement(By.name("dob")).click();  
	    pause(1);
	    
 	    driver.findElement(By.xpath("//th[@class='datepicker-switch']")).click();
	    pause(1);
	    driver.findElement(By.xpath("//th[@class='datepicker-switch'and text()='2025']")).click();
	    pause(1);
	    
 	    WebDriverWait wait = new WebDriverWait(driver,5);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='datepicker-years' and not(@style='display: none;')]")));
	    
	    selectDecade("2000-2009");
	    selectDate("2003", "Jan", "12");

	}   
	public void selectDecade(String targetDecade) {

	    while (true) {
	        WebElement decadeRange = driver.findElement(By.xpath("//div[@class='datepicker-years']//th[@class='datepicker-switch']"));
	        String currentDecade = decadeRange.getText().trim();
	        System.out.println("Current decade: " + currentDecade);

	        if (currentDecade.equals(targetDecade)) {
	            System.out.println("Reached target decade!");
	            break;
	        }

 	        WebElement prevButton = driver.findElement(By.xpath("//div[@class='datepicker-years']//th[@class='prev']"));
	        prevButton.click();
	        System.out.println("Clicked prev button");

	    }

	}
	public void selectDate(String year, String month, String day) {
	    clickMenu("//span[@class='year' and text()='" + year + "']");
	    pause(1);
	    clickMenu("//span[@class='month' and text()='" + month + "']");
	    pause(1);
	    clickMenu("//td[@class='day' and text()='" + day + "']");
	    pause(1);
	}

	

	 
	public void Vaitro(String Ten, String quyen1, String quyen2, String quyen3, String quyen4) {
		clickMenu("//span[text()='Quản lý nhân viên']");
		clickMenu("//a[text()='Vai trò & Quyền hạn']");
		clickMenu("//a[text()=' Tạo vai trò mới']");
 		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Ten);
 		clickMenu(quyen1);
 		clickMenu(quyen2);
 		clickMenu(quyen3);
 		clickMenu(quyen4);
 		clickMenu("//input[@id='create-btn']");

	}


	
}
