package autotest.pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import autocom.common.CommonBase;

public class THday17 extends CommonBase {

	public THday17() {
		// TODO Auto-generated constructor stub

	}

	public void step234() {
		driver.findElement(By.xpath("//a[contains(. , 'Click Here')]")).click();
		String mainwindow = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			System.out.println(window);
			if (!window.equals(mainwindow)) {
				driver.switchTo().window(window);
				String currentUrl = driver.getCurrentUrl();
				Assert.assertEquals(currentUrl, "https://demo.guru99.com/articles_popup.php");

				driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("ha@gmail.com");

				driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
				pause(3000);
				driver.close();
				driver.switchTo().window(mainwindow);
				Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/popup.php");
				break;
			}
		}
		pause(5000);

	}

	@Test
	public void testCodeStar() {
		WebElement iframeDangKy = driver.findElement(By.xpath(
				"//*[h2[contains(.,'Đăng ký nhận tài liệu:')]]/following-sibling::div[contains(@class,'wpb_content_element')]//iframe"));
		driver.switchTo().frame(iframeDangKy);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Do Viet Ha");
		driver.findElement(By.xpath("//input[@id='phone_number']")).sendKeys("0123456789");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("dovietha@codestar.vn");
		driver.findElement(By.xpath("//button[contains(.,'Gửi ngay')]")).click();
		driver.switchTo().parentFrame();

	}

	@BeforeClass
	public void startBrowser() {
		this.startBrower("https://codestar.vn/", "chrome");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
