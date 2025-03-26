package autotest.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autocom.common.CommonPage;

public class AddSchoolPage extends CommonPage {
	public static String school_name = "Trường học ANHPTM";
	public static String school_support_email = "anhptm@gmail.com";
	public static String school_support_phone = "097653227";
	public static String school_tagline = "Slogan school";
	public static String school_address = "Hà Nội";
	public static String domain = "Bắc";
	public static String school_code_prefix = "MAC01";
	public static String admin_first_name = "Mai Anh";
	public static String admin_last_name = "Phạm";
	public static String admin_contact = "09837664432";
	public static String admin_email = "anhptm1@gmail.com";

	public AddSchoolPage() {
	}

	public void clickMenu() {
		driver.findElement(By.linkText("Trường học")).click();

	}

	public void addData(String name, String email, String phone, String slogan, String address, String domain,
			String code, String nameAd, String lastnameAd, String contactAd, String emailAd) {
		driver.findElement(By.id("school_name")).clear();
		driver.findElement(By.id("school_name")).sendKeys(name);
//
		WebElement fileInput = driver.findElement(By.xpath("//input[@id='school_image']"));
		String filePath = "C:\\Users\\Admin\\Pictures\\Camera Roll\\images.jpg"; // Gửi đường dẫn file vào thẻ input
		fileInput.sendKeys(filePath);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // Đợi vài giây để tải lên hoàn tất

		driver.findElement(By.id("school_support_email")).clear();
		driver.findElement(By.id("school_support_email")).sendKeys(email);
		driver.findElement(By.id("school_support_phone")).clear();
		driver.findElement(By.id("school_support_phone")).sendKeys(phone);
		driver.findElement(By.id("school_tagline")).clear();
		driver.findElement(By.id("school_tagline")).sendKeys(slogan);
		driver.findElement(By.id("school_address")).clear();
		driver.findElement(By.id("school_address")).sendKeys(address);
		driver.findElement(By.name("domain")).clear();
		driver.findElement(By.name("domain")).sendKeys(domain);
		driver.findElement(By.id("school_code_prefix")).clear();
		driver.findElement(By.id("school_code_prefix")).sendKeys(code);
		driver.findElement(By.id("admin_first_name")).clear();
		driver.findElement(By.id("admin_first_name")).sendKeys(nameAd);
		driver.findElement(By.id("admin_last_name")).clear();
		driver.findElement(By.id("admin_last_name")).sendKeys(lastnameAd);
		driver.findElement(By.id("admin_contact")).clear();
		driver.findElement(By.id("admin_contact")).sendKeys(contactAd);
		driver.findElement(By.id("admin_email")).clear();
		driver.findElement(By.id("admin_email")).sendKeys(emailAd);

		WebElement fileInput2 = driver
				.findElement(By.xpath("//input[@class='file-upload-default form-control-danger']"));
		String filePath2 = "C:\\Users\\Admin\\Pictures\\Camera Roll\\images.jpg";
		fileInput2.sendKeys(filePath2);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void clickCreat() {
		driver.findElement(By.id("create-btn")).click();
	}

}
