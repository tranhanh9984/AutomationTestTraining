package autotest.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import autocom.common.CommonPage;
import autotest.pages.AddClient;

public class AddClientTestcases extends CommonPage{

	public AddClientTestcases() {
		// TODO Auto-generated constructor stub
	}

	AddClient addClient;
			@Test
		public void login1() {
			addClient.loginP("", "");
			
			pause(1000);
			addClient.clickMenu("Clients");
			
			pause(1000);
			
			addClient.addClient();
			pause(1000);
			}
		
		
//		@Test
		public void loginFail() {
			//fail email sia
			//loginPage = new LoginPage(driver);
			//gọi ham dang nhap tu class Login Pas
//			??loginPage.login("hanhtm", "1234", "33333");
			//get messasge lỗi
			//assert expected ...
		}
		
//		@Test
		public void loginFail1() {
			//fail email sia
			//gọi ham dang nhap tu class Login Pas
//			loginPage = new LoginPage(driver);
//			loginPage.login("hanhtm", "1234", "4444");
//			assert 1 == 2;
			//get messasge lỗi
			//assert expected ...
		}
		

		@BeforeSuite
		public void startPage() {
			this.startBrower("https://rise.fairsketch.com/signin", "chrome");
			addClient = new AddClient(driver);
			System.out.print("Khoi tao");
		}

		@AfterSuite
		public void closePage() throws InterruptedException {
//				Thread.sleep(2);
			this.closeBrowser(driver);
		}



}
