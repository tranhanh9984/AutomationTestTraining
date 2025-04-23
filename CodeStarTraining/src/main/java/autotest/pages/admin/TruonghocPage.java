package autotest.pages.admin;

import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autocom.common.CommonPage;

public class TruonghocPage extends CommonPage {
public TruonghocPage(){
	
}
public void clickTruonghoc() {
	driver.findElement(By.linkText("Trường học")).click();
}
public void dientttruonghoc() {
	driver.findElement(By.name("school_name")).clear();
	driver.findElement(By.name("school_name")).sendKeys("THCS Chu Văn An");
	driver.findElement(By.name("school_support_email")).clear();
	driver.findElement(By.name("school_support_email")).sendKeys("THCSCVA@gmail.com");
	driver.findElement(By.name("school_support_phone")).clear();
	driver.findElement(By.name("school_support_phone")).sendKeys("024897888");
	driver.findElement(By.name("school_tagline")).clear();
	driver.findElement(By.name("school_tagline")).sendKeys("Học học nữa học mãi");
	driver.findElement(By.name("school_address")).clear();
	driver.findElement(By.name("school_address")).sendKeys("Thụy Khuê");
	driver.findElement(By.name("school_image")).sendKeys("C:\\Users\\pc\\Desktop\\THCSCVA.png");
}
public void dienttquantrivien() {
	driver.findElement(By.name("admin_first_name")).clear();
	driver.findElement(By.name("admin_first_name")).sendKeys("Anh");
	driver.findElement(By.name("admin_last_name")).clear();
	driver.findElement(By.name("admin_last_name")).sendKeys("Nguyễn Văn");
	driver.findElement(By.name("admin_contact")).clear();
	driver.findElement(By.name("admin_contact")).sendKeys("0915892898");
	driver.findElement(By.name("admin_email")).clear();
	driver.findElement(By.name("admin_email")).sendKeys("anhnguyen@gmail.com");
	driver.findElement(By.name("admin_image")).sendKeys("C:\\Users\\pc\\Desktop\\giaovien.jpg");
}
public void clickGui() {
	driver.findElement(By.id("create-btn")).click();
}
// public void ClickChinhsua() {
	//driver.findElement(By.className("dropdown-item p-2 edit-data  set-form-url")).click();
//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
