package autotest.pages.staff;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import autocom.common.CommonPage;

public class addStaffPage extends CommonPage {

	public static String role_id = "Gói ANHPTM";
	public static String first_name = "anhptm";
	public static String last_name = "MAC";
	public static String mobile = "098865432";
	public static String email = "anhptm1234s@gmail.com";
	public static String dob = "17/05/2002";
	public static String[] schoolSelectValues = { "16", "18" };

	public void clickMenu() {
		driver.findElement(By.linkText("Quản lý nhân viên")).click();
		driver.findElement(By.xpath("//div[@id='staff-management']//li[last()]")).click();
	}

	public void addData(String name, String lastName, String phone, String email, String birthday,
			String[] schoolSelectValues) {

		driver.findElement(By.xpath("//select[@id = 'role_id']")).click();
		driver.findElement(By.xpath("//select[@id = 'role_id']/option[last()]")).click();

		driver.findElement(By.name("first_name")).clear();
		driver.findElement(By.name("first_name")).sendKeys(name);
		driver.findElement(By.name("last_name")).clear();
		driver.findElement(By.name("last_name")).sendKeys(lastName);
		driver.findElement(By.name("mobile")).clear();
		driver.findElement(By.name("mobile")).sendKeys(phone);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);

		WebElement fileInput = driver.findElement(By.xpath("//input[@name='image']"));
		String filePath = "C:\\Users\\Admin\\Pictures\\Camera Roll\\images.jpg";
		fileInput.sendKeys(filePath);
		driver.findElement(By.name("dob")).clear();
		driver.findElement(By.name("dob")).sendKeys(birthday);
		Actions actions = new Actions(driver);
		actions.moveByOffset(0, 0).click().perform();
		// driver.findElement(By.name("dob")).click();
		// driver.findElement(By.className("datepicker-switch")).click();
		// driver.findElement(By.xpath("//span[contains(text(), '2025')]")).click();
		// driver.findElement(By.xpath("//span[contains(text(), 'Feb')]")).click();

		driver.findElement(By.className("select2-selection--multiple")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String valuesString = "[\"" + String.join("\",\"", schoolSelectValues) + "\"]";
		js.executeScript("$('select[name=\"school_id[]\"]').val(" + valuesString + ").trigger('change');");

		js.executeScript("$('select[name=\"school_id[]\"]').select2(\"close\");");
		// List<String> schoolValues = (List<String>) js.executeScript(
		// "return $('#edit_school_id option').map(function() { return $(this).val();
		// }).get();"
		// );
	}

	public void clickCreat() {
		driver.findElement(By.id("create-btn")).click();
	}

}
