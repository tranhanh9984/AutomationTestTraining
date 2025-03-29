package autotest.testcases.admin;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.JavascriptExecutor;
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
public class TestSchoolEdit  extends CommonPage {
	LoginPageAdmin login;
	WebDriver driver; 
	SchoolPage school;
	public TestSchoolEdit() {
		// TODO Auto-generated constructor stub
	}
	@Test
	public void loginadmin() {
		login.LoginPage(KeywordConstant.usernameAd, KeywordConstant.passwordAd);
		login.clickLogin();
		school.clickMenu("");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 1000);");
		school.edit("Haba@gmail.com");
 		school.update("Phát");
 		
		}
	@BeforeTest
	public void startBrowser() {
		driver = this.startBrower(KeywordConstant.urlAd+"login", KeywordConstant.BROWSER);
		login = new LoginPageAdmin();
		login.driver = driver;
		school = new SchoolPage();
		school.driver = driver;
	}	
//	@AfterTest
//		public void closeBrowser() {
//			this.closeBrowser(driver);
//			
//		}
//		
	
}
