package autest.testcases.invoice; 
// import org.springframework.core.annotation.Order;
import org.testng.Assert;
 import org.testng.annotations.AfterTest;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;
// import javax.annotation.Priority; 
 import autocom.common.CommonPage;
 import autocom.constant.KeywordConstant;
 import autotest.pages.invoice.loginPage;
import autotest.pages.invoice.EditInvoicePage;
import autotest.pages.invoice.Homepage;
 
 public class LoginTestcase extends CommonPage{
 
 	public LoginTestcase() {
 		// TODO Auto-generated constructor stub
 	}
 
 	loginPage loginpage;
 	Homepage hompage;
 	EditInvoicePage editinvoice;

// 	@Test(priority =2)
// 	public void loginWrongpass() {
// 		loginpage.login(KeywordConstant.usernameInv, "123456789");
// 		pause(2);
// 		String text = loginpage.getErrorMsg();
// 		Assert.assertEquals(text, "Password incorrect for username "+KeywordConstant.usernameInv);
// 	}

// 	@Test(priority =1)
// 	public void loginWrongUser() {
// 		loginpage.login( KeywordConstant.usernameInv+10, KeywordConstant.passwordInv);
// 		pause(2);
// 		String text = loginpage.getErrorMsg();
// 		Assert.assertEquals(text, "No account found for username"+KeywordConstant.usernameInv+10);
// 	}
 	
 	@Test(priority =3)
 	public void loginSuccess() {
 		loginpage.login(KeywordConstant.usernameInv, KeywordConstant.passwordInv);
 		pause(2);
 		String text = hompage.getTitle();
 		Assert.assertEquals(text, KeywordConstant.usernameInv);
 		pause(2);
 		editinvoice.HoaDonBanHang();
 		pause(2);
 		editinvoice.Search();
 		pause(3);
 		editinvoice.MenuEdit();
 		pause(3);
 		editinvoice.editData(EditInvoicePage.toAddress, EditInvoicePage.toName, EditInvoicePage.toIdentification, EditInvoicePage.toEmailAddress,EditInvoicePage.toTelecomNumber, EditInvoicePage.accountNumber,
 				EditInvoicePage.bankName);
 		pause(3);
 		editinvoice.Save();
 		pause(5);
 	}
 	
 	@BeforeTest
 	public void startBrowser() {
 		driver = this.startBrower(KeywordConstant.urlInv, KeywordConstant.BROWSER);
 		loginpage = new loginPage();
 		loginpage.driver = driver;
 		hompage = new Homepage();
 		hompage.driver = driver;
 		editinvoice = new EditInvoicePage();
 		editinvoice.driver = driver;
 	}
 	
 	@AfterTest
 	public void closeBrowser() {
 		this.closeBrowser(driver);
 		
 	}
 }