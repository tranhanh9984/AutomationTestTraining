package autotest.pages.teacher;

import org.openqa.selenium.By;
import autocom.common.CommonPage;

public class LoginPageTeacher extends CommonPage {

	public LoginPageTeacher() {

	}

	public void loginPage(String email, String password) {
//		driver.findElement(By.id("email")).clear();
//		driver.findElement(By.id("email")).sendKeys(email);
//		driver.findElement(By.id("password")).clear();
//		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(By.name("btnlogin")).click();
	}

}
