package autotest.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import autocom.common.CommonPage;


public class AddPackagePage  extends CommonPage  {

		public static String name = "Gói ANHPTM";
		public static String description = "anhptm@gmail.com";
		public static String tagline = "MAC";
		public static String days = "17/07/2000";
		public static String no_of_students = "100";
		public static String no_of_staffs = "10";
		public static String charges = "100";
	


		public void clickMenu() {
			driver.findElement(By.linkText("Gói")).click();

		}
		public void clickButton() {
			driver.findElement(By.linkText("Tạo mới Gói")).click();

		}

		public void addData(String name, String description, String slogan, String date, String numberStu,
				String NumberStaff, String fee) {
			driver.findElement(By.xpath("//input[@type='radio' and @value='0']")).click();

			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys(name);
			driver.findElement(By.name("description")).clear();
			driver.findElement(By.name("description")).sendKeys(description);
			driver.findElement(By.name("tagline")).clear();
			driver.findElement(By.name("tagline")).sendKeys(slogan);
			driver.findElement(By.name("days")).clear();
			driver.findElement(By.name("days")).sendKeys(date);
			driver.findElement(By.name("no_of_students")).clear();
			driver.findElement(By.name("no_of_students")).sendKeys(numberStu);
			driver.findElement(By.name("no_of_staffs")).clear();
			driver.findElement(By.name("no_of_staffs")).sendKeys(NumberStaff);
			driver.findElement(By.name("charges")).clear();
			driver.findElement(By.name("charges")).sendKeys(fee);
			driver.findElement(By.xpath("//input[@type='checkbox' and @value='1']")).click();
			driver.findElement(By.xpath("//label[@for='Chat Module']")).click();
//			driver.findElement(By.xpath("//input[@type='checkbox' and @value='20']")).click();
			
			
		}

		public void clickCreat() {
			driver.findElement(By.id("create-btn")).click();
		}



}
