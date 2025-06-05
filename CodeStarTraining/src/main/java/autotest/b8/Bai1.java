package autotest.b8;

import autocom.common.CommonPage;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import autocom.constant.KeywordConstant;
import org.openqa.selenium.Keys;

public class Bai1 extends CommonPage {
	@Test
	public void testLogin() {
		addCookies();
		clearAll();
		this.Login("admin@demo.com", "riseDemo");
		this.createNewProject();
		pause(3);

	}
	private void createNewProject() {
		//Chọn button [Projects]
		driver.findElement(By.linkText("Projects")).click();
		pause(2);
		//Chọn button [Add project]
		driver.findElement(By.linkText("Add project")).click();
		pause(2);
		//Nhập thông tin cho project mới:
		 driver.findElement(By.id("title")).sendKeys("Project 1");
		 driver.findElement(By.id("description")).click();
		 driver.findElement(By.className("note-editable")).sendKeys("Tạo mới dự án");
		 driver.findElement(By.id("start_date")).sendKeys("04/06/2025");
		 driver.findElement(By.id("deadline")).sendKeys("04/06/2025");
		 driver.findElement(By.id("price")).sendKeys("1000000");
		 driver.findElement(By.id("s2id_autogen8")).click();
		 driver.findElement(By.id("s2id_autogen8")).sendKeys("Perfect" + Keys.ENTER);
		 pause(1);     
		 driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
		 pause(2);
	}
	
	private void Login(String username, String password) {
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button")).click();
	}

	private void clearAll() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).clear();
	}

	private void addCookies() {
		Cookie cookie = new Cookie.Builder("myCookie", "cc7b10096e6750174d9cc22d43fcd304").domain("rise.fairsketch.com")
				.path("/").isHttpOnly(true).isSecure(false).build();
		driver.manage().addCookie(cookie);
	}

	@BeforeTest
	public void startBrowser() {
		driver = this.startBrowser(KeywordConstant.urlRise, "chrome");
	}

	@AfterTest
	public void closeBrowser() {
		this.closeBrowser(driver);
	}
}
