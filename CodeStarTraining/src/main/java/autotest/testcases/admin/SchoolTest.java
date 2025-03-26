package autotest.testcases.admin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
import autocom.common.CommonPage;
import autocom.constant.KeywordConstant;
import autotest.pages.admin.LoginPageAdmin;
import autotest.pages.admin.SchoolPage;
public class SchoolTest extends CommonPage {
	LoginPageAdmin login;
	WebDriver driver; 
	SchoolPage school;
	public SchoolTest() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void loginadmin() {
		login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
		school.clickMenu();
		school.creat_School("Trường Tiểu học Võ Chí Công", "VoChiCong22@gmail.com", "0123456789", "Sáng tạo - Phát triển", "Hà Nội", "CC56"
				);
		school.create_Admin("Nguyễn", "Ha Bac", "0987654321", "Haba@gmail.com"); 
		school.submit();
 		pause(10);

	}
	
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd+"login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
		school = new SchoolPage();
		school.driver = driver;

		
	}
}
