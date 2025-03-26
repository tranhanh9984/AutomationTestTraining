package autotest.pages.admin;
import org.openqa.selenium.By;
import autocom.common.CommonPage;

public class LoginPageAdmin extends CommonPage{

	public  LoginPageAdmin() {
		
	}
	
	public void loginPage(String email,String password ) {
//		driver.findElement(By.id("email")).clear();
//		driver.findElement(By.id("email")).sendKeys(email);
//		driver.findElement(By.id("password")).clear();
//		driver.findElement(By.id("password")).sendKeys(password); btnlogin
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password); 
	}
	public void clickLogin() {
// 		driver.findElement(By.id("login_btn")).click();
 		driver.findElement(By.name("btnlogin")).click();
 	}
 
}
