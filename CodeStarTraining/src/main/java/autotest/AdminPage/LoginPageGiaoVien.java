package autotest.AdminPage;
import org.openqa.selenium.By;
import autocom.common.CommonPage;

public class LoginPageGiaoVien extends CommonPage {
	public void LoginPageGiaoVien() {
		
	}
	public void LoginPage(String email, String password) {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
	}
	public void clickLogin() {
		driver.findElement(By.id("login_btn")).click();
	}

}
