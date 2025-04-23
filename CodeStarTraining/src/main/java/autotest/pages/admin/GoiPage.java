package autotest.pages.admin;

import org.openqa.selenium.By;

import autocom.common.CommonPage;

public class GoiPage extends CommonPage{
public GoiPage() {
}
public void clickGoi() {
	driver.findElement(By.linkText("Gói")).click();
}
public void clicktaomoigoi() {
	driver.findElement(By.linkText("Tạo mới Gói")).click();
}
public void dienthongtingoi() {
	driver.findElement(By.name("name")).clear();
	driver.findElement(By.name("name")).sendKeys("Gói 1");
	driver.findElement(By.name("description")).clear();
	driver.findElement(By.name("description")).sendKeys("Gói số 1");
	driver.findElement(By.name("days")).clear();
	driver.findElement(By.name("days")).sendKeys("30");
	driver.findElement(By.name("student_charge")).clear();
	driver.findElement(By.name("student_charge")).sendKeys("500,000");
	driver.findElement(By.name("staff_charge")).clear();
	driver.findElement(By.name("staff_charge")).sendKeys("200,000");
}
public void clickGui() {
	driver.findElement(By.id("create-btn")).click();
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
