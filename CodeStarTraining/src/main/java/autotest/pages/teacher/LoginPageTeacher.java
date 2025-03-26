package autotest.pages.teacher;
import autocom.common.CommonPage;
import org.openqa.selenium.By;
public class LoginPageTeacher extends CommonPage {

	public LoginPageTeacher() {
		// TODO Auto-generated constructor stub
	}

	public void LoginPage(String email, String password) {
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);			
	}
	
	public void clickLogin() {
		driver.findElement(By.name("btnlogin")).click();
	}

}
